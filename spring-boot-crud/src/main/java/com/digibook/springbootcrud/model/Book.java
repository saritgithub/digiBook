package com.digibook.springbootcrud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//mark class as an Entity 
@Entity
//defining class name as Table name 
@Table(name = "BOOKS")

public class Book {
	
	//Defining book id as primary key 
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BOOK_ID")
	private Long bookId;
	
	
	private String bookTitle;
	private String bookDescription;
	private String issuer;
	private int dateOfIssue;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "BORROW_ID")
//     private Borrow borrow;
	
	@Enumerated(value=EnumType.STRING)
    @Column(name="CATEGORY")
    private Category category;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "BOOK_AUTHOR",
    joinColumns = @JoinColumn(name = "BOOK_ID"),
    inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    protected Set<Author> authors = new HashSet<>();
	
	
	

	//constructors
	


	
	

//	public Book(String bookTitle, String bookDescription, String issuer, int dateOfIssue, Borrow borrow,
//			Category category, Set<Author> authors) {
//		
//		this.bookTitle = bookTitle;
//		this.bookDescription = bookDescription;
//		this.issuer = issuer;
//		this.dateOfIssue = dateOfIssue;
//		this.borrow = borrow;
//		this.category = category;
//		this.authors = authors;
//	}
	
	public Book() {
		
	}
	
	public Book(String bookTitle, String bookDescription, String issuer, int dateOfIssue, Category category,
			Set<Author> authors) {
		super();
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.issuer = issuer;
		this.dateOfIssue = dateOfIssue;
		this.category = category;
		this.authors = authors;
	}

	//getters and setters

	
	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public int getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(int dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
		
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
		
	}
	
//	public Borrow getBorrow() {
//		return borrow;
//	}
//
//	public void setBorrow(Borrow borrow) {
//		this.borrow = borrow;
//	}

	
	// hashCode() and equals()

	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((bookDescription == null) ? 0 : bookDescription.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + dateOfIssue;
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookDescription == null) {
			if (other.bookDescription != null)
				return false;
		} else if (!bookDescription.equals(other.bookDescription))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (category != other.category)
			return false;
		if (dateOfIssue != other.dateOfIssue)
			return false;
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		} else if (!issuer.equals(other.issuer))
			return false;
		return true;
	}*/
	

}

