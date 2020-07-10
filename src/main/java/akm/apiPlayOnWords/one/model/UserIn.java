package akm.apiPlayOnWords.one.model;

/**
 * Object obtaind from
 * https://api.github.com/users/{login} (ex. https://api.github.com/users/octocat)
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserIn {
    @JsonProperty("login")
    private String login;
    @JsonProperty("id")
    private String id;
    @JsonProperty("node_id")
    private String node_id;
    @JsonProperty("avatar_url")
    private String avatar_url;
    @JsonProperty("gravatar_id")
    private String gravatar_id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("html_url")
    private String html_url;
    @JsonProperty("followers_url")
    private String followers_url;
    @JsonProperty("following_url")
    private String following_url;
    @JsonProperty("gists_url")
    private String gists_url;
    @JsonProperty("starred_url")
    private String starred_url;
    @JsonProperty("subscriptions_url")
    private String subscriptions_url;
    @JsonProperty("organizations_url")
    private String organizations_url;
    @JsonProperty("repos_url")
    private String repos_url;
    @JsonProperty("events_url")
    private String events_url;
    @JsonProperty("received_events_url")
    private String received_events_url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("site_admin")
    private String site_admin;
    @JsonProperty("name")
    private String name;
    @JsonProperty("company")
    private String company;
    @JsonProperty("blog")
    private String blog;
    @JsonProperty("location")
    private String location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("hireable")
    private String hireable;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("twitter_username")
    private String twitter_username;
    @JsonProperty("public_repos")
    private int public_repos;
    @JsonProperty("public_gists")
    private String public_gists;
    @JsonProperty("followers")
    private int followers;
    @JsonProperty("following")
    private String following;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("updated_at")
    private String updated_at;

}
