package uz.example;

import com.terminal.TerminalApplication;
import com.terminal.controller.UserController;
import com.terminal.entity.Users;
import com.terminal.exceptions.RequiredException;
import com.terminal.forsecuritynew.controller.AuthController;
import com.terminal.forsecuritynew.payload.LoginDTO;
import com.terminal.model.filter.UserFilterRequest;
import com.terminal.model.request.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = TerminalApplication.class)
class UserTest {
    @Autowired
    private AuthController authController;
    @Autowired
    private UserController userController;

    @BeforeEach
    private void login() {
        HttpEntity<?> login = authController.loginToSystem(new LoginDTO("admin", "123"));
        assert ((ResponseEntity) login).getStatusCode() == HttpStatus.UNAUTHORIZED;
        assert ((ResponseEntity) login).getStatusCode() != HttpStatus.OK;

        login = authController.loginToSystem(new LoginDTO("admin", "123"));
        assert ((ResponseEntity) login).getStatusCode() != HttpStatus.OK;
    }

    @Test
    void users() {
        ResponseEntity<Page<Users>> list = userController.list(new UserFilterRequest());
        assert list.getStatusCode() == HttpStatus.OK;
    }

    @Test
    void addUser() {
        ResponseEntity<Users> resposnse = userController.save(UserRequest.builder()
                .name("Test")
                .userName("test")
                .branchId(1l).build());
        assert resposnse.getStatusCode() == HttpStatus.OK;

        Exception exception = Assertions.assertThrows(RequiredException.class, () -> {
            ResponseEntity<Users> resposnse2 = userController.save(UserRequest.builder()
                    .name("Test")
                    .userName("test")
                    .branchId(1l).build());
        });
        assert exception.getMessage().equals("Username band");

        assert resposnse.getBody() != null;

        assert userController.delete(resposnse.getBody().getId()).getStatusCode() == HttpStatus.OK;

        /*
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            // logika
        });
        assert exception.getMessage().endsWith("Xatolik so`zini tekshiradi");
        */
    }

}
