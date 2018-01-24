import entity.*;

import java.io.*;
import java.util.ArrayList;

abstract class FromToFile {
    static ArrayList<Item> readFromLibrary(File file) throws IOException {
        int ID; String type, name, additional;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<Item> items = new ArrayList<>();
        while ((type = reader.readLine()) != null){
            switch (type){
                case "Article":
                    ID = Integer.parseInt(reader.readLine());
                    name = reader.readLine();
                    additional = reader.readLine();
                    Article article = new Article(ID, name, additional);
                    items.add(article);
                    break;
                case "Book":
                    ID = Integer.parseInt(reader.readLine());
                    name = reader.readLine();
                    additional = reader.readLine();
                    Book book = new Book(ID, name, additional);
                    items.add(book);
                    break;
                case "Journal":
                    ID = Integer.parseInt(reader.readLine());
                    name = reader.readLine();
                    additional = reader.readLine();
                    Journal journal = new Journal(ID, name, additional);
                    items.add(journal);
                    break;
                case "Newspaper":
                    ID = Integer.parseInt(reader.readLine());
                    name = reader.readLine();
                    additional = reader.readLine();
                    Newspaper newspaper = new Newspaper(ID, name, additional);
                    items.add(newspaper);
                    break;
            }
        }

        return items;
    }
}
