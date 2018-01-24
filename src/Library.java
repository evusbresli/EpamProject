import entity.Pupils;
import entity.publications.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Library {
    private File library;
    private ArrayList<Item> items;
    private Pupils pupils;

    Library(String root) { this.library = new File(root + "sources/library.txt"); }

    void showAvailable() throws IOException {
        items = FromToFile.readFromLibrary(library);
        System.out.println("\n\tList of available literature:");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    void buildPupils(String rootSystem) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try {
            Document document = builder.parse(rootSystem + "sources/pupilsBase.xml");
            Element root = document.getDocumentElement();
            pupils = new Pupils(ParseFile.pupilListBuilder(root));

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    void showMoreThan1Book() { pupils.getReadingPupils(); }

    void showLessThan3Book() { pupils.getNotReadingPupils(); }
}
