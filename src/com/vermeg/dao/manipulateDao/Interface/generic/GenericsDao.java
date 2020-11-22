package com.vermeg.dao.manipulateDao.Interface.generic;

import java.sql.SQLException;
import java.util.List;

public interface GenericsDao<T> {

    public int add(T t) throws SQLException;
    public int delete(T t) throws SQLException;
    public int delete(int id) throws SQLException;
    public T find(int id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public int update(T t) throws SQLException;
}
