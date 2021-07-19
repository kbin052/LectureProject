package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoy {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); // ipTional
    List<Member> findAll();

}
