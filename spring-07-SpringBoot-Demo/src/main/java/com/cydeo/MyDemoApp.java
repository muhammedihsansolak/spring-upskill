package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyDemoApp {

	public static void main(String[] args) {

		Comment comment = new Comment();
		comment.setAuthor("Muhammed");
		comment.setText("Spring is fun");

		ApplicationContext context = SpringApplication.run(MyDemoApp.class, args);

		CommentService commentService = context.getBean(CommentService.class);
		commentService.publishComment(comment);

		commentService.printConfigData();
		commentService.printDBConfigData();

	}

}
