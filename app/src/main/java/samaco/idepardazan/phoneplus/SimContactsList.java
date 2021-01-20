package samaco.idepardazan.phoneplus;


import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import samaco.idepardazan.phoneplus.Adapter.ViewPagerAdapter;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.GetMaterialDrawer;
import samaco.idepardazan.phoneplus.Common.GetMenuEvent;
import samaco.idepardazan.phoneplus.Fragment.Fragment_ContactsList;
import samaco.idepardazan.phoneplus.Fragment.Fragment_SimContactsList;


public class SimContactsList extends ActionBarActivity {


    GetMaterialDrawer getMenuDrawer=new GetMaterialDrawer();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Typeface TextFont;
    TextView textView;
    Cursor cursor;
    String name, phonenumber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_contacts_list);

        getMenuDrawer.GetMenuDrawer(this,savedInstanceState);


        TextFont= Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        textView=(TextView) findViewById(R.id.TextView);

        Set_TabLayout();
        tabLayout.setBackgroundColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));

    }

    private void SetComponentsColor()
    {
        if (ClassHelper.getApp_Color_Code().equals("0")) {

            //Green

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff19b46b"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff19b46b"));
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff19b46b"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff19b46b"));
            }


        }
        else  if (ClassHelper.getApp_Color_Code().equals("1")) {

            //Blue

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff2863b4"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff2863b4"));
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff4a5b94"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff4a5b94"));
            }



        }
        else  if (ClassHelper.getApp_Color_Code().equals("2")) {

            //Red

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffe40914"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffe40914"));
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffd30914"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffd30914"));
            }


        }

        else  if (ClassHelper.getApp_Color_Code().equals("3")) {

            //Gold

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffeee8aa"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffeee8aa"));
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffd2cc92"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffd2cc92"));
            }



        }

        else  if (ClassHelper.getApp_Color_Code().equals("4")) {

            //Brown

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffc14920"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffc14920"));
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ffb0502d"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffb0502d"));
            }



        }

        else  if (ClassHelper.getApp_Color_Code().equals("5")) {

            //Black

            if (ClassHelper.getApp_Color_Code2().equals("0"))
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff434343"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff434343"));
            }
            else
            {
                tabLayout.setBackgroundColor(Color.parseColor("#ff2f2f2f"));
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ff2f2f2f"));
            }


        }

    }

    private void Set_TabLayout()
    {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        textView.setText("");
        textView.setTypeface(TextFont);
        tabLayout.getTabAt(0).setCustomView(textView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Set_TabLayout();


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_SimContactsList(),"");

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

    public void GetContactsIntoArrayList(){

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            //customToast.ShowCustomToast(getApplicationContext(),"Name : "+name+" Phone : "+phonenumber);

        }

        cursor.close();

    }





}
