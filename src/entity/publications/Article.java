package entity.publications;

public class Article extends Item {
    private static String type = "Article";
    private String journalist;

    public Article(int ID, String name, String journalist) {
        super(ID, name);
        this.journalist = journalist;
    }

    public String getType() { return super.getType() + type; }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", journalist: " +journalist+ ";";
    }
}
