package schemaExercise;

import domin.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 设计配置属性和JavaBean
 * 编写XSD文件  ttp://www.w3school.com.cn/schema/schema_schema.asp
 * 编写NamespaceHandler和BeanDefinitionParser完成解析工作
 * 编写spring.handlers和spring.schemas串联起所有部件
 * 在Bean文件中应用
 */
public class SchemaTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        People p = (People)ctx.getBean("p1");
        System.out.println(p);

    }
}
