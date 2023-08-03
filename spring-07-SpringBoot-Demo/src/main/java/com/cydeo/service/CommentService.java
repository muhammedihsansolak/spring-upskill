package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationInterface;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationInterface commentNotificationInterface;
    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationInterface commentNotificationInterface, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationInterface = commentNotificationInterface;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationInterface.sendComment(comment);
    }
    public void printConfigData(){
        System.out.println(appConfigData.getUsername());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }

    public void printDBConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }

}
