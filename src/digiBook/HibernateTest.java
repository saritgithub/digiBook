package digiBook;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		Users users = new Users();
		users.setUserId(0);
		users.setFirstName("John");
		users.setLastName("Lennon");
		//users.setAddress("Liverpool");
		users.setTelephone("123456");
		users.setEmail("lennon@gmail.com");
		users.setUserName("John Lennon");
		users.setPassword("123456");
		users.setJoinedDate(new Date());
		users.setTakenDate(new Date());
		users.setReturnDate(new Date());
		
		Book book = new Book();
		book.setBookId(0);
		book.setBookTitle("A day in a life");
		book.setBookDescription("this is book description");
		book.setIssuer("Privat");
		book.setDateOfIssue(2000);
		book.setCategory(Category.MUSIC);
		
		Book book1 = new Book();
		book1.setBookId(0);
		book1.setBookTitle("Two days in a life");
		book1.setBookDescription("this is book two description");
		book1.setIssuer("Privat two");
		book1.setDateOfIssue(2002);
		book1.setCategory(Category.BIOGRAPHY);
		
		Book book2 = new Book();
		book2.setBookId(0);
		book2.setBookTitle("Three days in a life");
		book2.setBookDescription("this is book three description");
		book2.setIssuer("Privat three");
		book2.setDateOfIssue(2003);
		book2.setCategory(Category.DRAMA);
		
		Borrow borrow = new Borrow();
		borrow.setUserId(0);
		borrow.setBookId(2);
		borrow.setTakenDate(new Date());
		borrow.setReturnDate(new Date());
		
		Author author = new Author();
		author.setAuthorId(0);
		author.setAuthorName("author");
		
		Address address = new Address();
		address.setStreet("street");
		address.setCity("city");
		address.setCountry("country");
		address.setZipcode("12345");
		users.setAddress(address);
		
		users.setBorrow(borrow);
		borrow.setUsers(users);
		book.setAuthors(null);
		author.setBooks(null);
		
		
		
		
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
         session.save(users);
         session.save(book);
         session.save(book1);
         session.save(book2);
         session.save(borrow);
         session.save(author);
         
         session.getTransaction().commit();
         session.close();
         sessionFactory.close();
         
         
         

	}

}
