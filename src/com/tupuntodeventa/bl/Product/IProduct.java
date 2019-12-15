package com.tupuntodeventa.bl.Product;

import java.util.List;

public interface IProduct {
    List<Product> getAll() throws Exception;
    String save(Product product) throws Exception;
    Product getProductById(int code) throws Exception;
    String addPlateToCombo(Product product, SinglePlate plate) throws Exception;
}
