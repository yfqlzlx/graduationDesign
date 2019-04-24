## 零一购物商城
### 1、项目结构
> commons             公共模块
> manage-part	后台管理模块
> user-part	      用户操作系统
### 2、启动配置
  **更改数据库配置**
  ```yaml
 # /manage-part/src/main/resources/application.yml
 # /user-part/src/main/resources/application.yml
 spring:
 	datasource:
 		username: 自己的用户名
 		password: 自己的密码
  ```

### 3、初始化数据库

导入`/sql.sql`到`mysql`数据库

### 4、启动项目

待maven下载完成之后，项目无报错，分别启动管理模块和用户模块

```html
# 用户模块
http://localhost:8900/index
# 用户模块
http://localhost:9000/index
```

### 5、注意事项

- 8900和9000端口不能被占用
- 请确保文件路径`D:\素材\gd`存在，此文件夹为图片存储路径

### 6、技术栈

- 前端：jquery，layui
- 模板引擎：thymeleaf
- 持久层：mybatis-plus
- 容器框架：springboot
- 开发平台：idea2018-2  jdk1.8  win10