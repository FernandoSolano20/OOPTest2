package com.tupuntodeventa.bl.Product;

import com.tupuntodeventa.dl.DataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProduct {
    private DataAccess dataAccess = new DataAccess();
    @Override
    public List<Product> getAll() throws Exception {
        Product product = null;
        List<Product> products = new ArrayList<>();
        String queryString = "SELECT * FROM Product";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                product = createProduct(result);
                products.add(product);
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return products;
    }

    @Override
    public String save(Product product) throws Exception {
        String message = "Error";
        String queryString = "INSERT INTO Product(id, price, type";

        String queryValues = ") VALUES("+ product.getCode() +", "+ product.getPrice() +", '"+ product.getType() +"'";

        if(product.getType() == "Plato" && product instanceof SinglePlate){
            queryString += ", descript";
            SinglePlate singlePlate = (SinglePlate) product;
            queryValues += ", '"+ singlePlate.getDescript() +"'";
        }
        else if(product.getType() == "Combo" && product instanceof Combo){
            queryString += ", name";
            Combo combo = (Combo) product;
            queryValues += ", '"+ combo.getName() +"'";
        }

        queryValues += ")";
        try {
            message = dataAccess.insertData(queryString+queryValues);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return message;
    }

    @Override
    public Product getProductById(int code) throws Exception {
        Product product = null;
        String queryString = "SELECT * FROM Product " +
                "WHERE id = "+ code +"";
        ResultSet result = dataAccess.selectData(queryString);
        try{
            while (result.next())
            {
                product = createProduct(result);
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return product;
    }

    @Override
    public String addPlateToCombo(Product product, SinglePlate plate) throws Exception {
        String message = "Error";
        try {
            if (product.getType() == "Combo" && product instanceof Combo) {
                String queryString = "INSERT INTO ComboPlates(idCombo, idPlate) " +
                            "VALUES (" + product.getCode() + ", " + plate.getCode() + ")";
                message = dataAccess.insertData(queryString);
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return message;
    }


    public Product createProduct(ResultSet result) throws SQLException {
        Product product = null;
        if (result.getString("type").equals("Plato")){
            product = new SinglePlate(
                    result.getInt("id"),
                    result.getInt("price"),
                    result.getString("descript")
            );
        }
        else {
            product = new Combo(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getInt("price")
            );
            List<Product> plates = new ArrayList<>();
            SinglePlate plate = null;
            String queryString = "SELECT * FROM ComboPlates as cp " +
                    "INNER JOIN Product as p ON cp.idPlate = p.id " +
                    "WHERE cp.idCombo = " + result.getInt("id") + "";
            ResultSet resultPlates = dataAccess.selectData(queryString);
            while (resultPlates.next())
            {
                if (resultPlates.getString("type").equals("Plato")){
                    plate = new SinglePlate(
                            resultPlates.getInt("id"),
                            resultPlates.getInt("price"),
                            resultPlates.getString("descript")
                    );
                }
                ((Combo)product).setPlates(plate);
            }
        }
        return product;
    }
}
