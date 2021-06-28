package digiBook;

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
	private int bookId;
	
	@Column(name = "BOOK_TITLE" , nullable = false)
	private String bookTitle;
	
	@Column(name = "BOOK_DESCRIPTION" , nullable = false)
	private String bookDescription;
	
	@Column(name = "ISSUER" , nullable = false)
	private String issuer;
	
	@Column(name = "DATE_OF_ISSUE"  , updatable = true, nullable = false)
	private int dateOfIssue;
	
	@Enumerated(value=EnumType.STRING)
    @Column(name="CATEGORY")
    private Category category;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BOOK_AUTHOR",
               joinColumns = @JoinColumn(name = "BOOK_ID"),
               inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    protected Set<Author> authors = new HashSet<>();

	//constructors
	
	public Book() {
		
	}
	
	public Book(String bookTitle, String bookDescription, String issuer, int dateOfIssue, Category category,
			Set<Author> authors) {
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

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
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

	//tostring
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookDescription=" + bookDescription
				+ ", issuer=" + issuer + ", dateOfIssue=" + dateOfIssue + ", category=" + category + ", authors="
				+ authors + "]";
	}
	
	
	
	
	

}

	
	
	
	
	


