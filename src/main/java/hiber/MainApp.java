package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;


public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
        Car car = new Car("Audi", 1);
        Car car2 = new Car("Toyota", 2);
        Car car3 = new Car("Mercedes-Benz", 3);
        Car car4 = new Car("BMW", 4);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        carService.add(car);
        carService.add(car2);
        carService.add(car3);
        carService.add(car4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println();
        }

        List<Car> cars = carService.listCars();
        for (Car c : cars) {
            System.out.println(c.getModel());
        }

        for (int i = 0; i < users.size() && i < cars.size(); i++) {
            User user = users.get(i);
            Car c = cars.get(i);
            user.setCar(c);

            User newUser = new User(user.getFirstName(), user.getLastName(), user.getEmail(), c);

            newUser.setId(user.getId());

            userService.add(newUser);
        }

        List<User> usersByCarModelAndSeries = userService.getUsersByCarModelAndSeries(car.getModel(), car.getSeries());
        for (User user : usersByCarModelAndSeries) {
            System.out.println(user);
        }
        context.close();
    }
}