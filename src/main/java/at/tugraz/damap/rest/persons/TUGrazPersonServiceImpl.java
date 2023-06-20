package at.tugraz.damap.rest.persons;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import at.ac.tuwien.damap.rest.base.ResultList;
import at.ac.tuwien.damap.rest.base.Search;
import at.ac.tuwien.damap.rest.dmp.domain.ContributorDO;
import at.ac.tuwien.damap.rest.persons.PersonService;
import at.tugraz.blueprint.rest.auth.CredentialsService;
import at.tugraz.damap.rest.dmp.domain.TUGrazPerson;
import at.tugraz.damap.rest.dmp.mapper.TUGrazPersonDOMapper;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class TUGrazPersonServiceImpl implements PersonService {

    @Inject
    @RestClient
    TUGrazPersonRestService tuGrazPersonRestService;

    @Inject
    CredentialsService credentialsService;

    @Override
    public ContributorDO read(String id, MultivaluedMap<String, String> queryParams) {
        TUGrazPerson contributor;
        // We first try to get local attributes. If a field does not exist or we do
        // not have permission to access it, this will throw. So we try again without
        // fetching locals.
        try {
            contributor = tuGrazPersonRestService.read(id, List.of("email"));
        } catch (Exception e) {
            contributor = tuGrazPersonRestService.read(id, List.of());
        }

        return TUGrazPersonDOMapper.mapEntityToDO(contributor, new ContributorDO());
    }

    @Override
    public ResultList<ContributorDO> search(MultivaluedMap<String, String> queryParams) {
        Search s = Search.fromMap(queryParams);
        List<TUGrazPerson> tuGrazPersons = List.of();

        // We first try to get local attributes. If a field does not exist or we do
        // not have permission to access it, this will throw. So we try again without
        // fetching locals.
        try {
            tuGrazPersons = tuGrazPersonRestService.search(s.getQuery(), s.getPagination().getPage(),
                    s.getPagination().getPerPage(), List.of("email"));
        } catch (Exception e) {
            tuGrazPersons = tuGrazPersonRestService.search(s.getQuery(), s.getPagination().getPage(),
                    s.getPagination().getPerPage(), List.of());
        }

        List<ContributorDO> contributors = tuGrazPersons.stream()
                .map(c -> TUGrazPersonDOMapper.mapEntityToDO(c, new ContributorDO()))
                .collect(Collectors.toList());

        return ResultList.fromItemsAndSearch(contributors, s);
    }
}
