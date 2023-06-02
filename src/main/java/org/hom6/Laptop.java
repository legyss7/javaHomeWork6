package org.hom6;

public class Laptop {
    public String name;
    public Integer ram;
    public Integer hardDiskCapacity;
    public String operatingSystem;
    public String color;

    public Laptop(String name, Integer ram, Integer hardDiskCapacity,
                  String operatingSystem, String color) {
        this.name = name;
        this.ram = ram;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return
                "name = " + name +
                ", ram = " + ram +
                ", hardDiskCapacity = " + hardDiskCapacity +
                ", operatingSystem = " + operatingSystem +
                ", color = " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (!name.equals(laptop.name)) return false;
        if (!ram.equals(laptop.ram)) return false;
        if (!hardDiskCapacity.equals(laptop.hardDiskCapacity)) return false;
        if (!operatingSystem.equals(laptop.operatingSystem)) return false;
        return color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + ram.hashCode();
        result = 31 * result + hardDiskCapacity.hashCode();
        result = 31 * result + operatingSystem.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}
