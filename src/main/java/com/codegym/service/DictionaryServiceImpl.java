package com.codegym.service;

import com.codegym.model.Dictionary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryServiceImpl implements Service<Dictionary> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demodictionary?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final DictionaryServiceImpl DICTIONARY = new DictionaryServiceImpl();
    public static DictionaryServiceImpl getContent() {
        return DICTIONARY;
    }
    public DictionaryServiceImpl(){
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Dictionary> printAll() throws SQLException {
        List<Dictionary> productList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from dictionary");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String english = rs.getString("english");
            String vietnamese = rs.getString("vietnamese");
            productList.add(new Dictionary(english, vietnamese));
        }
        return productList;
    }

    @Override
    public Dictionary findByName(String name) throws SQLException {
        List<Dictionary> list = printAll();
        for(Dictionary dictionary: list){
            if(dictionary.getEng().equals(name)){
                return dictionary;
            }
        }
        return null;
    }
}
