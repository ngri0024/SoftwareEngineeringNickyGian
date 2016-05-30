import java.util.ArrayList;

public abstract class Filter {
    public abstract ArrayList<Book> search();

    public boolean addFilter(Filter filter){
        return false;
    }

    public boolean removeFilter(Filter filter){
        return false;
    }

    public Filter getChild(int index){
        return null;
    }
}
