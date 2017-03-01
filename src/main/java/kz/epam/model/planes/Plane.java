package kz.epam.model.planes;

public abstract class Plane implements Comparable<Plane> {
    private String name;
    private Integer seatsNumber;
    private Integer overallWeight;
    private Integer maxDistance;
    private Integer fuelCapacity;

    public Plane() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getOverallWeight() {
        return overallWeight;
    }

    public void setOverallWeight(int overallWeight) {
        this.overallWeight = overallWeight;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (name != null ? !name.equals(plane.name) : plane.name != null) return false;
        if (seatsNumber != null ? !seatsNumber.equals(plane.seatsNumber) : plane.seatsNumber != null) return false;
        if (overallWeight != null ? !overallWeight.equals(plane.overallWeight) : plane.overallWeight != null) return false;
        if (maxDistance != null ? !maxDistance.equals(plane.maxDistance) : plane.maxDistance != null) return false;
        return fuelCapacity != null ? fuelCapacity.equals(plane.fuelCapacity) : plane.fuelCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (seatsNumber != null ? seatsNumber.hashCode() : 0);
        result = 31 * result + (overallWeight != null ? overallWeight.hashCode() : 0);
        result = 31 * result + (maxDistance != null ? maxDistance.hashCode() : 0);
        result = 31 * result + (fuelCapacity != null ? fuelCapacity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", overallWeight=" + overallWeight +
                ", maxDistance=" + maxDistance +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}