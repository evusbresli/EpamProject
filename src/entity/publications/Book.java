package entity.publications;

public class Book extends Item {
    private static String type = "Book";
    private String author;

    public Book(int ID, String name, String author) {
        super(ID, name);
        this.author = author;
    }

    public String getType() { return super.getType() + type; }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", author: " +author+ ";";
    }
}
