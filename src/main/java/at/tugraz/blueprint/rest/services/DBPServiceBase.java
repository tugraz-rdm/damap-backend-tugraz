package at.tugraz.blueprint.rest.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public interface DBPServiceBase<T> {
    // Base class for digital blueprint api
    @GET
    @Path("")
    List<T> search(@QueryParam("search") String searchQuery, @QueryParam("page") int page,
            @QueryParam("perPage") int resultsPerPage, @QueryParam("includeLocal") Iterable<String> localAttributes);

    @GET
    @Path("/{id}")
    T read(@PathParam("id") String id, @QueryParam("includeLocal") Iterable<String> localAttributes);

}
