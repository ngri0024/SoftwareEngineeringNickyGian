import java.util.ArrayList;
import java.util.List;

public class TitleFilter extends Filter{

    private String title;

    public TitleFilter(String title){
        this.title = title.toLowerCase(); //removed case sensitivity
    }


    @Override
    public List<Book> search(List<Book> books){
        List<Book> subTitle= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title)){//comparing the case insensitive title to be a substring
                subTitle.add(b);//adding the book to the list if this condition is satisfied
            }
        }
        return subTitle;
    }
}
