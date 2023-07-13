package com.suyo.quran.repository;

import com.suyo.quran.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = "update users set password=:pass where id=:id returning *", nativeQuery = true)
    Optional<User> setUpPassword(@Param("id") Long id, @Param("pass") String password);

    @Query(value = "update users u set password=:newPass where id=(select u2.id from users u2 where u2.id = :id and u2.password=:oldPass) returning *", nativeQuery = true)
    Optional<User> changePassword(@Param("id") Long id, @Param("newPass") String newPassword, @Param("oldPass") String oldPassword);
}
