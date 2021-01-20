package samaco.idepardazan.phoneplus.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;


import java.lang.reflect.Field;
import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.MainListAdapter4;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Entities.EntityMainList;
import samaco.idepardazan.phoneplus.R;


/**
 * Created by Alireza on 03/31/2017.
 */
public class Fragment_Page4 extends Fragment {

    private View myFragmentView;
    ArrayList<EntityMainList> Itm_MainList = new ArrayList<>();
    GridView gv;
    Activity activity;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        activity=getActivity();




        myFragmentView = inflater.inflate(R.layout.item_fragment_page1, container, false);
        gv = (GridView) myFragmentView.findViewById(R.id.gridView1);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);


        if (ClassHelper.getApp_Color_Code().equals("0")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footergreen);
            else
                linearLayout.setBackgroundResource(R.drawable.footergreendark);
        }
        else  if (ClassHelper.getApp_Color_Code().equals("1")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footerblue);
            else
                linearLayout.setBackgroundResource(R.drawable.footerbluedark);
        }
        else  if (ClassHelper.getApp_Color_Code().equals("2")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footer);
            else
                linearLayout.setBackgroundResource(R.drawable.footerdark);
        }

        else  if (ClassHelper.getApp_Color_Code().equals("3")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footergold);
            else
                linearLayout.setBackgroundResource(R.drawable.footergolddark);
        }

        else  if (ClassHelper.getApp_Color_Code().equals("4")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footerbrown);
            else
                linearLayout.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else  if (ClassHelper.getApp_Color_Code().equals("5")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footerblack);
            else
                linearLayout.setBackgroundResource(R.drawable.footerblack);
        }


        Itm_MainList.clear();
        Get_Main_List();



        return myFragmentView;

    }

    private void Get_Main_List()
    {
        EntityMainList ItmPublic=new EntityMainList();
        ItmPublic.setId("401");
        ItmPublic.setTitle("تنظیم کلمه عبور");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("402");
        ItmPublic.setTitle("تغییر کلمه عبور");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("403");
        ItmPublic.setTitle("حذف کلمه عبور");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("404");
        ItmPublic.setTitle("سایر برنامه ها");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("405");
        ItmPublic.setTitle("ثبت امتیاز");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("406");
        ItmPublic.setTitle("در مورد برنامه");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("407");
        ItmPublic.setTitle("فایل پشتیبان");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("408");
        ItmPublic.setTitle("بازگردانی اطلاعات");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("409");
        ItmPublic.setTitle("تغییر رنگ زمینه");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("410");
        ItmPublic.setTitle("معرفی به دوستان");
        Itm_MainList.add(ItmPublic);


        ItmPublic=new EntityMainList();
        ItmPublic.setId("411");
        ItmPublic.setTitle("برنامه نویس");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("412");
        ItmPublic.setTitle("خروج");
        Itm_MainList.add(ItmPublic);

        MainListAdapter4 mainListAdapter=new MainListAdapter4(getContext(),activity,Itm_MainList);
        gv.setAdapter(mainListAdapter);
    }



}

