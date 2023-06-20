package at.tugraz.damap.rest.dmp.mapper;

import at.ac.tuwien.damap.rest.dmp.domain.ProjectDO;
import at.tugraz.damap.rest.dmp.domain.TUGrazProject;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TUGrazProjectDOMapper {

    public ProjectDO mapEntityToDO(TUGrazProject project, ProjectDO projectDO) {
        projectDO.setUniversityId(project.getIdentifier());
        projectDO.setTitle(project.getName());
        projectDO.setDescription(project.getDescription());
        projectDO.setStart(project.getStartDate());
        projectDO.setEnd(project.getEndDate());

        return projectDO;
    }
}
