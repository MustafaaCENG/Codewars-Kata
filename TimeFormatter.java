package KatasSolution;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TimeFormatter {
    public static final int yilSn = 31536000;
    public static final int daySn = 86400;
    public static final int hourSn = 3600;
    public static final int minuteSn = 60;
    public static int year = 0;
    public static int day = 0;
    public static int hour = 0;
    public static int minute = 0;
    public static int sec = 0;


    public static String formatDuration(int seconds) {
        if (seconds == 0)
            return "now";
        int sec = seconds % 60;
        int minute = ((seconds - sec) / 60) % 60;
        int hour = ((seconds - minute * 60 - sec) / 3600) % 24;
        int day = ((seconds - hour * 3600 - minute * 60 - sec) / (24 * 3600)) % 365;
        int year = ((seconds - day * 24 * 3600 - hour * 3600 - minute * 60 - sec) / (365 * 24 * 3600));

        LinkedHashMap<String, Integer> mapS = new LinkedHashMap<>();
        mapS.put("year", year);
        mapS.put("day", day);
        mapS.put("hour", hour);
        mapS.put("minute", minute);
        mapS.put("second", sec);
        List<String> format = new ArrayList<>();
        for (String ekle : mapS.keySet())
            if (mapS.get(ekle) != 0) {
                if (mapS.get(ekle) == 1)
                    format.add(String.format("%d %s", mapS.get(ekle), ekle));
                else
                    format.add(String.format("%d %ss", mapS.get(ekle), ekle));
            }
        StringBuilder buildAnswer = new StringBuilder();
        for (int i = 0; i < format.size(); i++) {
            buildAnswer.append(format.get(i));
            if (i < format.size() - 1) {
                if (i == format.size() - 2) {
                    buildAnswer.append(" and ");
                    continue;
                }
                buildAnswer.append(", ");
            }
        }
        return buildAnswer.toString();
    }
}
