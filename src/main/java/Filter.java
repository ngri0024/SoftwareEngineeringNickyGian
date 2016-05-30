import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public abstract class Filter {




    public abstract AbstractSet<Book> search(List<Book> books);



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
