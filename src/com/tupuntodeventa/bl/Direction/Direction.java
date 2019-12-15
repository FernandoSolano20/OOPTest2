package com.tupuntodeventa.bl.Direction;

import java.util.Objects;

public class Direction {
    private String exactAddress;
    private String canton;
    private String district;
    private String province;
    private int kilometersToRestaurant;

    public Direction(String exactAddress, String canton, String district, String province, int kilometersToRestaurant) {
        this.exactAddress = exactAddress;
        this.canton = canton;
        this.district = district;
        this.province = province;
        this.kilometersToRestaurant = kilometersToRestaurant;
    }

    public String getExactAddress() {
        return exactAddress;
    }

    public void setExactAddress(String exactAddress) {
        this.exactAddress = exactAddress;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getKilometersToRestaurant() {
        return kilometersToRestaurant;
    }

    public void setKilometersToRestaurant(int kilometersToRestaurant) {
        this.kilometersToRestaurant = kilometersToRestaurant;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "exactAddress='" + exactAddress + '\'' +
                ", canton='" + canton + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", kilometersToRestaurant=" + kilometersToRestaurant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Direction)) return false;
        Direction direction = (Direction) o;
        return kilometersToRestaurant == direction.kilometersToRestaurant &&
                Objects.equals(exactAddress, direction.exactAddress) &&
                Objects.equals(canton, direction.canton) &&
                Objects.equals(district, direction.district) &&
                Objects.equals(province, direction.province);
    }
}
