package org.gabriel.config;

import org.gabriel.Alien;
import org.gabriel.Computer;
import org.gabriel.Desktop;
import org.gabriel.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.gabriel")
public class AppConfig {

//    @Bean
//    public Alien alien(/*@Qualifier("desktop")*/ @Autowired Computer com) {
//        Alien obj = new Alien();
//        obj.setAge(25);
//        obj.setCom(com);
//        return obj;
//    }
//
////    @Bean (name = {"com2", "desktop", "Beast"})
//    @Bean
////    @Scope("prototype") //O Spring cria uma NOVA instância toda vez que alguém pedir esse bean.
//    public Desktop desktop() {
//        return new Desktop();
//    }
//
//    @Bean
////    @Primary //Essa é a solução mais comum. Você elege um dos beans como o "padrão". Se ninguém especificar qual quer, o Spring entrega esse.
//    public Laptop laptop() {
//        return new Laptop();
//    }

}
