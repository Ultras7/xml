package kz.epam.parsers;

import kz.epam.model.AirCompany;
import kz.epam.model.planes.Airbus;
import kz.epam.model.planes.Boeing;
import kz.epam.model.planes.Embraer;
import kz.epam.model.planes.Plane;
import kz.epam.validator.Validator;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static kz.epam.model.planes.PlanesType.*;


public class Stax {
    private static final Integer ITEM_INDEX = 0;
    private ArrayList<Plane> planes = new ArrayList<>();
    private AirCompany airCompany = new AirCompany();
    private Plane plane;
    private String str = "";

    public AirCompany parse() {
        XMLInputFactory factory = XMLInputFactory.newFactory();

        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(Validator.FILE_NAME));
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT :
                        if (reader.getLocalName().equals(ELEMENT_PLANE)) {

                            switch (reader.getAttributeValue(ITEM_INDEX)) {
                                case BOEING_747 :
                                    plane = new Boeing();
                                    break;
                                case AIRBUS_A320 :
                                    plane = new Airbus();
                                    break;
                                case AIRBUS_A321 :
                                    plane = new Airbus();
                                    break;
                                case EMBRAER_190 :
                                    plane = new Embraer();
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS :
                        str = reader.getText();
                        break;

                    case XMLStreamConstants.END_ELEMENT :

                        switch (reader.getLocalName()) {
                            case ELEMENT_NAME :
                                plane.setName(str);
                                break;
                            case ELEMENT_SEATS_NUMBER :
                                plane.setSeatsNumber(Integer.parseInt(str));
                                break;
                            case ELEMENT_OVERALL_WEIGHT :
                                plane.setOverallWeight(Integer.parseInt(str));
                                break;
                            case ELEMENT_MAX_DISTANCE :
                                plane.setMaxDistance(Integer.parseInt(str));
                                break;
                            case ELEMENT_FUEL_CAPACITY :
                                plane.setFuelCapacity(Integer.parseInt(str));
                                break;
                            case ELEMENT_PLANE :
                                planes.add(plane);
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        airCompany.add(planes);
        return airCompany;
    }
}
