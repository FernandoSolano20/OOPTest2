package com.tupuntodeventa.tl;

import com.tupuntodeventa.bl.*;
import com.tupuntodeventa.bl.Coupon.Coupon;
import com.tupuntodeventa.bl.Coupon.ICoupon;
import com.tupuntodeventa.bl.Direction.Direction;
import com.tupuntodeventa.bl.Orden.IOrden;
import com.tupuntodeventa.bl.Orden.Orden;
import com.tupuntodeventa.bl.Position.IPosition;
import com.tupuntodeventa.bl.Position.Position;
import com.tupuntodeventa.bl.Product.Combo;
import com.tupuntodeventa.bl.Product.IProduct;
import com.tupuntodeventa.bl.Product.Product;
import com.tupuntodeventa.bl.Product.SinglePlate;
import com.tupuntodeventa.bl.User.*;
import com.tupuntodeventa.bl.factory.DaoFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private BL logic = new BL();

    private DaoFactory factory;
    private IUser userDao;
    private IProduct productDao;
    private IPosition positionDao;
    private IOrden ordenDao;
    private ICoupon couponDao;
    private static User actualUser;

    public Controller() {
        factory = DaoFactory.getDaoFactory(1);
        userDao = factory.getUserDao();
        productDao = factory.getProductDao();
        positionDao = factory.getPositionDao();
        ordenDao = factory.getOrdenDao();
        couponDao = factory.getCouponDao();
    }

    public String registerAdmin(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone) throws Exception {
        Admin admin = new Admin(id,name,lastName1,lastName2,userName,email,pass, LocalDate.of(year,month,day),gender,phone);
        if(userDao.getById(admin) == null){
            return userDao.save(admin);
        }
        return "Error";
    }

    public String registerClient(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone, ArrayList<String[]> directions) throws Exception {
        Client client = new Client(id,name,lastName1,lastName2,userName,email,pass, LocalDate.of(year,month,day),gender,phone);
        for (String[] direction:directions) {
            client.setDirections(direction[0],direction[1],direction[2],direction[3],Integer.parseInt(direction[4]));
        }
        if(userDao.getById(client) == null){
            return userDao.save(client);
        }
        return "Error";
    }

    public String registerEmployee(int id, String name, String lastName1, String lastName2, String userName, String email, String pass, int day, int month, int year, int gender, String phone, String position) throws Exception {
        Employee employee = new Employee(id,name,lastName1,lastName2,userName,email,pass, LocalDate.of(year,month,day),gender,phone);
        Position position1 = positionDao.searchByName(position);
        if(position1 != null && userDao.getById(employee) == null){
            employee.setPosition(position1);
            return userDao.save(employee);
        }
        return "Error";
    }

    public boolean isAdminOnDB() throws Exception {
        return userDao.isAdminOnDB();
    }

    public String login(String userName, String pass) throws Exception {
        User user = userDao.login(userName,pass);
        String response = null;
        if (user != null){
            actualUser = user;
            response = user.getUserType();
        }
        return response;
    }

    public String registerPosition(String name, int baseSalary, int bonus, int totalSalary, LocalDate dayContract) throws Exception {
        Position position = new Position(name,baseSalary,bonus,totalSalary,dayContract);
        if(positionDao.searchByName(name) == null){
            return positionDao.save(position);
        }
        return "Error";
    }

    public String registerCoupon(int day, int month, int year, boolean status, int discount) {
        Coupon coupon = new Coupon(LocalDate.of(year,month,day),status,discount);
        boolean result = true;
        do{
            coupon.setCode();
            result = couponDao.isCouponAvailable(coupon);
            if(result){
                couponDao.save(coupon);
            }
        }while (!result);
        return "Registrado";
    }

    public String registerPlate(int code, int price, String descript) throws Exception {
        SinglePlate singlePlate = new SinglePlate(code,price,descript);
        if(productDao.getProductById(code) == null){
            return productDao.save(singlePlate);
        }
        return "Error";
    }

    public String searchPlate(int codeCombo, int code) throws Exception {
        Product product = productDao.getProductById(code);
        if(product != null && product instanceof  SinglePlate){
            Product productCombo = productDao.getProductById(codeCombo);
            if(productCombo != null && productCombo instanceof Combo){
                ((Combo) productCombo).setPlates((SinglePlate) product);
                return productDao.addPlateToCombo(productCombo,(SinglePlate) product);
            }
        }
        return "no se agrego";
    }

    public String registerCombo(int code, String name, int price) throws Exception {
        Combo combo = new Combo(code,name,price);
        if(productDao.getProductById(code) == null){
            return productDao.save(combo);
        }
        return "Error";
    }

    public String registerPlateCombo(int codeCombo, int code, int price, String descript) throws Exception {
        if(productDao.getProductById(code) == null){
            Product product = productDao.getProductById(codeCombo);
            if(product != null && product instanceof Combo){
                registerPlate(code,price,descript);
                return  productDao.addPlateToCombo(product, new SinglePlate(code,price,descript));
            }
        }
        return "No Se registro";
    }

    public String registerOrden(String type, ArrayList<Integer> codes) throws Exception {
        Orden orden = new Orden(actualUser,type);
        for (Integer code:codes) {
            Product product = productDao.getProductById(code);
            if (product != null){
                orden.setProducts(product);
            }
        }
        return ordenDao.save(orden);
    }

    public List<String> listUsers() throws Exception {
        List<User> users = userDao.getAll();
        List<String> result = new ArrayList<>();
        for (User user:users) {
            result.add(user.toString());
        }
        return result;
    }

    public List<String> listCoupons() {
        List<Coupon> coupons = couponDao.getAll();
        List<String> result = new ArrayList<>();
        for (Coupon coupon:coupons) {
            result.add(coupon.toString());
        }
        return result;
    }

    public List<String> listPositions() throws Exception {
        List<Position> positions = positionDao.getAll();
        List<String> result = new ArrayList<>();
        for (Position position:positions) {
            result.add(position.toString());
        }
        return result;
    }

    public List<String> listProducts() throws Exception {
        List<Product> products = productDao.getAll();
        List<String> result = new ArrayList<>();
        for (Product product:products) {
            result.add(product.toString());
        }
        return result;
    }

    public List<String> listOrdens() throws Exception {
        List<Orden> ordens = ordenDao.getAll();
        List<String> result = new ArrayList<>();
        for (Orden orden:ordens) {
            result.add(orden.toString());
        }
        return result;
    }
}
