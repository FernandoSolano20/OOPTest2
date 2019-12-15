package com.tupuntodeventa.bl;

import com.tupuntodeventa.bl.Coupon.Coupon;
import com.tupuntodeventa.bl.Position.Position;
import com.tupuntodeventa.bl.Product.Product;
import com.tupuntodeventa.bl.User.Admin;
import com.tupuntodeventa.bl.User.Client;
import com.tupuntodeventa.bl.User.User;

import java.util.ArrayList;

public class BL {
    /*private ArrayList<Position> positions = new ArrayList<>();
    private ArrayList<Coupon> coupons = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public String registerPosition(Position position){
        if (getUser(position) == null){
            puestos.add(user);
            return "Usuario registrado";
        }
        return "Usuario no registrado";
    }

    public User getUser(User user){
        User u = null;
        for (User us:users) {
            if(us.equals(user)){
                u = us;
                break;
            }
        }
        return u;
    }

    public User getUserById(int id){
        User u = null;
        for (User us:users) {
            if(id == us.getId()){
                u = us;
                break;
            }
        }
        return u;
    }

    public String registerAdmin(Admin admin) {
        if (getUserAdmin() == null){
            return registerUser(admin);
        }
        return "Adminsitrador ya registrado";
    }

    public User getUserAdmin(){
        User u = null;
        for (User us:users) {
            if(us.getUserType().equals("Administrador")){
                u = us;
                break;
            }
        }
        return u;
    }

    public void registerDirection(int id, String exactAddress, String district, String canton, String province, int km) {
        User user = getUserById(id);
        if(user != null && user instanceof Client){
            ((Client) user).setDirections(exactAddress, district, canton, province, km);
        }
    }

    public boolean registerCoupon(Coupon coupon){
        if (getCoupon(coupon) == null){
            coupons.add(coupon);
            return true;
        }
        return false;
    }

    public Coupon getCoupon(Coupon coupon){
        Coupon c = null;
        for (Coupon cou:coupons) {
            if(cou.equals(coupon)){
                c = cou;
                break;
            }
        }
        return c;
    }

    public String registerProduct(Product product) {
        if (getProduct(product) == null){
            products.add(product);
            return "Producto registrado";
        }
        return "Producto no registrado";
    }

    public Product getProduct(Product product){
        Product p = null;
        for (Product pro:products) {
            if(pro.equals(product)){
                p = pro;
                break;
            }
        }
        return p;
    }

    public Product getProductById(int code){
        Product p = null;
        for (Product pro:products) {
            if(code == pro.getCode()){
                p = pro;
                break;
            }
        }
        return p;
    }

    public String[] listUsers(){
        int size = users.size();
        String[] result = new String[size];
        if(size > 0){
            for (int i = 0; i < size; i++){
                result[i] = users.get(i).toString();
            }
        }
        else {
            result = new String[1];
            result[0] = "No ha users";
        }
        return result;
    }

    public String[] listCoupons(){
        int size = coupons.size();
        String[] result = new String[size];
        if(size > 0){
            for (int i = 0; i < size; i++){
                result[i] = coupons.get(i).toString();
            }
        }
        else {
            result = new String[1];
            result[0] = "No hay cupones";
        }
        return result;
    }

    public String[] listProducts(){
        int size = products.size();
        String[] result = new String[size];
        if(size > 0){
            for (int i = 0; i < size; i++){
                result[i] = products.get(i).toString();
            }
        }
        else {
            result = new String[1];
            result[0] = "No hay productos";
        }
        return result;
    }*/
}
