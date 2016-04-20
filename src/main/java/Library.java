import java.util.ArrayList;
import java.util.List;


public class Library {
    private Catalogue catalogue;
    private List<User> users;
    private final int loanDuration=28;


    public Library(){
        catalogue = new Catalogue();
        users= new ArrayList<User>();
    }

    public boolean addBook(Book newBook){
        return catalogue.addBook(newBook);
    }

    public boolean addUser(User newUser){//
        int nUID = newUser.getID();
        for (User u : users) {
            if (u.getID() == nUID) {
                return false;
            }
        }
        users.add(newUser);
        return true;
    }

    public boolean removeUser(User toRemove) {//has to be the same object
        return users.remove(toRemove);
    }

    public boolean loanBookTo(Book toLoan, User user){
        if(users.contains(user)) {
            for (Book book : catalogue.getAllBooks()) {
                if (book.equals(toLoan)) {
                    if (book.getDaysLoaned() == -1) {//can be loaned
                        return user.addBooksLoaned(toLoan);
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean returnBook(Book toReturn) {
        int userId = toReturn.getCurrentUserID();
        for (User u : users) {
            if (userId == u.getID()) {
                return u.removeBooksLoaned(toReturn);
            }
        }
    return false;
    }
}
