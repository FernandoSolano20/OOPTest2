package com.tupuntodeventa.bl.Coupon;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Coupon {
    private String code;
    private LocalDate expiration;
    private boolean status;
    private int discount;

    public Coupon(LocalDate expiration, boolean status, int discount) {
        this.expiration = expiration;
        this.status = status;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public void setCode() {
        int n = 100 + new Random().nextInt(900);
        char a = (char) (new Random().nextInt(26) + 'a');
        char b = (char) (new Random().nextInt(26) + 'a');
        char c = (char) (new Random().nextInt(26) + 'a');
        this.code = a + "" + b + "" + c + "" + n;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "code='" + code + '\'' +
                ", expiration=" + expiration +
                ", status=" + status +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Coupon)) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(code, coupon.code);
    }
}
