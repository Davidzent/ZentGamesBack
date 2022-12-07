package com.example.zent.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;

import com.example.zent.module.User;
import com.example.zent.service.UserService;

class UserControllerTest {
    private static final String USERNAME = "dummyUsername";
    private static final String PSWD = "abc123";
    private static final String fname = "David";
    private static final String lname = "Guijosa";
    private static final String EMAIL = "dummy@email.com";
    private static User expected = new User();

    private static final String USERNAME2 = "dummyUsername2";
    private static final String PSWD2 = "abc123";
    private static final String fname2 = "Zent";
    private static final String lname2 = "Senshin";
    private static final String EMAIL2 = "dummy2@email.com";
    private static User expected2 = new User();
    

    private User user;
    private User testUser;

    private MockHttpSession session;
    
    @Mock
    private UserService us;

    @InjectMocks
    UserController uc;

    @BeforeEach
	 void initMock() {
        MockitoAnnotations.openMocks(this);
        expected = new User(USERNAME, PSWD, fname, lname, EMAIL);
        expected2 = new User(USERNAME2, PSWD2, fname2, lname2, EMAIL2);
        user = new User();
        user.setUsername(USERNAME);
        user.setPassword(PSWD);
        user.setFname(fname);
        user.setLname(lname);
        user.setEmail(EMAIL);
        
        testUser = new User();
        testUser.setUsername(USERNAME2);
        testUser.setPassword(PSWD2);
        testUser.setFname(fname2);
        testUser.setLname(lname2);
        testUser.setEmail(EMAIL2);
        
	  }
	 
	 @BeforeEach
	 void initEachMock() {
		 MockitoAnnotations.openMocks(this);
	 }

    @Test
    void testCreateUser() {
        when(us.getProfileByEmail(any(User.class))).thenReturn(null);
        when(us.register(any(User.class))).thenReturn(expected);
        try (MockedStatic<AuthController> utilities = Mockito.mockStatic(AuthController.class)) {
            utilities.when(() -> AuthController.setSession(user,session))
              .thenAnswer((Answer<Void>) invocation -> null);
    
            ResponseEntity<User> responseEntity = uc.createUser(user,session);  
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        }
    }

    @Test
    void testIsloged() {
        try (MockedStatic<AuthController> utilities = Mockito.mockStatic(AuthController.class)) {
            utilities.when(() -> AuthController.isLogin(session))
              .thenReturn(expected);

              ResponseEntity<User> responseEntity = uc.isloged(session);  
              assertNotNull(responseEntity);
              assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        }

    }

    @Test
    void testLogin() {
        when(us.login(any(User.class))).thenReturn(expected);
        try (MockedStatic<AuthController> utilities = Mockito.mockStatic(AuthController.class)) {
            utilities.when(() -> AuthController.setSession(user,session))
              .thenAnswer((Answer<Void>) invocation -> null);
    
            ResponseEntity<User> responseEntity = uc.login(user,session);  
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        }
    }

    @Test
    void testLogout() {
        try (MockedStatic<AuthController> utilities = Mockito.mockStatic(AuthController.class)) {
            utilities.when(() -> AuthController.clearSession(session))
              .thenAnswer((Answer<Void>) invocation -> null);
            uc.logout(session);  
            assertTrue(true);
        }
    }

    @Test
    void testUpdate() {
        when(us.update(any(User.class))).thenReturn(expected2);
        try (MockedStatic<AuthController> utilities = Mockito.mockStatic(AuthController.class)) {
            utilities.when(() -> AuthController.isLogin(session))
              .thenReturn(expected);
            ResponseEntity<User> responseEntity = uc.update(expected2,session);  
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        }

    }
}
