package at.tugraz.damap.rest.persons;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import at.tugraz.blueprint.rest.auth.BearerTokenClientHeadersFactory;
import at.tugraz.blueprint.rest.services.DBPServiceBase;
import at.tugraz.damap.rest.dmp.domain.TUGrazPerson;

@RegisterRestClient(configKey = "rest.persons")
@RegisterClientHeaders(BearerTokenClientHeadersFactory.class)
public interface TUGrazPersonRestService extends DBPServiceBase<TUGrazPerson> {
}
