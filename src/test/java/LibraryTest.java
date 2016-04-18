import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nicky on 4/18/2016.
 */
public class LibraryTest {


    private User user1;
    private User user2;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Library library;


    @Before
    public void setUp() throws Exception {
        library = new Library();
        user1 = new User(1, "Gian", "Laferla");
        user2 = new User(2, "Nicky", "Soler");
        book1 = new Book(1000000, "Harry Potter", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        book2 = new Book(2000000, "Harry Potter 2", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        book3 = new Book(3000000, "Ron Potter 3", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        book4 = new Book(4000000, "Spongebob book", "Squares", "Comedy",
                "This book is funny", -1, 0, 2004);
    }

    @After
    public void tearDown() throws Exception {
        library = null;
        user1 = null;
        user2 = null;
        book1 = null;
        book2 = null;
        book3 = null;
        book4 = null;
    }

    @Test
    public void addOneUserTest() throws Exception {//a single User is added to the library
        assertEquals("User was not added", true, library.addUser(user1));
    }

    @Test
    public void addDuplicateUserTest() throws Exception {//a user with the same ID cannot be added
        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User with the same ID was added", false, library.addUser(user1));
    }

    @Test
    public void addDifferentUserTest() throws Exception {//two users are added successfully
        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));
    }

    @Test
    public void removeValidUserTest() throws Exception {
        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not deleted", true, library.removeUser(user1));
    }

    @Test
    public void removeInvalidUserTest() throws Exception {
        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not deleted", false, library.removeUser(user2));
    }
}