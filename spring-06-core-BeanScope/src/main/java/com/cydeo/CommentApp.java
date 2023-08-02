package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Muhammed");
        comment.setText("Spring is fun");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

        //Singleton scope --> container always creates the same bean
        CommentService sc1 = context.getBean(CommentService.class);
        CommentService sc2 = context.getBean(CommentService.class);

        System.out.println(sc1);
        System.out.println(sc2);

        System.out.println(sc1 == sc2);



    }
}
