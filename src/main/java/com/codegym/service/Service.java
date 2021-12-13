package com.codegym.service;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {
    List<T> printAll() throws SQLException;
    T findByName(String name) throws SQLException;
}