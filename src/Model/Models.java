/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author LIVIANA FEBRIYANTI
 */
public class Models {
    private String getTanggal(){
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String thisDay = dateFormat.format(date);
        return thisDay;
    }
    private String getBulan(){
        DateFormat dateFormat = new SimpleDateFormat("MMMM");
        Date date = new Date();
        String thisDay = dateFormat.format(date);
        if (thisDay.equals("January")) {
            thisDay = "Januari";
        }else if(thisDay.equals("February")){
            thisDay = "Februari";
        }else if(thisDay.equals("March")){
            thisDay = "Maret";
        }else if(thisDay.equals("April")){
            thisDay = "April";
        }else if(thisDay.equals("May")){
            thisDay = "Mei";
        }else if(thisDay.equals("June")){
            thisDay = "Juni";
        }else if(thisDay.equals("July")){
            thisDay = "Juli";
        }else if(thisDay.equals("August")){
            thisDay = "Agustus";
        }else if(thisDay.equals("September")){
            thisDay = "September";
        }else if(thisDay.equals("October")){
            thisDay = "Oktober";
        }else if(thisDay.equals("November")){
            thisDay = "November";
        }else if(thisDay.equals("Desember")){
            thisDay = "Desember";
        }
        return thisDay;
    }
    private String getTahun(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String thisDay = dateFormat.format(date);
        return thisDay;
    }
    public String getToday(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String thisDay = dateFormat.format(date);
        String today = dayName(thisDay,"dd/MM/yyyy");
        String HariIni = "Senin";
        if(today.equals("Monday")){
            HariIni = "Senin";
        }else if(today.equals("Tuesday")){
            HariIni = "Selasa";
        }else if(today.equals("Wednesday")){
            HariIni = "Rabu";
        }else if(today.equals("Thursday")){
            HariIni = "Kamis";
        }else if(today.equals("Friday")){
            HariIni = "Jumat";
        }else if(today.equals("Saturday")){
            HariIni = "Sabtu";
        }else if(today.equals("Sunday")){
            HariIni = "Minggu";
        }
        String TanggalSekarang = "Jakarta,"+HariIni+","+getTanggal()+"-"+getBulan()+"-"+getTahun();
        return TanggalSekarang;
    }
    public static String dayName(String inputDate, String format){
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(inputDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }
}
