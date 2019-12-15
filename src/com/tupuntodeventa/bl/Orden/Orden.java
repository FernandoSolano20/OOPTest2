package com.tupuntodeventa.bl.Orden;

import com.tupuntodeventa.bl.Product.Product;
import com.tupuntodeventa.bl.User.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Orden {
    private static int idGeneral;
    private int id;
    private User user;
    private LocalDate day;
    private int hour;
    private int min;
    private String type;
    private ArrayList<Product> products;
    private int price;

    public Orden(User user, String type) {
        idGeneral++;
        this.id = idGeneral;
        this.user = user;
        this.day = LocalDate.now();
        this.hour = LocalDateTime.now().getHour();
        this.min = LocalDateTime.now().getMinute();
        this.type = type;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice() {
        for (Product product:products){
            this.price += product.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", day=" + day +
                ", hour=" + hour +
                ", min=" + min +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", \n         user=" + user +
                ", \n         products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return id == orden.id &&
                hour == orden.hour &&
                min == orden.min &&
                price == orden.price &&
                Objects.equals(user, orden.user) &&
                Objects.equals(day, orden.day) &&
                Objects.equals(type, orden.type) &&
                Objects.equals(products, orden.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, day, hour, min, type, products, price);
    }
}
