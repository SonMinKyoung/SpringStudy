package study.mini02.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberid);
}
