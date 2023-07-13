package com.suyo.quran.repository;

import com.suyo.quran.entities.MailData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MailCodeRepository extends JpaRepository<MailData, Long> {
    @Query(value = "select COALESCE((select true from mail_code where mail = :mail and code = :code and created_at + INTERVAL '10 min' > now() order by created_at desc limit 1), false)", nativeQuery = true)
    boolean existsByMailAndAndCodeAndCreatedAtIsLessThan(@Param("mail") String mail, @Param("code") String code);
}
