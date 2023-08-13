package com.suyo.quran.repository;

import com.suyo.quran.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Query(value = "update users set password=:pass where id=:id and password IS NULL returning *", nativeQuery = true)
    Optional<User> setUpPassword(@Param("id") UUID id, @Param("pass") String password);

    @Query(value = "update users u set password=:newPass where id=(select u2.id from users u2 where u2.id =:id and u2.password=:oldPass) returning *", nativeQuery = true)
    Optional<User> changePassword(@Param("id") UUID id, @Param("newPass") String newPassword, @Param("oldPass") String oldPassword);

    @Query(value = "WITH updated_item AS (UPDATE users SET code =:code, first_name=:firstName, last_name=:lastName, authenticated_time = now(), updated_at = now() WHERE email =:email RETURNING *), inserted_item as (INSERT INTO users (code, email, first_name, last_name, created_at, updated_at, authenticated_time) SELECT :code, :email, :firstName, :lastName, now(), now(), now() WHERE NOT EXISTS(SELECT * FROM updated_item) returning *) select * from updated_item UNION ALL select * from inserted_item;", nativeQuery = true)
    User updateAuthCode(@Param("email") String emailAddress, @Param("code") String mailCode, @Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(value = "update users set authenticated = true where email=:email and code =:code and authenticated_time + INTERVAL '10 min' > now() returning *", nativeQuery = true)
    Optional<User> checkEmailCode(@Param("email") String email, @Param("code") String code);
}
