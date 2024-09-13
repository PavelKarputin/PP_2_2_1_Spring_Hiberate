package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class   MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);


      UserService userService = context.getBean(UserService.class);
      //userService.deleteAllUsers();

      Car Lada = new Car("Lada", 9);
      Car Mazda = new Car("Mazda", 6);
      Car BMV = new Car("BMV", 5);
      Car Toyota = new Car("Toyota", 70);

      userService.add(new User("Sergei", "Vasichev", "serVAs@mail.ru").setCar(Lada));
      userService.add(new User("Vladimir", "Kazakov", "kazakV@gmail.com").setCar(Mazda));
      userService.add(new User("Aleksandr", "Gavrin", "aleksGav@mail.ru").setCar(BMV));
      userService.add(new User("Darya", "Chepikova", "dacha@gmail.com").setCar(Toyota));

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

      User user = userService.getUserByCar("Lada", 9);
      System.out.println(user.toString());

      context.close();
   }
}
