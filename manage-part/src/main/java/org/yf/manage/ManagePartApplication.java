package org.yf.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yf
 * @date 2019/4/9 09:40
 */
@SpringBootApplication
@MapperScan(basePackages = "org.yf.manage.mapper")
public class ManagePartApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManagePartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("##########################################");
        System.out.println("#--------     购物商城启动       --------#");
        System.out.println("#--------     模块：管理         --------#");
        System.out.println("#--------     版本：v1           --------#");
        System.out.println("#--------     环境：测试         --------#");
        System.out.println("##########################################");
    }
}
