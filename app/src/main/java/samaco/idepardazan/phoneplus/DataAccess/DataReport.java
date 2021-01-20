package samaco.idepardazan.phoneplus.DataAccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.DateUtility;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntityDateDiff;
import samaco.idepardazan.phoneplus.Entities.EntityDay;
import samaco.idepardazan.phoneplus.Entities.EntityReport;


public class DataReport {

    private static String DB_NAME= ClassHelper.getDataBase_Name();
    private SQLiteDatabase database;

    DateUtility dateUtility=new DateUtility();

    public ArrayList<EntityReport> DataReport_Tavalod(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        ArrayList<EntityReport> List=new ArrayList<>();
        EntityReport Itm;
        String DateDiff="";
        String DateDiffMod="";
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,lname,phone1,birthdate,nesbat,name "+
                " from vw_tavalod_report where (birthdate<>'') and (lname like '%"
                +Data+"%' or phone1 like '%"+Data+"%') and (substr(birthdate,5,2)='"+Month+"' or '"
                +Month+"'='') and ((birthdate>='"+_CurrentDate
                +"' and birthdate<='"+_NextDate+"') or '"+_NextDate+"'='') order by birthdate ",null);

        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                Itm = new EntityReport();

                Itm.setId(cursor.getString(0));
                Itm.setName(cursor.getString(1));
                Itm.setMobile(cursor.getString(2));

                Itm.set_Date(cursor.getString(3));
                Itm.set_DateWithSlash(GetDateWithSlash(cursor.getString(3)));
                Itm.set_DateWithMonthWord(dateUtility.GetShamsiDateWithMonthString(cursor.getString(3)));

                String MyDate=cursor.getString(3);
                String MyMiladiDate=dateUtility.GetShamsiToMiladiDate(MyDate);

                Itm.set_DateMiladi(MyMiladiDate);
                Itm.set_DateMiladiWithSlash(GetDateWithSlash(MyMiladiDate));
                Itm.set_DateMiladiWithMonthWord(dateUtility.GetMiladiDateWithMonthString(MyMiladiDate));

                Itm.set_DateDayName(dateUtility.GetDayOfWeek(MyMiladiDate));

                String CurrentMiladiDate=dateUtility.GetCurrentMiladi();
                String CurrentShamsiDate=dateUtility.GetCurrentShamsiDate();

                EntityDateDiff ItmDiff=dateUtility.DateDiff(MyMiladiDate,CurrentMiladiDate);
                DateDiff="";

                if (!ItmDiff.getYear().equals("0"))
                    DateDiff=ItmDiff.getYear()+" سال";

                if (!ItmDiff.getMonth().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getMonth()+" ماه";
                    else
                       DateDiff=DateDiff+" و "+ItmDiff.getMonth()+" ماه";

                if (!ItmDiff.getDay().equals("0"))
                    if (DateDiff.equals(""))
                          DateDiff=ItmDiff.getDay()+" روز ";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getDay()+" روز ";

                Itm.set_DateDiff(DateDiff);

                EntityDateDiff ItmDiffMod=dateUtility.DateDiffMod(cursor.getString(3), CurrentShamsiDate);
                DateDiffMod="";

                if (!ItmDiffMod.getYear().equals("0"))
                    DateDiffMod=ItmDiffMod.getYear()+" سال";

                if (!ItmDiffMod.getMonth().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getMonth()+" ماه";
                     else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getMonth()+" ماه";

                if (!ItmDiffMod.getDay().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getDay()+" روز ";
                     else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getDay()+" روز ";

                Itm.set_DateDiffMandeh(DateDiffMod);

                EntityDay entityDay=dateUtility.DateDifferenceDays(MyMiladiDate,CurrentMiladiDate);
                Itm.set_DateDiffDay(entityDay.getDays());
                Itm.set_DateDiffHour(entityDay.getHours());
                Itm.set_DateDiffMinute(entityDay.getMinutes());

                Itm.setNesbat(GetNesbatTitle(cursor.getString(4)));
                Itm.setNesbatName(cursor.getString(5));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())


        return List;

    }

    public ArrayList<EntityReport> DataReport_Aghd(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        ArrayList<EntityReport> List=new ArrayList<>();
        EntityReport Itm;
        String DateDiff="";
        String DateDiffMod="";
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,lname,phone1,aghddate,nesbat,name "+
                " from vw_aghd_report where (aghddate<>'') and (lname like '%"
                +Data+"%' or phone1 like '%"+Data+"%') and (substr(aghddate,5,2)='"+Month+"' or '"
                +Month+"'='') and ((aghddate>='"+_CurrentDate
                +"' and aghddate<='"+_NextDate+"') or '"+_NextDate+"'='') order by aghddate ",null);

        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                Itm = new EntityReport();

                Itm.setId(cursor.getString(0));
                Itm.setName(cursor.getString(1));
                Itm.setMobile(cursor.getString(2));

                Itm.set_Date(cursor.getString(3));
                Itm.set_DateWithSlash(GetDateWithSlash(cursor.getString(3)));
                Itm.set_DateWithMonthWord(dateUtility.GetShamsiDateWithMonthString(cursor.getString(3)));

                String MyDate=cursor.getString(3);
                String MyMiladiDate=dateUtility.GetShamsiToMiladiDate(MyDate);

                Itm.set_DateMiladi(MyMiladiDate);
                Itm.set_DateMiladiWithSlash(GetDateWithSlash(MyMiladiDate));
                Itm.set_DateMiladiWithMonthWord(dateUtility.GetMiladiDateWithMonthString(MyMiladiDate));

                Itm.set_DateDayName(dateUtility.GetDayOfWeek(MyMiladiDate));

                String CurrentMiladiDate=dateUtility.GetCurrentMiladi();
                String CurrentShamsiDate=dateUtility.GetCurrentShamsiDate();

                EntityDateDiff ItmDiff=dateUtility.DateDiff(MyMiladiDate,CurrentMiladiDate);
                DateDiff="";

                if (!ItmDiff.getYear().equals("0"))
                    DateDiff=ItmDiff.getYear()+" سال";

                if (!ItmDiff.getMonth().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getMonth()+" ماه";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getMonth()+" ماه";

                if (!ItmDiff.getDay().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getDay()+" روز ";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getDay()+" روز ";

                Itm.set_DateDiff(DateDiff);

                EntityDateDiff ItmDiffMod=dateUtility.DateDiffMod(cursor.getString(3), CurrentShamsiDate);
                DateDiffMod="";

                if (!ItmDiffMod.getYear().equals("0"))
                    DateDiffMod=ItmDiffMod.getYear()+" سال";

                if (!ItmDiffMod.getMonth().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getMonth()+" ماه";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getMonth()+" ماه";

                if (!ItmDiffMod.getDay().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getDay()+" روز ";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getDay()+" روز ";

                Itm.set_DateDiffMandeh(DateDiffMod);

                EntityDay entityDay=dateUtility.DateDifferenceDays(MyMiladiDate,CurrentMiladiDate);
                Itm.set_DateDiffDay(entityDay.getDays());
                Itm.set_DateDiffHour(entityDay.getHours());
                Itm.set_DateDiffMinute(entityDay.getMinutes());

                Itm.setNesbat(GetNesbatTitle(cursor.getString(4)));
                Itm.setNesbatName(cursor.getString(5));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())


        return List;

    }

    public ArrayList<EntityReport> DataReport_Ezdevaj(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        ArrayList<EntityReport> List=new ArrayList<>();
        EntityReport Itm;
        String DateDiff="";
        String DateDiffMod="";
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,lname,phone1,ezdevajdate,nesbat,name "+
                " from vw_ezdevaj_report where (ezdevajdate<>'') and (lname like '%"
                +Data+"%' or phone1 like '%"+Data+"%') and (substr(ezdevajdate,5,2)='"+Month+"' or '"
                +Month+"'='') and ((ezdevajdate>='"+_CurrentDate
                +"' and ezdevajdate<='"+_NextDate+"') or '"+_NextDate+"'='') order by ezdevajdate ",null);

        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                Itm = new EntityReport();

                Itm.setId(cursor.getString(0));
                Itm.setName(cursor.getString(1));
                Itm.setMobile(cursor.getString(2));

                Itm.set_Date(cursor.getString(3));
                Itm.set_DateWithSlash(GetDateWithSlash(cursor.getString(3)));
                Itm.set_DateWithMonthWord(dateUtility.GetShamsiDateWithMonthString(cursor.getString(3)));

                String MyDate=cursor.getString(3);
                String MyMiladiDate=dateUtility.GetShamsiToMiladiDate(MyDate);

                Itm.set_DateMiladi(MyMiladiDate);
                Itm.set_DateMiladiWithSlash(GetDateWithSlash(MyMiladiDate));
                Itm.set_DateMiladiWithMonthWord(dateUtility.GetMiladiDateWithMonthString(MyMiladiDate));

                Itm.set_DateDayName(dateUtility.GetDayOfWeek(MyMiladiDate));

                String CurrentMiladiDate=dateUtility.GetCurrentMiladi();
                String CurrentShamsiDate=dateUtility.GetCurrentShamsiDate();

                EntityDateDiff ItmDiff=dateUtility.DateDiff(MyMiladiDate,CurrentMiladiDate);
                DateDiff="";

                if (!ItmDiff.getYear().equals("0"))
                    DateDiff=ItmDiff.getYear()+" سال";

                if (!ItmDiff.getMonth().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getMonth()+" ماه";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getMonth()+" ماه";

                if (!ItmDiff.getDay().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getDay()+" روز ";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getDay()+" روز ";

                Itm.set_DateDiff(DateDiff);

                EntityDateDiff ItmDiffMod=dateUtility.DateDiffMod(cursor.getString(3), CurrentShamsiDate);
                DateDiffMod="";

                if (!ItmDiffMod.getYear().equals("0"))
                    DateDiffMod=ItmDiffMod.getYear()+" سال";

                if (!ItmDiffMod.getMonth().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getMonth()+" ماه";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getMonth()+" ماه";

                if (!ItmDiffMod.getDay().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getDay()+" روز ";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getDay()+" روز ";

                Itm.set_DateDiffMandeh(DateDiffMod);

                EntityDay entityDay=dateUtility.DateDifferenceDays(MyMiladiDate,CurrentMiladiDate);
                Itm.set_DateDiffDay(entityDay.getDays());
                Itm.set_DateDiffHour(entityDay.getHours());
                Itm.set_DateDiffMinute(entityDay.getMinutes());

                Itm.setNesbat(GetNesbatTitle(cursor.getString(4)));
                Itm.setNesbatName(cursor.getString(5));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())


        return List;

    }

    public ArrayList<EntityReport> DataReport_Vafat(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        ArrayList<EntityReport> List=new ArrayList<>();
        EntityReport Itm;
        String DateDiff="";
        String DateDiffMod="";
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,lname,phone1,vafatdate,nesbat,name "+
                " from vw_vafat_report where (vafatdate<>'') and (lname like '%"
                +Data+"%' or phone1 like '%"+Data+"%') and (substr(vafatdate,5,2)='"+Month+"' or '"
                +Month+"'='') and ((vafatdate>='"+_CurrentDate
                +"' and vafatdate<='"+_NextDate+"') or '"+_NextDate+"'='') order by vafatdate ",null);

        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                Itm = new EntityReport();

                Itm.setId(cursor.getString(0));
                Itm.setName(cursor.getString(1));
                Itm.setMobile(cursor.getString(2));

                Itm.set_Date(cursor.getString(3));
                Itm.set_DateWithSlash(GetDateWithSlash(cursor.getString(3)));
                Itm.set_DateWithMonthWord(dateUtility.GetShamsiDateWithMonthString(cursor.getString(3)));

                String MyDate=cursor.getString(3);
                String MyMiladiDate=dateUtility.GetShamsiToMiladiDate(MyDate);

                Itm.set_DateMiladi(MyMiladiDate);
                Itm.set_DateMiladiWithSlash(GetDateWithSlash(MyMiladiDate));
                Itm.set_DateMiladiWithMonthWord(dateUtility.GetMiladiDateWithMonthString(MyMiladiDate));

                Itm.set_DateDayName(dateUtility.GetDayOfWeek(MyMiladiDate));

                String CurrentMiladiDate=dateUtility.GetCurrentMiladi();
                String CurrentShamsiDate=dateUtility.GetCurrentShamsiDate();

                EntityDateDiff ItmDiff=dateUtility.DateDiff(MyMiladiDate,CurrentMiladiDate);
                DateDiff="";

                if (!ItmDiff.getYear().equals("0"))
                    DateDiff=ItmDiff.getYear()+" سال";

                if (!ItmDiff.getMonth().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getMonth()+" ماه";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getMonth()+" ماه";

                if (!ItmDiff.getDay().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getDay()+" روز ";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getDay()+" روز ";

                Itm.set_DateDiff(DateDiff);

                EntityDateDiff ItmDiffMod=dateUtility.DateDiffMod(cursor.getString(3), CurrentShamsiDate);
                DateDiffMod="";

                if (!ItmDiffMod.getYear().equals("0"))
                    DateDiffMod=ItmDiffMod.getYear()+" سال";

                if (!ItmDiffMod.getMonth().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getMonth()+" ماه";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getMonth()+" ماه";

                if (!ItmDiffMod.getDay().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getDay()+" روز ";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getDay()+" روز ";

                Itm.set_DateDiffMandeh(DateDiffMod);

                EntityDay entityDay=dateUtility.DateDifferenceDays(MyMiladiDate,CurrentMiladiDate);
                Itm.set_DateDiffDay(entityDay.getDays());
                Itm.set_DateDiffHour(entityDay.getHours());
                Itm.set_DateDiffMinute(entityDay.getMinutes());

                Itm.setNesbat(GetNesbatTitle(cursor.getString(4)));
                Itm.setNesbatName(cursor.getString(5));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())


        return List;

    }

    public ArrayList<EntityReport> DataReport_Taghvim(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        ArrayList<EntityReport> List=new ArrayList<>();
        EntityReport Itm;
        String DateDiff="";
        String DateDiffMod="";
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,lname,phone1,birthdate,nesbat,name,datetitle "+
                " from vw_taghvim where (birthdate<>'') and (lname like '%"
                +Data+"%' or phone1 like '%"+Data+"%') and (substr(birthdate,5,2)='"+Month+"' or '"
                +Month+"'='') and ((birthdate>='"+_CurrentDate
                +"' and birthdate<='"+_NextDate+"') or '"+_NextDate+"'='') order by birthdate ",null);

        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                Itm = new EntityReport();

                Itm.setId(cursor.getString(0));
                Itm.setName(cursor.getString(1));
                Itm.setMobile(cursor.getString(2));

                Itm.set_Date(cursor.getString(3));
                Itm.set_DateWithSlash(GetDateWithSlash(cursor.getString(3)));
                Itm.set_DateWithMonthWord(dateUtility.GetShamsiDateWithMonthString(cursor.getString(3)));

                String MyDate=cursor.getString(3);
                String MyMiladiDate=dateUtility.GetShamsiToMiladiDate(MyDate);

                Itm.set_DateMiladi(MyMiladiDate);
                Itm.set_DateMiladiWithSlash(GetDateWithSlash(MyMiladiDate));
                Itm.set_DateMiladiWithMonthWord(dateUtility.GetMiladiDateWithMonthString(MyMiladiDate));

                Itm.set_DateDayName(dateUtility.GetDayOfWeek(MyMiladiDate));

                String CurrentMiladiDate=dateUtility.GetCurrentMiladi();
                String CurrentShamsiDate=dateUtility.GetCurrentShamsiDate();

                EntityDateDiff ItmDiff=dateUtility.DateDiff(MyMiladiDate,CurrentMiladiDate);
                DateDiff="";

                if (!ItmDiff.getYear().equals("0"))
                    DateDiff=ItmDiff.getYear()+" سال";

                if (!ItmDiff.getMonth().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getMonth()+" ماه";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getMonth()+" ماه";

                if (!ItmDiff.getDay().equals("0"))
                    if (DateDiff.equals(""))
                        DateDiff=ItmDiff.getDay()+" روز ";
                    else
                        DateDiff=DateDiff+" و "+ItmDiff.getDay()+" روز ";

                Itm.set_DateDiff(DateDiff);

                EntityDateDiff ItmDiffMod=dateUtility.DateDiffMod(cursor.getString(3), CurrentShamsiDate);
                DateDiffMod="";


                if (!ItmDiffMod.getYear().equals("0"))
                    DateDiffMod=ItmDiffMod.getYear()+" سال";

                if (!ItmDiffMod.getMonth().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getMonth()+" ماه";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getMonth()+" ماه";

                if (!ItmDiffMod.getDay().equals("0"))
                    if (DateDiffMod.equals(""))
                        DateDiffMod=ItmDiffMod.getDay()+" روز ";
                    else
                        DateDiffMod=DateDiffMod+" و "+ItmDiffMod.getDay()+" روز ";



                Itm.set_DateDiffMandeh(DateDiffMod);

                EntityDay entityDay=dateUtility.DateDifferenceDays(MyMiladiDate,CurrentMiladiDate);
                Itm.set_DateDiffDay(entityDay.getDays());
                Itm.set_DateDiffHour(entityDay.getHours());
                Itm.set_DateDiffMinute(entityDay.getMinutes());

                Itm.setNesbat(GetNesbatTitle(cursor.getString(4)));
                Itm.setNesbatName(cursor.getString(5));
                Itm.set_DateType(cursor.getString(6));
                Itm.set_DateTypeTitle(GetDateTypeTitle(cursor.getString(6)));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())


        return List;

    }

    public ArrayList<EntityContacts> DataReport_FullReport(Context context,String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();
        EntityContacts Itm;
        String birthdate;
        String aghddate;
        String ezdevajdate;

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,lname,phone1"+
                ",birthdate,aghddate,ezdevajdate"+
                " from personlist where  (lname like '%" +Data+"%' or phone1 like '%"+Data+"%') order by lname",null);

        if (cursor != null && cursor.moveToFirst())
        {
            do
            {
                Itm = new EntityContacts();

                Itm.setId(cursor.getString(0));
                Itm.setName(cursor.getString(1));
                Itm.setMobile1(cursor.getString(2));

                birthdate=cursor.getString(3);
                aghddate=cursor.getString(4);
                ezdevajdate=cursor.getString(5);

                Itm.setBirthdate("");
                Itm.setAghddate("");
                Itm.setEzdevajdate("");

                if (!birthdate.equals(""))
                    Itm.setBirthdate(dateUtility.GetShamsiDateWithMonthString(birthdate));

                if (!aghddate.equals(""))
                    Itm.setAghddate(dateUtility.GetShamsiDateWithMonthString(aghddate));

                if (!ezdevajdate.equals(""))
                    Itm.setEzdevajdate(dateUtility.GetShamsiDateWithMonthString(ezdevajdate));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())

        return List;

    }

    private String GetDateWithSlash(String Date)
    {
        String Ret="";

        String Day="";
        String Month="";
        String Year="";

        if (!Date.equals(""))
        {
            Year=Date.substring(0,4);
            Month=Date.substring(4,6);
            Day=Date.substring(6,8);

            Ret=Year+"/"+Month+"/"+Day;

        }

        return Ret;
    }

    private String GetNesbatTitle(String NesbatId)
    {
        String Ret="";

        switch (NesbatId)
        {
            case "1":
                Ret = "پدر";
                break;
            case "2":
                Ret = "مادر";
                break;
            case "3":
                Ret = "برادر";
                break;
            case "4":
                Ret = "خواهر";
                break;
            case "5":
                Ret = "همسر";
                break;
            case "6":
                Ret = "فرزند";
                break;
            case "7":
                Ret = "پدربزرگ";
                break;
            case "8":
                Ret = "مادربزرگ";
                break;
            case "9":
                Ret = "سایر";
                break;
        }



        return Ret;

    }

    private String GetDateTypeTitle(String DateTypeId)
    {
        String Ret = "";

        switch (DateTypeId)
        {
            case "1":
                Ret = "تاریخ تولد";
                break;
            case "2":
                Ret = "تاریخ عقد";
                break;
            case "3":
                Ret = "تاریخ ازدواج";
                break;
            case "4":
                Ret = "تاریخ وفات";
                break;
        }

        return Ret;
    }

}
