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

    public boolean addBooksLoaned(Book newBook) {
        if(booksLoaned.size()<3){
            for(Book book: booksLoaned){
                if(book.getDaysLoaned()>28){
                    return false;
                }
            }
            newBook.setCurrentUserID(ID);
            booksLoaned.add(newBook);
            newBook.setDaysLoaned(0);
            return true;
        }
        return false;//by default returns false
    }

    public boolean removeBooksLoaned(Book toRemove) {
       boolean removed=booksLoaned.remove(toRemove);
        if(removed){
            toRemove.setDaysLoaned(-1);
            toRemove.setCurrentUserID(-1);
        }
        return removed;
    }//call reset method to reset days loaned also set isAvaliable to true

}
