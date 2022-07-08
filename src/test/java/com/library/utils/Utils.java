package com.library.utils;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import io.cucumber.java.it.Ma;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    private static HomePage homePage = new HomePage();
    private static LoginPage loginPage = new LoginPage();


    /**
     * ,This method using for the static waiting
     *
     * @param seconds
     */

    public static void waitFor(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("static wait error...");
        }
    }

    /**
     * This method using for the navigation
     *
     * @param URL
     */
    public static void navigateTo(String URL) {
        Driver.getDriver().get(URL);
    }


    /**
     * DB connections methods
     * <p>
     * <p>
     * getUserName method returns List of Map and 7432 key and value
     * Table contains 8 column and 929 row
     * <p>
     * EXAMPLE:{
     * <p>
     * year=2005,
     * added_date=2019-09-19T00:00,
     * author=Kalie Moniker,
     * isbn=387081258244,
     * name=Otocyon megalotis,
     * description=Sed sagittis.Nam congue, risus semper porta volutpat,
     * quam pede lobortis ligula, sit amet eleifend pede libero quis orci.
     * Nullam molestie nibh in lectus.,
     * id=922,
     * book_category_id=9}
     */

    public static List<Map<String, Object>> getUsername(String database) {
        String query;
        if (database.equalsIgnoreCase("all")) {
            query = " select * from books " +
                    "join book_categories on books.book_category_id = book_categories.id ";


        } else {
            query = " select * from books " +
                    "join book_categories on books.book_category_id = book_categories.id " +
                    "where book_categories.name='" + database + "'";
        }


        List<Map<String, Object>> bookList = new ArrayList<>();


        try {
            Connection conn = DriverManager.getConnection(ConfigReader.getProperty("database3.URL"),
                    ConfigReader.getProperty("database3.username"), ConfigReader.getProperty("database3.password"));

            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData rsmd = resultSet.getMetaData();


            while (resultSet.next()) {

                Map<String, Object> bookListRows = new HashMap<>();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {


                    bookListRows.put(rsmd.getColumnName(i), resultSet.getObject(i));

                }

                bookList.add(bookListRows);


            }


        } catch (SQLException e) {

        }
        return bookList;

    }


    /**
     * This method returns UI search results as "Integer"
     * what if return no result
     * it will give "0"
     * @return
     */

    public static int searchResultUI() {

        int result = 0;

        String searchResultText = homePage.searchResultText.getText();

        if (searchResultText.equals("No entries found")) {

            return result;

        } else {

            String[] eachSearchResult = searchResultText.split(" ");

            result = Integer.parseInt(eachSearchResult[5]);
        }

        return result;

    }


    public static int searchResultUIWithKey(int key) {

        int result = 0;

        String searchResultText = homePage.searchResultText.getText();

        if (searchResultText.equals("No entries found")) {

            return result;

        } else {

            String[] eachSearchResult = searchResultText.split(" ");

            result = Integer.parseInt(eachSearchResult[key]);
        }

        return result;

    }
    /**
     * This method returns String for selectByValue
     * <p>
     * it accept visible text and returns value
     *
     * @param visibleText
     * @return
     */

    public static String returnBookCategoriesSelectValueNumber(String visibleText) {

        String result = "null";

        switch (visibleText.trim()) {

            case "Action and Adventure":
                result = "1";
                break;
            case "Anthology":
                result = "2";
                break;
            case "Classic":
                result = "3";
                break;
            case "Comic and Graphic Novel":
                result = "4";
                break;
            case "Crime and Detective":
                result = "5";
                break;
            case "Drama":
                result = "6";
                break;
            case "Fable":
                result = "7";
                break;
            case "Fairy Tale":
                result = "8";
                break;
            case "Fan-Fiction":
                result = "9";
                break;
            case "Fantasy":
                result = "10";
                break;
            case "Historical Fiction":
                result = "11";
                break;
            case "Horror":
                result = "12";
                break;
            case "Science Fiction":
                result = "13";
                break;
            case "Biography/Autobiography":
                result = "14";
                break;
            case "Humor":
                result = "15";
                break;
            case "Romance":
                result = "16";
                break;
            case "Short Story":
                result = "17";
                break;
            case "Essay":
                result = "18";
                break;
            case "Memoir":
                result = "19";
                break;
            case "Poetry":
                result = "20";
                break;
        }

        return result;
    }



    public static Map<String,String> getUserNameFromExcelForStudent(){

        Map<String,String> UserNameAndPassWord = new HashMap<>();
        
        try {
            FileInputStream file = new FileInputStream("Library credentials.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("library3");

            for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {

                UserNameAndPassWord.put(sheet.getRow(i).getCell(1).toString(),sheet.getRow(i).getCell(2).toString());

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return UserNameAndPassWord;
    }

    public static Map<String,String> getUserNameFromExcelForLibrarian(){

        Map<String,String> UserNameAndPassWord = new HashMap<>();

        try {
            FileInputStream file = new FileInputStream("Library credentials.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("library3");

            for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {

                UserNameAndPassWord.put(sheet.getRow(i).getCell(6).toString(),sheet.getRow(i).getCell(7).toString());

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return UserNameAndPassWord;
    }

}
