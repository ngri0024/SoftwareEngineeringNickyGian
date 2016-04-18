import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;//created as userTest class variables
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private List<Book> titleBooks;


    @Before
    public void setUp() throws Exception {
        catalogue= new Catalogue();
        book1 = new Book(1000000, "Harry Potter", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        book2=new Book(2000000, "Harry Potter 2", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        book3=new Book(3000000, "Ron Potter 3", "J. K. Rowling", "Fiction",
                "This book is about a wizard", -1, 0, 2000);
        book4=new Book(4000000, "Spongebob book", "Squares", "Comedy",
                "This book is funny", -1, 0, 2004);
        titleBooks= new ArrayList<Book>();
    }

    @After
    public void tearDown() throws Exception {
        book1= null;
        book2=null;
        book3=null;
        book4=null;
        catalogue=null;
        titleBooks=null;
    }

    @Test
    public void addOneBookTest() throws Exception {//a book is added, this should return true
        assertEquals("Book was not added", true, catalogue.addBook(book1));
    }

    @Test
    public void addDuplicateBookTest() throws Exception {//a book is added, a duplcate book is not added false
        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book with the same ID was added", false, catalogue.addBook(book1));
    }

    @Test
    public void addDifferentBookTest() throws Exception {//a book is added, another book is added both retun true
        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
    }

    @Test
    public void getAllBooksTest() throws Exception {//this is for a getter so not really useful
        titleBooks.add(book1);
        titleBooks.add(book2);
        titleBooks.add(book3);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));

        assertEquals("Lists do not match", titleBooks, catalogue.getAllBooks());

    }

    @Test
    public void searchSubTitleTest() throws Exception {//test for substring
        titleBooks.add(book1);
        titleBooks.add(book2);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));


        assertEquals("Lists do not match", titleBooks, catalogue.searchByTitle("Harry"));

    }
    @Test
    public void searchCapTitleTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));


        assertEquals("Lists do not match", titleBooks, catalogue.searchByTitle("HaRrY"));
        
    }

    @Test
    public void searchGenreTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);
        titleBooks.add(book3);


        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));
        assertEquals("Book was not added", true, catalogue.addBook(book4));

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByGenre(new Genre("Fiction", "This book is about a wizard")));

    }

    @Test
    public void searchYopTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);
        titleBooks.add(book3);


        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));
        assertEquals("Book was not added", true, catalogue.addBook(book4));

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByYearOfPublication(2000));

    }

}