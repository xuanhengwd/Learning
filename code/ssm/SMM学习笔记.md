# SMM学习笔记

## springmvc

### 静态资源访问不到

```xml
 <!--开放资源的访问-->
<mvc:resources mapping="/js/**" location="/js/"/>

<!--或者这样也可以-->
<mvc:default-servlet-handler/>
```

### 解决post乱码问题

```xml
<!--配置全局过滤filter-->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```