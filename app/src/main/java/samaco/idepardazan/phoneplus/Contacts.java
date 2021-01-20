package samaco.idepardazan.phoneplus;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import samaco.idepardazan.phoneplus.Adapter.ViewPagerAdapter;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.GetMaterialDrawer;
import samaco.idepardazan.phoneplus.Common.GetMenuEvent;
import samaco.idepardazan.phoneplus.Fragment.Fragment_Contacts;


public class Contacts extends ActionBarActivity {

    GetMaterialDrawer getMenuDrawer=new GetMaterialDrawer();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Typeface TextFont;
    FloatingActionButton Fab_Menu_New;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        getMenuDrawer.GetMenuDrawer(this,savedInstanceState);

        TextFont= Typeface.createFromAsset(getAssets(), "fonts/BYekan.ttf");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        Fab_Menu_New=(FloatingActionButton)findViewById(R.id.Fab_Menu_New);
        textView=(TextView) findViewById(R.id.TextView);

        Set_TabLayout();
        Get_FloatingActionButton();


        tabLayout.setBackgroundColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor(ClassHelper.getApp_Color_Code_String()));
        Fab_Menu_New.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(ClassHelper.getApp_Color_Code_String())));

    }

    private void Set_TabLayout()
    {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        textView.setText("");
        textView.setTypeface(TextFont);
        tabLayout.getTabAt(0).setCustomView(textView);
    }

    private void Get_FloatingActionButton()
    {
        Fab_Menu_New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_main=new Intent(getApplicationContext(), ContactsEdit.class);
                //intent_main.putExtra("EditMode","New");
                ClassHelper.setEdit_Mode("New");
                ClassHelper.setContactId(0);
                startActivity(intent_main);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Set_TabLayout();


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_Contacts(),"");

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
                && getMenuDrawer.result.isDrawerOpen())
        {
            getMenuDrawer.result.closeDrawer();

        }
        else
        {
            super.onBackPressed();
        }
    }

}
