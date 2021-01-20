package samaco.idepardazan.phoneplus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import samaco.idepardazan.phoneplus.Adapter.ViewPagerAdapter;
import samaco.idepardazan.phoneplus.Business.GetVersionBu;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.GetMaterialDrawer;
import samaco.idepardazan.phoneplus.Common.GetMenuEvent;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Page1;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Page4;


public class MainActivity extends ActionBarActivity {

    GetMaterialDrawer getMenuDrawer=new GetMaterialDrawer();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Typeface TextFont;
    CustomToast customToast=new CustomToast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClassHelper.setCheckBackUpdate(0);





        SharedPreferences prefs = getSharedPreferences("Color", MODE_PRIVATE);
        String restoredText = prefs.getString("Color1", null);

        if (restoredText != null) {

            ClassHelper.setApp_Color_Code(prefs.getString("Color1",""));
            ClassHelper.setApp_Color_Code2(prefs.getString("Color2",""));

        }
        else {

            SharedPreferences.Editor editor = getSharedPreferences("Color", MODE_PRIVATE).edit();
            editor.putString("Color1", "0");
            editor.putString("Color2", "1");
            editor.apply();

            SharedPreferences prefs2 = getSharedPreferences("Color", MODE_PRIVATE);
            ClassHelper.setApp_Color_Code(prefs2.getString("Color1",""));
            ClassHelper.setApp_Color_Code2(prefs2.getString("Color2",""));
        }


        SharedPreferences prefs2 = getSharedPreferences("Password", MODE_PRIVATE);
        String restoredText2 = prefs2.getString("PSW", null);

        if (restoredText2 == null) {

            SharedPreferences.Editor editor = getSharedPreferences("Password", MODE_PRIVATE).edit();
            editor.putString("PSW", "NO");
            editor.apply();

        }


        getMenuDrawer.GetMenuDrawer(this,savedInstanceState);

        TextFont= Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

        TextView textView;
        TextView textView4;

        textView=(TextView) findViewById(R.id.TextView);
        textView4=(TextView) findViewById(R.id.TextView4);

        textView.setText("منوی اصلی");
        textView.setTypeface(TextFont);


        textView4.setText("تنظیمات");
        textView4.setTypeface(TextFont);

        tabLayout.getTabAt(0).setCustomView(textView);
        tabLayout.getTabAt(1).setCustomView(textView4);


        SetComponentsColor();


        ClassHelper.setDataBase_Name("phonepluse.sqlite");
        GetAppVersion();

        //Delete DataBase
        //DeleteDataBase ddb=new DeleteDataBase();
        //ddb.DeleteIfExists(this);

        String CurrentVersion="";
        GetVersionBu getVersionBu=new GetVersionBu();
        CurrentVersion=getVersionBu.GetCurrentVersion(this);

        ClassHelper.setPasswordCorrect("YES");
        ShowPasswordPage(this);
    }


    private void SetComponentsColor()
    {
        if (ClassHelper.getApp_Color_Code().equals("0")) {

            //Green

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff19b46b"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff19b46b"));

                ClassHelper.setApp_Color_Code_String("#ff19b46b");

            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff3f8831"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff3f8831"));

                //tabLayout.setSelectedTabIndicatorColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));

                ClassHelper.setApp_Color_Code_String("#ff3f8831");
            }


        }
        else  if (ClassHelper.getApp_Color_Code().equals("1")) {

            //Blue

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff5e7eae"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff5e7eae"));

                ClassHelper.setApp_Color_Code_String("#ff5e7eae");
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff5475a6"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff5475a6"));

                ClassHelper.setApp_Color_Code_String("#ff5475a6");
            }



        }
        else  if (ClassHelper.getApp_Color_Code().equals("2")) {

            //Red

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffbf6060"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffbf6060"));

                ClassHelper.setApp_Color_Code_String("#ffbf6060");
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffa75454"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffa75454"));

                ClassHelper.setApp_Color_Code_String("#ffa75454");
            }


        }

        else  if (ClassHelper.getApp_Color_Code().equals("3")) {

            //Gold

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffc1bb7e"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffc1bb7e"));

                ClassHelper.setApp_Color_Code_String("#ffc1bb7e");
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffb6b075"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffb6b075"));

                ClassHelper.setApp_Color_Code_String("#ffb6b075");
            }



        }

        else  if (ClassHelper.getApp_Color_Code().equals("4")) {

            //Brown

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffaa5f39"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffaa5f39"));

                ClassHelper.setApp_Color_Code_String("#ffaa5f39");
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff984d39"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff984d39"));

                ClassHelper.setApp_Color_Code_String("#ff984d39");
            }



        }

        else  if (ClassHelper.getApp_Color_Code().equals("5")) {

            //Black

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff434343"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff434343"));

                ClassHelper.setApp_Color_Code_String("#ff434343");
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff2f2f2f"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff2f2f2f"));

                ClassHelper.setApp_Color_Code_String("#ff2f2f2f");
            }


        }

    }

    public void ShowPasswordPage(final  Activity activity)
    {
        ClassHelper.setPasswordCorrect("NO");

        SharedPreferences prefs2 = getSharedPreferences("Password", MODE_PRIVATE);
        final String _PSW = prefs2.getString("PSW", null);

        if (!_PSW.equals("NO")) {

        TextFont= Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_password_show, null);

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

            final Drawable drawable_dark = getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
            drawable_dark.setColorFilter(new PorterDuffColorFilter(getResources()
                    .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

            final Drawable drawable_light = getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
            drawable_light.setColorFilter(new PorterDuffColorFilter(getResources()
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

            Btn_Ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String _Pass=EditText_CurrentPass.getText().toString().trim();

                    if (_PSW.equals(_Pass)) {

                        ClassHelper.setPasswordCorrect("YES");
                        alert.dismiss();
                    }
                    else
                    {
                        customToast.ShowCustomToast(getApplicationContext(),"کلمه عبور صحیح نیست");
                    }
                }
            });

            Btn_NotOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ClassHelper.setPasswordCorrect("NO");
                    alert.dismiss();
                }
            });


            alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {

                    if (ClassHelper.getPasswordCorrect().equals("NO"))
                        activity.finishAffinity();

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



        }//if (!_PSW.equals("NO"))
    }

    public void GetAppVersion()
    {
        ClassHelper.setAppVersion("1.0.2");
        //ClassHelper.setMarketName("cafebazaar");
        ClassHelper.setMarketName("");
        //ClassHelper.setMarketName("cando");
        //ClassHelper.setMarketName("myket");
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_Page1(),"منوی اصلی");
        adapter.addFragment(new Fragment_Page4(),"تنظیمات");

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (getMenuDrawer.mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        GetMenuEvent getMenuEvent=new GetMenuEvent();
        getMenuEvent.CallMenuEvent(getApplicationContext(),this,item);


        return super.onOptionsItemSelected(item);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getMenuDrawer.mDrawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getMenuDrawer.mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (getMenuDrawer.result != null
                && getMenuDrawer.result.isDrawerOpen()) {
            getMenuDrawer.result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

}
