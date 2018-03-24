package team.lunch.planner.team.rest;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Member;

@Component
@RequiredArgsConstructor
class MemberDTOMapper {

    Member map(MemberDTO member) {
        return new Member(member.getDatabaseId(), member.getDatabaseUserId(), member.isTurn(), member.isPresent());
    }
    
    MemberDTO map(Member member) {
        return new MemberDTO(member.getId(), member.getUserId(), "*** Name ***", member.isTurn(), member.isPresent());
    }
    
}
