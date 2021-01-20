package samaco.idepardazan.phoneplus.Common;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import java.util.Calendar;

import samaco.idepardazan.phoneplus.Entities.EntityDateDiff;
import samaco.idepardazan.phoneplus.Entities.EntityDay;

public class DateUtility {

    public String GetCurrentMiladi()
    {
        String _Date="";
        String _Year="";
        String _Month="";
        String _Day="";

        Calendar calendar=Calendar.getInstance();

        int Year=calendar.get(Calendar.YEAR);
        int Month=calendar.get(Calendar.MONTH)+1;
        int Day=calendar.get(Calendar.DAY_OF_MONTH);

        _Year=Integer.toString(Year);
        _Month=Integer.toString(Month);
        _Day=Integer.toString(Day);

        if (_Month.length()==1) _Month="0"+_Month;
        if (_Day.length()==1) _Day="0"+_Day;

        _Date=_Year+_Month+_Day;



        return _Date;
    }

    public String GetCurrentMiladiWithSlash()
    {
        String _Date="";
        String _Year="";
        String _Month="";
        String _Day="";

        Calendar calendar=Calendar.getInstance();

        int Year=calendar.get(Calendar.YEAR);
        int Month=calendar.get(Calendar.MONTH)+1;
        int Day=calendar.get(Calendar.DAY_OF_MONTH);

        _Year=Integer.toString(Year);
        _Month=Integer.toString(Month);
        _Day=Integer.toString(Day);

        if (_Month.length()==1) _Month="0"+_Month;
        if (_Day.length()==1) _Day="0"+_Day;

        _Date=_Year+"/"+_Month+"/"+_Day;

        return _Date;
    }

    public String GetCurrentShamsiDate()
    {
        String Shamsi="";

        String PersianYear="";
        String PersianMonth="";
        String PersianDay="";

        Calendar calendar=Calendar.getInstance();

        int Year=calendar.get(Calendar.YEAR);
        int Month=calendar.get(Calendar.MONTH)+1;
        int Day=calendar.get(Calendar.DAY_OF_MONTH);

        Roozh jCal = new Roozh();

        jCal.GregorianToPersian(Year, Month, Day);

        Shamsi=jCal.toString();

        PersianYear=Shamsi.substring(0,4);
        PersianMonth=Shamsi.substring(5,7);
        PersianDay=Shamsi.substring(8,10);

        Shamsi=PersianYear+PersianMonth+PersianDay;

        return Shamsi;
    }

    public String GetShamsiToMiladiDate(String ShamsiDate)
    {
        String _Date="";

        String PersianYear="";
        String PersianMonth="";
        String PersianDay="";

        String MiladiYear="";
        String MiladiMonth="";
        String MiladiDay="";

        PersianYear=ShamsiDate.substring(0,4);
        PersianMonth=ShamsiDate.substring(4,6);
        PersianDay=ShamsiDate.substring(6,8);

        int Year=Integer.parseInt(PersianYear);
        int Month=Integer.parseInt(PersianMonth);
        int Day=Integer.parseInt(PersianDay);

        Roozh jCal = new Roozh();

        jCal.PersianToGregorian(Year,Month,Day);

        _Date=jCal.toString();




        MiladiYear=_Date.substring(0,4);
        MiladiMonth=_Date.substring(5,7);
        MiladiDay=_Date.substring(8,10);

        _Date=MiladiYear+MiladiMonth+MiladiDay;

        //_Date="19801010";

        return _Date;

    }

    public String GetCurrentShamsiDateWithSlash()
    {
        String Shamsi="";

        String PersianYear="";
        String PersianMonth="";
        String PersianDay="";

        Calendar calendar=Calendar.getInstance();

        int Year=calendar.get(Calendar.YEAR);
        int Month=calendar.get(Calendar.MONTH)+1;
        int Day=calendar.get(Calendar.DAY_OF_MONTH);

        Roozh jCal = new Roozh();

        jCal.GregorianToPersian(Year,Month,Day);

        Shamsi=jCal.toString();

        PersianYear=Shamsi.substring(0,4);
        PersianMonth=Shamsi.substring(5,7);
        PersianDay=Shamsi.substring(8,10);

        Shamsi=PersianYear+"/"+PersianMonth+"/"+PersianDay;

        return Shamsi;
    }

    public EntityDay DateDifferenceDays(String Date1,String Date2)
    {
        EntityDay Itm=new EntityDay();
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        int Date1_Year=Integer.parseInt(Date1.substring(0,4));
        int Date1_Month=Integer.parseInt(Date1.substring(4,6));
        int Date1_Day=Integer.parseInt(Date1.substring(4,6));

        int Date2_Year=Integer.parseInt(Date2.substring(0,4));
        int Date2_Month=Integer.parseInt(Date2.substring(4,6));
        int Date2_Day=Integer.parseInt(Date2.substring(4,6));

        cal1.set(Date1_Year, Date1_Month, Date1_Day);
        cal2.set(Date2_Year, Date2_Month, Date2_Day);

        // Get the represented date in milliseconds
        long millis1 = cal1.getTimeInMillis();
        long millis2 = cal2.getTimeInMillis();

        // Calculate difference in milliseconds
        long diff = millis2 - millis1;

        // Calculate difference in seconds
        long diffSeconds = diff / 1000;

        // Calculate difference in minutes
        long diffMinutes = diff / (60 * 1000);

        // Calculate difference in hours
        long diffHours = diff / (60 * 60 * 1000);

        // Calculate difference in days
        long diffDays = diff / (24 * 60 * 60 * 1000);


        Itm.setDays(Long.toString(diffDays));
        Itm.setHours(Long.toString(diffHours));
        Itm.setMinutes(Long.toString(diffMinutes));


        return Itm;
    }

    public EntityDateDiff DateDiff(String MiladiDate1,String MiladiDate2)
    {
        EntityDateDiff Itm=new EntityDateDiff();

        //DateTime dateTimeFrom = new DateTime("1982-09-30");
        //DateTime dateTimeTo = new DateTime("2017-12-24");

        String _Date1=(MiladiDate1.substring(0,4)+"-"+MiladiDate1.substring(4,6)+"-"+MiladiDate1.substring(6,8));
        String _Date2=(MiladiDate2.substring(0,4)+"-"+MiladiDate2.substring(4,6)+"-"+MiladiDate2.substring(6,8));

        _Date1=ArabicToDecimal(_Date1);
        _Date2=ArabicToDecimal(_Date2);

        DateTime dateTimeFrom = new DateTime(_Date1);
        DateTime dateTimeTo = new DateTime(_Date2);

        Period period = new Period(dateTimeFrom,dateTimeTo, PeriodType.yearMonthDay());




        Itm.setDay(Integer.toString(period.getDays()));
        Itm.setMonth(Integer.toString(period.getMonths()));
        Itm.setYear(Integer.toString(period.getYears()));


        return Itm;
    }

    public String GetDayOfWeek(String _Date)
    {
        String Ret="";
        _Date=(_Date.substring(0,4)+"-"+_Date.substring(4,6)+"-"+_Date.substring(6,8));

        _Date=ArabicToDecimal(_Date);
        DateTime dateTimeFrom = new DateTime(_Date);
        int day=dateTimeFrom.getDayOfWeek()+1;

        switch (day) {
            case Calendar.SUNDAY:
                Ret="یکشنبه";
                break;
            case Calendar.MONDAY:
                Ret="دوشنبه";
                break;
            case Calendar.TUESDAY:
                Ret="سه شنبه";
                break;
            case Calendar.WEDNESDAY:
                Ret="چهارشنبه";
                break;
            case Calendar.THURSDAY:
                Ret="پنجشنبه";
                break;
            case Calendar.FRIDAY:
                Ret="جمعه";
                break;
            case Calendar.SATURDAY:
                Ret="شنبه";
                break;
        }

        return Ret;
    }

    public String ArabicToDecimal(String number) {
        char[] chars = new char[number.length()];
        for(int i=0;i<number.length();i++) {
            char ch = number.charAt(i);
            if (ch >= 0x0660 && ch <= 0x0669)
                ch -= 0x0660 - '0';
            else if (ch >= 0x06f0 && ch <= 0x06F9)
                ch -= 0x06f0 - '0';
            chars[i] = ch;
        }
        return new String(chars);
    }

    public String GetShamsiDateWithMonthString(String ShamsiDate) {

        String _Date = "";
        String _MonthName = "";

        String _Year = "";
        String _Month = "";
        String _Day = "";

        _Year = ShamsiDate.substring(0, 4);
        _Month = ShamsiDate.substring(4, 6);
        _Day = ShamsiDate.substring(6, 8);

        _Month=ArabicToDecimal(_Month);

        switch (_Month)
        {
            case "01":
                _MonthName="فروردین";
                break;
            case "02":
                _MonthName="اردیبهشت";
                break;
            case "03":
                _MonthName="خرداد";
                break;
            case "04":
                _MonthName="تیر";
                break;
            case "05":
                _MonthName="مرداد";
                break;
            case "06":
                _MonthName="شهریور";
                break;
            case "07":
                _MonthName="مهر";
                break;
            case "08":
                _MonthName="آبان";
                break;
            case "09":
                _MonthName="آذر";
                break;
            case "10":
                _MonthName="دی";
                break;
            case "11":
                _MonthName="بهمن";
                break;
            case "12":
                _MonthName="اسفند";
                break;
        }//switch (_Month)

        _Date=_Day+" "+_MonthName+" "+_Year;

        return _Date;
    }

    public String GetMiladiDateWithMonthString(String MiladiDate) {

        String _Date = "";
        String _MonthName = "";

        String _Year = "";
        String _Month = "";
        String _Day = "";

        _Year = MiladiDate.substring(0, 4);
        _Month = MiladiDate.substring(4, 6);
        _Day = MiladiDate.substring(6, 8);

        _Month=ArabicToDecimal(_Month);

        switch (_Month)
        {
            case "01":
                _MonthName="ژانویه";
                break;
            case "02":
                _MonthName="فوریه";
                break;
            case "03":
                _MonthName="مارس";
                break;
            case "04":
                _MonthName="آوریل";
                break;
            case "05":
                _MonthName="مه";
                break;
            case "06":
                _MonthName="ژوئن";
                break;
            case "07":
                _MonthName="ژوئیه";
                break;
            case "08":
                _MonthName="اوت";
                break;
            case "09":
                _MonthName="سپتامبر";
                break;
            case "10":
                _MonthName="اکتبر";
                break;
            case "11":
                _MonthName="نوامبر";
                break;
            case "12":
                _MonthName="دسامبر";
                break;
        }//switch (_Month)

        _Date=_Day+" "+_MonthName+" "+_Year;

        return _Date;
    }

    public EntityDateDiff DateDiffMod(String ShamsiDate1,String ShamsiDate2)
    {
        EntityDateDiff Itm=new EntityDateDiff();

        Itm.setDay("0");
        Itm.setMonth("0");
        Itm.setYear("0");

        String _Year = "";
        String _Month = "";
        String _Day = "";

        _Year = ShamsiDate1.substring(0, 4);
        _Month = ShamsiDate1.substring(4, 6);
        _Day = ShamsiDate1.substring(6, 8);

        int Year1=Integer.parseInt(_Year);
        int Month1=Integer.parseInt(_Month);
        int Day1=Integer.parseInt(_Day);

        _Year = ShamsiDate2.substring(0, 4);
        _Month = ShamsiDate2.substring(4, 6);
        _Day = ShamsiDate2.substring(6, 8);

        int Year2=Integer.parseInt(_Year);
        int Month2=Integer.parseInt(_Month);
        int Day2=Integer.parseInt(_Day);

        Year1=Year2;
        String NewDate1,NewDay1,NewMonth1,NewDate2;

        if (Month2>Month1)
        {
            Year1=Year1+1;

            if(Integer.toString(Day1).length()==1)
                NewDay1="0"+Integer.toString(Day1);
            else
                NewDay1=Integer.toString(Day1);

            if(Integer.toString(Month1).length()==1)
                NewMonth1="0"+Integer.toString(Month1);
            else
                NewMonth1=Integer.toString(Month1);

            NewDate1=Integer.toString(Year1)+NewMonth1+NewDay1;
            NewDate1=GetShamsiToMiladiDate(NewDate1);
            NewDate2=GetShamsiToMiladiDate(ShamsiDate2);

            Itm=DateDiff(NewDate2,NewDate1);
        }
        else if (Month2<Month1)
        {
            if(Integer.toString(Day1).length()==1)
                NewDay1="0"+Integer.toString(Day1);
            else
                NewDay1=Integer.toString(Day1);

            if(Integer.toString(Month1).length()==1)
                NewMonth1="0"+Integer.toString(Month1);
            else
                NewMonth1=Integer.toString(Month1);

            NewDate1=Integer.toString(Year1)+NewMonth1+NewDay1;
            NewDate1=GetShamsiToMiladiDate(NewDate1);
            NewDate2=GetShamsiToMiladiDate(ShamsiDate2);

            Itm=DateDiff(NewDate2,NewDate1);
        }
        else if (Month2==Month1 && Day2>Day1)
        {
            Year1=Year1+1;

            if(Integer.toString(Day1).length()==1)
                NewDay1="0"+Integer.toString(Day1);
            else
                NewDay1=Integer.toString(Day1);

            if(Integer.toString(Month1).length()==1)
                NewMonth1="0"+Integer.toString(Month1);
            else
                NewMonth1=Integer.toString(Month1);

            NewDate1=Integer.toString(Year1)+NewMonth1+NewDay1;
            NewDate1=GetShamsiToMiladiDate(NewDate1);
            NewDate2=GetShamsiToMiladiDate(ShamsiDate2);

            Itm=DateDiff(NewDate2,NewDate1);

        }
        else if (Month2==Month1 && Day2<Day1)
        {
            if(Integer.toString(Day1).length()==1)
                NewDay1="0"+Integer.toString(Day1);
            else
                NewDay1=Integer.toString(Day1);

            if(Integer.toString(Month1).length()==1)
                NewMonth1="0"+Integer.toString(Month1);
            else
                NewMonth1=Integer.toString(Month1);

            NewDate1=Integer.toString(Year1)+NewMonth1+NewDay1;
            NewDate1=GetShamsiToMiladiDate(NewDate1);
            NewDate2=GetShamsiToMiladiDate(ShamsiDate2);

            Itm=DateDiff(NewDate2,NewDate1);

        }



        return Itm;

    }

    public String AddDays(String MiladiDate,int Days)
    {
        String Ret="";
        String PersianYear="";
        String PersianMonth="";
        String PersianDay="";

        String _Date=(MiladiDate.substring(0,4)+"-"+MiladiDate.substring(4,6)+"-"+MiladiDate.substring(6,8));
        _Date=ArabicToDecimal(_Date);

        DateTime dateTime = new DateTime(_Date);
        dateTime = dateTime.plusDays(Days);

        int Year=dateTime.getYear();
        int Month=dateTime.getMonthOfYear();
        int Day=dateTime.getDayOfMonth();

        Roozh jCal = new Roozh();

        jCal.GregorianToPersian(Year, Month, Day);

        Ret=jCal.toString();

        PersianYear=Ret.substring(0,4);
        PersianMonth=Ret.substring(5,7);
        PersianDay=Ret.substring(8,10);

        Ret=PersianYear+PersianMonth+PersianDay;

        return  Ret;

    }




}
