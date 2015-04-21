package com.haduart.rest.decision;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("decision")
@Consumes({"application/json"})
@Produces({"application/json"})
@Stateless
@LocalBean
public class RestService {

    @EJB
    DecisionService service;

    @Path("/")
    @GET
    public Response listPurchases(@Context final UriInfo ui,
                                  @DefaultValue("") @QueryParam("email") final String email) {
        return service.listPurchases(ui, email);
    }

    @Path("/")
    @POST
    public Response purchase(@Context final UriInfo uriInfo, final Purchase purchase) {
        return service.purchase(uriInfo, purchase);
    }

}
