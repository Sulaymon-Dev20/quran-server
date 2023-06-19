package com.suyo.quran.util;

public interface CronContent {
    String everyTen = "*/10 * * * * *";
    String everyMin = "* * * * * *";
    String everyMinWorkTime = "0 * 3-23 ? * *";
    String everyTenSecWorkTime = "*/10 * 3-23 * * *";
    String everyTenSec = "*/10 * * * * *";
    String everyDay = "43 * 1 * * *";
    String everyDayAtTwoClock = "45 * 2 * * *";
    String everyDayAtTwoClockAndNullMin = "0 * 2 * * *";
}
