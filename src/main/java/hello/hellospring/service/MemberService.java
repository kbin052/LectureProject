package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository MemberRepositore;

    public MemberService(MemoryMemberRepository memberRepositore) {
        MemberRepositore = memberRepositore;
    }

    public long join(Member member){
       //같은 이름이 있는 중복회원은 X
        validateDuplicateMember(member); // 중복 회원 검증
        MemberRepositore.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        MemberRepositore.findByName(member.getName())
                .ifPresent(m -> {
                   throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public List<Member> findMembers(){
      return  MemberRepositore.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return MemberRepositore.findById(memberId);
    }
}
