package org.sample.rest.jaxrs_hypermedia.simple.business.cart.entity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.sample.rest.jaxrs_hypermedia.simple.business.books.entity.Book;

public class BookSelection extends Selection {
    
    @XmlTransient
    private long id;
    
    @NotNull
    @XmlJavaTypeAdapter(IsbnBookXmlAdapter.class)
    @XmlElement(name = "isbn")
    private Book book;
    
    @XmlTransient
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
