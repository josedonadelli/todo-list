package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {

    public static Date dateFormat(String date){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.parse(date);
        }
        catch(ParseException e){
            System.out.println("Exception :" + e);
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyNumberOfDays(String date){
        String[] dateSplit = date.split("-");
        int day = Integer.parseInt(dateSplit[0]);
        int year = Integer.parseInt(dateSplit[2]);
        boolean leapYear = (year % 4 == 0) && (year % 100 != 0);

        if(day<=0 || day>31){
            return false;
        }
        switch (dateSplit[1]) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                return true;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov": if(day <= 30){
                return true;
            }
            case "Feb": if(day <= 28 || (day == 29 && leapYear)){
                return true;
            }
            default: return false;
        }
    }

    public static Date outPutToInputFormat(String date){
        String dateHandler;

        if(date.equals("null") || date.isEmpty()){
            return null;
        }

        if(date.contains(" ")){
            String[] dateSplit = date.split(" ");
            dateHandler = (dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[5]);
        }else{
            return dateFormat(date);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            return sdf.parse(dateHandler);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            throw new RuntimeException(e);
        }

    }
}
