package model.repository.impl;

import model.bean.Product;
import model.repository.BaseRepository;
import model.repository.CRUDRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements CRUDRepository<Product> {

    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select *\n" +
                    "from product;");

            Product product = null;
            while (resultSet.next()) {
                product = new Product();
                product.setName(resultSet.getString(1));
                product.setPrice(Double.parseDouble(resultSet.getString(2)));
                product.setQuantity(Integer.parseInt(resultSet.getString(3)));
                product.setColor(resultSet.getString(4));
                product.setDescription(resultSet.getString(5));
                product.setCategoryId(Integer.parseInt(resultSet.getString(6)));


                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }
}
