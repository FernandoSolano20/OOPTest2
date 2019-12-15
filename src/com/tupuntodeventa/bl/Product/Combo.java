package com.tupuntodeventa.bl.Product;

import java.util.ArrayList;
import java.util.Objects;

public class Combo extends Product {
    ArrayList<SinglePlate> plates = new ArrayList<>();
    private String name;

    public Combo(int code, String name, int price) {
        super(code, price);
        this.name = name;
        setType("Combo");
    }

    public ArrayList<SinglePlate> getPlates() {
        return plates;
    }

    public void setPlates(int code, int price, String descript) {
        SinglePlate plate = new SinglePlate(code,price,descript);
        plates.add(plate);
    }

    public void setPlates(SinglePlate plate) {
        plates.add(plate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "" + super.toString() +
                "plates=" + plates +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Combo)) return false;
        Combo combo = (Combo) o;
        return Objects.equals(plates, combo.plates) &&
                Objects.equals(name, combo.name);
    }
}
