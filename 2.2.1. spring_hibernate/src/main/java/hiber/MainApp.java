package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class   MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);


      UserService userService = context.getBean(UserService.class);

      User Sergei = new User("Sergei", "Vasichev", "serVAs@mail.ru");
      User Vladimir = new User("Vladimir", "Kazakov", "kazakV@gmail.com");
      User Aleksandr = new User("Aleksandr", "Gavrin", "aleksGav@mail.ru");
      User Darya = new User("Darya", "Chepikova", "dacha@gmail.com");

      Car Lada = new Car("Lada", 9);
      Car Mazda = new Car("Mazda", 6);
      Car BMV = new Car("BMV", 5);
      Car Toyota = new Car("Toyota", 70);

      userService.add(Sergei.setCar(Lada).setUser(Sergei));
      userService.add(Vladimir.setCar(Mazda).setUser(Vladimir));
      userService.add(Aleksandr.setCar(BMV).setUser(Aleksandr));
      userService.add(Darya.setCar(Toyota).setUser(Darya));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      User user = userService.getUserByCar("BMW", 5);
      System.out.println(user.toString());

      try {
         User notFoundUser = userService.getUserByCar("Lada", 9);
      } catch (NoResultException e) {
         e.printStackTrace();
      }

      context.close();
   }
}
