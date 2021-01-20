package samaco.idepardazan.phoneplus;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import samaco.idepardazan.phoneplus.Adapter.ViewPagerAdapter;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.GetMaterialDrawer;
import samaco.idepardazan.phoneplus.Common.GetMenuEvent;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Edit_Page1;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Edit_Page2;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Edit_Page3;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Edit_Page4;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Edit_Page5;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Page1;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Page4;


public class ContactsEdit extends ActionBarActivity {

    GetMaterialDrawer getMenuDrawer=new GetMaterialDrawer();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Typeface TextFont;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_edit);

        getMenuDrawer.GetMenuDrawer(this,savedInstanceState);

        ClassHelper.setEdit_Page2(0);
        ClassHelper.setEdit_Page3(0);
        ClassHelper.setEdit_Page4(0);
        ClassHelper.setEdit_Page5(0);

        TextFont= Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        textView=(TextView) findViewById(R.id.TextView);
        textView2=(TextView) findViewById(R.id.TextView2);
        textView3=(TextView) findViewById(R.id.TextView3);
        textView4=(TextView) findViewById(R.id.TextView4);
        textView5=(TextView) findViewById(R.id.TextView5);

        Set_TabLayout();

        tabLayout.setBackgroundColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));

    }

    private void Set_TabLayout()
    {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);



        textView.setText("ویرایش");
        textView.setTypeface(TextFont);

        textView2.setText("تاریخ");
        textView2.setTypeface(TextFont);

        textView3.setText("حساب");
        textView3.setTypeface(TextFont);

        textView4.setText("سایر");
        textView4.setTypeface(TextFont);

        textView5.setText("عکس");
        textView5.setTypeface(TextFont);

        tabLayout.getTabAt(0).setCustomView(textView);
        tabLayout.getTabAt(1).setCustomView(textView2);
        tabLayout.getTabAt(2).setCustomView(textView3);
        tabLayout.getTabAt(3).setCustomView(textView4);
        tabLayout.getTabAt(4).setCustomView(textView5);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_Edit_Page1(),"");
        adapter.addFragment(new Fragment_Edit_Page2(),"");
        adapter.addFragment(new Fragment_Edit_Page3(),"");
        adapter.addFragment(new Fragment_Edit_Page4(),"");
        adapter.addFragment(new Fragment_Edit_Page5(),"");

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

    @Override
    protected void onResume() {
        super.onResume();

        if (ClassHelper.getCheckBackUpdate()==1)
        {
            Set_TabLayout();
            ClassHelper.setCheckBackUpdate(0);

        }//if (ClassHelper.getCheckBackUpdate()==1)

    }



}
