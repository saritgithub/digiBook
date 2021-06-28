package digiBook;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BORROWS")

public class Borrow {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "UDER_ID")
	private long userId;
	
	@Column(name = "BOOK_ID"  , updatable = true, nullable = false)
	private int bookId;
	
	@Column(name = "TAKEN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date takenDate;
	
	@Column(name = "RETURN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "UDER_ID")
    private Users users;
	
	//getters and setters

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getTakenDate() {
		return takenDate;
	}

	public void setTakenDate(Date takenDate) {
		this.takenDate = takenDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
	

}
