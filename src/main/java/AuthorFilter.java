import java.util.ArrayList;
import java.util.List;

public class AuthorFilter extends Filter{

    private String author;

    public AuthorFilter(String author){
        this.author = author.toLowerCase();//removed case sensitivity
    }


    @Override
    public List<Book> search(List<Book> books){
        List<Book> authorBooks= new ArrayList<Book>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(author)){//comparing the case insensitive author to be a substring
                authorBooks.add(b);//adding the book to the list if this condition is satisfied
            }
        }
        return authorBooks;
    }
}
