package samaco.idepardazan.phoneplus.Common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public class ShareUtility {

    public void ShareWith_EveryThing(Activity activity,String Msg_Body,String Msg_Title)
    {
        try
        {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");

            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, Msg_Title);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, Msg_Body);
            activity.startActivity(Intent.createChooser(sharingIntent, "به اشتراک گذاری با ..."));
        }
        catch (Exception ex)
        {

        }
    }

    public void ShareWith_SMS(Activity activity,String Msg_Body)
    {
        try
        {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", "");
            smsIntent.putExtra("sms_body", Msg_Body);
            activity.startActivity(smsIntent);
        }
        catch (Exception ex)
        {

        }
    }

    public void ShareWith_Email(Activity activity,String Msg_Body,String Msg_Title)
    {
        try
        {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, Msg_Title);
            intent.putExtra(Intent.EXTRA_TEXT, Msg_Body);
            intent.setData(Uri.parse("mailto:"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);

        }
        catch (Exception ex)
        {

        }

    }

    public void ShareWith_Telegram(Activity activity,String Msg_Body)
    {
        final String appName = "org.telegram.messenger";
        final boolean isAppInstalled = IsAppAvailable(activity, appName);
        if (isAppInstalled)
        {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            myIntent.setPackage(appName);
            myIntent.putExtra(Intent.EXTRA_TEXT, Msg_Body);
            activity.startActivity(Intent.createChooser(myIntent, "اشتراک گذاری با ..."));

        }
        else
        {
            CustomToast customToast=new CustomToast();
            customToast.ShowCustomToast(activity,"تلگرام نصب نیست");
        }
    }

    private static boolean IsAppAvailable(Context context, String appName)
    {
        PackageManager pm = context.getPackageManager();
        try
        {
            pm.getPackageInfo(appName, PackageManager.GET_ACTIVITIES);
            return true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            return false;
        }
    }
}
