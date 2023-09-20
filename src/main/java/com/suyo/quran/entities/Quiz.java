package com.suyo.quran.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "quiz")
public class Quiz extends AbsNameEntity {
    @OneToOne(optional = false)
    @NotNull
    private Translation question;

    @OneToOne(optional = false)
    @NotNull
    private QuizOptions options;
}
