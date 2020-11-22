package com.vermeg.dao.implementation;

import com.vermeg.dao.SingletonConnection;
import com.vermeg.dao.manipulateDao.Interface.BookDao;
import com.vermeg.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao {

    Connection connection = SingletonConnection.getConnection();

    @Override
    public int add(Book book) throws SQLException {

        String query = "INSERT INTO book(title,author,price,releaseDate) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1,book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3,book.getPrice());
        ps.setString(4, book.getReleaseDate());

        return ps.executeUpdate();
    }

    @Override
    public int delete(Book book) throws SQLException{

        String query = "DELETE FROM book WHERE book_id =?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, book.getBook_id());

        return ps.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {

        String query = "DELETE FROM book WHERE book_id =?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);

        return ps.executeUpdate();
    }

    @Override
    public Book find(int id) throws SQLException {

        Book book = new Book();

        String query = "SELECT * FROM book WHERE book_id= ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        boolean check = false; // verify if the book instance is empty or not.

        while (rs.next()) {
            check = true;
            book.setBook_id(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setReleaseDate(rs.getString("releaseDate"));
        }
        if(check)
            return book;
        return null;
    }

    @Override
    public List<Book> findAll() throws SQLException {

        String query = "SELECT * FROM book";
        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        List<Book> bookList = new ArrayList();

        while (rs.next()) {
            Book book = new Book();
            book.setBook_id(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setReleaseDate(rs.getString("release"));
            bookList.add(book);
        }

        return bookList;
    }

    @Override
    public int update(Book book) throws SQLException {

        String query = "UPDATE book SET title=?, author=?, price=?, releaseDate=?, where book_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1,book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setDouble(3,book.getPrice());
        ps.setString(4, book.getReleaseDate());

        return ps.executeUpdate();
    }
}
