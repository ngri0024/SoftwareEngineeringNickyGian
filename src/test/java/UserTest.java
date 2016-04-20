import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UserTest {
    private User user;//created as userTest class variables
    private Book book;
    private Book book2;
    private Book book3;
    private Book book4;
    private Genre fiction;
    private Genre comedy;


    @Before
    public void setUp() throws Exception {
        fiction = new Genre("Fiction", "This book is about a wizard");
        comedy = new Genre("Comedy", "This book is funny");
        book = new Book(1000000, "Harry Potter", "J. K. Rowling",  fiction, -1, 0, 2000);
        book2 = new Book(2000000, "Harry Potter 2", "J. K. Rowling", fiction, -1, 0, 2000);
        book3 = new Book(3000000, "Ron Potter 3", "J. K. Rowling", fiction , -1, 0, 2000);
        book4 = new Book(4000000, "Spongebob book", "Squares", comedy, -1, 0, 2004);
        user = new User(5000000, "Nicky", "Griscti Soler");
    }

    @After
    public void tearDown() throws Exception {
        book = null;
        book2 = null;
        book3 = null;
        book4 = null;
        user = null;
        fiction=null;
        comedy=null;
    }

    @Test
    public void addBooksLoaned() throws Exception {//a book is added, this should return true
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
    }

    @Test
    public void addMaxBooksLoaned() throws Exception {//three books added successfully
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not added", true, user.addBooksLoaned(book2));
        assertEquals("Book was not added", true, user.addBooksLoaned(book3));
    }

    @Test
    public void addAboveMaxBooksLoaned() throws Exception {//4th books not added successfully
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not added", true, user.addBooksLoaned(book2));
        assertEquals("Book was not added", true, user.addBooksLoaned(book3));
        assertEquals("Book was still added", false, user.addBooksLoaned(book4));
    }

    @Test
    public void addOnOverdueLoaned() throws Exception {//4th books not added successfully
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not added", true, user.addBooksLoaned(book2));
        book2.setDaysLoaned(30);
        assertEquals("Book was added", false, user.addBooksLoaned(book3));
    }

    @Test
    public void removeEmptyBooksLoaned() throws Exception {//no books are present, therefore this should return false
        assertEquals("Book was not removed because it was not in the list", false, user.removeBooksLoaned(book));
    }

    @Test
    public void removeValidBooksTest() throws Exception {//no books are present, therefore this should return false
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not removed", true, user.removeBooksLoaned(book));
    }

    @Test
    public void removeInvalidBooksTest() throws Exception {//book to remove does not exist
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was removed", false, user.removeBooksLoaned(book2));
    }
    }