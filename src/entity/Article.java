package entity;

public class Article extends Item {
    private static String type = "Article";
    private String journalist;

    public Article(int ID, String name, String journalist) {
        super(ID, name);
        this.journalist = journalist;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Article.type = type;
    }

    public String getJournalist() {
        return journalist;
    }

    public void setJournalist(String journalist) {
        this.journalist = journalist;
    }

    @Override
    public String toString() {
        return "#" +super.getID()+ " " +type+ ": " +super.toString()+ ", journalist: " +journalist+ ";";
    }
}
