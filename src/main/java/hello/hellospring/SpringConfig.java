package hello.hellospring;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

  private EntityManager em;

  @Autowired
  public  SpringConfig(EntityManager em){
      this.em =em;
  }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepositoy());
    }

    @Bean
    public MemberRepository memberRepositoy() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
   }
}
//자바코드로 스프링 빈 등록
