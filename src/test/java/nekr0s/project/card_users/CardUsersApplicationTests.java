package nekr0s.project.card_users;

import nekr0s.project.card_users.utils.CustomNamingStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardUsersApplicationTests {

    @Test
    public void CustomNamingStrategy_ShouldReturn_InCorrectNamingConvention() {
        CustomNamingStrategy customNamingStrategy = new CustomNamingStrategy();

        String input = "personalNumber";

        String result = "PersonalNumber";

        Assert.assertEquals(result, customNamingStrategy.columnName(input));
    }

    @Test
    public void CustomNamingStrategy_ShouldCover_CornerCase() {
        CustomNamingStrategy customNamingStrategy = new CustomNamingStrategy();

        String input = "requestId";

        String result = "RequestID";

        Assert.assertEquals(result, customNamingStrategy.columnName(input));
    }

}
