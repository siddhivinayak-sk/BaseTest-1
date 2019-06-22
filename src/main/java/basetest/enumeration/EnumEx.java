/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.enumeration;

import java.util.Date;

/**
 *
 * @author sandeep.kumar
 */
public class EnumEx {
    public static void main(String...args) {
        Day today = Day.FRIDAY;
        //Day t1 = Day.valueOf("sunday");
        Day t2 = Day.valueOf("SUNDAY");
        System.out.println(t2.getDayValue());
        t2.setDayValue(100);
        System.out.println(t2.getDayValue());
        System.out.println(Day.SUNDAY.getDayValue());
        
        Day.SUNDAY.setDayValue(101);
        System.out.println(t2.getDayValue());
        
        for(Day temp:Day.values()) {
            System.out.println(temp);
        }
        
        System.out.println(Day.SUNDAY == Day.SUNDAY);
        System.out.println(new Object() == Day.SUNDAY);
        System.out.println(Day.SUNDAY instanceof Day);
        System.out.println(Day.SUNDAY instanceof Enum);
        System.out.println(Day.SUNDAY instanceof Object);
        
        System.out.println(d);
        System.out.println(d.SUNDAY);
        System.out.println(d.SUNDAY.MONDAY);
        Day.SUNDAY.setBoxed("A");
        System.out.println(d.SUNDAY.getBoxed());
    }
    static Day d;
}

enum Day {
    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY;
    
    private int dayValue;
    private String boxed;
    private Boolean isRed;
    private Date startDate;

    private Day() {
        this.dayValue = -1;
    }
    
    Day(int dayValue) {
        this.dayValue = dayValue;
    }

    public int getDayValue() {
        return dayValue;
    }

    public void setDayValue(int dayValue) {
        this.dayValue = dayValue;
    }

    public String getBoxed() {
        return boxed;
    }

    public void setBoxed(String boxed) {
        this.boxed = boxed;
    }

    public Boolean getIsRed() {
        return isRed;
    }

    public void setIsRed(Boolean isRed) {
        this.isRed = isRed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
