package at.tugraz.blueprint.rest.services;

import at.tugraz.blueprint.rest.models.SearchResult;
import at.tugraz.damap.rest.dmp.domain.TUGrazPerson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Produces("application/ld+json")
public interface PersonServiceBase {

  @GET
  @Path("")
  @Produces("application/ld+json")
  SearchResult<TUGrazPerson> search(
      @QueryParam("search") String searchQuery,
      @QueryParam("page") int page,
      @QueryParam("perPage") int resultsPerPage,
      @QueryParam("includeLocal") Iterable<String> localAttributes);

  @GET
  @Path("/{id}")
  @Produces("application/ld+json")
  TUGrazPerson read(
      @PathParam("id") String id, @QueryParam("includeLocal") Iterable<String> localAttributes);
}
