package com.suyo.quran.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "mail_code")
public class MailData extends AbsNameEntity {
    private String mail;
    @Column(length = 6)
    private String code;

    public MailData(String mail) {
        this.mail = mail;
        final int max = 999999;
        final int min = 100000;
        this.code = String.valueOf(new Random().nextInt(max + 1 - min) + min);
    }

    public String getCode() {
        return code.substring(0, 3) + " " + code.substring(3);
    }
}
