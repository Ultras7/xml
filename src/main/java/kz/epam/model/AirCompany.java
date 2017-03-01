package kz.epam.model;



import kz.epam.model.planes.Plane;

import java.util.ArrayList;



public class AirCompany {
    private ArrayList<Plane> planes = new ArrayList<>();

    public ArrayList<Plane> getPlanes() {
        return planes;
    }
    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    public void add(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirCompany airCompany1 = (AirCompany) o;

        return planes != null ? planes.equals(airCompany1.planes) : airCompany1.planes == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}


