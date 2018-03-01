package team.lunch.planner.user.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter
@ToString
class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private final String email;
    private final String password;
    private final String firstname;
    private final String lastname;
    
    public UserEntity() {
        this(null, "", "", "", "");
    }
}
