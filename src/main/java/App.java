import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(bean.getMessage());

        HelloWorld bean2 =
                (HelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(bean2.getMessage());
        System.out.println("Объект один и тот же? Ответ - " + (bean == bean2));

        System.out.println("----------------------------------------");

        Cat catBean = (Cat) applicationContext.getBean("cat");
        System.out.println(catBean.getMessage());

        Cat catBean2 = (Cat) applicationContext.getBean("cat");
        System.out.println(catBean2.getMessage());
        System.out.println("Объект один и тот же? Ответ - " + (catBean==catBean2));




    }
}
