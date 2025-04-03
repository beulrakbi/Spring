package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Question {
    @Id
    //id속성을 기본키로 지정한다.
    //id 속성의 고유 번호들은 엔티티에서 각 데이터들을 구분하는 유효한 값으로, 중복되면 안 되기 때문이다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;

    @Column(length = 200)
    private String content;

    @Column(columnDefinition = "TEXT")
    private String conten;

    private LocalDateTime createDate;
}
