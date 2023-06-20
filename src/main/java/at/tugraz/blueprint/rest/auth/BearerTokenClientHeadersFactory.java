package at.tugraz.blueprint.rest.auth;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class BearerTokenClientHeadersFactory implements ClientHeadersFactory {

    @Inject
    CredentialsService credentialsService;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
            MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> result = new MultivaluedHashMap<>();
        String token = credentialsService.getToken();
        result.add("Authorization", "Bearer " + token);
        return result;
    }
}
