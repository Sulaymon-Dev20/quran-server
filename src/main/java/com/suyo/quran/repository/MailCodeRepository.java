package com.suyo.quran.repository;

import com.suyo.quran.models.MailData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MailCodeRepository extends JpaRepository<MailData, Long> {
    @Query("select ")
    boolean existsByMailAndAndCodeAndCreatedAtIsLessThan();
}
