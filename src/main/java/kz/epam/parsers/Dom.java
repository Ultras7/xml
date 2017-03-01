package kz.epam.parsers;

import kz.epam.model.AirCompany;
import kz.epam.model.planes.*;
import kz.epam.validator.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import static kz.epam.model.planes.PlanesType.*;


public class Dom {
    private static final Integer ITEM_INDEX = 0;
    private ArrayList<Plane> planes = new ArrayList<>();
    private Plane plane;
    private AirCompany airCompany = new AirCompany();
    private Element e = null;

    public AirCompany parse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(Validator.FILE_NAME);
            NodeList nodeList = document.getElementsByTagName(ELEMENT_PLANE);
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    e = (Element) node;
                    switch (e.getAttribute(PLANE_TYPE)) {
                        case BOEING_747 :
                            plane = new Boeing();
                            getElements(plane);
                            break;
                        case AIRBUS_A320 :
                            plane = new Airbus();
                            getElements(plane);
                            break;
                        case AIRBUS_A321 :
                            plane = new Airbus();
                            getElements(plane);
                            break;
                        case EMBRAER_190 :
                            plane = new Embraer();
                            getElements(plane);
                            break;
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        airCompany.add(planes);
        return airCompany;
    }

    public void getElements(Plane plane) {
        plane.setName(e.getElementsByTagName(ELEMENT_NAME).item(ITEM_INDEX).getTextContent());
        plane.setSeatsNumber(Integer.parseInt(e.getElementsByTagName(ELEMENT_SEATS_NUMBER).item(ITEM_INDEX).getTextContent()));
        plane.setOverallWeight(Integer.parseInt(e.getElementsByTagName(ELEMENT_OVERALL_WEIGHT).item(ITEM_INDEX).getTextContent()));
        plane.setMaxDistance(Integer.parseInt(e.getElementsByTagName(ELEMENT_MAX_DISTANCE).item(ITEM_INDEX).getTextContent()));
        plane.setFuelCapacity(Integer.parseInt(e.getElementsByTagName(ELEMENT_FUEL_CAPACITY).item(ITEM_INDEX).getTextContent()));
        planes.add(plane);
    }


}
