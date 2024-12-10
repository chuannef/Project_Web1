package com.boot.novel.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

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
    private int chapterNumber; // Chapter number (e.g., 1, 2, 3)

    @Column(name = "title", nullable = false)
    private String title; // Chapter title

    @Lob
    @Column(name = "content")
    private String content; // Content of the chapter

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate; // Date when the chapter was published

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "novel_id", nullable = false)
    private Novel novel; // Reference to the parent novel
}
