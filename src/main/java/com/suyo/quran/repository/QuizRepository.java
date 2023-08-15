package com.suyo.quran.repository;

import com.suyo.quran.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {

    @Query(value = "select * from quiz offset :size * :page limit :size", nativeQuery = true)
    List<Quiz> findAllByPageable(@Param("page") Integer pageNumber, @Param("size") Integer sizeNumber);
}
