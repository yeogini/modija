package modija.modija;

import modija.modija.controller.MemberController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberController memberController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(memberController).isNotNull();

    }

}
