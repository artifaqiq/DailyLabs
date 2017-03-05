package by.casanova.team.json;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by artifaqiq on 3/5/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJsonTests {

    @Test
    public void fromJsonTest() {
        String json = "{\"username\":\"USERNAME\", \"password\":\"PASSWORD\"}";
    }
}
