package com.cydeo.streotype_annotation.monitorfactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AcerMonitor extends Monitor{

    public AcerMonitor() {
        super("25 inch beast","Sony",25);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");
    }
}
