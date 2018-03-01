package team.lunch.planner.team.persistence;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import team.lunch.planner.team.domain.Member;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class MemberEntityMapper {

    public Member map(MemberEntity memberEntity) {
        return new Member(memberEntity.getId(), memberEntity.getUserId(), memberEntity.isTurn(), memberEntity.isPresent());
    }

    public MemberEntity map(Member member) {
        return new MemberEntity(member.getId(), member.getUserId(), member.isTurn(), member.isPresent());
    }
}
