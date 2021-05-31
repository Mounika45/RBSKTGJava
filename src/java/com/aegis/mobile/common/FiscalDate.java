/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.common;

import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Baby
 */
public class FiscalDate {
    private static final int    FIRST_FISCAL_MONTH  = Calendar.MARCH;

    private Calendar            calendarDate;

    public FiscalDate(Calendar calendarDate) {
        this.calendarDate = calendarDate;
    }

    public FiscalDate(Date date) {
        this.calendarDate = Calendar.getInstance();
        this.calendarDate.setTime(date);
    }

    public int getFiscalMonth() {
        int month = calendarDate.get(Calendar.MONTH);
        int result = ((month - FIRST_FISCAL_MONTH - 1) % 12) + 1;
        if (result < 0) {
            result += 12;
        }
        return result;
    }

    public int getFiscalYear() {
        int month = calendarDate.get(Calendar.MONTH);
        int year = calendarDate.get(Calendar.YEAR);
        return (month >= FIRST_FISCAL_MONTH) ? year : year - 1;
    }

    public int getCalendarMonth() {
        return calendarDate.get(Calendar.MONTH);
    }

    public int getCalendarYear() {
        return calendarDate.get(Calendar.YEAR);
    }
    public static String displayFinancialDate(Calendar calendar) {
        FiscalDate fiscalDate = new FiscalDate(calendar);
        int year = fiscalDate.getFiscalYear();
        String newyear= (year + 1)+"";
        String finyear=year + "-" +newyear.substring(2);
        //System.out.println("Current Date : " + calendar.getTime().toString());
        System.out.println("Fiscal Years : " + finyear);
       // System.out.println("Fiscal Month : " + fiscalDate.getFiscalMonth());
        //System.out.println(" ");
        return finyear;
    }
}
