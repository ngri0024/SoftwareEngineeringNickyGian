import java.util.ArrayList;
import java.util.List;

public class YOPFilter extends Filter{

    private int yop;

    public YOPFilter(int yop){
        this.yop = yop;//removed case sensitivity
    }

    @Override
    public List<Book>  search(List<Book> books){
        List<Book> yopBooks= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getYearPublished()==yop){//when the year of publication is the same
                // the book is added to the list
                yopBooks.add(b);
            }
        }
        return yopBooks;
    }
}
