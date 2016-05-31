import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class CatalogueTest {

    private Catalogue catalogue;//created as userTest class variables
    private Filter filter;
    private Filter filter1;
    private Filter filter2;
    private Filter filter3;
    private Filter filter4;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private List<Book> titleBooks;
    private Genre fiction;
    private Genre comedy;


    @Before
    public void setUp() throws Exception {

        catalogue= Catalogue.getCatalogue();
        fiction = new Genre("Fiction", "This book is about a wizard");
        comedy = new Genre("Comedy", "This book is funny");
        book1 = new Book(1000000, "Harry Potter", "J. K. Rowling",  fiction, -1, 0, 2000);
        book2 = new Book(2000000, "Harry Potter 2", "J. K. Rowling", fiction, -1, 0, 2000);
        book3 = new Book(3000000, "Ron Potter 2", "J. K. Trolling", fiction , -1, 0, 2000);
        book4 = new Book(4000000, "Spongebob book", "Squares", comedy, -1, 0, 2004);
        book5 =new Book(5000000, "Fake Potter 2", "J. K. Trolling", comedy , -1, 0, 2000);
        titleBooks= new ArrayList<Book>();
    }

    @After
    public void tearDown() throws Exception {
        filter = null;
        filter1 = null;
        filter2 = null;
        filter3 = null;
        filter4 = null;
        book1= null;
        book2=null;
        book3=null;
        book4=null;
        book5=null;
        catalogue=catalogue.resetInstance();
        titleBooks=null;
        comedy=null;
        fiction=null;
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

        filter = new TitleFilter("Harry");
        assertEquals("Lists do not match", titleBooks, catalogue.searchByFilter(filter));

    }

    @Test
    public void searchCapTitleTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));

        filter = new TitleFilter("HaRrY");
        assertEquals("Lists do not match", titleBooks, catalogue.searchByFilter(filter));
        
    }


    @Test
    public void searchAuthorTest() throws Exception {//test for substring
        titleBooks.add(book1);
        titleBooks.add(book2);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));

        filter = new AuthorFilter("Rowling");
        assertEquals("Lists do not match", titleBooks, catalogue.searchByFilter(filter));
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

        filter = new GenreFilter(fiction);

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));
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

        filter = new YOPFilter(2000);

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));
    }


    @Test //search by year and name
    public void searchNameYopTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);


        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));
        assertEquals("Book was not added", true, catalogue.addBook(book4));

        filter = new CompositeFilter();
        filter1 = new YOPFilter(2000);
        filter2 = new TitleFilter("HaRrY");

        filter.addFilter(filter1);
        filter.addFilter(filter2);

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));
    }

    @Test //testing remove
    public void removeFilterTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);
        titleBooks.add(book3);
        titleBooks.add(book5);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));
        assertEquals("Book was not added", true, catalogue.addBook(book4));
        assertEquals("Book was not added", true, catalogue.addBook(book5));

        filter = new CompositeFilter();
        filter1 = new YOPFilter(2000);
        filter2 = new TitleFilter("HaRrY");

        filter.addFilter(filter1);
        filter.addFilter(filter2);
        filter.removeFilter(filter2);

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));
    }

    @Test //testing getChild()
    public void getChildFilterTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);
        titleBooks.add(book3);
        titleBooks.add(book5);

        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));
        assertEquals("Book was not added", true, catalogue.addBook(book4));
        assertEquals("Book was not added", true, catalogue.addBook(book5));

        filter = new CompositeFilter();
        filter1 = new YOPFilter(2000);
        filter2 = new TitleFilter("HaRrY");

        filter.addFilter(filter1);
        filter.addFilter(filter2);
        filter = filter.getChild(0);

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));

        filter = filter.getChild(0);

        titleBooks.remove(book5); //remo
        titleBooks.add(book4); //added missing book
        titleBooks.add(book5); //added missing book

        //filter is null therefore all books should be returned
        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));

    }

    @Test //testing getChild()
    public void nullFilterTest() throws Exception {//tests for case sensitivity
        titleBooks.add(book1);
        titleBooks.add(book2);
        titleBooks.add(book3);
        titleBooks.add(book4);
        titleBooks.add(book5);


        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book3));
        assertEquals("Book was not added", true, catalogue.addBook(book4));
        assertEquals("Book was not added", true, catalogue.addBook(book5));

        filter = new CompositeFilter();
        filter = filter.getChild(0);

        //filter is null therefore all books should be returned
        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));

    }

    @Test //search by year and name
    public void searchNameYopGenreTest() throws Exception {//tests for case sensitivity

        titleBooks.add(book5);


        assertEquals("Book was not added", true, catalogue.addBook(book1));
        assertEquals("Book was not added", true, catalogue.addBook(book2));
        assertEquals("Book was not added", true, catalogue.addBook(book5));
        assertEquals("Book was not added", true, catalogue.addBook(book4));

        filter = new CompositeFilter();
        filter3 = new CompositeFilter();

        filter1 = new YOPFilter(2000);
        filter2 = new TitleFilter("Potter 2");

        filter4 = new GenreFilter(comedy);


        filter.addFilter(filter1);
        filter.addFilter(filter2);

        filter3.addFilter(filter4);

        filter.addFilter(filter3);

        assertEquals("Lists do not match", titleBooks,
                catalogue.searchByFilter(filter));
    }

}