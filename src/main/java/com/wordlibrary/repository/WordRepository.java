package com.wordlibrary.repository;

import com.wordlibrary.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT * FROM words WHERE set_id = :set_id", nativeQuery = true)
    List<Word> findByWordSetId(Long setId);

    @Query(value = "SELECT * FROM words WHERE set_id = :setId ORDER BY RANDOM()", nativeQuery = true)
    List<Word> findByWordSetIdOrderByRandom(@Param("setId") Long setId);

    @Query(value = "SELECT * FROM words WHERE set_id = :setId ORDER BY word ASC", nativeQuery = true)
    List<Word> findByWordSetIdOrderAlphabeticalAsc(@Param("setId") Long setId);

    @Query(value = "SELECT * FROM words WHERE set_id = :setId ORDER BY word DESC", nativeQuery = true)
    List<Word> findByWordSetIdOrderAlphabeticalDesc(@Param("setId") Long setId);
}
