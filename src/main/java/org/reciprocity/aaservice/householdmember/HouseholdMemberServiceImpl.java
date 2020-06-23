package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.model.AdditionalHouseMemberRequest;
import org.reciprocity.aaservice.repository.member.*;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<People> getAllHouseholdMembers(UUID headHouseholdId) {
        Optional<People> headOfHousehold = peopleRepository.findById(headHouseholdId);

        if (headOfHousehold.isPresent()) {
            return peopleRepository.findAllByPrimaryContact(headOfHousehold.get());
        }

        throw new RuntimeException("UUID is not a validate head of household");
    }

    @Override
    public void saveHouseholdMember(AdditionalHouseMemberRequest request) {
        UUID headOfHouseholdUUID = request.getHeadOfHouseId();
        Optional<Member> headOfHouseholdMember = memberRepository.findById(headOfHouseholdUUID);
        Optional<People> headOfHouseholdPerson = peopleRepository.findById(headOfHouseholdUUID);

        if(!headOfHouseholdMember.isPresent()) {
            throw new RuntimeException("Did not find head of household");
        }

        Name name = FormMapper.MAPPER.nameToEntity(request.getAdditionalHouseMember().getAdditionalMemberName());

        Optional<Name> additionalName = namesRepository.findById(name.getNamesId());

        if(!additionalName.isPresent()) {
            namesRepository.save(name);
        }

        Member savedMember = memberRepository.save(
                FormMapper.MAPPER.additionalMemberToEntity(
                        request.getAdditionalHouseMember(),
                        name,
                        headOfHouseholdMember.get().getAddress()));

        peopleRepository.save(
                FormMapper.MAPPER.additionalPeopleToEntity(
                        request.getAdditionalHouseMember(),
                        savedMember,
                        headOfHouseholdPerson.get()));
    }

    @Override
    public void updateHouseholdMember(UUID memberId, AdditionalHouseMemberRequest request) {

    }

}
