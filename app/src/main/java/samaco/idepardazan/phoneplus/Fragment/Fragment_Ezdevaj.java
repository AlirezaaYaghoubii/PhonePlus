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
import samaco.idepardazan.phoneplus.Adapter.EzdevajAdapter;
import samaco.idepardazan.phoneplus.Adapter.MySpinnerAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessReport;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.DateUtility;
import samaco.idepardazan.phoneplus.Entities.EntityReport;
import samaco.idepardazan.phoneplus.R;

public class Fragment_Ezdevaj extends Fragment {

    private View myFragmentView;
    private RecyclerView recyclerView;
    private ArrayList<EntityReport> LstRep = new ArrayList();

    private EditText TxtSearch;
    Typeface TextFont;

    EzdevajAdapter ezdevajAdapter;
    LinearLayout linearLayout;

    BusinessReport businessReport=new BusinessReport();

    Button Btn_NextDays;
    Button Btn_NextMonth;
    Spinner Spinner_Month;
    String Month;
    String _NextDate;
    String _CurrentDate;
    String CurrentMiladi="";
    DateUtility dateUtility=new DateUtility();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.content_ezdevaj, container, false);
        recyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view);
        TxtSearch = (EditText) myFragmentView.findViewById(R.id.TxtSearch);

        Btn_NextDays = (Button) myFragmentView.findViewById(R.id.Btn_NextDays);
        Btn_NextMonth = (Button) myFragmentView.findViewById(R.id.Btn_NextMonth);

        Spinner_Month = (Spinner) myFragmentView.findViewById(R.id.Spinner_Month);


        linearLayout = (LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);


        TextFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/BYekan.ttf");
        TxtSearch.setTypeface(TextFont);
        Btn_NextDays.setTypeface(TextFont);
        Btn_NextMonth.setTypeface(TextFont);

        Month="";
        _NextDate="";
        _CurrentDate="";

        ezdevajAdapter = new EzdevajAdapter(getActivity(), myFragmentView.getContext(), GetList(""));
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(ezdevajAdapter);

        TxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                String _Data=TxtSearch.getText().toString().trim();
                Month=Integer.toString(Spinner_Month.getSelectedItemPosition());

                if (Month.length()==1) Month="0"+Month;
                if (Month.equals("00")) Month="";

                _NextDate="";
                _CurrentDate="";

                ezdevajAdapter = new EzdevajAdapter(getActivity(), myFragmentView.getContext(), GetList(_Data));
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(ezdevajAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Btn_NextDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Data=TxtSearch.getText().toString().trim();
                Month=Integer.toString(Spinner_Month.getSelectedItemPosition());

                if (Month.length()==1) Month="0"+Month;
                if (Month.equals("00")) Month="";



                CurrentMiladi=dateUtility.GetCurrentMiladi();
                _CurrentDate=dateUtility.GetCurrentShamsiDate();
                _NextDate=dateUtility.AddDays(CurrentMiladi,10);


                ezdevajAdapter = new EzdevajAdapter(getActivity(), myFragmentView.getContext(), GetList(_Data));
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(ezdevajAdapter);

            }
        });

        Btn_NextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Data=TxtSearch.getText().toString().trim();
                Month=Integer.toString(Spinner_Month.getSelectedItemPosition());

                if (Month.length()==1) Month="0"+Month;
                if (Month.equals("00")) Month="";


                CurrentMiladi=dateUtility.GetCurrentMiladi();
                _CurrentDate=dateUtility.GetCurrentShamsiDate();
                _NextDate=dateUtility.AddDays(CurrentMiladi,30);


                ezdevajAdapter = new EzdevajAdapter(getActivity(), myFragmentView.getContext(), GetList(_Data));
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(ezdevajAdapter);

            }
        });

        Spinner_Month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String _Data=TxtSearch.getText().toString().trim();
                Month=Integer.toString(Spinner_Month.getSelectedItemPosition());

                if (Month.length()==1) Month="0"+Month;
                if (Month.equals("00")) Month="";
                _NextDate="";


                ezdevajAdapter = new EzdevajAdapter(getActivity(), myFragmentView.getContext(), GetList(_Data));
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(ezdevajAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        SetComponentsColor();
        SetButtonsColor();
        GetMonthList();

        return myFragmentView;
    }

    private void SetButtonsColor()
    {
        final Drawable drawable_dark = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_NextDays.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NextDays.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NextDays.setBackground(drawable_dark);
                        break;

                }

                return false;
            }
        });



        Btn_NextMonth.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NextMonth.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NextMonth.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });




    }

    private ArrayList<EntityReport> GetList(String Data)
    {
        ArrayList<EntityReport> List=new ArrayList<>();

        List=businessReport.BusinessReport_Ezdevaj(getContext(),Data,Month,_NextDate,_CurrentDate);


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

    private void GetMonthList()
    {
        ArrayList<String> List_Group = new ArrayList<>();
        List_Group.add("ماه");
        List_Group.add("فروردین");
        List_Group.add("اردیبهشت");
        List_Group.add("خرداد");
        List_Group.add("تیر");
        List_Group.add("مرداد");
        List_Group.add("شهریور");
        List_Group.add("مهر");
        List_Group.add("آبان");
        List_Group.add("آذر");
        List_Group.add("دی");
        List_Group.add("بهمن");
        List_Group.add("اسفند");

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group);



        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Month.setAdapter(dataAdapter);


    }
}
