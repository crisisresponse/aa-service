package org.reciprocity.aaservice.repository.householdmember;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="household_case_notes")
@Getter @Setter
public class HouseholdCaseNotes {

    @Id
    @GeneratedValue
    @Column(name="notesKey")
    private Long notesKey;

    @OneToOne
    @JoinColumn(name = "member_key", referencedColumnName = "member_key")
    private Member member;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="modified_date")
    private LocalDate modifiedDate;
}
