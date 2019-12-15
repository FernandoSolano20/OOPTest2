package com.tupuntodeventa.bl.factory;

import com.tupuntodeventa.bl.Coupon.CouponDao;
import com.tupuntodeventa.bl.Coupon.ICoupon;
import com.tupuntodeventa.bl.Orden.IOrden;
import com.tupuntodeventa.bl.Orden.OrdenDao;
import com.tupuntodeventa.bl.Position.IPosition;
import com.tupuntodeventa.bl.Position.PositionDao;
import com.tupuntodeventa.bl.Product.IProduct;
import com.tupuntodeventa.bl.Product.ProductDao;
import com.tupuntodeventa.bl.User.IUser;
import com.tupuntodeventa.bl.User.UserDao;

public class MySqlDaoFactory extends DaoFactory {
    @Override
    public IUser getUserDao() {
        return new UserDao();
    }

    @Override
    public IProduct getProductDao() {
        return new ProductDao();
    }

    @Override
    public IPosition getPositionDao() {
        return new PositionDao();
    }

    @Override
    public IOrden getOrdenDao() {
        return new OrdenDao();
    }

    @Override
    public ICoupon getCouponDao() {
        return new CouponDao();
    }
}
