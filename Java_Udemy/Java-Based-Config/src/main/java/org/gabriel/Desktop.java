package org.gabriel;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer {

    public  Desktop() {
        System.out.println("Desktop  Objected Created");
    }
    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}
