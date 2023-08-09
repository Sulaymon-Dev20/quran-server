package com.suyo.quran.util;

public class SwaggerDoc {
    //   auth docs
    public static final String authTag = "auth controller";
    public static final String authTagDescription = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

    public static final String authPostRegister = "View a list of available products";
    public static final String authPostRegisterDescription = authTagDescription;
    public static final String authPostRegister200 = "model ``` asdf asdf``` <br/>";
    public static final String authPostRegister400 = "model ``` asdf asdf``` <br/>";

    public static final String authPostCheckCode = "View a list of available products";
    public static final String authPostCheckCodeDescription = authTagDescription;
    public static final String authPostCheckCode200 = authPostRegister200;
    public static final String authPostCheckCode400 = authPostRegister400;

    public static final String authPostLogin = "View a list of available products";
    public static final String authPostLoginDescription = authTagDescription;
    public static final String authPostLogin200 = authPostRegister200;
    public static final String authPostLogin400 = authPostRegister400;

    //    user docs
    public static final String userTag = "user controller";
    public static final String userTagDescription = "Operations ```asdf``` pertaining to manager blood donors in the application";

    public static final String userGet = "View a list of available products";
    public static final String userGetDescription = "Lorem ```Ipsum``` is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
    public static final String userGet200 = authPostRegister200;
    public static final String userGet400 = authPostRegister400;

    public static final String userPostPassword = userGet;
    public static final String userPostPasswordDescription = userGetDescription;
    public static final String userPostPassword200 = authPostRegister200;
    public static final String userPostPassword400 = authPostRegister400;

    public static final String userPostRefreshToken = userGet;
    public static final String userPostRefreshTokenDescription = userGetDescription;
    public static final String userPostRefreshToken200 = authPostRegister200;
    public static final String userPostRefreshToken400 = authPostRegister400;

    //    chapter docs
    public static final String chapterTag = "chapter controller";
    public static final String chapterTagDescription = userTagDescription;

    public static final String chapterGet = userGet;
    public static final String chapterGetDescription = userGetDescription;
    public static final String chapterGet200 = authPostRegister200;
    public static final String chapterGet400 = authPostRegister400;

    //    juz docs
    public static final String juzTag = "juz controller";
    public static final String juzTagDescription = userTagDescription;

    public static final String juzGet = userGet;
    public static final String juzGetDescription = userGetDescription;
    public static final String juzGet200 = authPostRegister200;
    public static final String juzGet400 = authPostRegister400;

    //    chapter docs
    public static final String versesTag = "verses controller";
    public static final String versesTagDescription = userTagDescription;

    public static final String versesGetAllChapter = userGet;
    public static final String versesGetAllChapterDescription = userGetDescription;
    public static final String versesGetAllChapter200 = authPostRegister200;
    public static final String versesGetAllChapter400 = authPostRegister400;

    public static final String versesGetChapter = userGet;
    public static final String versesGetChapterDescription = userGetDescription;
    public static final String versesGetChapterNumberParameter = userGetDescription;
    public static final String versesGetChapter200 = authPostRegister200;
    public static final String versesGetChapter400 = authPostRegister400;

    //    Unique params
    public static final String languageParameter = userGetDescription;
}
