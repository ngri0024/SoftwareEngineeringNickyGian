import java.util.ArrayList;
import java.util.List;


public class Library {
    private Catalogue catalogue;
    private List<User> users;
    private final int loanDuration=28;

    /* The library will have a catalogue containing the list of books, and a list of users.*/
    public Library(){
        catalogue = Catalogue.getCatalogue();
        users= new ArrayList<User>();
    }


    public Library destroyLibrary(){//created since catalogue uses a singleton design pattern and
        //must be removed for JunitTests to work as expected
        catalogue=catalogue.resetInstance();//needed for JUnit
        return null;
    }


    public boolean addBook(Book newBook){
        return catalogue.addBook(newBook);
    }

    /* This function is used to add a user to the list.
    Every user's ID must be unique.*/
    public boolean addUser(User newUser){
        int nUID = newUser.getID();
        for (User u : users) {
            if (u.getID() == nUID) {//user is checked not to be in the list before adding
                return false;
            }
        }
        users.add(newUser);
        return true;
    }

    /* Removes the user from the list.*/
    public boolean removeUser(User toRemove) {//has to same ID
        int userId = toRemove.getID();
        for(User user:users) {
            if (user.getID() == userId) {//the user id must match that of a user in the list to be deleted
                return users.remove(user);

            }
        }
        return false;
    }

    /* Finds the user in the list of users.
    * Find the book to loan from the catalogue.
    * If that book is already loaned, returns false.*/
    public boolean loanBookTo(Book toLoan, User user){
        int loanId = toLoan.getBookID();
        int userId = user.getID();
        boolean userInSystem=false;
        for(User u:users) {
            if (u.getID() == userId) {//the user must exist in the library
                userInSystem = true;
                user=u;//changing reference
                break;
            }
        }
        if(userInSystem) {
            for (Book book : catalogue.getAllBooks()) {
                if (book.getBookID() == loanId) {//to match the book
                    if (book.getDaysLoaned() == -1) {//can be loaned
                        return user.addBooksLoaned(book);
                    } else {//is already loaned
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /* The user is found in the list of users.
    * If found, his book is removed.*/
    public boolean returnBook(Book toReturn) {
        int userId = toReturn.getCurrentUserID();
        for (User u : users) {
            if (userId == u.getID()) {
                if(u.removeBooksLoaned(toReturn)){
                   loanToNextInterested(toReturn);//tries to loan the book to the next Interested User
                    return true;
                }else{
                    return false;
                }
            }
        }
    return false;
    }

    public boolean registerInterest(Book book, User user){
        int loanId = book.getBookID();
        int userId = user.getID();
        boolean userInSystem=false;
        for(User u:users) {
            if (u.getID() == userId) {//the user must exist in the library
                userInSystem = true;
                user=u;//changing reference
                break;
            }
        }

        //user must be in system, and book interested in must not already be loaned to that user
        if(userInSystem && (book.getCurrentUserID() != user.getID())) {
            for (Book b: catalogue.getAllBooks()) {
                if (b.getBookID() == loanId) {//to match the book
                    if (b.getDaysLoaned() == -1) {//is available
                        return false;
                    } else {//is already loaned, register interest
                        if(user.addInterestedBook(b)) {//might already be in the users interestedBooks list
                            b.attach(user);
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean loanToNextInterested(Book book){
        List<Observer> temp= new ArrayList<Observer>();
        Observer currentObserver;
        for (Book b : catalogue.getAllBooks()) {
            if(b.getBookID() == book.getBookID()) {//to match the book
               while((currentObserver=b.getNextObserver())!=null){
                   if(loanBookTo(b,(User)currentObserver)){//attemp to loan the book to the currentObserver
                       b.concatObservers(temp);//concatenate unsuccessfully loaned to users list
                       b.notifyObservers();//send notification
                       return true;
                   }else{
                       temp.add(currentObserver);//just add to the list
                   }

               }
                b.concatObservers(temp);//concatenate unsuccessfully loaned to users list
            }
        }
        return true;
    }
}
