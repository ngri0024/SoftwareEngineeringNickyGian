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

    public boolean addUser(User newUser){
        int nUID = newUser.getID();
        for (User u : users) {
            if (u.getID() == nUID) {
                return false;
            }
        }
        users.add(newUser);
        return true;
    }

    public boolean removeUser(User toRemove) {
        return users.remove(toRemove);
    }

    public boolean loanBookTo(Book toLoan, User user){


    }

}
