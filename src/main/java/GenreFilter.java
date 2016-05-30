import java.util.ArrayList;
import java.util.List;

public class GenreFilter extends Filter{

    private Genre genre;

    public GenreFilter(Genre genre){
        this.genre = genre; //removed case sensitivity
    }


    @Override
    public List<Book>  search(List<Book> books){
        String gName=genre.getName();//only the genre name is needed
        List<Book> genreBooks= new ArrayList<Book>();
        for (Book b : books) {
            if ((b.getGenre().getName()).equals(gName)){//when the genre name is the same
                //by default the description for that genre should also be the same
                genreBooks.add(b);//adding the book to the list if this condition is satisfied
            }
        }
        return genreBooks;
    }
}