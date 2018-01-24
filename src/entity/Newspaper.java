package entity;

public class Newspaper extends Item{
    private static String type = "Newspaper";
    private String publishingHouse;

    public Newspaper(int ID, String name, String publishingHouse) {
        super(ID, name);
        this.publishingHouse = publishingHouse;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Newspaper.type = type;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", publishing house: " +publishingHouse+ ";";
    }
}
