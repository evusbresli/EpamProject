import entity.Pupil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

class ParseFile {

    static ArrayList<Pupil> pupilListBuilder(Element root){

        ArrayList<Pupil> pupilArrayList = new ArrayList<>();
        NodeList pupilNodes = root.getElementsByTagName("pupil");

        for (int i = 0; i < pupilNodes.getLength(); i++){
            Pupil pupil = new Pupil();

            Element pupilElement = (Element) pupilNodes.item(i);
            pupil.setID(pupilElement.getAttribute("ID"));
            pupil.setName(getBabyValue(pupilElement, "name"));
            pupil.setBirthDate(getBabyValue(pupilElement, "birthDate"));
            pupil.setRead(getBabyValue(pupilElement, "read"));

            pupilArrayList.add(pupil);
        }

        return pupilArrayList;
    }

    private static String getBabyValue(Element parent,String childName){
        NodeList childList = parent.getElementsByTagName(childName);
        Element child = (Element) childList.item(0);
        Node node = child.getFirstChild();

        return node.getNodeValue();
    }
}
