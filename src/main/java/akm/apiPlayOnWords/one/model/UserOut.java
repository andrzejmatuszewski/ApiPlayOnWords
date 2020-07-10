package akm.apiPlayOnWords.one.model;

/**
 * outgoing object
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserOut {
    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private double calculations;

    public String getJson() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(" \"id\": " + id);
        sb.append(", \"login\": " + "\"" + login + "\"");
        sb.append(", \"name\": " + "\"" + name + "\"");
        sb.append(", \"type\": " + "\"" + type + "\"");
        sb.append(", \"avatarUrl\": " + "\"" + avatarUrl + "\"");
        sb.append(", \"createdAt\": " + "\"" + createdAt + "\"");
        sb.append(", \"calculations\": " + calculations);
        sb.append("}");
        return sb.toString();
    }

}
