package kz.epam.parsers;

import kz.epam.model.AirCompany;
import kz.epam.model.planes.Airbus;
import kz.epam.model.planes.Boeing;
import kz.epam.model.planes.Embraer;
import kz.epam.model.planes.Plane;
import kz.epam.validator.Validator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import static kz.epam.model.planes.PlanesType.*;

public class Sax extends DefaultHandler {
    private static ArrayList<Plane> planes = new ArrayList<>();
    private AirCompany airCompany = new AirCompany();
    private StringBuilder stringBuilder;
    private Plane plane;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ELEMENT_PLANE :
                switch (attributes.getValue(0).toString()) {
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
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder = new StringBuilder();
        stringBuilder.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ELEMENT_NAME :
                plane.setName(stringBuilder.toString());
                break;
            case ELEMENT_SEATS_NUMBER :
                plane.setSeatsNumber(Integer.parseInt(stringBuilder.toString()));
                break;
            case ELEMENT_OVERALL_WEIGHT :
                plane.setOverallWeight(Integer.parseInt(stringBuilder.toString()));
                break;
            case ELEMENT_MAX_DISTANCE :
                plane.setMaxDistance(Integer.parseInt(stringBuilder.toString()));
                break;
            case ELEMENT_FUEL_CAPACITY :
                plane.setFuelCapacity(Integer.parseInt(stringBuilder.toString()));
                break;
            case ELEMENT_PLANE :
                planes.add(plane);
                break;
        }
    }

    public AirCompany parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser sax = factory.newSAXParser();
            DefaultHandler handler = new Sax();
            sax.parse(Validator.FILE_NAME, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        airCompany.add(planes);
        return airCompany;
    }
}
