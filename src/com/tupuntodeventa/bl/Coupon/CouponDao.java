package com.tupuntodeventa.bl.Coupon;

import java.util.ArrayList;
import java.util.List;

public class CouponDao implements ICoupon {
    private static ArrayList<Coupon> coupons = new ArrayList<>();
    @Override
    public List<Coupon> getAll() {
        return coupons;
    }

    @Override
    public String save(Coupon coupon) {
        coupons.add(coupon);
        return "Guardado";
    }

    @Override
    public boolean isCouponAvailable(Coupon coupon) {
        for (Coupon c:coupons) {
            if (coupon.equals(c)){
                return false;
            }
        }
        return true;
    }

}
