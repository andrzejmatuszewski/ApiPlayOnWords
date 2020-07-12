package akm.apiPlayOnWords.one.populator;

import akm.apiPlayOnWords.one.exceptions.CalculationsGeneralException;
import akm.apiPlayOnWords.one.exceptions.UserInNullException;
import akm.apiPlayOnWords.one.model.UserIn;
import akm.apiPlayOnWords.one.model.UserOut;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserOutPopulator {

    public void populate(UserOut userOut, UserIn userIn) {

        userOut.setId(userIn.getId());
        userOut.setLogin(userIn.getLogin());
        userOut.setName(userIn.getName());
        userOut.setType(userIn.getType());
        userOut.setAvatarUrl(userIn.getAvatar_url());
        userOut.setCreatedAt(userIn.getCreated_at());
        try {
            userOut.setCalculations(calculation(userIn));
        } catch (CalculationsGeneralException ex) {
            ex.printStackTrace();
            userOut.setCalculations(0.0);
        }
    }

    private double calculation(UserIn userIn) {
        if (Objects.nonNull(userIn)) {
            int followers = userIn.getFollowers();
            int publicRepos = userIn.getPublic_repos();
            int six = 6;
            int two = 2;

            if (followers == 0) {
                throw new CalculationsGeneralException("followers");
            }

            return six / followers * (two + publicRepos);
        } else {
            throw new UserInNullException();
        }
    }
}
