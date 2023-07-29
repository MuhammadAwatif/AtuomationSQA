package utils;

import io.qameta.allure.Allure;

public class LogUtil {

    public static void log(String message) {
        System.out.println(message);  // Log to console
        Allure.addAttachment("Log", message);  // Attach log to Allure report
    }
}