package at.tugraz.blueprint.rest.auth;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

@Singleton
@RegisterRestClient(configKey = "rest.tugraz.api.auth")
@RegisterClientHeaders(BasicTokenAPIClientHeadersFactory.class)
public interface CredentialsRestService {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CredentialsResponseBody getToken(@FormParam("grant_type") String grantType);

}
