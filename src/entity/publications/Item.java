package entity.publications;

public class Item {
    private int ID;
    private String name;

    Item(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getType() { return "";}

    @Override
    public String toString() { return "\"" +name+ "\""; }
}
