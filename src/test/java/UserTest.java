import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UserTest {
    private User user;//created as userTest class variables
    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book(1000000, "Harry Potter", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        user = new User(5000000, "Nicky", "Griscti Soler", new ArrayList<Book>());
    }

    @After
    public void tearDown() throws Exception {
        book = null;
        user = null;
    }

    @Test
    public void addBooksLoaned() throws Exception {//a book is added, this should return true
        assertEquals("Book was not added", true, user.addBooksLoaned(book));
    }

    @Test
    public void removeBooksLoaned() throws Exception {//no books are present, therefore this should return false
        assertEquals("Book was not removed because it was not in the list", false, user.removeBooksLoaned(book));
    }

}