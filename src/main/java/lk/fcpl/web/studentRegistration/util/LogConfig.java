package lk.fcpl.web.studentRegistration.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-23
 **/
public class LogConfig {
    public static void initLogging(){
        Properties prop = new Properties();
        String logFilePath;
        try{
            if(prop.getProperty("app.log_dir") != null){
                logFilePath = prop.getProperty("app.log_dir")+"back-end.log";
            }else {
                logFilePath = System.getProperty("catalina.home")+"/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
