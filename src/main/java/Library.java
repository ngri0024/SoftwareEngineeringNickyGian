import java.util.ArrayList;
import java.util.List;


public class Library {
    private Catalogue catalogue;
    private List<User> users;

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


}
