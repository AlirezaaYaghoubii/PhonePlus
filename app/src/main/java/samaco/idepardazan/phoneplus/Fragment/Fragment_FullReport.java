package samaco.idepardazan.phoneplus.Fragment;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.FullReportAdapter;
import samaco.idepardazan.phoneplus.Adapter.MySpinnerAdapter;
import samaco.idepardazan.phoneplus.Adapter.TavalodAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessReport;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.DateUtility;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntityReport;
import samaco.idepardazan.phoneplus.R;


public class Fragment_FullReport extends Fragment {

    private View myFragmentView;
    private RecyclerView recyclerView;
    private ArrayList<EntityReport> LstRep = new ArrayList();

    private EditText TxtSearch;
    Typeface TextFont;

    FullReportAdapter fullReportAdapter;
    LinearLayout linearLayout;

    BusinessReport businessReport=new BusinessReport();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.content_fullreport, container, false);
        recyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view);
        TxtSearch = (EditText) myFragmentView.findViewById(R.id.TxtSearch);




        linearLayout = (LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);


        TextFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/BYekan.ttf");
        TxtSearch.setTypeface(TextFont);


        fullReportAdapter = new FullReportAdapter(getActivity(), myFragmentView.getContext(), GetList(""));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fullReportAdapter);

        TxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                String _Data=TxtSearch.getText().toString().trim();

                fullReportAdapter = new FullReportAdapter(getActivity(), myFragmentView.getContext(), GetList(_Data));
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(fullReportAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        SetComponentsColor();


        return myFragmentView;
    }


    private ArrayList<EntityContacts> GetList(String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();

        List=businessReport.BusinessReport_FullReport(getContext(), Data);


        return List;
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


}