/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.JulianFields;
import java.util.regex.Pattern;

/**
 *
 * @author sandeep.kumar
 */
public class DateTimeAPIEx {
    public static void main(String...args) {
        LocalDate ld1 = LocalDate.now();
        LocalTime lt1 = LocalTime.now();
        LocalDateTime ldt1 = LocalDateTime.now();
        
        int y1 = ldt1.getYear();
        Month m1 = ldt1.getMonth();
        int d1 = ldt1.getDayOfMonth();
        int h1 = ldt1.getHour();
        int mi1 = ldt1.getMinute();
        int s1 = ldt1.getSecond();
        int n1 = ldt1.getNano();
        
        LocalDateTime ldt2 = ldt1.withDayOfYear(11).withMonth(1).withDayOfMonth(1).withHour(12).withMinute(59).withSecond(59).withNano(999);
        LocalDateTime ldt3 = ldt2.plusWeeks(3).minusMinutes(1);

        //With to Set value
        LocalDateTime ldt4 = ldt3.with(ChronoField.YEAR, 1);
        LocalDateTime ldt5 = ldt3.with(IsoFields.QUARTER_OF_YEAR, 1);
        //LocalDateTime ldt6 = ldt3.with(WeekFields.SUNDAY_START, 1);
        LocalDateTime ldt7 = ldt3.with(JulianFields.RATA_DIE, 10);
        //Minus to subtract values
        LocalDateTime ldt8 = ldt3.minus(10, ChronoUnit.DAYS);
        //Plus to add values
        LocalDateTime ldt9 = ldt3.plus(10, ChronoUnit.DAYS);
        //Truncate the time/date to specified field to get precision values
        LocalDateTime ldt10 = ldt3.truncatedTo(ChronoUnit.HOURS);
        
        String fdt1 = ldt10.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(fdt1);
        LocalDateTime ldt14 = LocalDateTime.parse("12/11/2001 14:11", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(ldt14.getYear() + "-" + ldt14.get(ChronoField.MONTH_OF_YEAR) + "-" + ldt14.getDayOfMonth());
                
        
        ZoneId zi1 = ZoneId.of("GMT+4");
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, zi1);
        
        ZoneOffset zo1 = ZoneOffset.of("+5");
        OffsetDateTime odt1 = OffsetDateTime.of(ldt1, zo1);
        OffsetDateTime odt2 = odt1.withOffsetSameInstant(ZoneOffset.of("-1"));
        OffsetDateTime odt3 = odt1.withOffsetSameLocal(ZoneOffset.of("-1"));
        
        //A Period represents a timeframe on timeline (e.g. 1 year, 4 months and 8 days)
        Period p1 = Period.of(1, 4, 8);
        LocalDateTime ldt11 = ldt1.plus(p1);
        LocalDateTime ldt12 = ldt1.minus(p1);

        //A Duration is same as Period but measure unit is time instead of date
        Duration du1 = Duration.ofSeconds(5, 10);
        LocalDateTime ldt13 = ldt1.minus(du1);
        
        
        //Instant represents linux epoch time from 1 January 1970 (same as java.util.Date)
        Instant i1 = Instant.now();
        LocalDateTime ldt15 =  LocalDateTime.ofInstant(i1, ZoneId.systemDefault());
        Instant l2 = ldt15.toInstant(ZoneOffset.UTC);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        String password = "aSdffcd-";
        String errorMessage = "";
        boolean isPasswordCorrect = true;
        if(null != password && !password.isEmpty()) {
            if(isPasswordCorrect && password.length() < 8) {
                errorMessage = "Password must be 8 digit";
                isPasswordCorrect = false;
            }
            if(isPasswordCorrect && false == password.matches("(.*)[A-Z](.*)")) {
                errorMessage = "Password must have capial letter";
                isPasswordCorrect = false;
            }
            if(isPasswordCorrect && false == password.matches("(.*)[a-z](.*)")) {
                errorMessage = "Password must have small letter";
                isPasswordCorrect = false;
            }
            String[] specialCharList = {"`", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "="};
            boolean isContainsSpecialChar = false;
            for(String str:specialCharList) {
                if(password.contains(str)) {
                    isContainsSpecialChar = true;
                    break;
                }
            }
            if(isPasswordCorrect && false == isContainsSpecialChar) {
                errorMessage = "Password must have special character";
                isPasswordCorrect = false;
            }
            if(isPasswordCorrect && true == Pattern.compile("([a-z\\d])\\1\\1").matcher(password).find()) {
                errorMessage = "Password must not have same consicutive 3 character";
                isPasswordCorrect = false;
            }
        }
        else {
            errorMessage = "Empty Passowrd";
            isPasswordCorrect = false;
        }
        System.out.println(errorMessage);
        
        
        
        
        
        
        
        
        
        
    }
}
