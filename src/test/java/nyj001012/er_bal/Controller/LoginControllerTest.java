package nyj001012.er_bal.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(LoginController.class)
@AutoConfigureRestDocs
public class LoginControllerTest {

    LoginController loginController;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        loginController = new LoginController();
    }

    @Test
    public void test_로그인() throws Exception {
        mockMvc.perform(get("/api/login"))
                .andExpect(result -> {
                    assertThat(result.getResponse().getStatus()).isEqualTo(200);
                    assertThat(result.getResponse().getContentAsString()).isEqualTo("Login");
                });
    }
}