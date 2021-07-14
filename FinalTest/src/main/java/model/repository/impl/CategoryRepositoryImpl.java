package model.repository.impl;

import model.bean.Category;
import model.repository.BaseRepository;
import model.repository.CRUDRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CRUDRepository<Category> {

    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();

        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select *\n" +
                    "from category;");

            Category category = null;
            while (resultSet.next()) {
                category = new Category();
                category.setId(Integer.parseInt(resultSet.getString(1)));
                category.setName(resultSet.getString(2));

                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }
}
