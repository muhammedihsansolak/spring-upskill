package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationInterface{

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Email Notification for Comment:"+comment.getText());
    }
}
