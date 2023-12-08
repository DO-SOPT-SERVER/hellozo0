package com.example.week3_hw.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post") //DB table에 mapping 된다
public class Post extends BaseTimeEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT") //왜 썼을까? 기본 VARCHAR로 저장되는데, TEXT로 저장된다 (아마 긴글 담을 수 있는 용도 일거임...)
    private String content;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY) //지연로딩 설정(member가 필요할때 불러오도록)
    @JoinColumn(name = "member_id")//DB에 FK로 저장되기 위해서 사용하는 어노테이션, name속성으로 DB에 어떤 이름으로 저장될지 지정
    private Member member; //memberId 이런게 아니라 내가 실제로 매핑할 객체를 적어줌

    // @ManyToOne 사용이 아닌 논리적으로 관계만 맺어둠.
    @Column(name = "category_id")
    private CategoryId categoryId;


    @Builder // 생성자에 Builder 붙여줌 그러면 필요한 파라미터만 받아서 객체를 만들 수도 있다.
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    @Builder(builderMethodName = "builderWithImageUrl") //option을 추가하여, 사용
    public Post(String title, String content, String imageUrl, Member member) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.member = member;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void addCategory(CategoryId categoryId) {
        this.categoryId = categoryId;
    }
}
