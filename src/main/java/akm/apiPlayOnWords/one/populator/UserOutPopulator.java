package akm.apiPlayOnWords.one.populator;

import akm.apiPlayOnWords.one.exceptions.UserInNullException;
import akm.apiPlayOnWords.one.model.UserIn;
import akm.apiPlayOnWords.one.model.UserOut;

import java.util.Objects;

public class UserOutPopulator {

    public void populate(UserOut userOut, UserIn userIn) {

        userOut.setId(userIn.getId());
        userOut.setLogin(userIn.getLogin());
        userOut.setName(userIn.getName());
        userOut.setType(userIn.getType());
        userOut.setAvatarUrl(userIn.getAvatar_url());
        userOut.setCreatedAt(userIn.getCreated_at());
        userOut.setCalculations(calculation(userIn));
    }

    private double calculation(UserIn userIn) {
        if (Objects.nonNull(userIn)) {
            int followers = userIn.getFollowers();
            int publicRepos = userIn.getPublic_repos();
            int six = 6;
            int two = 2;


            return six / followers * (two + publicRepos);
        } else {
            throw new UserInNullException();
        }
    }
}
