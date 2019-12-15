package com.tupuntodeventa.bl.Coupon;

import java.util.List;

public interface ICoupon {
    List<Coupon> getAll();

    String save(Coupon coupon);

    boolean isCouponAvailable(Coupon coupon);
}
