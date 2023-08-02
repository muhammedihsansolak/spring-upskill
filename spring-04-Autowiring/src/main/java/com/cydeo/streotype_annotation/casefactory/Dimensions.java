package com.cydeo.streotype_annotation.casefactory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@Component
public class Dimensions {
    private int width;
    private int height;
    private int depth;

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
