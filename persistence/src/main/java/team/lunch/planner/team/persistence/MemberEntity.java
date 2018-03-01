package team.lunch.planner.team.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
public class MemberEntity {

    @Id
    @GeneratedValue
    private final Long id;
    private final Long userId;
    private final boolean turn;
    private final boolean present;

    MemberEntity() {
        this(null, null, false, false);
    }
}
