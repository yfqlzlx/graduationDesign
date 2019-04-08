package org.yf.manage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
