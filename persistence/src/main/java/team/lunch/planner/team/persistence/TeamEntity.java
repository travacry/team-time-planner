package team.lunch.planner.team.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
class TeamEntity {

    @Id
    @GeneratedValue
    private final Long id;
    private final String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<MemberEntity> members;
    @OneToOne(cascade = CascadeType.ALL)
    private final LunchEntity lunch;

    TeamEntity() {
        this(null, "", null, null);
    }
}
