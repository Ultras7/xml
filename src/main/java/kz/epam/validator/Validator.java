package kz.epam.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {
    public static final String FILE_NAME = "src/main/recources/aircompany.xml";
    public static final String SCHEMA_NAME = "src/main/recources/aircompany.xsd";

    private Validator(){
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(SCHEMA_NAME);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            javax.xml.validation.Validator validator = schema.newValidator();
            Source source = new StreamSource(FILE_NAME);
            validator.validate(source);

        } catch (SAXException | IOException e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
        }
    }

}
