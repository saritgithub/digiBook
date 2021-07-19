package com.digibook.springbootcrud.model;

	import java.util.Date;

    import javax.persistence.CascadeType;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

	@Entity
	@Table(name = "BORROWS")

	public class Borrow {
		
		@Id 
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		@Column(name = "BORROW_ID")
		private long borrowId;
		
		
		
		/*@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "TAKEN_DATE")
		@CreatedDate
		private Date takenDate;
		
		
		
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "RETURN_DATE")
		@LastModifiedDate
		private Date returnDate;*/
		
		@CreationTimestamp
		@Column(name="taken_Date", nullable=false, updatable=false)
		private Date takenDate;
		
		
		@Column(name="return_Date")
		private Date returnDate;
		
		 @OneToOne(cascade = CascadeType.ALL)
		    @JoinColumn(name = "BOOK_ID")
		     private Book book;
		 
		 @OneToOne(cascade = CascadeType.ALL)
		    @JoinColumn(name = "USER_ID")
		     private Users users;
		
		//getters and setters
		
		public long getBorrowId() {
			return borrowId;
		}

		public void setBorrowId(long borrowId) {
			this.borrowId = borrowId;
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

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
		}

		//constructors
		
		 public Borrow() {
				
			}

		public Borrow(Date takenDate, Date returnDate, Book book, Users users) {
			super();
			this.takenDate = takenDate;
			this.returnDate = returnDate;
			this.book = book;
			this.users = users;
		}
		
		 // hashCode() and equals()

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((book == null) ? 0 : book.hashCode());
			result = prime * result + (int) (borrowId ^ (borrowId >>> 32));
			result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
			result = prime * result + ((takenDate == null) ? 0 : takenDate.hashCode());
			result = prime * result + ((users == null) ? 0 : users.hashCode());
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
			Borrow other = (Borrow) obj;
			if (book == null) {
				if (other.book != null)
					return false;
			} else if (!book.equals(other.book))
				return false;
			if (borrowId != other.borrowId)
				return false;
			if (returnDate == null) {
				if (other.returnDate != null)
					return false;
			} else if (!returnDate.equals(other.returnDate))
				return false;
			if (takenDate == null) {
				if (other.takenDate != null)
					return false;
			} else if (!takenDate.equals(other.takenDate))
				return false;
			if (users == null) {
				if (other.users != null)
					return false;
			} else if (!users.equals(other.users))
				return false;
			return true;
		}
		 
		
		

}
