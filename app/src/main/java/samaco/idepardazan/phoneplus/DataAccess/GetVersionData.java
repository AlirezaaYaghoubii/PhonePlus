package samaco.idepardazan.phoneplus.DataAccess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import samaco.idepardazan.phoneplus.Common.ClassHelper;


public class GetVersionData {

private static String DB_NAME= ClassHelper.getDataBase_Name();
private SQLiteDatabase database;

        public String GetCurrentVersion(Context context) {

            String LocalVersion="0";

            try {
                ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(context, DB_NAME);
                database = dbOpenHelper.openDataBase();

                Cursor cursor;


                cursor = database.rawQuery("SELECT versionname FROM tblversion ", null);


                if (cursor != null && cursor.moveToFirst()) {
                    do {

                        LocalVersion = cursor.getString(0);

                    } while (cursor.moveToNext());

                }//if (cursor != null && cursor.moveToFirst()) {

            }
            catch (Exception Ex)
            {
                LocalVersion="0";
            }

            return  (LocalVersion);

        }
}
