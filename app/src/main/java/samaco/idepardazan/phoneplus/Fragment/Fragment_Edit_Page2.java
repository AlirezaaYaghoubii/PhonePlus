package samaco.idepardazan.phoneplus.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.MySpinnerAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.ShareUtility;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.R;



public class Fragment_Edit_Page2 extends Fragment {

    private View myFragmentView;

    Spinner Spinner_Day;
    Spinner Spinner_Month;

    Spinner Spinner_Aghd_Day;
    Spinner Spinner_Aghd_Month;

    Spinner Spinner_Ezdevaj_Day;
    Spinner Spinner_Ezdevaj_Month;

    LinearLayout linearLayout;

    Button Btn_Save;
    Button Btn_Cancel;
    Button Btn_Telegram;
    Button Btn_ShareWith;

    EditText EditText_Birth_Year;
    EditText EditText_Aghd_Year;
    EditText EditText_Ezdevaj_Year;

    TextView TextView_BirthDate;
    TextView TextView_AghdDate;
    TextView TextView_EzdvajDate;

    CheckBox CheckBox_UserName;
    CheckBox CheckBox_Phone1;
    CheckBox CheckBox_Phone2;
    CheckBox CheckBox_BirthDate;
    CheckBox CheckBox_AghadDate;
    CheckBox CheckBox_EzdevajDate;

    Typeface TextFont;

    BusinessContact businessContact=new BusinessContact();
    CustomToast customToast=new CustomToast();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_edit_page2, container, false);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);

        Btn_Save=(Button) myFragmentView.findViewById(R.id.Btn_Save);
        Btn_Cancel=(Button) myFragmentView.findViewById(R.id.Btn_Cancel);
        Btn_Telegram=(Button) myFragmentView.findViewById(R.id.Btn_Telegram);
        Btn_ShareWith=(Button) myFragmentView.findViewById(R.id.Btn_ShareWith);

        EditText_Birth_Year=(EditText) myFragmentView.findViewById(R.id.EditText_Birth_Year);
        EditText_Aghd_Year=(EditText) myFragmentView.findViewById(R.id.EditText_Aghd_Year);
        EditText_Ezdevaj_Year=(EditText) myFragmentView.findViewById(R.id.EditText_Ezdevaj_Year);

        TextView_EzdvajDate=(TextView) myFragmentView.findViewById(R.id.TextView_EzdvajDate);
        TextView_AghdDate=(TextView) myFragmentView.findViewById(R.id.TextView_AghdDate);
        TextView_BirthDate=(TextView) myFragmentView.findViewById(R.id.TextView_BirthDate);

        Spinner_Day = (Spinner) myFragmentView.findViewById(R.id.Spinner_Day);



        TextFont= Typeface.createFromAsset(getActivity().getAssets(), "fonts/BYekan.ttf");

        SetComponentsFont();
        SetComponentsColor();
        SetButtonsColor();
        Get_Group_List();
        Get_Group_List_Aghd();
        Get_Group_List_Ezdevaj();

        GetButtonEvent();

        try {

            Bundle extras = getActivity().getIntent().getExtras();

            if (ClassHelper.getEdit_Mode().equals("Edit"))
            {
                String  Birthdate=extras.getString("_Birthdate");
                String  Aghddate=extras.getString("_Aghddate");
                String  Ezdevajdate=extras.getString("_Ezdevajdate");

                if (!Birthdate.equals(""))
                {
                    EditText_Birth_Year.setText(Birthdate.substring(0,4));
                    Integer Birthdate_Month=Integer.parseInt(Birthdate.substring(4,6));
                    Integer Birthdate_Day=Integer.parseInt(Birthdate.substring(6,8));

                    Spinner_Day.setSelection(Birthdate_Day);
                    Spinner_Month.setSelection(Birthdate_Month);
                }

                if (!Aghddate.equals(""))
                {
                    EditText_Aghd_Year.setText(Aghddate.substring(0,4));
                    Integer Aghddate_Month=Integer.parseInt(Aghddate.substring(4,6));
                    Integer Aghddate_Day=Integer.parseInt(Aghddate.substring(6,8));

                    Spinner_Aghd_Day.setSelection(Aghddate_Month);
                    Spinner_Aghd_Month.setSelection(Aghddate_Day);
                }

                if (!Ezdevajdate.equals(""))
                {
                    EditText_Ezdevaj_Year.setText(Ezdevajdate.substring(0,4));
                    Integer Ezdevajdate_Month=Integer.parseInt(Ezdevajdate.substring(4,6));
                    Integer Ezdevajdate_Day=Integer.parseInt(Ezdevajdate.substring(6,8));

                    Spinner_Ezdevaj_Day.setSelection(Ezdevajdate_Day);
                    Spinner_Ezdevaj_Month.setSelection(Ezdevajdate_Month);
                }

            }//if (getEdit_Mode().equals("Edit"))

        }
        catch (Exception e)
        {

        }

        return myFragmentView;

    }

    private void SetComponentsFont() {

        Btn_Save.setTypeface(TextFont);
        Btn_Cancel.setTypeface(TextFont);
        Btn_Telegram.setTypeface(TextFont);
        Btn_ShareWith.setTypeface(TextFont);

        EditText_Birth_Year.setTypeface(TextFont);
        EditText_Aghd_Year.setTypeface(TextFont);
        EditText_Ezdevaj_Year.setTypeface(TextFont);

        TextView_EzdvajDate.setTypeface(TextFont);
        TextView_AghdDate.setTypeface(TextFont);
        TextView_BirthDate.setTypeface(TextFont);

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

    private void SetButtonsColor()
    {
        final Drawable drawable_dark = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_Save.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Save.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Save.setBackground(drawable_dark);
                        break;

                }

                return false;
            }
        });



        Btn_Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Cancel.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Cancel.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


        Btn_Telegram.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Telegram.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Telegram.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



        Btn_ShareWith.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_ShareWith.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_ShareWith.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });




    }

    private void Get_Group_List()
    {
        ArrayList<String> List_Group=new ArrayList<>();

        List_Group.add("روز");
        List_Group.add("01");
        List_Group.add("02");
        List_Group.add("03");
        List_Group.add("04");
        List_Group.add("05");
        List_Group.add("06");
        List_Group.add("07");
        List_Group.add("08");
        List_Group.add("09");
        List_Group.add("10");
        List_Group.add("11");
        List_Group.add("12");
        List_Group.add("13");
        List_Group.add("14");
        List_Group.add("15");
        List_Group.add("16");
        List_Group.add("17");
        List_Group.add("18");
        List_Group.add("19");
        List_Group.add("20");
        List_Group.add("21");
        List_Group.add("22");
        List_Group.add("23");
        List_Group.add("24");
        List_Group.add("25");
        List_Group.add("26");
        List_Group.add("27");
        List_Group.add("28");
        List_Group.add("29");
        List_Group.add("30");
        List_Group.add("31");


        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group);



        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Day.setAdapter(dataAdapter);


        ArrayList<String> List_Group_Month=new ArrayList<>();
        List_Group_Month.add("ماه");
        List_Group_Month.add("01");
        List_Group_Month.add("02");
        List_Group_Month.add("03");
        List_Group_Month.add("04");
        List_Group_Month.add("05");
        List_Group_Month.add("06");
        List_Group_Month.add("07");
        List_Group_Month.add("08");
        List_Group_Month.add("09");
        List_Group_Month.add("10");
        List_Group_Month.add("11");
        List_Group_Month.add("12");

        MySpinnerAdapter dataAdapter_Month = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group_Month);

        Spinner_Month = (Spinner) myFragmentView.findViewById(R.id.Spinner_Month);

        dataAdapter_Month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Month.setAdapter(dataAdapter_Month);

    }

    private void Get_Group_List_Aghd()
    {
        ArrayList<String> List_Group=new ArrayList<>();

        List_Group.add("روز");
        List_Group.add("01");
        List_Group.add("02");
        List_Group.add("03");
        List_Group.add("04");
        List_Group.add("05");
        List_Group.add("06");
        List_Group.add("07");
        List_Group.add("08");
        List_Group.add("09");
        List_Group.add("10");
        List_Group.add("11");
        List_Group.add("12");
        List_Group.add("13");
        List_Group.add("14");
        List_Group.add("15");
        List_Group.add("16");
        List_Group.add("17");
        List_Group.add("18");
        List_Group.add("19");
        List_Group.add("20");
        List_Group.add("21");
        List_Group.add("22");
        List_Group.add("23");
        List_Group.add("24");
        List_Group.add("25");
        List_Group.add("26");
        List_Group.add("27");
        List_Group.add("28");
        List_Group.add("29");
        List_Group.add("30");
        List_Group.add("31");


        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group);

        Spinner_Aghd_Day = (Spinner) myFragmentView.findViewById(R.id.Spinner_Aghd_Day);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Aghd_Day.setAdapter(dataAdapter);


        ArrayList<String> List_Group_Month=new ArrayList<>();
        List_Group_Month.add("ماه");
        List_Group_Month.add("01");
        List_Group_Month.add("02");
        List_Group_Month.add("03");
        List_Group_Month.add("04");
        List_Group_Month.add("05");
        List_Group_Month.add("06");
        List_Group_Month.add("07");
        List_Group_Month.add("08");
        List_Group_Month.add("09");
        List_Group_Month.add("10");
        List_Group_Month.add("11");
        List_Group_Month.add("12");

        MySpinnerAdapter dataAdapter_Month = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group_Month);

        Spinner_Aghd_Month = (Spinner) myFragmentView.findViewById(R.id.Spinner_Aghd_Month);

        dataAdapter_Month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Aghd_Month.setAdapter(dataAdapter_Month);

    }

    private void Get_Group_List_Ezdevaj()
    {
        ArrayList<String> List_Group=new ArrayList<>();

        List_Group.add("روز");
        List_Group.add("01");
        List_Group.add("02");
        List_Group.add("03");
        List_Group.add("04");
        List_Group.add("05");
        List_Group.add("06");
        List_Group.add("07");
        List_Group.add("08");
        List_Group.add("09");
        List_Group.add("10");
        List_Group.add("11");
        List_Group.add("12");
        List_Group.add("13");
        List_Group.add("14");
        List_Group.add("15");
        List_Group.add("16");
        List_Group.add("17");
        List_Group.add("18");
        List_Group.add("19");
        List_Group.add("20");
        List_Group.add("21");
        List_Group.add("22");
        List_Group.add("23");
        List_Group.add("24");
        List_Group.add("25");
        List_Group.add("26");
        List_Group.add("27");
        List_Group.add("28");
        List_Group.add("29");
        List_Group.add("30");
        List_Group.add("31");


        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group);

        Spinner_Ezdevaj_Day = (Spinner) myFragmentView.findViewById(R.id.Spinner_Ezdevaj_Day);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Ezdevaj_Day.setAdapter(dataAdapter);


        ArrayList<String> List_Group_Month=new ArrayList<>();
        List_Group_Month.add("ماه");
        List_Group_Month.add("01");
        List_Group_Month.add("02");
        List_Group_Month.add("03");
        List_Group_Month.add("04");
        List_Group_Month.add("05");
        List_Group_Month.add("06");
        List_Group_Month.add("07");
        List_Group_Month.add("08");
        List_Group_Month.add("09");
        List_Group_Month.add("10");
        List_Group_Month.add("11");
        List_Group_Month.add("12");

        MySpinnerAdapter dataAdapter_Month = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group_Month);

        Spinner_Ezdevaj_Month = (Spinner) myFragmentView.findViewById(R.id.Spinner_Ezdevaj_Month);

        dataAdapter_Month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Ezdevaj_Month.setAdapter(dataAdapter_Month);

    }

    private void GetButtonEvent() {

        Btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().finish();
            }
        });

        Btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveData();

            }
        });

        Btn_Telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Show_Before_Share(getActivity(),"Telegram");

            }
        });

        Btn_ShareWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Show_Before_Share(getActivity(),"ShareWith");

            }
        });

    }

    private void SaveData()
    {
        Integer _Id=ClassHelper.getContactId();

        String _Spinner_Day=Integer.toString(Spinner_Day.getSelectedItemPosition());
        String _Spinner_Month=Integer.toString(Spinner_Month.getSelectedItemPosition());
        String _Birth_Year=EditText_Birth_Year.getText().toString().trim();

        String _Spinner_Aghd_Day=Integer.toString(Spinner_Aghd_Day.getSelectedItemPosition());
        String _Spinner_Aghd_Month=Integer.toString(Spinner_Aghd_Month.getSelectedItemPosition());
        String _Aghd_Year=EditText_Aghd_Year.getText().toString().trim();

        String _Spinner_Ezdevaj_Day=Integer.toString(Spinner_Ezdevaj_Day.getSelectedItemPosition());
        String _Spinner_Ezdevaj_Month=Integer.toString(Spinner_Ezdevaj_Month.getSelectedItemPosition());
        String _Ezdevaj_Year=EditText_Ezdevaj_Year.getText().toString().trim();


        if (!_Spinner_Day.equals("0"))
            if (_Spinner_Day.length()==1)
                _Spinner_Day="0"+_Spinner_Day;

        if (!_Spinner_Month.equals("0"))
            if (_Spinner_Month.length()==1)
                _Spinner_Month="0"+_Spinner_Month;

        if (!_Birth_Year.equals(""))
            if (_Birth_Year.length()==2)
                _Birth_Year="13"+_Birth_Year;


        if (!_Spinner_Aghd_Day.equals("0"))
            if (_Spinner_Aghd_Day.length()==1)
                _Spinner_Aghd_Day="0"+_Spinner_Aghd_Day;

        if (!_Spinner_Aghd_Month.equals("0"))
            if (_Spinner_Aghd_Month.length()==1)
                _Spinner_Aghd_Month="0"+_Spinner_Aghd_Month;

        if (!_Aghd_Year.equals(""))
            if (_Aghd_Year.length()==2)
                _Aghd_Year="13"+_Aghd_Year;


        if (!_Spinner_Ezdevaj_Day.equals("0"))
            if (_Spinner_Ezdevaj_Day.length()==1)
                _Spinner_Ezdevaj_Day="0"+_Spinner_Ezdevaj_Day;

        if (!_Spinner_Ezdevaj_Month.equals("0"))
            if (_Spinner_Ezdevaj_Month.length()==1)
                _Spinner_Ezdevaj_Month="0"+_Spinner_Ezdevaj_Month;

        if (!_Ezdevaj_Year.equals(""))
            if (_Ezdevaj_Year.length()==2)
                _Ezdevaj_Year="13"+_Ezdevaj_Year;


        Boolean Check= DataValidation(_Id,_Spinner_Day,_Spinner_Month,_Birth_Year
                ,_Spinner_Aghd_Day,_Spinner_Aghd_Month,_Aghd_Year
        ,_Spinner_Ezdevaj_Day,_Spinner_Ezdevaj_Month,_Ezdevaj_Year);

        if(Check)
        {
            String birthdate="";
            String Aghddate="";
            String Ezdevajdate="";

            birthdate=_Birth_Year+_Spinner_Month+_Spinner_Day;
            Aghddate=_Aghd_Year+_Spinner_Aghd_Month+_Spinner_Aghd_Day;
            Ezdevajdate=_Ezdevaj_Year+_Spinner_Ezdevaj_Month+_Spinner_Ezdevaj_Day;

            if (birthdate.equals("00"))birthdate="";
            if (Aghddate.equals("00"))Aghddate="";
            if (Ezdevajdate.equals("00"))Ezdevajdate="";

            if (!birthdate.equals("") || !Aghddate.equals("") || !Ezdevajdate.equals(""))
            {
                businessContact.BusinessContact_UpdateDate(getContext(),_Id.toString()
                        ,birthdate,Aghddate,Ezdevajdate);

                customToast.ShowCustomToast(getContext(),"تغییرات ثبت شد");
            }
            else
            {
                customToast.ShowCustomToast(getContext(),"تمام آیتم ها خالی است");
            }

        }

    }

    private Boolean DataValidation(Integer _Id,String _Spinner_Day,String _Spinner_Month,String _Birth_Year
    ,String _Spinner_Aghd_Day,String _Spinner_Aghd_Month,String _Aghd_Year
            ,String _Spinner_Ezdevaj_Day,String _Spinner_Ezdevaj_Month,String _Ezdevaj_Year)
    {
        if (_Id==0)
        {
            customToast.ShowCustomToast(getContext(),"مخاطب ثبت نشده است");
            return false;
        }

        if (!(_Spinner_Day.equals("0")) || !(_Spinner_Month.equals("0")) || !(_Birth_Year.equals("")))
            if ((_Spinner_Day.equals("0")) || (_Spinner_Month.equals("0")) || (_Birth_Year.equals("")))
        {
            customToast.ShowCustomToast(getContext(),"تاریخ تولد معتبر نیست");
            return false;
        }

        if (!(_Birth_Year.equals("")))
            if (_Birth_Year.length()!=4)
            {
                customToast.ShowCustomToast(getContext(),"سال تولد معتبر نیست");
                return false;
            }

        if (!(_Spinner_Aghd_Day.equals("0")) || !(_Spinner_Aghd_Month.equals("0")) || !(_Aghd_Year.equals("")))
            if ((_Spinner_Aghd_Day.equals("0")) || (_Spinner_Aghd_Month.equals("0")) || (_Aghd_Year.equals("")))
            {
                customToast.ShowCustomToast(getContext(),"تاریخ عقد معتبر نیست");
                return false;
            }

        if (!(_Aghd_Year.equals("")))
            if (_Aghd_Year.length()!=4)
            {
                customToast.ShowCustomToast(getContext(),"سال عقد معتبر نیست");
                return false;
            }


        if (!(_Spinner_Ezdevaj_Day.equals("0")) || !(_Spinner_Ezdevaj_Month.equals("0")) || !(_Ezdevaj_Year.equals("")))
            if ((_Spinner_Ezdevaj_Day.equals("0")) || (_Spinner_Ezdevaj_Month.equals("0")) || (_Ezdevaj_Year.equals("")))
            {
                customToast.ShowCustomToast(getContext(),"تاریخ ازدواج معتبر نیست");
                return false;
            }

        if (!(_Ezdevaj_Year.equals("")))
            if (_Ezdevaj_Year.length()!=4)
            {
                customToast.ShowCustomToast(getContext(),"سال ازدواج معتبر نیست");
                return false;
            }

        return  true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        if (isVisibleToUser){
            //This means this fragment is visible to user so you can write code to refresh the fragment here by reloaded the data.

            try
            {

                if (ClassHelper.getEdit_Page2()==1)
                {
                    ClassHelper.setEdit_Page2(0);

                    Spinner_Day.setSelection(0);
                    Spinner_Month.setSelection(0);
                    Spinner_Aghd_Day.setSelection(0);
                    Spinner_Aghd_Month.setSelection(0);
                    Spinner_Ezdevaj_Day.setSelection(0);
                    Spinner_Ezdevaj_Month.setSelection(0);

                    EditText_Birth_Year.setText("");
                    EditText_Aghd_Year.setText("");
                    EditText_Ezdevaj_Year.setText("");
                }
            }
            catch (Exception e)
            {

            }

        }
    }

    private String GetShareValue(Boolean _UserName,Boolean _Phone1,Boolean _Phone2
            ,Boolean _BirthDate,Boolean _AghadDate,Boolean _EzdevajDate)
    {
        String Val="";

        EntityContacts entityContacts=businessContact.BusinessContact_Select_Contact(getContext(), ClassHelper.getContactId().toString());

        if (_UserName)
            Val="نام : "+entityContacts.getName();

        if (_Phone1)
            Val=Val+"\n"+"تلفن : "+entityContacts.getMobile1();

        if (_Phone2)
            Val=Val+"\n"+"تلفن دو :"+entityContacts.getMobile2();

        if (_BirthDate)
            Val=Val+"\n"+"تاریخ تولد : "+entityContacts.getBirthdatewithslash();

        if (_AghadDate)
            Val=Val+"\n"+"تاریخ عقد : "+entityContacts.getAghddatewithslash();

        if (_EzdevajDate)
            Val=Val+"\n"+"تاریخ ازدواج : " +entityContacts.getEzdevajdatewithslash();

        return Val;
    }

    private String GetCheckedItems()
    {
        Boolean _UserName=false;
        Boolean _Phone1=false;
        Boolean _Phone2=false;
        Boolean _BirthDate=false;
        Boolean _AghadDate=false;
        Boolean _EzdevajDate=false;

        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Phone1.isChecked())
            _Phone1=true;

        if (CheckBox_Phone2.isChecked())
            _Phone2=true;

        if (CheckBox_BirthDate.isChecked())
            _BirthDate=true;

        if (CheckBox_AghadDate.isChecked())
            _AghadDate=true;

        if (CheckBox_EzdevajDate.isChecked())
            _EzdevajDate=true;


        return (GetShareValue(_UserName, _Phone1, _Phone2,_BirthDate,_AghadDate,_EzdevajDate));
    }

    private void Show_Before_Share(final Activity activity,final String Messenger)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_date_share, null);

        alert.setCustomTitle(view);
        alert.setView(view2);

        alert.show();

        try {

            Resources resources = alert.getContext().getResources();

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(Color.GRAY);

        } catch (Exception ex)
        {

        }

        final Button Btn_SendMessage=(Button) alert.findViewById(R.id.Btn_SendMessage);
        final Button Btn_Cancel=(Button) alert.findViewById(R.id.Btn_Cancel);
        final TextView TextView_Message=(TextView) alert.findViewById(R.id.TextView_Message);
        final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

        CheckBox_UserName=(CheckBox) alert.findViewById(R.id.CheckBox_UserName);
        CheckBox_Phone1=(CheckBox) alert.findViewById(R.id.CheckBox_Phone1);
        CheckBox_Phone2=(CheckBox) alert.findViewById(R.id.CheckBox_Phone2);
        CheckBox_BirthDate=(CheckBox) alert.findViewById(R.id.CheckBox_BirthDate);
        CheckBox_AghadDate=(CheckBox) alert.findViewById(R.id.CheckBox_AghadDate);
        CheckBox_EzdevajDate=(CheckBox) alert.findViewById(R.id.CheckBox_EzdevajDate);

        CheckBox_UserName.setTypeface(TextFont);
        CheckBox_Phone1.setTypeface(TextFont);
        CheckBox_Phone2.setTypeface(TextFont);

        CheckBox_BirthDate.setTypeface(TextFont);
        CheckBox_AghadDate.setTypeface(TextFont);
        CheckBox_EzdevajDate.setTypeface(TextFont);

        Btn_SendMessage.setTypeface(TextFont);
        Btn_Cancel.setTypeface(TextFont);

        TextView_Message.setTypeface(TextFont);

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

        Boolean _UserName=false;
        Boolean _Phone1=false;
        Boolean _Phone2=false;
        Boolean _BirthDate=false;
        Boolean _AghadDate=false;
        Boolean _EzdevajDate=false;


        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Phone1.isChecked())
            _Phone1=true;

        if (CheckBox_Phone2.isChecked())
            _Phone2=true;

        if (CheckBox_BirthDate.isChecked())
            _BirthDate=true;

        if (CheckBox_AghadDate.isChecked())
            _AghadDate=true;

        if (CheckBox_EzdevajDate.isChecked())
            _EzdevajDate=true;

        TextView_Message.setText(GetShareValue(_UserName,_Phone1,_Phone2,_BirthDate,_AghadDate,_EzdevajDate));

        Btn_SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();

                if (Messenger=="Telegram")
                {

                    ShareUtility shareUtility=new ShareUtility();
                    shareUtility.ShareWith_Telegram(activity,TextView_Message.getText().toString());
                }
                else  if (Messenger=="ShareWith") {

                    ShareUtility shareUtility=new ShareUtility();
                    shareUtility.ShareWith_EveryThing(activity
                            , TextView_Message.getText().toString(), "مخاطب");
                }

            }
        });

        Btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.dismiss();
            }
        });


        CheckBox_UserName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });

        CheckBox_Phone1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });

        CheckBox_Phone2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });

        CheckBox_BirthDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });


        CheckBox_AghadDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });


        CheckBox_EzdevajDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });
    }




}