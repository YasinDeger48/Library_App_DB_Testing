package com.library.utils;

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


}
