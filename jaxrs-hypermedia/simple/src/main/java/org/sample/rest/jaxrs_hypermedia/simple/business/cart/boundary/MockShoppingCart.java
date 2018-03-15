package org.sample.rest.jaxrs_hypermedia.simple.business.cart.boundary;

import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.sample.rest.jaxrs_hypermedia.simple.business.books.boundary.MockBookStore;
import org.sample.rest.jaxrs_hypermedia.simple.business.books.entity.Book;
import org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity.BookSelection;
import org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity.ShoppingCart;

@Stateless
public class MockShoppingCart {
    
    @Inject
    MockBookStore bookStore;
    
    public void addBookSelection(BookSelection selection) {
        
    }
    
    public void updateBookSelection(long selectionId, int quantity) {
        // book selection retrieved from id and quantity updated for session
    }

    public ShoppingCart getShoppingCart() {
        final ShoppingCart cart = new ShoppingCart();
        cart.setSelections(bookStore.getBooks().stream().map(this::createBookSelection).collect(Collectors.toSet()));
        cart.setPrice(cart.getSelections().stream().mapToDouble(BookSelection::getPrice).sum());
        return cart;
    }

    private BookSelection createBookSelection(Book book) {
        final BookSelection selection = new BookSelection();
        selection.setId(1L);
        selection.setBook(book);
        selection.setQuantity(2);
        selection.setPrice(book.getPrice() * selection.getQuantity());
        return selection;
    }
}
