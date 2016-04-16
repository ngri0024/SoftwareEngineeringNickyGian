import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicky on 4/16/2016.
 */
public class Catalogue {
    private List<Book> books;

    public Catalogue() {
        books = new ArrayList<Book>();
    }

    public boolean addBook(Book newBook) {
        int nID = newBook.getBookID();
        for (Book b : books) {
            if (b.getBookID() == nID) {
                return false;
            }
        }
        books.add(newBook);
        return true;
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
