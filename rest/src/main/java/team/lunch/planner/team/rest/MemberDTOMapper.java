package team.lunch.planner.team.rest;

import org.springframework.stereotype.Component;

import team.lunch.planner.team.domain.Member;

@Component
class MemberDTOMapper {

//    Member map(MemberDTO member) {
//        return new Member(member.getDatabaseId(), member.get)
//    }
    
    MemberDTO map(Member member) {
        return new MemberDTO(member.getId(), member.getUserId());
    }
    
}
