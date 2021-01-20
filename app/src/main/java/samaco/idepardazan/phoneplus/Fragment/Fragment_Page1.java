package samaco.idepardazan.phoneplus.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import samaco.idepardazan.phoneplus.Adapter.MainListAdapter;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Entities.EntityMainList;
import samaco.idepardazan.phoneplus.R;

public class Fragment_Page1 extends Fragment {

    private View myFragmentView;
    ArrayList<EntityMainList> Itm_MainList=new ArrayList<>();
    GridView gv;
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_fragment_page1, container, false);
        gv=(GridView) myFragmentView.findViewById(R.id.gridView1);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);

        Itm_MainList.clear();
        Get_Main_List();

        SetComponentsColor();
        return myFragmentView;

    }

    private void SetComponentsColor()
    {
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

    }

    private void Get_Main_List()
    {
        EntityMainList ItmPublic=new EntityMainList();
        ItmPublic.setId("101");
        ItmPublic.setTitle("مخاطبین");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("102");
        ItmPublic.setTitle("لیست مخاطبین");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("103");
        ItmPublic.setTitle("جدول مخاطبین");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("104");
        ItmPublic.setTitle("سیم کارت");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("105");
        ItmPublic.setTitle("اطلاعات مخاطب");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("106");
        ItmPublic.setTitle("حساب بانکی");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("107");
        ItmPublic.setTitle("تولد");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("108");
        ItmPublic.setTitle("عقد");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("109");
        ItmPublic.setTitle("ازدواج");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("110");
        ItmPublic.setTitle("وفات");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("111");
        ItmPublic.setTitle("تقویم");
        Itm_MainList.add(ItmPublic);

        ItmPublic=new EntityMainList();
        ItmPublic.setId("112");
        ItmPublic.setTitle("گزارش");
        Itm_MainList.add(ItmPublic);


        MainListAdapter mainListAdapter=new MainListAdapter(getContext(),Itm_MainList);
        gv.setAdapter(mainListAdapter);
    }
}
