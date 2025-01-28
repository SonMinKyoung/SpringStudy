package study.mini01.repository;

import study.mini01.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    //동시성 문제를 고려하면, Map > ConcurrentHashMap / Long > AtomicLog 사용
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findbyId(Long id) {
        return Optional.ofNullable(store.get(id));
        //store(Map)에서 key(id)값을 이용해 가져온 후, null 유무 판단하여 optional로 감싼다.
    }

    @Override
    public Optional<Member> findbyName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
