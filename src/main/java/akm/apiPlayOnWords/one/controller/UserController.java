package akm.apiPlayOnWords.one.controller;

import akm.apiPlayOnWords.one.exceptions.UserInNullException;
import akm.apiPlayOnWords.one.model.UserIn;
import akm.apiPlayOnWords.one.model.UserOut;
import akm.apiPlayOnWords.one.populator.UserOutPopulator;
import akm.apiPlayOnWords.one.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserService userService;
    private final UserOutPopulator outPopulator;

    @RequestMapping("/")
    public String rootContext() {
        return "ON";
    }

    @RequestMapping("/users")
    public String userContext() {
        UserOut userOut = new UserOut();
        String testString = "{\"login\": \"octocat\",  \"id\": 583231,  \"node_id\": \"MDQ6VXNlcjU4MzIzMQ==\",  \"avatar_url\": \"https://avatars3.githubusercontent.com/u/583231?v=4\",  \"gravatar_id\": \"\",  \"url\": \"https://api.github.com/users/octocat\",  \"html_url\": \"https://github.com/octocat\",  \"followers_url\": \"https://api.github.com/users/octocat/followers\",  \"following_url\": \"https://api.github.com/users/octocat/following{/other_user}\",  \"gists_url\": \"https://api.github.com/users/octocat/gists{/gist_id}\",  \"starred_url\": \"https://api.github.com/users/octocat/starred{/owner}{/repo}\",  \"subscriptions_url\": \"https://api.github.com/users/octocat/subscriptions\",  \"organizations_url\": \"https://api.github.com/users/octocat/orgs\",  \"repos_url\": \"https://api.github.com/users/octocat/repos\",  \"events_url\": \"https://api.github.com/users/octocat/events{/privacy}\",  \"received_events_url\": \"https://api.github.com/users/octocat/received_events\",  \"type\": \"User\",  \"site_admin\": false,  \"name\": \"The Octocat\",  \"company\": \"@github\",  \"blog\": \"https://github.blog\",  \"location\": \"San Francisco\",  \"email\": null,  \"hireable\": null,  \"bio\": null,  \"twitter_username\": null,  \"public_repos\": 8,  \"public_gists\": 8,  \"followers\": 3132,  \"following\": 9,  \"created_at\": \"2011-01-25T18:44:36Z\",  \"updated_at\": \"2020-07-02T15:22:33Z\"}";

        UserIn userIn = userService.processResponce(testString);
        LOG.info(userOut);
        LOG.info(userIn);
        outPopulator.populate(userOut, userIn);
        LOG.info(userOut);
        LOG.info(userOut.getJson());

        return "podaj login";
    }

    @RequestMapping("/users/{login}")
    public String userContext(@PathVariable("login") String login) {
        UserIn userIn = userService.connectToApi(login);
        if (Objects.nonNull(userIn)) {
            UserOut userOut = new UserOut();
            outPopulator.populate(userOut, userIn);



            LOG.info("Returning: "+userOut.getJson());
            return userOut.getJson();

        } else {
            throw new UserInNullException();
        }

    }


}
