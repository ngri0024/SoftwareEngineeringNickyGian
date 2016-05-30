import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Nicky on 5/30/2016.
 */
public class TitleFilter extends Filter{

    private String title;

    public TitleFilter(String title){
        this.title = title;
    }


    @Override
    public List<Book> search(List<Book> books){
        title= title.toLowerCase();//removed case sensitivity
        List<Book> subTitle= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title)){//comparing the case insensitive title to be a substring
                subTitle.add(b);//adding the book to the list if this condition is satisfied
            }
        }
        return subTitle;
    }
}
