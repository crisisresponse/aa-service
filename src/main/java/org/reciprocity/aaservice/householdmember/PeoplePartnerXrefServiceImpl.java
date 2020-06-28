package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.PeoplePartnerXrefRequest;
import org.reciprocity.aaservice.repository.householdmember.People;
import org.reciprocity.aaservice.repository.householdmember.PeoplePartnerXrefRepository;
import org.reciprocity.aaservice.repository.householdmember.PeopleRepository;
import org.reciprocity.aaservice.repository.householdmember.PeoplesPartnerXref;

import java.util.Optional;

public class PeoplePartnerXrefServiceImpl implements PeoplePartnerXrefService {

    private PeoplePartnerXrefRepository peoplePartnerXrefRepository;
    private PeopleRepository peopleRepository;


    private PeoplePartnerXrefServiceImpl(PeoplePartnerXrefRepository peoplePartnerXrefRepository,
                                         PeopleRepository peopleRepository) {
        this.peoplePartnerXrefRepository = peoplePartnerXrefRepository;
        this.peopleRepository = peopleRepository;
    }



    @Override
    public void savePersonsXrefOrg(PeoplePartnerXrefRequest request) {
        Optional<People> person = peopleRepository.findById(request.getPersonKey());

        if(!person.isPresent()) {
            throw new RuntimeException("Person does not exist");
        }

        PeoplesPartnerXref entity = HouseholdMemberMapper.MAPPER.peoplesPartnerXrefToEntity(request, person.get());

        peoplePartnerXrefRepository.save(entity);
    }
}
