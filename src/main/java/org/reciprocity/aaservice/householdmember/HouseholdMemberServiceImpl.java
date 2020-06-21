package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.model.AdditionalAdultHouseMemberRequest;
import org.reciprocity.aaservice.repository.member.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HouseholdMemberServiceImpl implements HouseholdMemberService {

    private MemberRepository memberRepository;
    private NamesRepository namesRepository;
    private PeopleRepository peopleRepository;

    private HouseholdMemberServiceImpl(MemberRepository memberRepository, NamesRepository namesRepository,
                                       PeopleRepository peopleRepository) {
        this.memberRepository = memberRepository;
        this.namesRepository = namesRepository;
        this.peopleRepository = peopleRepository;
    }


    @Override
    public void saveHouseholdMember(AdditionalAdultHouseMemberRequest request) {
        UUID headOfHouseholdUUID = request.getHeadOfHouseId();
        Optional<Member> headOfHouseholdMember = memberRepository.findById(headOfHouseholdUUID);
        Optional<People> headOfHouseholdPerson = peopleRepository.findById(headOfHouseholdUUID);

        if(!headOfHouseholdMember.isPresent()) {
            throw new RuntimeException("Did not find head of household");
        }

        Name name = FormMapper.MAPPER.nameToEntity(request.getAdditionalAdultMember().getAdditionalMemberName());

        Optional<Name> additionalName = namesRepository.findById(name.getNamesId());

        if(!additionalName.isPresent()) {
            namesRepository.save(name);
        }

        Member addHousehold = FormMapper.MAPPER.additionalMemberToEntity(request.getAdditionalAdultMember(),
               name , headOfHouseholdMember.get().getAddress());

        Member savedMember = memberRepository.save(addHousehold);

        People personToAddToPeopleTable =
                FormMapper.MAPPER.additionalPeopleToEntity(
                        request.getAdditionalAdultMember(), savedMember, headOfHouseholdPerson.get());

        peopleRepository.save(personToAddToPeopleTable);
    }
}
