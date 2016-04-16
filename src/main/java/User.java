import java.util.List;


public class User {
    private int ID;
    private  String name;
    private String surname;
    private List<Book> booksLoaned;

    public User(int ID, String name, String surname, List<Book> booksLoaned) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.booksLoaned = booksLoaned;
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
            booksLoaned.add(newBook);
            return true;
        }
        return false;//by default returns false
    }

    public boolean removeBooksLoaned(Book toRemove) {
        return booksLoaned.remove(toRemove);
    }

}
