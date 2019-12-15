package com.tupuntodeventa.bl.User;

import java.time.LocalDate;

public class Admin extends User {

    public Admin(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, LocalDate born, int gender, String phone) {
        super(id, name, lastName1, lastName2, userName, email, pass, born, gender, phone);
        this.setUserType("Administrador");
    }

    @Override
    public String toString() {
        return "Admin{"+super.toString()+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Admin)) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return super.equals(admin);
    }
}
