package uz.example;

import com.terminal.TerminalApplication;
import com.terminal.controller.ApplicationController;
import com.terminal.entity.Application;
import com.terminal.forsecuritynew.controller.AuthController;
import com.terminal.forsecuritynew.payload.LoginDTO;
import com.terminal.model.filter.ApplicationFilterRequest;
import com.terminal.model.request.ApplicationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = TerminalApplication.class)
public class AppTest {
    @Autowired
    private AuthController authController;

    @Autowired
    private ApplicationController applicationController;

    @BeforeEach
    private void login() {
        HttpEntity<?> login = authController.loginToSystem(new LoginDTO("admin", "123"));
        assert ((ResponseEntity) login).getStatusCode() == HttpStatus.UNAUTHORIZED;
        assert ((ResponseEntity) login).getStatusCode() != HttpStatus.OK;

        login = authController.loginToSystem(new LoginDTO("admin", "123"));
        assert ((ResponseEntity) login).getStatusCode() != HttpStatus.OK;
    }

    @Test
    void applist(){
        ResponseEntity<Page<Application>> list =applicationController.list(new ApplicationFilterRequest());
        assert list.getStatusCode()== HttpStatus.OK;
    }
    @Test
    void addApplication(){
        ResponseEntity<Application> response = applicationController.save( ApplicationRequest.builder()
                .appNumber(1L).serialNumber("1").organizationId(1L).build());
        assert response.getStatusCode()==HttpStatus.OK;
        assert response.getBody() != null;
        assert applicationController.delete(response.getBody().getId()).getStatusCode() == HttpStatus.OK;
    }
}
