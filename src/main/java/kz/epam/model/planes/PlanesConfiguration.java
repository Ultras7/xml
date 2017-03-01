package kz.epam.model.planes;

public enum PlanesConfiguration {
    PLANE_TYPE("planeType"),
    BOEING_747("Boeing"),
    AIRBUS_A320("Airbus320"),
    AIRBUS_A321("Airbus321"),
    EMBRAER_190("Embraer"),
    ELEMENT_PLANE("plane"),
    ELEMENT_NAME ("name"),
    ELEMENT_SEATS_NUMBER ("seatsNumber"),
    ELEMENT_OVERALL_WEIGHT ("overalWeight"),
    ELEMENT_MAX_DISTANCE ("maxDistance"),
    ELEMENT_FUEL_CAPACITY("fuelcapacity");

    private final String element;

    PlanesConfiguration(String element) {
        this.element = element;
    }
    public static PlanesConfiguration getElements(String str) {

        PlanesConfiguration element = null;
        for (PlanesConfiguration elements : PlanesConfiguration.values()) {
            if (elements.getElement().equals(str)) {
                element = elements;
            }
        }
        return element;
    }

    public String getElement() {
        return element;
    }
}
