package com.xgq.h;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author xiegaoqiong
 * @date 2022/9/28
 * @apiNote
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class HCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(HCenterApplication.class, args);
    }
}
