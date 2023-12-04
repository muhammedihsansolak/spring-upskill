package com.cydeo.service.impl;

import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void findByUsername_Test(){
        userService.findByUserName("harold@manager.com");

        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, times(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        InOrder inOrder = inOrder(userRepository, userMapper);
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);
    }

}