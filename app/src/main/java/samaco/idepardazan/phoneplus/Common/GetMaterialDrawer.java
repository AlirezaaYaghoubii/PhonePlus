package samaco.idepardazan.phoneplus.Common;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import samaco.idepardazan.phoneplus.MainActivity;
import samaco.idepardazan.phoneplus.R;

public class GetMaterialDrawer {

    private AccountHeader headerResult = null;
    public Drawer result = null;
    public ActionBarDrawerToggle mDrawerToggle;
    SettingPage settingPage=new SettingPage();

    public void GetMenuDrawer(final ActionBarActivity actionBarActivity,Bundle savedInstanceState)
    {
        Typeface TextFont
                = Typeface.createFromAsset(actionBarActivity.getApplicationContext().getAssets(), "fonts/BYekan.ttf" );


        final Toolbar toolbar = (Toolbar) actionBarActivity.findViewById(R.id.toolbar);
        toolbar.setTitle("مخاطب پلاس");


        if (ClassHelper.getApp_Color_Code().equals("0")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                toolbar.setBackgroundColor(Color.parseColor("#ff19b46b"));
            else
                toolbar.setBackgroundColor(Color.parseColor("#ff3f8831"));
        }
        else  if (ClassHelper.getApp_Color_Code().equals("1")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                toolbar.setBackgroundColor(Color.parseColor("#ff5e7eae"));
            else
                toolbar.setBackgroundColor(Color.parseColor("#ff5475a6"));
        }
        else  if (ClassHelper.getApp_Color_Code().equals("2")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                toolbar.setBackgroundColor(Color.parseColor("#ffbf6060"));
            else
                toolbar.setBackgroundColor(Color.parseColor("#ffa75454"));
        }

        else  if (ClassHelper.getApp_Color_Code().equals("3")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                toolbar.setBackgroundColor(Color.parseColor("#ffc1bb7e"));
            else
                toolbar.setBackgroundColor(Color.parseColor("#ffb6b075"));
        }

        else  if (ClassHelper.getApp_Color_Code().equals("4")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                toolbar.setBackgroundColor(Color.parseColor("#ffaa5f39"));
            else
                toolbar.setBackgroundColor(Color.parseColor("#ff984d39"));
        }

        else  if (ClassHelper.getApp_Color_Code().equals("5")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                toolbar.setBackgroundColor(Color.parseColor("#ff434343"));
            else
                toolbar.setBackgroundColor(Color.parseColor("#ff2f2f2f"));
        }




        actionBarActivity.setSupportActionBar(toolbar);

        actionBarActivity.getSupportActionBar().setDisplayUseLogoEnabled(true);
        actionBarActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);

        actionBarActivity.getSupportActionBar().setHomeButtonEnabled(true);
        actionBarActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Farsi
        actionBarActivity.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);



        if (ClassHelper.getApp_Color_Code().equals("0")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            headerResult = new AccountHeaderBuilder()
                    .withActivity(actionBarActivity)
                    .withCompactStyle(true)
                    .withSavedInstance(savedInstanceState)
                    .withTextColor(Color.BLACK)
                    .withHeaderBackground(R.drawable.footergreen)
                    .withHeightDp(60)
                    .build();
            else
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footergreendark)
                        .withHeightDp(60)
                        .build();
        }
        else  if (ClassHelper.getApp_Color_Code().equals("1")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            headerResult = new AccountHeaderBuilder()
                    .withActivity(actionBarActivity)
                    .withCompactStyle(true)
                    .withSavedInstance(savedInstanceState)
                    .withTextColor(Color.BLACK)
                    .withHeaderBackground(R.drawable.footerblue)
                    .withHeightDp(60)
                    .build();
            else
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footerbluedark)
                        .withHeightDp(60)
                        .build();
        }
        else  if (ClassHelper.getApp_Color_Code().equals("2")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footer)
                        .withHeightDp(60)
                        .build();
            else
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footerdark)
                        .withHeightDp(60)
                        .build();
        }
        else  if (ClassHelper.getApp_Color_Code().equals("3")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footergold)
                        .withHeightDp(60)
                        .build();
            else
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footergolddark)
                        .withHeightDp(60)
                        .build();
        }
        else  if (ClassHelper.getApp_Color_Code().equals("4")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footerbrown)
                        .withHeightDp(60)
                        .build();
            else
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footerbrowndark)
                        .withHeightDp(60)
                        .build();
        }
        else  if (ClassHelper.getApp_Color_Code().equals("5")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footerblack)
                        .withHeightDp(60)
                        .build();
            else
                headerResult = new AccountHeaderBuilder()
                        .withActivity(actionBarActivity)
                        .withCompactStyle(true)
                        .withSavedInstance(savedInstanceState)
                        .withTextColor(Color.BLACK)
                        .withHeaderBackground(R.drawable.footerblackdark)
                        .withHeightDp(60)
                        .build();
        }





        result = new DrawerBuilder()
                .withActivity(actionBarActivity)
                .withAccountHeader(headerResult)

                .addDrawerItems(

                        new PrimaryDrawerItem().withName("صفحه اصلی").withIcon(FontAwesome.Icon.faw_home)
                                .withTypeface(TextFont).withIdentifier(1),
                        new PrimaryDrawerItem().withName("در مورد برنامه").withIcon(FontAwesome.Icon.faw_windows)
                                .withTypeface(TextFont).withIdentifier(2),
                        new PrimaryDrawerItem().withName("سایر برنامه ها").withIcon(FontAwesome.Icon.faw_book)
                                .withTypeface(TextFont).withIdentifier(3),


                        new SectionDrawerItem().withName("تنظیمات").withTypeface(TextFont),


                        new SecondaryDrawerItem().withName("ساخت فایل پشتیبان").withIcon(FontAwesome.Icon.faw_archive).withTypeface(TextFont)
                                .withEnabled(true).withTypeface(TextFont).withIdentifier(4),
                        new SecondaryDrawerItem().withName("بازگردانی اطلاعات").withIcon(FontAwesome.Icon.faw_folder_open).withTypeface(TextFont)
                                .withEnabled(true).withTypeface(TextFont).withIdentifier(5),

                        new SectionDrawerItem().withName("عمومی").withTypeface(TextFont),
                        new SecondaryDrawerItem().withName("ثبت امتیاز").withIcon(FontAwesome.Icon.faw_camera).withTypeface(TextFont).withEnabled(true)
                                .withTypeface(TextFont).withIdentifier(6),
                        new SecondaryDrawerItem().withName("معرفی به دوستان").withIcon(FontAwesome.Icon.faw_user_plus).withTypeface(TextFont)
                                .withEnabled(true).withIdentifier(7),
                        new SecondaryDrawerItem().withName("برنامه نویس").withIcon(FontAwesome.Icon.faw_user).withTypeface(TextFont)
                                .withEnabled(true).withIdentifier(8),
                        new SecondaryDrawerItem().withName("خروج").withIcon(FontAwesome.Icon.faw_close).withTypeface(TextFont)
                                .withEnabled(true).withIdentifier(9)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                       if (drawerItem != null) {

                                                           int Id = (int) drawerItem.getIdentifier();

                                                           switch (Id) {
                                                               case 1:
                                                                   actionBarActivity.finishAffinity();
                                                                   Intent intent_main = new Intent(actionBarActivity.getApplicationContext(), MainActivity.class);
                                                                   actionBarActivity.startActivity(intent_main);
                                                                   break;
                                                               case 2:
                                                                   settingPage.About_App(actionBarActivity.getApplicationContext(),actionBarActivity);
                                                                   break;
                                                               case 3:
                                                                   settingPage.AppList(actionBarActivity);
                                                                   break;
                                                               case 4:
                                                                   settingPage.GernerateBackup(actionBarActivity.getApplicationContext(),actionBarActivity);
                                                                   break;
                                                               case 5:
                                                                   settingPage.DatabaseRecovery(actionBarActivity.getApplicationContext(),actionBarActivity);
                                                                   break;
                                                               case 6:
                                                                   settingPage.App_Comment(actionBarActivity);
                                                                   break;
                                                               case 7:
                                                                   settingPage.AppShareTo_Others(actionBarActivity);
                                                                   break;
                                                               case 8:
                                                                   settingPage.About_Developer(actionBarActivity.getApplicationContext(),actionBarActivity);
                                                                   break;
                                                               case 9:
                                                                   actionBarActivity.finishAffinity();
                                                                   break;
                                                           }


                                                       }

                                                       if (drawerItem instanceof Nameable) {

                                                           // toolbar.setTitle("کروز موبایل");
                                                       }

                                                       return false;
                                                   }
                                               }

                )
                            .

                    withSavedInstance(savedInstanceState)

                    .

                    build();

                    mDrawerToggle=new

                    ActionBarDrawerToggle(
                            actionBarActivity,
                            result.getDrawerLayout(),

                    R.string.drawer_open,R.string.drawer_close)

                    {


                        public void onDrawerClosed (View view){
                        super.onDrawerClosed(view);
                        actionBarActivity.getSupportActionBar().setTitle("");
                        actionBarActivity.supportInvalidateOptionsMenu();
                    }

                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                        actionBarActivity.getSupportActionBar().setTitle("");
                        actionBarActivity.supportInvalidateOptionsMenu();
                    }

                };

    }


}
