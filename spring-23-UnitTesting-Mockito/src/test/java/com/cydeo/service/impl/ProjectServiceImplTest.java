package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectMapper projectMapper;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test(){

        //Given
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); //Stubbing
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        //When
        ProjectDTO byProjectCode = projectService.getByProjectCode(anyString());

        //Then
        InOrder inOrder = inOrder(projectRepository, projectMapper);

        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(byProjectCode);
    }

    @Test
    void getByProjectCode_ExceptionTest(){
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project not found"));

        Throwable exception = assertThrows(NoSuchElementException.class, () -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");
        verify(projectMapper, never()).convertToDto(any(Project.class));

        assertEquals("Project not found", exception.getMessage());
    }

}