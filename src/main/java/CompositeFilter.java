import java.util.*;

public class CompositeFilter extends Filter{

    ArrayList<Filter> children;


    public CompositeFilter(){
        children= new ArrayList<Filter>();
    }

    @Override
    public AbstractSet<Book> search(List<Book> books) {
        AbstractSet<Book> requestedBooks= new TreeSet<Book>();
        int count=0;
        for(Filter child: children){

            if(count==0){
                requestedBooks=child.search(books);
            }else{
                requestedBooks.retainAll(child.search(books));
            }
            count++;
            //add intersect of lists
        }
        return requestedBooks;
    }

    @Override
    public boolean addFilter(Filter filter){
        return children.add(filter);
    }

    @Override
    public boolean removeFilter(Filter filter) {//assuming the filter reference is the same
        return children.remove(filter);
    }

    @Override
    public Filter getChild(int index) {
        if(index>=0 && index<children.size()){
            return children.get(index);
        }
        return null;
    }

}
