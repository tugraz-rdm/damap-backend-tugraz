package at.tugraz.blueprint.rest.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import at.tugraz.blueprint.rest.models.SearchResult;

@Produces("application/ld+json")
public interface DBPServiceBase<T> {
    // Base class for digital blueprint api
    @GET
    @Path("")
    @Produces("application/ld+json")
    SearchResult<T> search(@QueryParam("search") String searchQuery, @QueryParam("page") int page,
            @QueryParam("perPage") int resultsPerPage, @QueryParam("includeLocal") Iterable<String> localAttributes);

    @GET
    @Path("/{id}")
    @Produces("application/ld+json")
    T read(@PathParam("id") String id, @QueryParam("includeLocal") Iterable<String> localAttributes);
}
