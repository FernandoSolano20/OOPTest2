package com.tupuntodeventa.bl.User;

import com.tupuntodeventa.bl.Position.Position;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends User {
    private Position position;

    public Employee(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, LocalDate born, int gender, String phone) {
        super(id, name, lastName1, lastName2, userName, email, pass, born, gender, phone);
        this.setUserType("Empleado");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "puesto=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(position, employee.position);
    }
}
