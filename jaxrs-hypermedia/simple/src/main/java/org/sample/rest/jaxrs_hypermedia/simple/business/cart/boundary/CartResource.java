package org.sample.rest.jaxrs_hypermedia.simple.business.cart.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.sample.rest.jaxrs_hypermedia.simple.business.EntityBuilder;
import org.sample.rest.jaxrs_hypermedia.simple.business.ResourceUriBuilder;
import org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity.BookSelection;
import org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity.Selection;
import org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity.ShoppingCart;

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Path("shopping_cart")
public class CartResource {

    @Inject
    MockShoppingCart shoppingCart;

    @Inject
    EntityBuilder entityBuilder;

    @Inject
    ResourceUriBuilder resourceUriBuilder;

    @Context
    UriInfo uriInfo;

    @GET
    public JsonObject getShoppingCart() {
        final ShoppingCart cart = shoppingCart.getShoppingCart();

        JsonArray bookSelections = cart.getSelections().stream()
                .map(b -> entityBuilder.buildBookSelection(b, resourceUriBuilder.forBookSelection(b, uriInfo), resourceUriBuilder.forBook(b.getBook(), uriInfo)))
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();

        return entityBuilder.buildShoppingCart(cart, bookSelections, resourceUriBuilder.forCheckout(uriInfo));
    }

    @POST
    public void addItem(@Valid @NotNull BookSelection selection) {
        shoppingCart.addBookSelection(selection);
    }

    @PUT
    @Path("{id}")
    public void updateSelection(@PathParam("id") long selectionId, @Valid @NotNull Selection selectionUpdate) {
        shoppingCart.updateBookSelection(selectionId, selectionUpdate.getQuantity());
    }

    @DELETE
    @Path("{id}")
    public void deleteSelection(@PathParam("id") long selectionId) {
        shoppingCart.updateBookSelection(selectionId, 0);
    }
}
