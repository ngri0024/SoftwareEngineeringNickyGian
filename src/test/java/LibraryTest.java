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
    private User user3;
    private User user4;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Genre fiction;
    private Genre comedy;
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        fiction = new Genre("Fiction", "This book is about a wizard");
        comedy = new Genre("Comedy", "This book is funny");
        user1 = new User(1, "Gian", "Laferla");
        user2 = new User(2, "Nicky", "Soler");
        user3 = new User(3, "Jonny", "Borg");
        user4 = new User(4, "Glenn", "Sciortino");
        book1 = new Book(1000000, "Harry Potter", "J. K. Rowling",  fiction, -1, -1, 2000);
        book2 = new Book(2000000, "Harry Potter 2", "J. K. Rowling", fiction, -1, -1, 2000);
        book3 = new Book(3000000, "Ron Potter 3", "J. K. Rowling", fiction , -1, -1, 2000);
        book4 = new Book(4000000, "Spongebob book", "Squares", comedy, -1, -1, 2004);

    }

    @After
    public void tearDown() throws Exception {
        library = library.destroyLibrary();
        user1 = null;
        user2 = null;
        user3 = null;
        user4 = null;
        book1 = null;
        book2 = null;
        book3 = null;
        book4 = null;
        fiction=null;
        comedy=null;
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

    @Test
    public void notFoundLoanTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("Book was Loaned", false, library.loanBookTo(book4,user1));
    }

    @Test
    public void validLoanTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("User was not added",true, library.addUser(user1));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book3,user1));
    }

    @Test
    public void noUserLoanTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("Book was Loaned", false, library.loanBookTo(book3,user1));
    }

    @Test
    public void invalidLoanTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        book1.setDaysLoaned(29);
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was Loaned", false, library.loanBookTo(book3,user1));
    }

    @Test
    public void loanToUnAuthorisedTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("User was not added", true, library.addUser(user2));
        assertEquals("Book was Loaned", false, library.loanBookTo(book3,user1));
    }

    @Test
    public void loanedToOtherTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("User was not added", true, library.addUser(user1));
        book3.setDaysLoaned(20);
        assertEquals("Book was Loaned", false, library.loanBookTo(book3,user1));
    }


    @Test
    public void returnBookTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("Book was Loaned", true, library.loanBookTo(book1,user1));
        assertEquals("Book was not returned", true, library.returnBook(book1));
    }

    @Test
    public void InvalidReturnBookTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));
        assertEquals("Book was removed", false, library.returnBook(book2));
    }

    @Test
    public void registerInterestTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));

        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));

        assertEquals("Book was not Registered", true, library.registerInterest(book1,user2)); //user 2 registers interest
        assertEquals("Book was Registered", false, library.registerInterest(book1,user2)); //user 2 tries to register same interest again
        assertEquals("Book was Registered", false, library.registerInterest(book1,user1)); //user 1 tries to register interest on book it already has
        assertEquals("Book was Registered", false, library.registerInterest(book2,user1)); //user 1 tries to register interest on an available book
    }


    @Test
    public void loanToNextInterestedTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));

        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));

        assertEquals("Book was not Registered", true, library.registerInterest(book1,user2));

        assertEquals("Book was not returned", true, library.returnBook(book1)); //returns from user 1 and gives to user 2
        assertEquals("Book was not returned", true, library.returnBook(book1)); //returns from user 2
        assertEquals("Book was returned", false, library.returnBook(book1)); //Book is not loaned out

    }


    @Test //user has 3 books and next interested book cannot be loaned to user
    public void loanToNextFullUserTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("Book was not added", true, library.addBook(book4));


        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book2,user2));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book3,user2));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book4,user2));

        assertEquals("Book was not Registered", true, library.registerInterest(book1,user2));

        assertEquals("Book was not returned", true, library.returnBook(book1));
        assertEquals("Book was returned", false, library.returnBook(book1));
    }

    @Test //user had 3 books, interested book was not loaned. User then returns a book and tries to loan the book he was interested in.
    public void loanInterestedBookUserTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));
        assertEquals("Book was not added", true, library.addBook(book4));


        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));


        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book2,user1));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book3,user1));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book4,user2));

        assertEquals("Book was not Registered", true, library.registerInterest(book4,user1));

        assertEquals("Book was not returned", true, library.returnBook(book4));
        assertEquals("Book was not returned", true, library.returnBook(book1));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book4,user1));
    }

    @Test
    public void notifyObserservsTest() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));

        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));
        assertEquals("User was not added", true, library.addUser(user3));
        assertEquals("User was not added", true, library.addUser(user4));


        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));

        assertEquals("Book was not Registered", true, library.registerInterest(book1,user2));
        assertEquals("Book was not Registered", true, library.registerInterest(book1,user3));
        assertEquals("Book was not Registered", true, library.registerInterest(book1,user4));

        assertEquals("Book was not returned", true, library.returnBook(book1)); //book returned from user 1
        assertEquals("Book was not returned", true, library.returnBook(book1)); //book returned from user 2
        assertEquals("Book was not returned", true, library.returnBook(book1)); //book returned from user 3
        assertEquals("Book was not returned", true, library.returnBook(book1)); //book returned from user 4
        assertEquals("Book was returned", false, library.returnBook(book1)); //book sohuld not be returned
    }

    @Test
    public void iterateThroughInterestedBooks() throws Exception {
        assertEquals("Book was not added", true, library.addBook(book1));
        assertEquals("Book was not added", true, library.addBook(book2));
        assertEquals("Book was not added", true, library.addBook(book3));

        assertEquals("User was not added", true, library.addUser(user1));
        assertEquals("User was not added", true, library.addUser(user2));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book1,user1));
        assertEquals("Book was not Loaned", true, library.loanBookTo(book2,user2));

        assertEquals("Book was not Registered", true, library.registerInterest(book2,user1));

        assertEquals("Book was not Loaned", true, library.loanBookTo(book3,user1));

    }
}