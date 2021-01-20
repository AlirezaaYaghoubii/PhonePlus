package samaco.idepardazan.phoneplus.DataAccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntityContactsDetails;


public class DataContractDetails {

    private static String DB_NAME= ClassHelper.getDataBase_Name();
    private SQLiteDatabase database;


    public Integer GetMaxId(Context context) {

        Integer Max_Id=0;
        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select max(id) from personlistdetails",null);

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


    public Integer DataContractDetails_Insert(Context context,String Person_Id,String Nesbat,String Name,String Title
            ,String TitleDate,String Comment)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();
        Integer Max_Id=GetMaxId(context);

        database.execSQL("insert into personlistdetails (id,personlist_id,nesbat,name,title,titledate,comment) values('"
                +Max_Id+"','"+Person_Id+"','"+Nesbat+"','"+Name+"','"+Title+"','"+TitleDate+"','"+Comment+"')");

        return Max_Id;
    }

    public void DataContractDetails_Delete(Context context,String Id)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("delete from personlistdetails  where id='"+Id+"'");
    }

    public void DataContractDetails_Update(Context context,String Id,String Nesbat,String Name,String Title
            ,String TitleDate,String Comment)
    {
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        database.execSQL("Update personlistdetails set nesbat='"+Nesbat+"',name='"+Name+"',title='"+Title+"',titledate='"+TitleDate
                +"',comment='"+Comment+"' where id='"+Id+"'");
    }

    public ArrayList<EntityContactsDetails> DataContractDetails_Select(Context context,String Person_Id)
    {
        ArrayList<EntityContactsDetails> List=new ArrayList<>();
        EntityContactsDetails Itm;

        Cursor cursor;
        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
        database = dbOpenHelper.openDataBase();

        cursor=database.rawQuery("select id,personlist_id,nesbat,name,title,titledate,comment "+
                " from personlistdetails where personlist_id='"+Person_Id+"'",null);

        if (cursor != null && cursor.moveToFirst()) {

            do {

                Itm = new EntityContactsDetails();

                Itm.setId(cursor.getString(0));
                Itm.setPerson_Id(cursor.getString(1));
                Itm.setNesbat(cursor.getString(2));
                Itm.setName(cursor.getString(3));
                Itm.setTitle(cursor.getString(4));
                Itm.setTitleDate(cursor.getString(5));
                Itm.setComment(cursor.getString(6));

                List.add(Itm);

            }while (cursor.moveToNext());

        }//if (cursor != null && cursor.moveToFirst())

        return List;
    }


}
