package entity;

public class Journal extends Item{
    private static String type = "Journal";
    private String publishingHouse;

    public Journal(int ID, String name, String publishingHouse) {
        super(ID, name);
        publishingHouse = publishingHouse;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Journal.type = type;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        publishingHouse = publishingHouse;
    }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", publishing house: " +publishingHouse+ ";";
    }
}

