package me.sevenbrother;

import me.sevenbrother.server.init.Bootstrap;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class BaseTest {
}
