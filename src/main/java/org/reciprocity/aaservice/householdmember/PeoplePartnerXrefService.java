package org.reciprocity.aaservice.householdmember;

import org.reciprocity.aaservice.model.PeoplePartnerXrefRequest;

public interface PeoplePartnerXrefService {

    void savePersonsXrefOrg(PeoplePartnerXrefRequest request);
}
