package org.yf.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date 2019/4/7 19:30:21
 * @author yf
 * 用户模块的主启动类
 */
@SpringBootApplication
public class UserPartApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserPartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("##########################################");
        System.out.println("#--------     购物商城启动       --------#");
        System.out.println("#--------     模块：用户         --------#");
        System.out.println("#--------     版本：v1           --------#");
        System.out.println("#--------     环境：测试         --------#");
        System.out.println("##########################################");
    }
}
