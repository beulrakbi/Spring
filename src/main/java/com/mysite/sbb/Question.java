package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id //@Id : id속성을 기본키로 지정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue  :  1씩 자동으로 증가 기본키는 중복되면 안 되기 때문에
    private Integer id;

    //Column : 엔티티의 속성은 테이블의 열 이름과 일치한다. 세부 설정을 위해 어노테이션을 사용 (필드 이름과 다를 때 연결하는 역할도 함)
    @Column(length = 200) //length : 길이를 설정
    private String subject;

    @Column(columnDefinition = "TEXT") //columnDefinition : 열 데이터의 유형이나 성격을 정의할 때 사용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //mappedBy : 참조 엔티티의 속성명을 정의 //cascade Type.REMOVE : 질문을 삭제하면 그에 달린 댓글도 삭제
    private List<Answer> answerList;
}
