import java.util.*;

public class CompositeFilter extends Filter{

    ArrayList<Filter> children;


    public CompositeFilter(){
        children= new ArrayList<Filter>();
    }

    @Override
    public List<Book> search(List<Book> books) {
        List<Book> requestedBooks= new ArrayList<Book>();//temporary storage
        int count=0;
        for(Filter child: children){

            if(count==0){
                requestedBooks=child.search(books);//first time simply put as requestedBooks
            }else{
                requestedBooks.retainAll(child.search(books));//else intersection
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
        if(index>=0 && index<children.size()){//limit checking
            return children.get(index);//returns child
        }
        return null;//otherwise null
    }

}
