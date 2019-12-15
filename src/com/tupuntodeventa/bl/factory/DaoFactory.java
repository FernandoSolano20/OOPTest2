package com.tupuntodeventa.bl.factory;

import com.tupuntodeventa.bl.Coupon.ICoupon;
import com.tupuntodeventa.bl.Orden.IOrden;
import com.tupuntodeventa.bl.Position.IPosition;
import com.tupuntodeventa.bl.Product.IProduct;
import com.tupuntodeventa.bl.User.IUser;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory(int tipo){
        switch (tipo){
            // es MySql
            case 1:
                return new MySqlDaoFactory();

            default: return null;
        }
    }
    public abstract IUser getUserDao();
    public abstract IProduct getProductDao();
    public abstract IPosition getPositionDao();
    public abstract IOrden getOrdenDao();
    public abstract ICoupon getCouponDao();
}
