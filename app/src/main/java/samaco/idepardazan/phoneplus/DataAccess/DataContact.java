package samaco.idepardazan.phoneplus.DataAccess;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;

public class DataContact {

    private static String DB_NAME= ClassHelper.getDataBase_Name();
    private SQLiteDatabase database;

    public Integer GetMaxId(Context context) {

        Integer Max_Id=0;
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select max(id) from personlist",null);

        if (cursor.getCount()>0)
        {
            try {
                cursor.moveToFirst();
                Max_Id = cursor.getInt(0);
            }
            catch (Exception e)
            {

            }

        }//if (cursor.getCount()>0)

        if (Max_Id==null || Max_Id==0)
            Max_Id=0;

        Max_Id++;

        return Max_Id;
    }


    public Integer DataContact_Insert(Context context,String lname,String phone1,String phone2,String email
    ,String website,String address,String postid,String shenasnameh
            ,String mellicardid,String govahinamehid,String jensiat)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();
        Integer Max_Id=GetMaxId(context);

        database.execSQL("insert into personlist (id,lname,phone1,phone2,email,website,address"+
                ",postid,shenasnameh,mellicardid,govahinamehid,jensiat,birthdate,aghddate,ezdevajdate"+
                ",bank1,hesab1,card1,bank2,hesab2,card2,photoaddress) values('"
                +Max_Id+"','"+lname+"','"+phone1+"','"+phone2+"','"+email+"','"+website+"','"+
                address+"','"+postid+"','"+shenasnameh+"','"+mellicardid+"','"+govahinamehid+"','"+jensiat+"','','','','','','','','','','')");

        return Max_Id;
    }

    public String DataContact_SelectName(Context context,String Id)
    {
        String _Name="";

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select lname from personlist where id='"+Id+"'",null);

        if (cursor != null && cursor.moveToFirst())
        {
            _Name=cursor.getString(0);
        }


        return _Name;
    }

    public EntityContacts DataContact_Select_Contact(Context context,String Id)
    {
        EntityContacts Itm=new EntityContacts();

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,jensiat,lname,phone1,phone2,email,website"+
                ",address,postid,shenasnameh,mellicardid,govahinamehid"+
                ",birthdate,aghddate,ezdevajdate,bank1,hesab1,card1,bank2,hesab2,card2,photoaddress "+
                " from personlist where id='"+Id+"' order by lname",null);

        if (cursor != null && cursor.moveToFirst())
        {
            Itm.setId(cursor.getString(0));
            Itm.setJensiat(cursor.getString(1));

            Itm.setName(cursor.getString(2));
            Itm.setMobile1(cursor.getString(3));
            Itm.setMobile2(cursor.getString(4));

            Itm.setEmail(cursor.getString(5));
            Itm.setWebsite(cursor.getString(6));

            Itm.setAddress(cursor.getString(7));
            Itm.setPostid(cursor.getString(8));

            Itm.setShenasnameh(cursor.getString(9));
            Itm.setMellicardid(cursor.getString(10));
            Itm.setGovahinamehid(cursor.getString(11));

            Itm.setBirthdate(cursor.getString(12));
            Itm.setAghddate(cursor.getString(13));
            Itm.setEzdevajdate(cursor.getString(14));

            Itm.setBank1(cursor.getString(15));
            Itm.setHesab1(cursor.getString(16));
            Itm.setCard1(cursor.getString(17));

            Itm.setBank2(cursor.getString(18));
            Itm.setHesab2(cursor.getString(19));
            Itm.setCard2(cursor.getString(20));

            Itm.setPhotoaddress(cursor.getString(21));

            Itm.setBankname1(GetBankName(cursor.getString(15)));
            Itm.setBankname2(GetBankName(cursor.getString(18)));

            Itm.setBirthdatewithslash(GetDateWithSlash(cursor.getString(12)));
            Itm.setAghddatewithslash(GetDateWithSlash(cursor.getString(13)));
            Itm.setEzdevajdatewithslash(GetDateWithSlash(cursor.getString(14)));

        }


        return Itm;
    }


    public ArrayList<EntityContacts> DataContact_Select(Context context,String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();
        EntityContacts Itm;

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,jensiat,lname,phone1,phone2,email,website"+
                ",address,postid,shenasnameh,mellicardid,govahinamehid"+
                ",birthdate,aghddate,ezdevajdate,bank1,hesab1,card1,bank2,hesab2,card2,photoaddress "+
                " from personlist where lname like '%"+Data+"%' or phone1 like '%"+Data+"%' order by lname ",null);

        if (cursor != null && cursor.moveToFirst()) {

            do {

                Itm = new EntityContacts();

                Itm.setId(cursor.getString(0));
                Itm.setJensiat(cursor.getString(1));

                Itm.setName(cursor.getString(2));
                Itm.setMobile1(cursor.getString(3));
                Itm.setMobile2(cursor.getString(4));

                Itm.setEmail(cursor.getString(5));
                Itm.setWebsite(cursor.getString(6));

                Itm.setAddress(cursor.getString(7));
                Itm.setPostid(cursor.getString(8));

                Itm.setShenasnameh(cursor.getString(9));
                Itm.setMellicardid(cursor.getString(10));
                Itm.setGovahinamehid(cursor.getString(11));

                Itm.setBirthdate(cursor.getString(12));
                Itm.setAghddate(cursor.getString(13));
                Itm.setEzdevajdate(cursor.getString(14));

                Itm.setBank1(cursor.getString(15));
                Itm.setHesab1(cursor.getString(16));
                Itm.setCard1(cursor.getString(17));

                Itm.setBank2(cursor.getString(18));
                Itm.setHesab2(cursor.getString(19));
                Itm.setCard2(cursor.getString(20));

                Itm.setPhotoaddress(cursor.getString(21));

                Itm.setBankname1(GetBankName(cursor.getString(15)));
                Itm.setBankname2(GetBankName(cursor.getString(18)));

                Itm.setBirthdatewithslash(GetDateWithSlash(cursor.getString(12)));
                Itm.setAghddatewithslash(GetDateWithSlash(cursor.getString(13)));
                Itm.setEzdevajdatewithslash(GetDateWithSlash(cursor.getString(14)));


                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())

        return List;
    }

    public ArrayList<EntityContacts> DataContact_SelectForGrid(Context context,String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();
        EntityContacts Itm;

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,jensiat,lname,phone1,phone2,email,website"+
                ",address,postid,shenasnameh,mellicardid,govahinamehid"+
                ",birthdate,aghddate,ezdevajdate,bank1,hesab1,card1,bank2,hesab2,card2,photoaddress "+
                " from personlist where lname like '%"+Data+"%' or phone1 like '%"+Data+"%' order by lname LIMIT 40",null);

        if (cursor != null && cursor.moveToFirst()) {

            do {

                Itm = new EntityContacts();

                Itm.setId(cursor.getString(0));
                Itm.setJensiat(cursor.getString(1));

                Itm.setName(cursor.getString(2));
                Itm.setMobile1(cursor.getString(3));
                Itm.setMobile2(cursor.getString(4));

                Itm.setEmail(cursor.getString(5));
                Itm.setWebsite(cursor.getString(6));

                Itm.setAddress(cursor.getString(7));
                Itm.setPostid(cursor.getString(8));

                Itm.setShenasnameh(cursor.getString(9));
                Itm.setMellicardid(cursor.getString(10));
                Itm.setGovahinamehid(cursor.getString(11));

                Itm.setBirthdate(cursor.getString(12));
                Itm.setAghddate(cursor.getString(13));
                Itm.setEzdevajdate(cursor.getString(14));

                Itm.setBank1(cursor.getString(15));
                Itm.setHesab1(cursor.getString(16));
                Itm.setCard1(cursor.getString(17));

                Itm.setBank2(cursor.getString(18));
                Itm.setHesab2(cursor.getString(19));
                Itm.setCard2(cursor.getString(20));

                Itm.setPhotoaddress(cursor.getString(21));

                Itm.setBankname1(GetBankName(cursor.getString(15)));
                Itm.setBankname2(GetBankName(cursor.getString(18)));

                Itm.setBirthdatewithslash(GetDateWithSlash(cursor.getString(12)));
                Itm.setAghddatewithslash(GetDateWithSlash(cursor.getString(13)));
                Itm.setEzdevajdatewithslash(GetDateWithSlash(cursor.getString(14)));


                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())

        return List;
    }

    public ArrayList<EntityContacts> DataContact_OnlyBankSelect(Context context,String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();
        EntityContacts Itm;

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,jensiat,lname,phone1,phone2,email,website"+
                ",address,postid,shenasnameh,mellicardid,govahinamehid"+
                ",birthdate,aghddate,ezdevajdate,bank1,hesab1,card1,bank2,hesab2,card2,photoaddress "+
                " from personlist where (lname like '%"+Data+"%' or phone1 like '%"+Data+"%') and (bank1<>'' or bank2<>'') order by lname ",null);

        if (cursor != null && cursor.moveToFirst()) {

            do {

                Itm = new EntityContacts();

                Itm.setId(cursor.getString(0));
                Itm.setJensiat(cursor.getString(1));

                Itm.setName(cursor.getString(2));
                Itm.setMobile1(cursor.getString(3));
                Itm.setMobile2(cursor.getString(4));

                Itm.setEmail(cursor.getString(5));
                Itm.setWebsite(cursor.getString(6));

                Itm.setAddress(cursor.getString(7));
                Itm.setPostid(cursor.getString(8));

                Itm.setShenasnameh(cursor.getString(9));
                Itm.setMellicardid(cursor.getString(10));
                Itm.setGovahinamehid(cursor.getString(11));

                Itm.setBirthdate(cursor.getString(12));
                Itm.setAghddate(cursor.getString(13));
                Itm.setEzdevajdate(cursor.getString(14));

                Itm.setBank1(cursor.getString(15));
                Itm.setHesab1(cursor.getString(16));
                Itm.setCard1(cursor.getString(17));

                Itm.setBank2(cursor.getString(18));
                Itm.setHesab2(cursor.getString(19));
                Itm.setCard2(cursor.getString(20));

                Itm.setPhotoaddress(cursor.getString(21));

                Itm.setBankname1(GetBankName(cursor.getString(15)));
                Itm.setBankname2(GetBankName(cursor.getString(18)));

                Itm.setBirthdatewithslash(GetDateWithSlash(cursor.getString(12)));
                Itm.setAghddatewithslash(GetDateWithSlash(cursor.getString(13)));
                Itm.setEzdevajdatewithslash(GetDateWithSlash(cursor.getString(14)));


                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())

        return List;
    }

    public ArrayList<EntityContacts> DataContact_OnlyContactSelect(Context context,String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();
        EntityContacts Itm;

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,jensiat,lname,phone1,phone2,email,website"+
                ",address,postid,shenasnameh,mellicardid,govahinamehid"+
                ",birthdate,aghddate,ezdevajdate,bank1,hesab1,card1,bank2,hesab2,card2,photoaddress "+
                " from personlist where (lname like '%"+Data+"%' or phone1 like '%"+Data
                +"%') and (birthdate<>'' or shenasnameh<>'' or mellicardid<>'') order by lname ",null);

        if (cursor != null && cursor.moveToFirst()) {

            do {

                Itm = new EntityContacts();

                Itm.setId(cursor.getString(0));
                Itm.setJensiat(cursor.getString(1));

                Itm.setName(cursor.getString(2));
                Itm.setMobile1(cursor.getString(3));
                Itm.setMobile2(cursor.getString(4));

                Itm.setEmail(cursor.getString(5));
                Itm.setWebsite(cursor.getString(6));

                Itm.setAddress(cursor.getString(7));
                Itm.setPostid(cursor.getString(8));

                Itm.setShenasnameh(cursor.getString(9));
                Itm.setMellicardid(cursor.getString(10));
                Itm.setGovahinamehid(cursor.getString(11));

                Itm.setBirthdate(cursor.getString(12));
                Itm.setAghddate(cursor.getString(13));
                Itm.setEzdevajdate(cursor.getString(14));

                Itm.setBank1(cursor.getString(15));
                Itm.setHesab1(cursor.getString(16));
                Itm.setCard1(cursor.getString(17));

                Itm.setBank2(cursor.getString(18));
                Itm.setHesab2(cursor.getString(19));
                Itm.setCard2(cursor.getString(20));

                Itm.setPhotoaddress(cursor.getString(21));

                Itm.setBankname1(GetBankName(cursor.getString(15)));
                Itm.setBankname2(GetBankName(cursor.getString(18)));

                Itm.setBirthdatewithslash(GetDateWithSlash(cursor.getString(12)));
                Itm.setAghddatewithslash(GetDateWithSlash(cursor.getString(13)));
                Itm.setEzdevajdatewithslash(GetDateWithSlash(cursor.getString(14)));


                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())

        return List;
    }

    public void DataContact_Delete(Context context,String Id)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("delete from personlist  where id='"+Id+"'");

        database.execSQL("delete from personlistdetails  where personlist_id='"+Id+"'");
    }

    public void DataContact_UpdateMain(Context context,String Id,String lname,String phone1,String phone2,String email
            ,String website,String address,String postid,String shenasnameh
            ,String mellicardid,String govahinamehid,String jensiat)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("Update personlist set lname='"+lname+"',phone1='"+phone1+"',phone2='"+phone2+"',email='"+email
                +"',website='"+website+"',address='"+address+"'"+
                ",postid='"+postid+"',shenasnameh='"+shenasnameh+"',mellicardid='"+mellicardid+"',govahinamehid='"+govahinamehid
                +"',jensiat='"+jensiat+"' where id='"+Id+"'");

    }

    public void DataContact_UpdateDate(Context context,String Id
            ,String birthdate,String aghddate,String ezdevajdate)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("Update personlist set birthdate='"+birthdate+"',aghddate='"+aghddate
                +"',ezdevajdate='"+ezdevajdate+"' where id='"+Id+"'");

    }

    public void DataContact_UpdateAccount(Context context,String Id
            ,String bank1,String hesab1,String card1,String bank2,String hesab2,String card2)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("Update personlist set bank1='"+bank1+"',hesab1='"+hesab1
                +"',card1='"+card1+"',bank2='"+bank2+"',hesab2='"+hesab2+"',card2='"+card2+"' where id='"+Id+"'");

    }

    public void DataContact_PhotoAddress(Context context,String Id
            ,String PhotoAddress)
    {

        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("Update personlist set photoaddress='"+PhotoAddress+"'" +
                " where id='"+Id+"'");

    }

    public void DataContact_InsertFromSim(Context context,String Name,String Phone)
    {
        Boolean _Check=CheckPhoneNumberExists(context,Phone);

        if (_Check==false)
        {

            ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
            database = dbOpenHelper.openDataBase();
            Integer Max_Id=GetMaxId(context);

            database.execSQL("insert into personlist (id,lname,phone1,phone2,email,website,address"+
                    ",postid,shenasnameh,mellicardid,govahinamehid,jensiat,birthdate,aghddate,ezdevajdate"+
                    ",bank1,hesab1,card1,bank2,hesab2,card2,photoaddress) values('"
                    +Max_Id+"','"+Name+"','"+Phone+"','','','',''"+
                    ",'','','','','1','','','','','','','','','','')");
        }

    }

    private Boolean CheckPhoneNumberExists(Context context,String Phone)
    {
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select * from personlist where phone1='"+Phone+"'",null);

        if (cursor != null && cursor.moveToFirst())
        {
            return true;
        }

        return false;
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

    private String GetBankName(String BankId)
    {
        String Ret="";

        switch (BankId)
        {
            case "1":
                Ret = "ملت";
                break;
            case "2":
                Ret = "ملی";
                break;
            case "3":
                Ret = "مسکن";
                break;
            case "4":
                Ret = "تجارت";
                break;
            case "5":
                Ret = "صادرات";
                break;
            case "6":
                Ret = "آینده";
                break;
            case "7":
                Ret = "انصار";
                break;
            case "8":
                Ret = "پارسیان";
                break;
            case "9":
                Ret = "پاسارگاد";
                break;
            case "10":
                Ret = "سامان";
                break;
            case "11":
                Ret = "سپه";
                break;
            case "12":
                Ret = "سرمایه";
                break;
            case "13":
                Ret = "سینا";
                break;
            case "14":
                Ret = "شهر";
                break;
            case "15":
                Ret = "کشاورزی";
                break;
            case "16":
                Ret = "قوامین";
                break;
            case "17":
                Ret = "سایر";
                break;
        }



        return Ret;

    }


}
