import java.util.List;

public abstract class Filter {



    //specific to each subclass
    public abstract List<Book> search(List<Book> books);



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
