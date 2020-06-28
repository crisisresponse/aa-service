package org.reciprocity.aaservice.householdmember;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.reciprocity.aaservice.form.FormMapper;
import org.reciprocity.aaservice.model.AdditionalHouseMember;
import org.reciprocity.aaservice.model.AdditionalHouseMemberRequest;
import org.reciprocity.aaservice.model.MemberName;
import org.reciprocity.aaservice.repository.member.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HouseholdMemberServiceImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    MemberRepository memberRepository;

    @Mock
    NamesRepository namesRepository;

    @Mock
    PeopleRepository peopleRepository;

    @InjectMocks
    HouseholdMemberServiceImpl householdMemberServiceImpl;

    @BeforeEach
    void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllHouseholdMembersHOHIsNotPresent() {

        UUID headOfHouseholdId = UUID.randomUUID();
        Mockito.when(peopleRepository.findById(headOfHouseholdId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            householdMemberServiceImpl.getAllHouseholdMembers(headOfHouseholdId);
        });
    }

    @Test
    public void testGetAllHouseholdMembersHOHIsPresent() {

        UUID headOfHouseholdId = UUID.randomUUID();
        People headOfHousehold = new People();

        List<People> householdMembers = new ArrayList<>();
        People person1 = new People();
        person1.setEmploymentStatus("test1");
        People person2 = new People();
        person2.setEmploymentStatus("test2");
        People person3 = new People();
        person2.setEmploymentStatus("test2");

        householdMembers.add(person1);
        householdMembers.add(person2);
        householdMembers.add(person3);

        Mockito.when(peopleRepository.findById(headOfHouseholdId)).thenReturn(Optional.of(headOfHousehold));
        Mockito.when(peopleRepository.findAllByPrimaryContact(headOfHousehold)).thenReturn(householdMembers);

        List<People> returnedHouseholdMembers = householdMemberServiceImpl.getAllHouseholdMembers(headOfHouseholdId);

        assertEquals(householdMembers, returnedHouseholdMembers);
    }

    @Test
    void testSaveHouseholdMemberHOHIsNotPresent() {
        UUID headOfHouseholdId = UUID.randomUUID();
        AdditionalHouseMemberRequest request = new AdditionalHouseMemberRequest();

        Mockito.when(memberRepository.findById(headOfHouseholdId)).thenReturn(Optional.empty());
        Mockito.when(peopleRepository.findById(headOfHouseholdId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            householdMemberServiceImpl.saveHouseholdMember(request);
        });
    }
//
//    @Test
//    void testSaveHouseholdMemberNoAdditionalName() {
//
//        AdditionalHouseMemberRequest request = new AdditionalHouseMemberRequest();
//        AdditionalHouseMember additionalHouseMember = new AdditionalHouseMember();
//        MemberName memberName = new MemberName();
//        memberName.setFirstName("FirstName");
//        memberName.setLastName("LastName");
//        additionalHouseMember.setAdditionalMemberName(memberName);
//        request.setAdditionalHouseMember(additionalHouseMember);
//
//        People headOfHousehold = new People();
//        Member memberOfHousehold = new Member();
//        Address address = new Address();
//        memberOfHousehold.setAddress(address);
//        Name name = new Name();
//
//        Mockito.when(peopleRepository.findById(Mockito.any())).thenReturn(Optional.of(headOfHousehold));
//        Mockito.when(memberRepository.findById(Mockito.any())).thenReturn(Optional.of(memberOfHousehold));
//
//
//        Mockito.when(memberRepository.save(Mockito.any())).thenReturn(memberOfHousehold);
//        Mockito.when(peopleRepository.save(Mockito.any())).thenReturn(headOfHousehold);
//
//        householdMemberServiceImpl.saveHouseholdMember(request);
//
//        verify(namesRepository.save(Mockito.any()), times(1));
//
//
//
//
//    }
}
