package com.example.commandexecutorproject;

import com.example.commandexecutorproject.models.User;
import com.example.commandexecutorproject.repositories.UserRepository;
import com.example.commandexecutorproject.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
class CommandExecutorProjectApplicationTests {

    private UserRepository userRepository;

    @BeforeEach
    public void init(){
        userRepository = Mockito.mock(UserRepository.class);
    }

    @AfterEach
    public void close(){
        // close static connections
    }

    @Test
    public void testUser(){
        UserService userService = new UserService(userRepository);
        User mockUser = User.builder().name("saharsh").id(10L).createdAt(new Date()).build();
        Mockito.when(userRepository.findUserByName("saharsh")).thenReturn(Optional.of(mockUser));

        User user = userService.login("saharsh");
        Assertions.assertEquals(user.getName(), "saharsh");
    }

    @Test
    void contextLoads() {
    }

}
