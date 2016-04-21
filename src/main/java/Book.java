public class Book {
    private int bookID;
    private String title;
    private String author;
    private Genre genre;
    private int currentUserID;
    private int daysLoaned;
    private int yearPublished;

    public Book(int bookID, String title, String author, Genre genre, int currentUserID, int daysLoaned, int yearPublished){

        this.bookID=bookID;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.currentUserID=currentUserID;
        this.daysLoaned=daysLoaned;
        this.yearPublished=yearPublished;

    }

    public int getBookID(){
        return bookID;
    }

    /*public void setBookID(int bookID){
        this.bookID=bookID;
    }*/

    public String getTitle(){
        return title;
    }

    /*public void setTitle(String title){
        this.title=title;
    }*/

    /*public String getAuthor(){
        return author;
    }*/

    /*public void setAuthor(String author){
        this.author=author;
    }*/

    public Genre getGenre(){
        return genre;
    }

    /*public void setGenre(String genre,String genreDesc){
        this.genre.setName(genre);
        this.genre.setDescription(genreDesc);
    }*/

    public int getCurrentUserID(){
        return currentUserID;
    }

    public void setCurrentUserID(int currentUserID){
        this.currentUserID=currentUserID;
    }

    public int getDaysLoaned(){
        return daysLoaned;
    }

    public void setDaysLoaned(int daysLoaned){
        this.daysLoaned=daysLoaned;
    }

    public int getYearPublished(){
        return yearPublished;
    }

    /*public void setYearPublished(int yearPublished){
        this.yearPublished=yearPublished;
    }*/


}
