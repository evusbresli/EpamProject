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

    static void increaseRead(Element root, String ID){
        ID = "id" + ID;
        NodeList pupilNodes = root.getElementsByTagName("pupil");
        Element pupilElement;
        for (int i = 0; i < pupilNodes.getLength(); i++){
            pupilElement = (Element) pupilNodes.item(i);
            if (pupilElement.getAttribute("ID").equals(ID)){
                int read = Integer.parseInt(getBabyValue(pupilElement, "read"));
                read += 1;
                setBabyValue(pupilElement, Integer.toString(read));
            }
        }
    }

    private static void setBabyValue(Element parent, String newChildName){
        NodeList childList = parent.getElementsByTagName("read");
        Element child = (Element) childList.item(0);
        Node node = child.getFirstChild();
        node.setNodeValue(newChildName);
    }
}
