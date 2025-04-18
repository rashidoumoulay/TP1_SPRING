package net.oumoulay.presentation;

import net.oumoulay.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("net.oumoulay");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("res = "+metier.calcul());
    }
}
