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
