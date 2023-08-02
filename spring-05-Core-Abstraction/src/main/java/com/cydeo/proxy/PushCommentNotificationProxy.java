package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationInterface {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending Push Notification for Comment:"+comment.getText());
    }
}
