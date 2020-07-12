package akm.apiPlayOnWords.one.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserStats {
    private String login ;
    private int requestCount;
}
