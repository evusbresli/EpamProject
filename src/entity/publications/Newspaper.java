package entity.publications;

public class Newspaper extends Item {
    private static String type = "Newspaper";
    private String publishingHouse;

    public Newspaper(int ID, String name, String publishingHouse) {
        super(ID, name);
        this.publishingHouse = publishingHouse;
    }

    public String getType() { return super.getType() + type; }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", publishing house: " +publishingHouse+ ";";
    }
}
