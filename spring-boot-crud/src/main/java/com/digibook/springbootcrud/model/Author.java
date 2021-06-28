package com.digibook.springbootcrud.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "AUTHOR")

public class Author {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "AUTHOR_ID")
	private long authorId;
	private String authorName;
	
	@ManyToMany(mappedBy = "authors")
    protected Set<Book> books = new HashSet<>();
	

	//getters and setters
	
	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	//constructors
	
    public Author() {
		
	}

	public Author(String authorName, Set<Book> books) {
		super();
		this.authorName = authorName;
		this.books = books;
	}
    
    
}

	
	


