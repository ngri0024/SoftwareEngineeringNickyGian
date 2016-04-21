public class Genre {
    private String name;
    private String description;

    public Genre(String name, String description){
        this.name=name;
        this.description=description;
    }

    public String getName(){//may be needed in future development
        return name;
    }

    public boolean setName(String name){
        if(name.equals("")) {
            return false;
        }
        this.name=name;
        return true;
    }

    public String getDescription(){
        return description;
    }//may be needed in future development

    public boolean setDescription(String description){
        if(description.equals("")) {
            return false;
        }
        this.description=description;
        return true;
    }

    /*public boolean compare(Genre g){
        return name.equals(g.getName())
                && description.equals(g.getDescription());
    }*/

}
