import java.util.ArrayList;
import java.util.List;


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

    public List<Book>  searchByTitle(String title){
        title= title.toLowerCase();
        List<Book> subTitle= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title)){
                subTitle.add(b);
            }
        }
        return subTitle;
    }

    public List<Book>  searchByGenre(Genre genre){
        List<Book> genreBooks= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getGenre().compare(genre)){
                genreBooks.add(b);
            }
        }
        return genreBooks;
    }



}
