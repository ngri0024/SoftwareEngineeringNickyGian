import java.util.ArrayList;
import java.util.List;


public class User {
    private int ID;
    private  String name;
    private String surname;
    private List<Book> booksLoaned;

    public User(int ID, String name, String surname) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.booksLoaned = new ArrayList<Book>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooksLoaned() {
        return booksLoaned;
    }

    public boolean addBooksLoaned(Book newBook) {
        if(booksLoaned.size()<3){
            for(Book book: booksLoaned){
                if(book.getDaysLoaned()>28){
                    return false;
                }
            }
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
        }
        return removed;
    }//call reset method to reset days loaned also set isAvaliable to true

}
