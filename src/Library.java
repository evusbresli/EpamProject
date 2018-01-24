import entity.Pupils;
import entity.publications.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Library {
    private File library;
    private ArrayList<Item> items;
    private Pupils pupils;
    private Element root;

    private static final String FILENAME = "sources/pupilsBase.xml";

    Library(String root) { this.library = new File(root + "sources/library.txt"); }

    void showAvailable() throws IOException {
        items = FromToFile.readFromLibrary(library);
        System.out.println("\n\tList of available literature:");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    void readSmth(String ID, String publicationID, String rootSystem){
        for (Item item : items){
            if (item.getID() == Integer.parseInt(publicationID)){
                if (item.getType().equals("Book")) {
                    ParseFile.increaseRead(root, ID);

                    try {
                        Transformer transformer = TransformerFactory.newInstance().newTransformer();
                        DOMSource source = new DOMSource(root);
                        StreamResult result = new StreamResult(new File(rootSystem + FILENAME));
                        transformer.transform(source, result);
                    } catch (TransformerException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("You've read this " + item.getType() + ".");
                return;
            }
        }
        System.out.println("Sorry. Publication with such ID not found...");
    }

    void buildPupils(String rootSystem) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try {
            Document document = builder.parse(rootSystem + FILENAME);
            root = document.getDocumentElement();
            pupils = new Pupils(ParseFile.pupilListBuilder(root));

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    boolean acceptID(String ID){ return pupils.acceptID(ID); }

    String greeting(String ID) { return pupils.greeting(ID); }

    void showMoreThan1Book() { pupils.getReadingPupils(); }

    void showLessThan3Book() { pupils.getNotReadingPupils(); }
}
