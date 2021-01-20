package samaco.idepardazan.phoneplus.Common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.obsez.android.lib.filechooser.ChooserDialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;
import samaco.idepardazan.phoneplus.Adapter.MySpinnerAdapter;
import samaco.idepardazan.phoneplus.MainActivity;
import samaco.idepardazan.phoneplus.R;


public class SettingPage extends ActionBarActivity {

    Typeface TextFont;
    Spinner spinner;
    Spinner spinner2;
    CustomToast customToast=new CustomToast();

    public void Application_Finish(Context context,Activity activity)
    {
        activity.finishAffinity();

    }

    public void DatabaseRecovery(final Context context,final Activity activity)
    {

        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_file_recovery, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final Button Btn_NotOk=(Button) alert.findViewById(R.id.Btn_NotOk);
        final Button Btn_SelectFile=(Button) alert.findViewById(R.id.Btn_SelectFile);

        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);
        final EditText EditText_SRC=(EditText) alert.findViewById(R.id.EditText_SRC);
        final EditText EditText_Desc=(EditText) alert.findViewById(R.id.EditText_Desc);


        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_Ok.setTypeface(TextFont);
        Btn_NotOk.setTypeface(TextFont);
        Btn_SelectFile.setTypeface(TextFont);

        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }

        final File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath()+ "/PhonePlus/Database/Databasephonepluse.sqlite");
        EditText_Desc.setText(dir.getPath());


        Btn_SelectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final File dir = new File(sdCard.getAbsolutePath()+ "/PhonePlus/Database/Databasephonepluse.sqlite");

                new ChooserDialog().with(activity)
                        .withFilter(false, false, "sqlite")
                        .withStartFile(sdCard.getAbsolutePath() + "/PhonePlus/Backup")
                        .withChosenListener(new ChooserDialog.Result() {
                            @Override
                            public void onChoosePath(String path, File pathFile) {

                                EditText_SRC.setText(path);


                            }
                        })
                        .build()
                        .show();


            }
        });


        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File Src = new File(EditText_SRC.getText().toString());
                File Desc = new File(EditText_Desc.getText().toString());

                try
                {
                    Desc.delete();
                }
                catch (Exception e)
                {

                }


                try
                {
                    copy(Src, Desc);
                    customToast.ShowCustomToast(activity,"عملیات با موفقیت انجام شد");
                    alert.dismiss();
                }
                catch (Exception e)
                {

                }

            }
        });


        Btn_NotOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });

        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


        Btn_NotOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NotOk.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NotOk.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });

        Btn_SelectFile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_SelectFile.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_SelectFile.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


    }

    public void GernerateBackup(final Context context,Activity activity)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_file_save, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final Button Btn_NotOk=(Button) alert.findViewById(R.id.Btn_NotOk);
        final TextView TextView_Crouse=(TextView) alert.findViewById(R.id.TextView_Crouse);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        final EditText EditText_SRC=(EditText) alert.findViewById(R.id.EditText_SRC);
        final EditText EditText_Desc=(EditText) alert.findViewById(R.id.EditText_Desc);


        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_Ok.setTypeface(TextFont);
        Btn_NotOk.setTypeface(TextFont);
        TextView_Crouse.setTypeface(TextFont);

        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }
        Date currentTime = Calendar.getInstance().getTime();

        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath()+ "/PhonePlus/Database/Databasephonepluse.sqlite");

        String DB_PATH;
        DB_PATH = dir.getPath();

        final File Src = new File(DB_PATH);

        File dir2 = new File(sdCard.getAbsolutePath()
                + "/PhonePlus/Backup/");

        File dir3 = new File(sdCard.getAbsolutePath()
                + "/PhonePlus/Database/");

        DB_PATH = dir2.getPath()+"/"+currentTime+".sqlite";
        final File Des = new File(DB_PATH);

        if(dir2.exists()==false)
            dir2.mkdirs();

        EditText_SRC.setText(dir3.getPath());
        EditText_Desc.setText(dir2.getPath());

        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {
                    copy(Src, Des);
                }
                catch(Exception e)
                {

                   e.printStackTrace();
                }

                customToast.ShowCustomToast(context,"فایل پشتیبان ایجاد شد");
                alert.dismiss();


            }
        });


        Btn_NotOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });


        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



        Btn_NotOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NotOk.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NotOk.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



    }

    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public void AppShareTo_Others(Activity activity)
    {
        if (ClassHelper.getMarketName().equals("cafebazaar"))
        {
            try
            {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://cafebazaar.ir/app/samaco.idepardazan.phoneplus/?l=fa");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "مخاطب پلاس");
                activity.startActivity(Intent.createChooser(shareIntent, "اشتراک لینک برنامه با:"));
            }
            catch (Exception e)
            {

            }

        }//if (ClassHelper.getMarketName().equals("cafebazaar"))
        else if (ClassHelper.getMarketName().equals("cando"))
        {
            try
            {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "http://cando.asr24.com/app.jsp?id=samaco.idepardazan.phoneplus");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "مخاطب پلاس");
                activity.startActivity(Intent.createChooser(shareIntent, "اشتراک لینک برنامه با:"));
            }
            catch (Exception e)
            {

            }

        }//else if (ClassHelper.getMarketName().equals("cando"))

        else if (ClassHelper.getMarketName().equals("myket"))
        {
            try
            {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "http://myket.ir/app/samaco.idepardazan.phoneplus");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "مخاطب پلاس");
                activity.startActivity(Intent.createChooser(shareIntent, "اشتراک لینک برنامه با:"));
            }
            catch (Exception e)
            {

            }

        }//else if (ClassHelper.getMarketName().equals("myket"))

    }

    public void AppList(Activity activity)
    {
        if (ClassHelper.getMarketName().equals("cafebazaar"))
        {
            try
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "alirezayaghoubi"));
                intent.setPackage("com.farsitel.bazaar");
                activity.startActivity(intent);
            }
            catch (Exception ex)
            {

            }

        }//if (ClassHelper.getMarketName().equals("cafebazaar"))
        else if (ClassHelper.getMarketName().equals("cando"))
        {
            try
            {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("cando://publisher?id=a.yaghoubi.samaco@gmail.com"));

            activity.startActivity(intent);

            }
            catch (Exception ex)
            {

            }

        }//else if (ClassHelper.getMarketName().equals("cando"))

        else if (ClassHelper.getMarketName().equals("myket"))
        {
            try
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("myket://developer/samaco.idepardazan.goldcommandcodes"));

                activity.startActivity(intent);

            }
            catch (Exception ex)
            {

            }

        }//else if (ClassHelper.getMarketName().equals("myket"))

    }

    public void App_Comment(Activity activity)
    {

        if (ClassHelper.getMarketName().equals("cafebazaar")) {
            try {

                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("bazaar://details?id=" + "samaco.idepardazan.phoneplus"));
                intent.setPackage("com.farsitel.bazaar");
                activity.startActivity(intent);
            }
            catch (Exception ex)
            {

            }

        }//if (ClassHelper.getMarketName().equals("cafebazaar"))
        else if (ClassHelper.getMarketName().equals("cando"))
        {
            try
            {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("cando://leave-review?id=samaco.idepardazan.phoneplus"));
                activity.startActivity(intent);
            }
            catch (Exception ex)
            {

            }

        }// else if (ClassHelper.getMarketName().equals("cando"))

        else if (ClassHelper.getMarketName().equals("myket"))
        {
            try
            {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("myket://comment?id=samaco.idepardazan.phoneplus"));
                activity.startActivity(intent);
            }
            catch (Exception ex)
            {

            }

        }// else if (ClassHelper.getMarketName().equals("myket"))

    }

    public void About_App(Context context,Activity activity)
    {

        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_about_app_body, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));


        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final TextView TextView_Crouse=(TextView) alert.findViewById(R.id.TextView_Crouse);
        final TextView TextView_User=(TextView) alert.findViewById(R.id.TextView_User);
        final TextView TextView_Position=(TextView) alert.findViewById(R.id.TextView_Position);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);


        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }

        TextView_Crouse.setTypeface(TextFont);
        TextView_User.setTypeface(TextFont);
        TextView_Position.setTypeface(TextFont);
        Btn_Ok.setTypeface(TextFont);

        TextView_User.setText("نسخه : "+ClassHelper.getAppVersion());

        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });

        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



    }

    public void About_Developer(final Context context,final Activity  activity)
    {

        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_alert_body, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final TextView TextView_Crouse=(TextView) alert.findViewById(R.id.TextView_Crouse);
        final TextView TextView_User=(TextView) alert.findViewById(R.id.TextView_User);
        final TextView TextView_Position=(TextView) alert.findViewById(R.id.TextView_Position);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        final TextView TextView_Phone=(TextView) alert.findViewById(R.id.TextView_Phone);
        final TextView TextView_Email=(TextView) alert.findViewById(R.id.TextView_Email);

        TextView_Crouse.setTypeface(TextFont);
        TextView_User.setTypeface(TextFont);
        TextView_Position.setTypeface(TextFont);
        Btn_Ok.setTypeface(TextFont);

        TextView_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Tel="09198284582";
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", _Tel);
                smsIntent.putExtra("sms_body", "");
                activity.startActivity(smsIntent);

            }
        });

        TextView_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {
                    String shareBody = "";
                    Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    intent.setData(Uri.parse("mailto:" + "a.yaghoubi.dev@gmail.com")); // or just "mailto:" for blank
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                    startActivity(intent);
                }
                catch (Exception e)
                {

                }

            }
        });


        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }


        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });

        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {


            }
        });


        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });

    }

    public void ChangeColor(final Context context,final Activity activity)
    {

        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_color_body, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }


        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final Button Btn_NotOk=(Button) alert.findViewById(R.id.Btn_NotOk);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        LayerHead.setBackgroundResource(R.drawable.footergreen);

        Btn_Ok.setTypeface(TextFont);
        Btn_NotOk.setTypeface(TextFont);

        //COLOR1
        ArrayList<String> List_Group=new ArrayList<>();
        List_Group.add("سبز");
        List_Group.add("آبی");
        List_Group.add("قرمز");
        List_Group.add("طلایی");
        List_Group.add("قهوه ای");
        List_Group.add("سیاه");

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(alert.getContext(),
                android.R.layout.simple_spinner_item, List_Group);

        spinner = (Spinner) alert.findViewById(R.id.Spinner_Color1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        Integer Position=0;
        Position=Integer.parseInt(ClassHelper.getApp_Color_Code());
        spinner.setSelection(Position);

        //COLOR2
        ArrayList<String> List_Group2=new ArrayList<>();
        List_Group2.add("روشن");
        List_Group2.add("تیره");


        MySpinnerAdapter dataAdapter2 = new MySpinnerAdapter(alert.getContext(),
                android.R.layout.simple_spinner_item, List_Group2);

        spinner2 = (Spinner) alert.findViewById(R.id.Spinner_Color2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        Integer Position2=0;
        Position2=Integer.parseInt(ClassHelper.getApp_Color_Code2());
        spinner2.setSelection(Position2);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                String _Color1=spinner.getSelectedItem().toString();
                String _Color2=spinner2.getSelectedItem().toString();

                if (_Color1.equals("سبز"))
                {
                    ClassHelper.setApp_Color_Code("0");

                    if (_Color2.equals("روشن"))
                        LayerHead.setBackgroundResource(R.drawable.footergreen);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footergreendark);


                }
                else if (_Color1.equals("آبی"))
                {
                    LayerHead.setBackgroundResource(R.drawable.footerblue);
                    ClassHelper.setApp_Color_Code("1");


                }
                else if (_Color1.equals("قرمز"))
                {
                    LayerHead.setBackgroundResource(R.drawable.footer);
                    ClassHelper.setApp_Color_Code("2");

                }
                else if (_Color1.equals("طلایی"))
                {
                    LayerHead.setBackgroundResource(R.drawable.footergold);
                    ClassHelper.setApp_Color_Code("3");

                }
                else if (_Color1.equals("قهوه ای"))
                {
                    LayerHead.setBackgroundResource(R.drawable.footerbrown);
                    ClassHelper.setApp_Color_Code("4");
                }
                else if (_Color1.equals("سیاه"))
                {
                    LayerHead.setBackgroundResource(R.drawable.footerblack);
                    ClassHelper.setApp_Color_Code("5");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                String _Color1=spinner2.getSelectedItem().toString();

                if (_Color1.equals("روشن"))
                {
                    ClassHelper.setApp_Color_Code2("0");

                }
                else if (_Color1.equals("تیره"))
                {
                    ClassHelper.setApp_Color_Code2("1");
                }

                if (ClassHelper.getApp_Color_Code().equals("0"))
                {
                    if (ClassHelper.getApp_Color_Code2().equals("0"))
                        LayerHead.setBackgroundResource(R.drawable.footergreen);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footergreendark);
                }
                else if (ClassHelper.getApp_Color_Code().equals("1"))
                {
                    if (ClassHelper.getApp_Color_Code2().equals("0"))
                        LayerHead.setBackgroundResource(R.drawable.footerblue);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footerbluedark);
                }
                else if (ClassHelper.getApp_Color_Code().equals("2"))
                {
                    if (ClassHelper.getApp_Color_Code2().equals("0"))
                        LayerHead.setBackgroundResource(R.drawable.footer);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footerdark);
                }

                else if (ClassHelper.getApp_Color_Code().equals("3"))
                {
                    if (ClassHelper.getApp_Color_Code2().equals("0"))
                        LayerHead.setBackgroundResource(R.drawable.footergold);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footergolddark);
                }

                else if (ClassHelper.getApp_Color_Code().equals("4"))
                {
                    if (ClassHelper.getApp_Color_Code2().equals("0"))
                        LayerHead.setBackgroundResource(R.drawable.footerbrown);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
                }

                else if (ClassHelper.getApp_Color_Code().equals("5"))
                {
                    if (ClassHelper.getApp_Color_Code2().equals("0"))
                        LayerHead.setBackgroundResource(R.drawable.footerblack);
                    else
                        LayerHead.setBackgroundResource(R.drawable.footerblackdark);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });



        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = context.getSharedPreferences("Color", context.MODE_PRIVATE).edit();
                editor.putString("Color1", ClassHelper.getApp_Color_Code());
                editor.putString("Color2", ClassHelper.getApp_Color_Code2());
                editor.apply();

                alert.dismiss();

                activity.finishAffinity();
                Intent intent_main=new Intent(context, MainActivity.class);
                activity.startActivity(intent_main);

            }
        });


        Btn_NotOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();

            }
        });


        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


        Btn_NotOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NotOk.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NotOk.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


    }

    public void PasswordSet(final Context context,Activity activity)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_password_set, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final Button Btn_NotOk=(Button) alert.findViewById(R.id.Btn_NotOk);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        final EditText EditText_Pass=(EditText) alert.findViewById(R.id.EditText_Pass);
        final EditText EditText_PassRepeat=(EditText) alert.findViewById(R.id.EditText_PassRepeat);

        Btn_Ok.setTypeface(TextFont);
        Btn_NotOk.setTypeface(TextFont);

        EditText_Pass.setTypeface(TextFont);
        EditText_PassRepeat.setTypeface(TextFont);

        SharedPreferences prefs2 = context.getSharedPreferences("Password", context.MODE_PRIVATE);
        final String _PSW = prefs2.getString("PSW", null);

        if (!_PSW.equals("NO")) {

            Btn_Ok.setEnabled(false);
            EditText_Pass.setEnabled(false);
            EditText_PassRepeat.setEnabled(false);

        }

        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }


        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Pass=EditText_Pass.getText().toString().trim();
                String _PassRepeat=EditText_PassRepeat.getText().toString().trim();

                if (!(_Pass.equals("")) && !(_PassRepeat.equals(""))) {
                    if (_Pass.equals(_PassRepeat)) {
                        SharedPreferences.Editor editor
                                = context.getSharedPreferences("Password", context.MODE_PRIVATE).edit();
                        editor.putString("PSW", _Pass);
                        editor.apply();

                        alert.dismiss();

                    }//if (_Pass.equals(_PassRepeat))
                    else
                    {
                        customToast.ShowCustomToast(context,"تکرار کلمه عبور صحیح نیست");
                    }

                }
                else
                {
                    customToast.ShowCustomToast(context,"اطلاعات کامل نیست");
                }


            }
        });


        Btn_NotOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });


        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



        Btn_NotOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NotOk.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NotOk.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


    }

    public void PasswordChange(final Context context,Activity activity)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_password_change, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final Button Btn_NotOk=(Button) alert.findViewById(R.id.Btn_NotOk);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        final EditText EditText_CurrentPass=(EditText) alert.findViewById(R.id.EditText_CurrentPass);
        final EditText EditText_Pass=(EditText) alert.findViewById(R.id.EditText_Pass);
        final EditText EditText_PassRepeat=(EditText) alert.findViewById(R.id.EditText_PassRepeat);

        Btn_Ok.setTypeface(TextFont);
        Btn_NotOk.setTypeface(TextFont);
        EditText_CurrentPass.setTypeface(TextFont);
        EditText_Pass.setTypeface(TextFont);
        EditText_PassRepeat.setTypeface(TextFont);

        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }

        SharedPreferences prefs2 = context.getSharedPreferences("Password", context.MODE_PRIVATE);
        final String _PSW = prefs2.getString("PSW", null);

        if (_PSW.equals("NO")) {

            Btn_Ok.setEnabled(false);
            EditText_CurrentPass.setEnabled(false);
            EditText_Pass.setEnabled(false);
            EditText_PassRepeat.setEnabled(false);

        }


        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Pass=EditText_CurrentPass.getText().toString().trim();
                String _NewPass=EditText_Pass.getText().toString().trim();
                String _NewPassRepeat=EditText_PassRepeat.getText().toString().trim();

                if(!_Pass.equals("") && !_NewPass.equals("") && !_NewPassRepeat.equals(""))
                {
                    if (_Pass.equals(_PSW))
                    {

                        if (_NewPass.equals(_NewPassRepeat)) {

                            SharedPreferences.Editor editor
                                    = context.getSharedPreferences("Password", context.MODE_PRIVATE).edit();
                            editor.putString("PSW", _NewPass);
                            editor.apply();

                            alert.dismiss();
                        }
                        else
                        {
                            customToast.ShowCustomToast(context,"تکرار کلمه عبور صحیح نیست");
                        }

                    }//if (_Pass.equals(_PSW))
                    else
                    {
                        customToast.ShowCustomToast(context,"کلمه عبور صحیح نیست");
                    }

                }//if(!_Pass.equals("") && !_NewPass.equals("") && !_NewPassRepeat.equals(""))
                else
                {
                    customToast.ShowCustomToast(context,"کلمه عبور را وارد کنید");
                }



            }
        });


        Btn_NotOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });


        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



        Btn_NotOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NotOk.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NotOk.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });

    }

    public void PasswordRemove(final Context context,Activity activity)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_password_remove, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.WHITE);

        } catch (Exception ex) {

        }

        final Button Btn_Ok=(Button) alert.findViewById(R.id.Btn_Ok);
        final Button Btn_NotOk=(Button) alert.findViewById(R.id.Btn_NotOk);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        final Drawable drawable_dark = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = context.getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(context.getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        final EditText EditText_CurrentPass=(EditText) alert.findViewById(R.id.EditText_CurrentPass);

        Btn_Ok.setTypeface(TextFont);
        Btn_NotOk.setTypeface(TextFont);
        EditText_CurrentPass.setTypeface(TextFont);

        if (ClassHelper.getApp_Color_Code().equals("0"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergreen);
            else
                LayerHead.setBackgroundResource(R.drawable.footergreendark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("1"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblue);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbluedark);
        }
        else if (ClassHelper.getApp_Color_Code().equals("2"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footer);
            else
                LayerHead.setBackgroundResource(R.drawable.footerdark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("3"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footergold);
            else
                LayerHead.setBackgroundResource(R.drawable.footergolddark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("4"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerbrown);
            else
                LayerHead.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else if (ClassHelper.getApp_Color_Code().equals("5"))
        {
            if (ClassHelper.getApp_Color_Code2().equals("0"))
                LayerHead.setBackgroundResource(R.drawable.footerblack);
            else
                LayerHead.setBackgroundResource(R.drawable.footerblackdark);
        }

        SharedPreferences prefs2 = context.getSharedPreferences("Password", context.MODE_PRIVATE);
        final String _PSW = prefs2.getString("PSW", null);

        if (_PSW.equals("NO")) {

            Btn_Ok.setEnabled(false);
            EditText_CurrentPass.setEnabled(false);

        }


        Btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Pass=EditText_CurrentPass.getText().toString().trim();

                if(!_Pass.equals(""))
                {
                    if (_Pass.equals(_PSW))
                    {
                        SharedPreferences.Editor editor
                                = context.getSharedPreferences("Password", context.MODE_PRIVATE).edit();
                        editor.putString("PSW", "NO");
                        editor.apply();

                        alert.dismiss();

                    }
                    else
                    {
                        customToast.ShowCustomToast(context,"کلمه عبور صحیح نیست");
                    }
                }
                else
                {
                    customToast.ShowCustomToast(context,"کلمه عبور را وارد کنید");
                }



            }
        });


        Btn_NotOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });


        Btn_Ok.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Ok.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Ok.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



        Btn_NotOk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NotOk.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NotOk.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


    }




}
