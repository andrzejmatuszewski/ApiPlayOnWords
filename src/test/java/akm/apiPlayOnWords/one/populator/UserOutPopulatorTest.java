package akm.apiPlayOnWords.one.populator;

import akm.apiPlayOnWords.one.exceptions.UserInNullException;
import akm.apiPlayOnWords.one.model.UserIn;
import akm.apiPlayOnWords.one.model.UserOut;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UserOutPopulatorTest {

    private static final String t1 = "Test-Id";
    private static final String t2 = "Test-Login";
    private static final String t3 = "Test-Name";
    private static final String t4 = "Test-Type";
    private static final String t5 = "Test-Avatar";
    private static final String t6 = "Test-Crated_at";
    private static final int t7 = 4;
    private static final int t8 = 3;

    private static final double r1 = 12;

    @Test
    void populate() {
        UserOut uOut = new UserOut();
        UserIn uIn = new UserIn();

        uIn.setId(t1);
        uIn.setLogin(t2);
        uIn.setName(t3);
        uIn.setType(t4);
        uIn.setAvatar_url(t5);
        uIn.setCreated_at(t6);
        uIn.setPublic_repos(t7);
        uIn.setFollowers(t8);

        UserOutPopulator uop = new UserOutPopulator();

        uop.populate(uOut, uIn);

        Assert.isTrue(uOut.getId().equals(t1),t1);
        Assert.isTrue(uOut.getLogin().equals(t2),t2);
        Assert.isTrue(uOut.getName().equals(t3),t3);
        Assert.isTrue(uOut.getType().equals(t4),t4);
        Assert.isTrue(uOut.getAvatarUrl().equals(t5),t5);
        Assert.isTrue(uOut.getCreatedAt().equals(t6),t6);
        Assert.isTrue(uOut.getCalculations()==r1, r1+"");
    }


}
