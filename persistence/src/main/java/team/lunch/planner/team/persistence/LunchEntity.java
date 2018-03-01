package team.lunch.planner.team.persistence;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @OneToMany(cascade = CascadeType.ALL)
    private final List<MemberEntity> participants;
    private final String restaurant;

    LunchEntity() {
        this(null, Collections.emptyList(), null);
    }
}
