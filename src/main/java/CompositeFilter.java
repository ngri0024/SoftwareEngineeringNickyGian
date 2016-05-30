import java.util.ArrayList;

public class CompositeFilter extends Filter{

    ArrayList<Filter> children;


    public CompositeFilter(){
        children= new ArrayList<Filter>();
    }

    @Override
    public ArrayList<Book> search() {
        ArrayList<Book> books= new ArrayList<Book>();
        int count=0;
        for(Filter child: children){

            if(count==0){
                books=child.search();
            }else{
                books.retainAll(child.search());
            }
            count++;
            //add intersect of lists
        }
        return books;
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
