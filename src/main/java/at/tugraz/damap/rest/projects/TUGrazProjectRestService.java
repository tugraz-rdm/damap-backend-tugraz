package at.tugraz.damap.rest.projects;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import at.tugraz.blueprint.rest.auth.BearerTokenClientHeadersFactory;
import at.tugraz.blueprint.rest.services.DBPServiceBase;
import at.tugraz.damap.rest.dmp.domain.TUGrazProject;

@RegisterRestClient(configKey = "rest.projects")
@RegisterClientHeaders(BearerTokenClientHeadersFactory.class)
public interface TUGrazProjectRestService extends DBPServiceBase<TUGrazProject> {
}
