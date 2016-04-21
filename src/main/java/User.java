import java.util.ArrayList;
import java.util.List;


public class User {
    private int ID;
    private  String name;
    private String surname;
    private List<Book> booksLoaned;

    public User(int ID, String name, String surname) throws UserException{
        if(!setID(ID)) throw new UserException("Id cannot be smaller than 0");
        if(!setName(name)) throw new UserException("Name cammpt be empty");
        if(!setSurname(surname)) throw new UserException("Surname cannot be empty");
        this.booksLoaned = new ArrayList<Book>();
    }

    public int getID() {
        return ID;
    }

    /* Sets ID if the ID is greater than 1.*/
    public boolean setID(int ID) {
        if(ID <1){
            return false;
        }
        this.ID = ID;
        return true;
    }

    /*public String getName() {
        return name;
    }*/

    /* Sets name if it is not left empty.*/
    public boolean setName(String name) {
        if(name.trim().length()<1){
            return false;
        }
        this.name = name;
        return true;
    }

    /*public String getSurname() {
        return surname;
    }*/

    /* Sets surname if it is not left empty.*/
    public boolean setSurname(String surname) {
        if(surname.trim().length()<1){
            return false;
        }
        this.surname = surname;
        return true;
    }

    /*public List<Book> getBooksLoaned() {
        return booksLoaned;
    }*/

    /* First the book is found in the list of books. */
    public boolean addBooksLoaned(Book newBook) {
        if(booksLoaned.size()<3){
            for(Book book: booksLoaned){
                if(book.getDaysLoaned()>28){ //tests that all books are under 4 weeks
                    return false;
                }
            }
            newBook.setCurrentUserID(ID); //sets book's current userID
            booksLoaned.add(newBook); //adds book to user's list.
            newBook.setDaysLoaned(0); //sets the book's days loaned to 0.
            return true;
        }
        return false;//by default returns false
    }

    /* Removes book from user's list of loaned books.*/
    public boolean removeBooksLoaned(Book toRemove) {
       boolean removed=booksLoaned.remove(toRemove);
        if(removed){
            toRemove.setDaysLoaned(-1); // Sets book's days loaned to -1 meaning it is available.
            toRemove.setCurrentUserID(-1);
        }
        return removed;
    }

}
