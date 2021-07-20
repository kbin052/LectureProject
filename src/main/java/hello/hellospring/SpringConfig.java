package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

   private DataSource dataSource;

   @Autowired
   public SpringConfig(DataSource dataSource){
       this.dataSource = dataSource;
   }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepositoy());
    }

    @Bean
    public MemberRepository memberRepositoy() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
//자바코드로 스프링 빈 등록
