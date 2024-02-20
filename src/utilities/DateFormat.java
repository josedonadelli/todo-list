package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static Date dateFormat(String date){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.parse(date);
        }
        catch(ParseException e){
            System.out.println("Exception :" + e);
            return new Date();
        }
    }

    public static boolean verifyNumberOfDays(String date){
        String[] dateSplit = date.split("-");
        int day = Integer.parseInt(dateSplit[0]);

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
            case "Nov": if(day<=30){
                return true;
            }
            case "Feb": if(day<=29){
                return true;
            }
            default: return false;
        }
    }
}
