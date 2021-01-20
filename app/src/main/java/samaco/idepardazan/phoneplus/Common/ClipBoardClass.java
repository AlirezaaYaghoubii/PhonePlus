package samaco.idepardazan.phoneplus.Common;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by Alireza on 05/12/2017.
 */
public class ClipBoardClass {

    public void Set_Clipboard(Context context,String Text)
    {
        CustomToast customToast=new CustomToast();

        ClipboardManager Clipboard;
        ClipData Clip;
        Clipboard = (ClipboardManager)context.getSystemService(context.CLIPBOARD_SERVICE);


        if (!Text.equals("")) {
            Clip = ClipData.newPlainText("text", Text);
            Clipboard.setPrimaryClip(Clip);
            customToast.ShowCustomToast(context, "در کلیپ بورد کپی شد");
        }//if (!Text.equals(""))


    }

}
