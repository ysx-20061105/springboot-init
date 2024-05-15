# SpringBoot初始化模板

## 介绍

SpringBoot初始化模板，包含SpringBoot、MyBatis、MySQL、Redis、Swagger、Lombok等常用依赖，以及一些常用的配置。

## 项目目录

```
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── springboot
│   │   │               ├── annotation -- 注解
│   │   │               │   └── AutoFill.java -- 自动填充注解
│   │   │               ├── aop  -- AOP
│   │   │               │   └── AutoFillAspect.java  -- 自动填充切面
│   │   │               ├── common  -- 通用类
│   │   │               │   └── BaseResponse.java  -- 基础返回类
│   │   │               │   └── ErrorCode.java     -- 错误码
│   │   │               │   └── ResultUtils.java   -- 返回工具类
│   │   │               ├── config  -- 配置类
│   │   │               │   └── Knife4jConfiguration.java  -- Swagger配置
│   │   │               │   └── MybatisPlusConfig.java     -- MyBatisPlus配置
│   │   │               │   └── RedisTemplateConfig.java   -- Redis配置
│   │   │               │   └── WebMvcConfig.java          -- WebMvc配置
│   │   │               ├── contant  -- 常量类
│   │   │               │   └── AutoFillConstant.java  -- 自动填充常量
│   │   │               │   └── OperationType.java     -- 操作类型常量
│   │   │               ├── controller  -- 控制器
│   │   │               │   └── UserController.java  -- 用户控制器
│   │   │               ├── exception  -- 异常类
│   │   │               │   └── BusinessException.java       -- 业务异常类
│   │   │               │   └── GlobalExceptionHandler.java  -- 全局异常处理类 
│   │   │               ├── job  -- 定时任务
│   │   │               │   └── TestJob.java  -- 测试定时任务
│   │   │               ├── mapper  -- Mapper接口
│   │   │               │   └── UserMapper.java  -- 用户Mapper接口
│   │   │               ├── pojo  -- 实体类
│   │   │               │   └── dto     -- DTO
│   │   │               │       └── UserDTO.java  -- 用户DTO
│   │   │               │   └── entity  -- 实体类
│   │   │               │       └── User.java     -- 用户实体类
│   │   │               │   └── vo      -- VO
│   │   │               │       └── UserVO.java   -- 用户VO
│   │   │               ├── service         -- 服务接口
│   │   │               │   └── impl  -- 服务接口实现类
│   │   │               │       └── UserServiceImpl.java  -- 用户服务接口实现类
│   │   │               │   └── UserService.java          -- 用户服务接口
│   │   │               ├── utils  -- 工具类
│   │   │               │   └── BaseContext.java  -- 获取当前线程用户ID工具类
│   │   │               └── SpringbootApplication.java  -- 启动类
│   │   ├── resources
│   │   │   ├── application.yml
│   │   │   ├── mapper
│   │   │   ├── templates

│   └── test
│       └── java
│           └── com
│               └── example
│                   └── springboot
│                       └── SpringbootApplicationTests.java
```

## 项目启动

1. 修改application.yml中的数据库连接信息
2. 运行SpringbootApplication.java
3. 访问http://localhost:8080/user/ 进行测试
4. 访问http://localhost:8080/user/list 进行测试
5. 接口文档http://localhost:8080/api/doc.html#/home
