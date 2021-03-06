package lk.fcpl.web.studentRegistration;

import lk.fcpl.web.studentRegistration.util.LogConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author:Tharanga Mahavila <tharangamahavila@gmail.com>
 * @since : 2021-02-23
 **/

@SpringBootApplication
public class WebAppInitializer {

    public static void main(String[] args) {
        LogConfig.initLogging();
        SpringApplication.run(WebAppInitializer.class,args);
    }
}
