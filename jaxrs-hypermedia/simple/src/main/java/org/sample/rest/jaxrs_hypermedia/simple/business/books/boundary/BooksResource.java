package org.sample.rest.jaxrs_hypermedia.simple.business.books.boundary;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.sample.rest.jaxrs_hypermedia.simple.business.EntityBuilder;
import org.sample.rest.jaxrs_hypermedia.simple.business.ResourceUriBuilder;
import org.sample.rest.jaxrs_hypermedia.simple.business.books.entity.Book;


@Stateless
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {
    
    @Inject
    MockBookStore bookStore;
    
    @Inject
    EntityBuilder entityBuilder;
    
    @Inject
    ResourceUriBuilder resourceUriBuilder;
    
    @Context
    UriInfo uriInfo;
    
    @GET
    public JsonArray getBooks() {
        
        return bookStore.getBooks().stream()
                .map(b -> entityBuilder.buildBookTeaser(b, resourceUriBuilder.forBook(b, uriInfo)))
                .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                .build();
    }
    
    @GET
    @Path("{id}")
    public JsonObject getBook(@PathParam("id") long id) {
        final Book book = bookStore.getBook(id);

        URI addToCart = null;
        if (bookStore.isAddToCartAllowed(book))
            addToCart = resourceUriBuilder.forShoppingCart(uriInfo);

        return entityBuilder.buildBook(book, resourceUriBuilder.forBook(book, uriInfo), addToCart);
    }
}
