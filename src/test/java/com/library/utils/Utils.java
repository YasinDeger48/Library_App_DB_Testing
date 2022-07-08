package com.library.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    /**
     * ,This method using for the static waiting
     * @param seconds
     */

    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            System.out.println("static wait error...");
        }
    }

    /**
     * This method using for the navigation
     * @param URL
     */
    public static void navigateTo(String URL){
        Driver.getDriver().get(URL);
    }


    /**
     *
     * DB connections methods
     *
     *
     * getUserName method returns List of Map and 7432 key and value
     * Table contains 8 column and 929 row 
     *
     * EXAMPLE:{
     *
     * year=2005,
     * added_date=2019-09-19T00:00,
     * author=Kalie Moniker,
     * isbn=387081258244,
     * name=Otocyon megalotis,
     * description=Sed sagittis.Nam congue, risus semper porta volutpat,
     *              quam pede lobortis ligula, sit amet eleifend pede libero quis orci.
     *              Nullam molestie nibh in lectus.,
     * id=922,
     * book_category_id=9}
     * 
     */

    public static List<Map<String,Object>> getUsername(String query)  {

        List<Map<String,Object>> bookList = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(ConfigReader.getProperty("database3.URL"),
                    ConfigReader.getProperty("database3.username"), ConfigReader.getProperty("database3.password"));

            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData rsmd = resultSet.getMetaData();



            while(resultSet.next()){

                Map<String,Object> bookListRows = new HashMap<>();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {



                    bookListRows.put(rsmd.getColumnName(i),resultSet.getObject(i));

                }

                bookList.add(bookListRows);


            }






        }catch (SQLException e){

        }
        return bookList;

    }





}
