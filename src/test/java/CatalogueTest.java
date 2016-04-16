import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;//created as userTest class variables
    private Book book;
    private Book differentBook;

    @Before
    public void setUp() throws Exception {
        catalogue= new Catalogue();
        book = new Book(1000000, "Harry Potter", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        differentBook=new Book(2000000, "Harry Potter 2", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
    }

    @After
    public void tearDown() throws Exception {
        book = null;
        differentBook=null;
        catalogue=null;
    }

    @Test
    public void addOneBookTest() throws Exception {//a book is added, this should return true
        assertEquals("Book was not added", true, catalogue.addBook(book));
    }

    @Test
    public void addDuplicateBookTest() throws Exception {//a book is added, a duplcate book is not added false
        assertEquals("Book was not added", true, catalogue.addBook(book));
        assertEquals("Book with the same ID was added", false, catalogue.addBook(book));
    }

    @Test
    public void addDifferentBookTest() throws Exception {//a book is added, another book is added both retun true
        assertEquals("Book was not added", true, catalogue.addBook(book));
        assertEquals("Book was not added", true, catalogue.addBook(differentBook));
    }

}