package org.gabriel;

import org.gabriel.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.telusko.config.AppConfig;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Desktop dt = context.getBean("desktop", Desktop.class);
//        dt.compile();

//        Desktop dt1 = context.getBean("desktop", Desktop.class);
//        Desktop dt2 = context.getBean("desktop", Desktop.class);

            Alien obj1 = context.getBean(Alien.class);
    	    System.out.println(obj1.getAge());
            obj1.code();

            int age = 4;
            Alien x =context.getBean(Alien.class);
            int idadeTotal = age + obj1.getAge();
            System.out.println("A idade de X é: " +idadeTotal);












//    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  // create a container

////
////    	Alien obj2 = (Alien) context.getBean("alien1");
////    	System.out.println(obj2.age);
////    	//obj2.code();
//
//
//
////        Computer com=	context.getBean( Computer.class);
//
//
//
////    	Desktop obj=(Desktop)context.getBean("com2",Desktop.class);
////	 Desktop obj= context.getBean( Desktop.class);
    }
}
