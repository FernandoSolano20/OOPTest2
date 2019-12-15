package com.tupuntodeventa.bl.User;

import com.tupuntodeventa.bl.Direction.Direction;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends User {

    private ArrayList<Direction> directions = new ArrayList<>();

    public Client(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, LocalDate born, int gender, String phone) {
        super(id, name, lastName1, lastName2, userName, email, pass, born, gender, phone);
        this.setUserType("Cliente");
    }

    public ArrayList<Direction> getDirections() {
        return directions;
    }

    public void setDirections(String exactAddress, String canton, String district, String province, int kilometersToRestaurant) {
        Direction direction = new Direction(exactAddress, canton, district, province, kilometersToRestaurant);
        this.directions.add(direction);
    }

    @Override
    public String toString() {
        return "Client{" +
                "" + super.toString() +
                "directions=" + directions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return super.equals(client);
    }
}
