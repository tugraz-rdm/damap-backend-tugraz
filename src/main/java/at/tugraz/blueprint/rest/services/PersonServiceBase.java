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
  @Produces("application/ld+json")
  SearchResult<TUGrazPerson> search(
      @QueryParam("search") String searchQuery,
      @QueryParam("page") int page,
      @QueryParam("perPage") int resultsPerPage,
      // includeLocal must be a comma separated list of additional attributes from TU Graz API (e.g.
      // "email,organization")
      @QueryParam("includeLocal") String localAttributes);

  @GET
  @Path("/{id}")
  @Produces("application/ld+json")
  // includeLocal must be a comma separated list of additional attributes from TU Graz API (e.g.
  // "email,organization")
  TUGrazPerson read(@PathParam("id") String id, @QueryParam("includeLocal") String localAttributes);
}
