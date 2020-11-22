package com.vermeg.main;

import com.vermeg.dao.implementation.BookDaoImp;
import com.vermeg.dao.manipulateDao.Interface.BookDao;
import com.vermeg.model.Book;
import com.vermeg.model.Order;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClasse {

    public static void main(String[] args) {
        /*double price = 0;
        int quantity = 0;
        boolean verify = true; // verify if the input is correct or not.
        boolean err1 = false; // verify if the first input is correct.
        boolean err2 = false; // verify if the second input is correct
        Scanner sc = null;

        while(verify) {

            try {
                sc = new Scanner( System.in );

                if(!err1) {
                    System.out.println("Please enter the quantity of the product: ");
                    System.out.print(">> ");
                    quantity = sc.nextInt();
                    err1 = true;
                }

                if(!err2) {
                    System.out.println("Please enter the price of the unit : ");
                    System.out.print(">> ");
                    price = sc.nextDouble();
                    err2=true;
                }
                System.out.println("the Total price is : "+ Order.calculateTotalPrice(quantity,price));

                verify = false;
            } catch(InputMismatchException e) {
                System.err.println("You should enter a number");
            }
        }
        sc.close();*/

        BookDao bookDao = new BookDaoImp();
        Book book;
        try {
            book = new Book();
            book.setTitle("title");
            book.setPrice(10.0);
            book.setReleaseDate("release");
            book.setAuthor("author");
            bookDao.add(book);
            System.out.println(bookDao.find(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
