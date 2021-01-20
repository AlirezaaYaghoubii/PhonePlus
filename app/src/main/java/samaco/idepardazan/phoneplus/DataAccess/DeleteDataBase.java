package samaco.idepardazan.phoneplus.DataAccess;

import android.content.Context;
import android.os.Environment;

import java.io.File;

import samaco.idepardazan.phoneplus.Common.ClassHelper;


public class DeleteDataBase {


    private static String DB_NAME= ClassHelper.getDataBase_Name();
    public static String DB_PATH;

    public void DeleteIfExists(Context context) {

        String packageName = context.getPackageName();

        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/PhonePlus/Database");
        DB_PATH = String.format(dir.getPath()+"/Database", packageName);

        boolean checkdb;

        String myPath = DB_PATH + DB_NAME;
        File dbfile = new File(myPath);
        checkdb = dbfile.exists();

        if (checkdb)
            dbfile.delete();

    }
}
