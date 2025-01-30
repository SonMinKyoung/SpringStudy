package study.mini01.repository;

import study.mini01.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //Optional: 검색 시 null도 나올 수 있다. 그걸 감싸주는 역할을 한다.
    Optional<Member> findbyId(Long id);

    Optional<Member> findbyName(String name);

    Optional<Member> findById(Long id);

    List<Member> findAll();


    Optional<Member> findByName(String name);
}
