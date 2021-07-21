package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepositore) {
        this.memberRepository = memberRepositore;
    }



    public long join(Member member){

        Long start =System.currentTimeMillis();
                //일일히 ms로 나오게 작업..
                try{
                    validateDuplicateMember(member);// 중복 회원 검증
                    memberRepository.save(member);
                    return member.getId();
                }finally {
                   long finish = System.currentTimeMillis();
                   long timeMs = finish - start;
                   System.out.println("Join = "+ timeMs+ "ms");
                }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                   throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public List<Member> findMembers(){
      return  memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
