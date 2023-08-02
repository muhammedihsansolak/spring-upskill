package com.cydeo.service;

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

    public CommentService(CommentRepository commentRepository,@Qualifier("PUSH") CommentNotificationInterface commentNotificationInterface) {
        this.commentRepository = commentRepository;
        this.commentNotificationInterface = commentNotificationInterface;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationInterface.sendComment(comment);

    }
}
