
public class Pair {
    private Book book;
    private int position;

    public Pair(Book book, int position){
        this.book=book;
        this.position=position;
    }

    /*
    public void setBook(Book book) {
        this.book = book;
    }*/

    public void setPosition(int position) {
        this.position = position;
    }

    public Book getBook() {
        return book;
    }

    public int getPosition(){
        return position;
    }
}
