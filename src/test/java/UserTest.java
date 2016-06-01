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
    public void tearDown(){
        book = null;
        book2 = null;
        book3 = null;
        book4 = null;
        user = null;
        fiction=null;
        comedy=null;
    }
    @Test(expected=UserException.class)
    public void badID() throws Exception {//a negative id is used
        user=new User(-2,"Nicky","Griscti");
    }

    @Test(expected=UserException.class)
    public void badName() throws Exception {//no name was given
        user=new User(2,"  ","Griscti");
    }

    @Test(expected=UserException.class)
    public void badSurname() throws Exception {//no surname was given
        user=new User(2,"Nicky","   ");
    }

    @Test
    public void addBooksLoaned(){//a book is added, this should return true
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
    }

    @Test
    public void addMaxBooksLoaned(){//three books added successfully
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not added", true, user.addBooksLoaned(book2));
        assertEquals("Book was not added", true, user.addBooksLoaned(book3));
    }

    @Test
    public void addAboveMaxBooksLoaned() {//4th books not added successfully
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not added", true, user.addBooksLoaned(book2));
        assertEquals("Book was not added", true, user.addBooksLoaned(book3));
        assertEquals("Book was still added", false, user.addBooksLoaned(book4));
    }

    @Test
    public void addOnOverdueLoaned() {//4th books not added successfully
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not added", true, user.addBooksLoaned(book2));
        book2.setDaysLoaned(30);
        assertEquals("Book was added", false, user.addBooksLoaned(book3));
    }

    @Test
    public void removeEmptyBooksLoaned(){//no books are present, therefore this should return false
        assertEquals("Book was removed but was not in the list", false, user.removeBooksLoaned(book));
    }

    @Test
    public void removeValidBooksTest(){//no books are present, therefore this should return false
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was not removed", true, user.removeBooksLoaned(book));
    }

    @Test
    public void removeInvalidBooksTest(){//book to remove does not exist
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
        assertEquals("Book was removed", false, user.removeBooksLoaned(book2));
    }
    }