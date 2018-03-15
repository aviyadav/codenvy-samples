package org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity;

import javax.enterprise.inject.spi.CDI;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.sample.rest.jaxrs_hypermedia.simple.business.books.boundary.MockBookStore;
import org.sample.rest.jaxrs_hypermedia.simple.business.books.entity.Book;

public class IsbnBookXmlAdapter extends XmlAdapter<String, Book> {
    
    private MockBookStore bookStore;
    
    public IsbnBookXmlAdapter() {
        bookStore = CDI.current().select(MockBookStore.class).get();
    }

    @Override
    public String marshal(Book book) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public Book unmarshal(String isbn) throws Exception {
        return bookStore.findBook(isbn);
    }
    
}
