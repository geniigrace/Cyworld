package com.cyoworld.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="diary")
@Getter
@Setter
@ToString
public class Diary extends BaseTimeEntity{

    @Id
    @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @Column(name = "diary_emoji", nullable = false)
    private String diaryEmoji;

    @Lob
    @Column(name = "diary_content", nullable = false)
    private String diaryContent;

}
