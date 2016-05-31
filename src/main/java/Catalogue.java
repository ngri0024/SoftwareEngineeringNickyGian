import java.util.ArrayList;
import java.util.List;


public class Catalogue {
    private List<Book> books;

    //for Singleton Design Pattern
    private static Catalogue catalogue=null;
    public static Catalogue getCatalogue(){
        if(catalogue==null){//creates a new instance
            catalogue=new Catalogue();
        }
        return catalogue;//always returns catalogue
    }

    public Catalogue resetInstance(){//created since catalogue uses a singleton design pattern and
        //must be removed for Junit Tests to work as expected
        catalogue=null;
        return null;
    }

    //set as private since only one instance should be made
    private Catalogue() {
        books = new ArrayList<Book>();
    }

    public boolean addBook(Book newBook) {
        int nID = newBook.getBookID();//a book can be added if it has a unique ID
        for (Book b : books) {
            if (b.getBookID() == nID) {//nID is compared with each book before adding the newBook
                return false;
            }
        }
        books.add(newBook);
        return true;
    }

    public List<Book> getAllBooks() {
        return books;
    }


    //using Composite Design pattern
    public List<Book> searchByFilter(Filter filter){
        if(filter==null){
            return books;
        }

        return filter.search(books);

    }


    /*

    public List<Book>  searchByTitle(String title){
        title= title.toLowerCase();//removed case sensitivity
        List<Book> subTitle= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title)){//comparing the case insensitive title to be a substring
                subTitle.add(b);//adding the book to the list if this condition is satisfied
            }
        }
        return subTitle;
    }

    public List<Book>  searchByGenre(Genre genre){
        String gName=genre.getName();//only the genre name is needed
        List<Book> genreBooks= new ArrayList<Book>();
        for (Book b : books) {
            if ((b.getGenre().getName()).equals(gName)){//when the genre name is the same
                //by default the description for that genre should also be the same
                genreBooks.add(b);//adding the book to the list if this condition is satisfied
            }
        }
        return genreBooks;
    }

    public List<Book>  searchByYearOfPublication(int yop){
        List<Book> yopBooks= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getYearPublished()==yop){//when the year of publication is the same
                // the book is added to the list
                yopBooks.add(b);
            }
        }
        return yopBooks;
    }

*/

}
