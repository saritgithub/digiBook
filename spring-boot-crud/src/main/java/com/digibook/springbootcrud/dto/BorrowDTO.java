package com.digibook.springbootcrud.dto;

import java.util.Date;

public class BorrowDTO {
	private long userId;
	private Date takenDate;
	private long bookId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getTakenDate() {
		return takenDate;
	}
	public void setTakenDate(Date takenDate) {
		this.takenDate = takenDate;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	

}
