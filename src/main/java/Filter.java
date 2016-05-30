import java.util.ArrayList;

public abstract class Filter {
    public abstract ArrayList<Book> search();

    public boolean addFilter(){
        return false;
    }

    public boolean removeFilter(){
        return false;
    }

    public Filter getChild(int index){
        return null;
    }
}
