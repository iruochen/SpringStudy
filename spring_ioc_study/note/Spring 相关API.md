## ApplicationContext 的实现类

- ClassPathXmlApplicationContext：它是从类的根路径下加载配置文件（推荐使用）
- FileSystemXmlApplicationContext：它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置
- AnnotationConfigApplicationContext：当使用注解配置容器对象时，需要使用此类来创建 spring 容器，它用来读取注解

## getBean() 方法使用
```java
// 允许容器中存在多个相同类型的 Bean 
public Object getBean(String name)throws BeansException{
    assertBeanFactoryActive();
    return getBeanFactory().getBean(name);
}
```
```java
// 不允许容器中存在多个相同类型的 Bean 
public <T> T getBean(Class<T> requiredType) throws BeansException {
    assertBeanFactoryActive();
    return getBeanFactory().getBean(requiredType);
}
```