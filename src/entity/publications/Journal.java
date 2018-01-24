package entity.publications;

public class Journal extends Item {
    private static String type = "Journal";
    private String publishingHouse;

    public Journal(int ID, String name, String publishingHouse) {
        super(ID, name);
        this.publishingHouse = publishingHouse;
    }

    public String getType() { return super.getType() + type; }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", publishing house: " +publishingHouse+ ";";
    }
}

