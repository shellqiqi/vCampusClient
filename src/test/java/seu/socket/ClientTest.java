package seu.socket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Dormitory;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class ClientTest {

    private ClientRequest clientRequest1;

    @Autowired
    Client client;

    @Before
    public void setUp() throws Exception {
        clientRequest1 = new ClientRequest("dormitoryService", "getDormitoryAll");
    }

    @Test
    public void send() throws Exception {
        List<Dormitory> dormitories = (List<Dormitory>) client.send(clientRequest1).getData();
        System.out.println(dormitories.get(0).getScore());
        System.out.println(dormitories);
    }

}