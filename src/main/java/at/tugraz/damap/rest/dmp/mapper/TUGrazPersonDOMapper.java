package at.tugraz.damap.rest.dmp.mapper;

import at.ac.tuwien.damap.rest.dmp.domain.ContributorDO;
import at.tugraz.damap.rest.dmp.domain.TUGrazPerson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TUGrazPersonDOMapper {

    public ContributorDO mapEntityToDO(TUGrazPerson tuGrazPerson, ContributorDO contributorDO) {
        contributorDO.setFirstName(tuGrazPerson.getGivenName());
        contributorDO.setLastName(tuGrazPerson.getFamilyName());
        contributorDO.setUniversityId(tuGrazPerson.getIdentifier());
        contributorDO.setMbox(tuGrazPerson.getEmail());

        return contributorDO;
    }
}
