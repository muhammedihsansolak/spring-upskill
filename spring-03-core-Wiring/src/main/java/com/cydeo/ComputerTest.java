package com.cydeo;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.config.PcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(PcConfig.class);

        Case dellCase = context.getBean(DellCase.class);
        System.out.println(dellCase);
    }
}
