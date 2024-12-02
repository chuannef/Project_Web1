package com.boot.novel.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Chapter", schema = "novel")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "chapter_number", nullable = false)
    private int chapterNumber; // Số chương

    @Lob
    @Column(name = "content", nullable = false)
    private String content; // Nội dung chương

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id", nullable = false)
    private Novel novel; // Liên kết tới tiểu thuyết

    @Column(name = "title")
    private String title; // Tiêu đề chương (tùy chọn)
}
