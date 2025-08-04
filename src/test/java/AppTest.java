import app.config.AppConfig;
import app.model.Animal;
import app.model.AnimalsCage;
import app.model.Cat;
import app.model.Dog;
import app.model.Timer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        Timer timerOne =
                applicationContext.getBean(Timer.class);
        Timer timerTwo =
                applicationContext.getBean(Timer.class);

        Animal dog = applicationContext.getBean(Dog.class);
        Animal cat = applicationContext.getBean(Cat.class);

        Assert.assertSame("Тест провален, не корректная настройка бина Animal", timerOne, timerTwo);
        Assert.assertNotSame("Тест провален, не корректная настройка бина Timer", dog, cat);
    }
}