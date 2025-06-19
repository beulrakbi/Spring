package example.studyspring.repository;

import example.studyspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//MemoryMemberRepository는 MemberRepository 인터페이스를 구현한 클래스
//실제 데이터베이스가 아닌, 메모리에 데이터를 저장하고 관리한다. (-> 강의에서 요구사항에 아직 db가 정해지지 않음)
public class MemoryMemberRepository implements MemberRepository{

    //static으로 선언된 store는 Member 데이터를 메모리에 저장하는 역할
    //key는 회원 Id, value는 member 객체
    private static Map<Long, Member> store = new HashMap<>();

    //sequence는 ID 생성을 위한 시퀀스
    //회원이 저장될 때마다 1씩 증가시켜 고유한 ID를 부여
    private static long sequence = 0L;

    /*
    * 회원 정보를 저장하는 메서드
    * 1.아이디를 sequence로 생성 (1씩 증가)
    * Map에 저장
    * 저장된 멤버 객체를 반환*/
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    /*
    * Id로 회원을 조회하는 메서드
    * Id가 존재하지 않을 경우 null이 될 수 있으므로 Optional로 감싸서 반환*/
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 있는 상황까지 고려해서
    }

    /*
    * 이름으로 회원을 조회하는 메서드
    * store의 모든 Member를 스트림으롤 순회하면서
    * 이름이 일치하는 회원을 찾아 Optional로 반환*/
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny(); //하나라도 찾으면 반환
    }

    //저장된 모든 회원 목록을 반환
    //store의 values()를 ArrayList로 반환하여 반환
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
