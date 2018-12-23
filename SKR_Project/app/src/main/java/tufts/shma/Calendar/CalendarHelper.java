package tufts.shma.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarHelper {
    public String dateGet() {
        Date now = new Date();
        //get the time as format: Weekday, Month, day, year (Saturday, September 25, 2018)
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        return dateFormatter.format(now);
    }
    public int getYear(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }
    public int getMonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        return month;
    }
    public int getDay(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }
    public static int getHours(){
        Calendar cal = Calendar.getInstance();
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        return hours;
    }
    public int getMinutes(){
        Calendar cal = Calendar.getInstance();
        int minutes = cal.get(Calendar.MINUTE);
        return minutes;
    }
    public int getSeconds(){
        Calendar cal = Calendar.getInstance();
        int seconds = cal.get(Calendar.SECOND);
        return seconds;
    }
    public int getGapDays(int day1, int day2){
        return day2 - day1;

    }
    // day2-day1 <= 1
    public int getGapseconds(int day1, int hours1, int minutes1, int seconds1, int day2, int hours2, int minutes2, int seconds2){
        int gap_seconds;
        if(day1 == day2){
            gap_seconds = (hours2-hours1)*60*60 + (minutes2-minutes1)*60 + (seconds2-seconds1);
        }
        else{
            gap_seconds = (24-(hours1+1)+hours2)*60*60 + (60-(minutes1+1)+minutes2)*60+(60-(seconds1+1)+seconds2);
        }
        return gap_seconds;
    }
    // convert seconds to HH:MM:SS
    public String convertSeconds(int gap_seconds){
        Integer seconds = new Integer(gap_seconds % 60);
        Integer minutes = new Integer((gap_seconds % 3600) / 60);
        Integer hours = new Integer(gap_seconds/3600);
        String gap = hours.toString()+ "hours" + minutes.toString()+"minutes"+seconds.toString() + "seconds";        String gap = hours.toString()+ ":" + minutes.toString()+":"+seconds.toString();
        return gap;

    }
}
