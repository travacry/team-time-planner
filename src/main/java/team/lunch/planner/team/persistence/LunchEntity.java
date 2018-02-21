package team.lunch.planner.team.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class LunchEntity {

    @Id
    @GeneratedValue
    private final Long id;
//    @OneToMany(cascade = CascadeType.ALL)
//    private final List<UserEntity> participants;
    private final String restaurant;

    LunchEntity() {
        this(null, null);
    }
}
