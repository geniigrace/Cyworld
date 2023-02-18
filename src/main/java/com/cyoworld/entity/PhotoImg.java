package com.cyoworld.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "photoImg")
public class PhotoImg extends BaseTimeEntity{
    @Id
    @Column(name="imgId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="titleName")
    private String title;

    @Column(name="category")
    private String category;

    @Column(name="detail")
    private String detail;

    private String imgName; //이미지 파일명

    private String oriImgName; //원본 이미지 파일명

    private String imgUrl; //이미지 조회 경로

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_userId")
//    private Member member;

    public void updatePhotoImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
