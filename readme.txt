ssm项目整合
    相关依赖
    <packaging>war</packaging>

    <properties>
        <spring.version>5.3.1</spring.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--springmvc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- Mybatis核心 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.7</version>
        </dependency>
        <!--mybatis和spring的整合包-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>
        <!-- 连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.9</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>
        <!-- log4j日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.2.0</version>
        </dependency>
        <!-- 日志 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
        <!-- ServletAPI -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.1</version>
        </dependency>
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.3.1</version>
        </dependency>
        <!-- Spring5和Thymeleaf整合包 -->
        <dependency>
            <groupId>org.thymeleaf</groupId>
            <artifactId>thymeleaf-spring5</artifactId>
            <version>3.0.12.RELEASE</version>
        </dependency>
    </dependencies>

 1、创建web.xml
     <!--    配置spring的编码过滤器-->
     <filter>
         <filter-name>CharacterEncodingFilter</filter-name>
         <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
         <init-param>
             <param-name>encoding</param-name>
             <param-value>UTF-8</param-value>
         </init-param>
         <init-param>
             <param-name>forceEncoding</param-name>
             <param-value>true</param-value>
         </init-param>
     </filter>
     <filter-mapping>
         <filter-name>CharacterEncodingFilter</filter-name>
         <url-pattern>/*</url-pattern>
     </filter-mapping>
     <!--    配置put、delete请求方式的过滤器-->
     <filter>
         <filter-name>HiddenHttpMethodFilter</filter-name>
         <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
     </filter>
     <filter-mapping>
         <filter-name>HiddenHttpMethodFilter</filter-name>
         <url-pattern>/*</url-pattern>
     </filter-mapping>
     <!--    配置SpringMVC前端控制器DispatchServlet-->
     <servlet>
         <servlet-name>SpringMVC</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <init-param>
             <!--         设置SpringMVC配置文件自定义的位置和名称-->
             <param-name>contextConfigLocation</param-name>
             <param-value>classpath:springmvc.xml</param-value>
         </init-param>
         <!--        将DispatcherServlet初始化时间提前到服务器启动时间-->
         <load-on-startup>1</load-on-startup>
     </servlet>
     <servlet-mapping>
         <servlet-name>SpringMVC</servlet-name>
         <url-pattern>/</url-pattern>
     </servlet-mapping>
     <!--    配置spring的监听器，在服务器启动时加载spring的配置文件-->
     <listener>
         <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     </listener>
     <!--自定义Spring配置文件的位置和名称-->
     <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:spring.xml</param-value>
     </context-param>


 2、创建SpringMVC配置文件并配置
    <!--    扫描组件-->
        <context:component-scan base-package="com.atguigu.ssm.controller"></context:component-scan>
        <!--配置视图解析器-->
        <bean id="viewResolver"
              class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
            <property name="order" value="1"/>
            <property name="characterEncoding" value="UTF-8"/>
            <property name="templateEngine">
                <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
                    <property name="templateResolver">
                        <bean
                                class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
                            <!-- 视图前缀 -->
                            <property name="prefix" value="/WEB-INF/templates/"/>
                            <!-- 视图后缀 -->
                            <property name="suffix" value=".html"/>
                            <property name="templateMode" value="HTML5"/>
                            <property name="characterEncoding" value="UTF-8" />
                        </bean>
                    </property>
                </bean>
            </property>
        </bean>
    <!--    配置访问首页的视图控制器-->
        <mvc:view-controller path="/" view-name="index"/>
    <!--    开启mvc注解驱动-->
        <mvc:annotation-driven/>
    <!--    配置默认的servlet处理静态资源-->
        <mvc:default-servlet-handler/>


 3、搭建Mybatis环境
    1、创建属性文件jdbc.properties
        jdbc.driver=com.mysql.cj.jdbc.Driver
        jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
        jdbc.username=root
        jdbc.password=abc123

    2、创建MyBatis的核心配置文件mybatis-config.xml
        <configuration>
            <!--
            MyBatis核心配置文件中，标签的顺序：
            properties?,settings?,typeAliases?,typeHandlers?,
            objectFactory?,objectWrapperFactory?,reflectorFactory?,
            plugins?,environments?,databaseIdProvider?,mappers?
            -->
            <settings>
                <!--将下划线映射为驼峰-->
                <setting name="mapUnderscoreToCamelCase" value="true"/>
            </settings>
            <plugins>
                <!--配置分页插件-->
                <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
            </plugins>
        </configuration>

    3、创建Mapper接口和映射文件
    4、创建日志文件log4j.xml
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

        <log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

            <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
                <param name="Encoding" value="UTF-8" />
                <layout class="org.apache.log4j.PatternLayout">
                    <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m  (%F:%L) \n" />
                </layout>
            </appender>
            <logger name="java.sql">
                <level value="debug" />
            </logger>
            <logger name="org.apache.ibatis">
                <level value="info" />
            </logger>
            <root>
                <level value="debug" />
                <appender-ref ref="STDOUT" />
            </root>
        </log4j:configuration>

 4、配置spring，整合Mybatis
         <!--    组件扫描(除Controller组件)-->
         <context:component-scan base-package="com.atguigu.ssm">
             <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
         </context:component-scan>
         <!--    引入jdbc.propertier文件-->
         <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
         <!--    配置Druid数据源-->
         <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
             <property name="driverClassName" value="${jdbc.driver}"></property>
             <property name="url" value="${jdbc.url}"></property>
             <property name="username" value="${jdbc.username}"></property>
             <property name="password" value="${jdbc.password}"></property>
         </bean>
         <!--配置SqlSessionFactoryBean，可以直接在Spring的IOC中获取SqlSessionFactory-->
         <bean class="org.mybatis.spring.SqlSessionFactoryBean">
             <!--设置MyBatis的核心配置文件的路径-->
             <property name="configLocation" value="classpath:mybatis-config.xml"></property>
             <!--设置数据源-->
             <property name="dataSource" ref="dataSource"></property>
             <!--设置类型别名所对应的包-->
             <property name="typeAliasesPackage" value="com.atguigu.ssm.pojo"></property>
             <!--设置映射文件的路径，只有映射文件的包和mapper接口的包不一致时需要设置-->
             <!--<property name="mapperLocations" value="classpath:mappers/*.xml"></property>-->

         </bean>
         <!--
         配置mapper接口的扫描，可以将指定包下所有的mapper接口
         通过SqlSession创建代理实现类对象，并将这些对象交给IOC容器管理
     -->
         <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
             <property name="basePackage" value="com.atguigu.ssm.mapper"></property>
         </bean>

         <!--    配置事务管理器-->
         <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
             <property name="dataSource" ref="dataSource"></property>
         </bean>
         <!--
         开启事务的注解驱动
         将使用注解@Transactional标识的方法或类中所有的方法进行事务管理
     -->
         <tx:annotation-driven transaction-manager="transactionManager" />