package kz.epam;

import kz.epam.model.AirCompany;
import kz.epam.model.planes.Plane;
import kz.epam.parsers.Dom;
import kz.epam.parsers.Sax;
import kz.epam.parsers.Stax;



public class App
{
    public static void main( String[] args )
    {
        String dom = "DOM";
        String sax = "SAX";
        String stax = "SAX";
        AirCompany domParser = new Dom().parse();
        AirCompany saxParser = new Sax().parse();
        AirCompany staxParser = new Stax().parse();

        System.out.println("Parser equals: ");
        System.out.println(domParser.equals(saxParser));
        System.out.println(saxParser.equals(staxParser));
        System.out.println(staxParser.equals(domParser));

        view(domParser, dom);
        view(saxParser, sax);
        view(staxParser, stax);

    }

    public static void view(AirCompany planes, String parserName) {
        System.out.println("\n" +parserName);

        for (Plane p : planes.getPlanes()) {
             System.out.println(p);
        }
        System.out.println("\n");
    }
}

