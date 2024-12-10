package com.boot.novel.repository;

import com.boot.novel.models.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Novel, Long> {

}
