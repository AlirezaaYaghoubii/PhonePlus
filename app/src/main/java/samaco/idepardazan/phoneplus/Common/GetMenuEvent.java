package samaco.idepardazan.phoneplus.Common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import samaco.idepardazan.phoneplus.MainActivity;
import samaco.idepardazan.phoneplus.R;


public class GetMenuEvent {

    SettingPage settingPage=new SettingPage();

    public boolean  CallMenuEvent(Context context,Activity activity,MenuItem item)
    {
        switch (item.getItemId()) {

            case R.id.action_Home:
                activity.finishAffinity();
                Intent intent_main=new Intent(activity.getApplicationContext()
                        , MainActivity.class);
                activity.startActivity(intent_main);
                return true;

            case R.id.action_About:
                settingPage.About_App(context,activity);
                return true;

            case R.id.action_Other:
                settingPage.AppShareTo_Others(activity);
                return true;

            case R.id.action_Programmer:
                settingPage.About_Developer(context,activity);
                return true;


            case R.id.action_Exit:
                activity.finishAffinity();
                return true;

            default:
                return true;

        }//switch (item.getItemId())

    }
}
