import java.util.ArrayList;
import java.util.List;

public class Book implements Subject{
    private int bookID;
    private String title;
    private String author;
    private Genre genre;
    private int currentUserID;
    private int daysLoaned;
    private int yearPublished;
    private List<Observer> interestedUsers;


    //constructor
    public Book(int bookID, String title, String author, Genre genre, int currentUserID, int daysLoaned, int yearPublished){

        this.bookID=bookID;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.currentUserID=currentUserID;
        this.daysLoaned=daysLoaned;
        this.yearPublished=yearPublished;
        interestedUsers=new ArrayList<Observer>();
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

    public String getAuthor(){
        return author;
    }

    /*public void setAuthor(String author){
        this.author=author;
    }*/

    public Genre getGenre(){
        return genre;
    }

    /*public void setGenre(Genre genre){
        this.genre=genre;

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

    //for the Observer Design Pattern
    @Override
    public void attach(Observer observer){
        interestedUsers.add(observer);//adds the observer to the insertedUsers list
        observer.update(bookID,interestedUsers.size());//updates position for the book added in the observer
    }

    @Override
    public void detach(Observer observer) {
        interestedUsers.remove(observer);//attempts to remove the observer from the list
    }

    @Override
    public void notifyObservers() {
            int position=1;//it is more natural for the user to see an index of 1 for the 1st in the queue
            for(Observer observer: interestedUsers){//sends the new position to each observer in interestedUsers list
                observer.update(bookID,position);
                position++;
            }
    }

    public Observer getNextObserver(){
        Observer first=null;
        if(interestedUsers.size()>0){//returns and removes the nextObserver
            first=interestedUsers.get(0);//retrieve first
            detach(first);
        }
        return first;//can return null
    }


    public void concatObservers(List<Observer> observers){
        interestedUsers.addAll(observers);//concatenates observers with interestedUsers
    }
    /*public void setYearPublished(int yearPublished){
        this.yearPublished=yearPublished;
    }*/


}
