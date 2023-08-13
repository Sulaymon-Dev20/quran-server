package com.suyo.quran.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "quiz_options")
public class QuizOptions extends AbsNameEntity {
    @OneToOne(optional = false)
    @NotNull
    private Translation Option1;
    @OneToOne(optional = false)
    @NotNull
    private Translation Option2;
    @OneToOne(optional = false)
    @NotNull
    private Translation Option3;
    @OneToOne(optional = false)
    @NotNull
    private Translation Option4;
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private TrueAnswerEnum trueAnswer;
}
