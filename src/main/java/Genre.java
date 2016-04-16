public class Genre {
    private String name;
    private String description;

    public Genre(String name, String description){
        this.name=name;
        this.description=description;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name.length() >0) {
            this.name = name;
        }
        else{
            System.out.println("Name not set");
        }
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        if(description.length()>0) {
            this.description = description;
        }
        else{
            System.out.println("Description not set");
        }
    }

}
