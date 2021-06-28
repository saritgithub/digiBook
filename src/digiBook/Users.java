package digiBook;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_DETAILS")
public class Users {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "FIRST_NAME" , nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME" , nullable = false)
	private String lastName;
	
	/*@Column(name = "ADDRESS" , nullable = false)
	private String address;*/
	
	@Column(name = "TELEPHONE" , nullable = false)
	private String telephone;
	
	@Column(name = "EMAIL" , nullable = false )
	private String email;
	
	@Column(name = "USERNAME" , nullable = false)
	private String userName;
	
	@Column(name = "PASSWORD" , nullable = false)
	private String password;
	
	@Column(name = "JOINED_DATE" )
	@Temporal(TemporalType.DATE)
	private Date JoinedDate;
	
	@Column(name = "TAKEN_DATE" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date takenDate;
	
	@Column(name = "RETURN_DATE" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;
	
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Borrow borrow;
	
	//getters and setters

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}*/

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinedDate() {
		return JoinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		JoinedDate = joinedDate;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	
	
}
