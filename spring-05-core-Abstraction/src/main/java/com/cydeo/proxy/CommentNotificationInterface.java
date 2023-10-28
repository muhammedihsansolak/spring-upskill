package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationInterface {
    void sendComment(Comment comment);
}
