package by.peshko.shape.entity;

public class BallParameter {
    private double volume;
    private double surfaceArea;
    private double radius;

    public BallParameter(double volume, double surfaceArea, double radius) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
        this.radius = radius;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }


    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallParameter that = (BallParameter) o;
        return Double.compare(that.volume, volume) == 0 &&
                Double.compare(that.surfaceArea, surfaceArea) == 0 &&
                Double.compare(that.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = 40;
        result = 20 * result * (int) this.volume;
        result = 20 * result * (int) this.surfaceArea;
        result = 20 * result * (int) this.radius;
        return result;
    }

    @Override
    public String toString() {
        return "BallParameter{ " +
                "volume = " + volume +
                ", surfaceArea = " + surfaceArea +
                ", radius = " + radius +
                '}';
    }
}
