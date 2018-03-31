package team.lunch.planner.team.domain;

import java.util.List;

public interface TeamEvent {

    String getName();
    List<Member> getParticipants();
}
