package org.sample.rest.jaxrs_hypermedia.simple.business.books.boundary;

import java.util.List;

import javax.ejb.Stateless;

import org.sample.rest.jaxrs_hypermedia.simple.business.books.entity.Availability;
import org.sample.rest.jaxrs_hypermedia.simple.business.books.entity.Book;

import static java.util.Collections.singletonList;

@Stateless
public class MockBookStore {
    
    public List<Book> getBooks() {
        return singletonList(newBook());
    }
    
    public Book getBook(long id) {
        final Book book = newBook();
        book.setId(id);
        return book;
    }
    
    public Book findBook(String isbn) {
        final Book book = newBook();
        book.setIsbn(isbn);
        return book;
    }
    
    public boolean isAddToCartAllowed(Book book) {
        return book.getAvailability() == Availability.IN_STOCK;
    }
    
    private static Book newBook() {
        Book book = new Book();
        
        book.setId(1L);
        book.setIsbn("1-2345-3456");
        book.setName("Hello World");
        book.setAuthor("Duke");
        book.setAvailability(Availability.IN_STOCK);
        book.setPrice(9.99d);
        
        return book;
    }
}
