package com.suyo.quran.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity(name = "mail_code")
@Table(indexes = {@Index(name = "index_mail",  columnList="email")})
public class MailData extends AbsNameEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false, length = 6)
    private String code;

    public MailData(String mail) {
        this.email = mail;
        final int max = 999999;
        final int min = 100000;
        this.code = String.valueOf(new Random().nextInt(max + 1 - min) + min);
    }

    public String getCode() {
        return code.substring(0, 3) + " " + code.substring(3);
    }
}
