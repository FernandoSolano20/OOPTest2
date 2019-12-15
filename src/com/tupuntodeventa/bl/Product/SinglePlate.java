package com.tupuntodeventa.bl.Product;

public class SinglePlate extends Product {
    private String descript;

    public SinglePlate(int code, int price, String descript) {
        super(code, price);
        this.descript = descript;
        setType("Plato");
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public String toString() {
        return "SinglePlate{" +
                "" + super.toString() +
                ", descript='" + descript + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  SinglePlate)) return false;
        if (!super.equals(o)) return false;
        SinglePlate that = (SinglePlate) o;
        return super.equals(that);
    }
}
