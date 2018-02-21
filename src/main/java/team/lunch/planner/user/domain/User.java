package team.lunch.planner.user.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    private final Long id;
    private final String email;
    private String password;
    private final String firstname;
    private final String lastname;
}
