package samaco.idepardazan.phoneplus.Fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.MySpinnerAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Business.BusinessContactDetails;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.R;



public class Fragment_ContactsDetails_Edit extends Fragment {

    private View myFragmentView;
    LinearLayout linearLayout;

    Button Btn_Save;
    Button Btn_New;
    Button Btn_Delete;
    Button Btn_Cancel;


    Spinner Spinner_Nesbat;
    Spinner Spinner_Title;
    Spinner Spinner_Day;
    Spinner Spinner_Month;


    TextView TextView_ContactName;
    EditText EditText_Name;
    EditText EditText_Year;
    EditText EditText_Comment;

    Typeface TextFont;

    BusinessContact businessContact=new BusinessContact();
    BusinessContactDetails businessContactDetails=new BusinessContactDetails();
    CustomToast customToast=new CustomToast();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_contactdetails_edit, container, false);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);

        Btn_Save=(Button) myFragmentView.findViewById(R.id.Btn_Save);
        Btn_New=(Button) myFragmentView.findViewById(R.id.Btn_New);
        Btn_Delete=(Button) myFragmentView.findViewById(R.id.Btn_Delete);
        Btn_Cancel=(Button) myFragmentView.findViewById(R.id.Btn_Cancel);


        Spinner_Nesbat=(Spinner) myFragmentView.findViewById(R.id.Spinner_Nesbat);
        Spinner_Title=(Spinner) myFragmentView.findViewById(R.id.Spinner_Title);
        Spinner_Day=(Spinner) myFragmentView.findViewById(R.id.Spinner_Day);
        Spinner_Month=(Spinner) myFragmentView.findViewById(R.id.Spinner_Month);


        TextView_ContactName=(TextView) myFragmentView.findViewById(R.id.TextView_ContactName);
        EditText_Name=(EditText) myFragmentView.findViewById(R.id.EditText_Name);
        EditText_Year=(EditText) myFragmentView.findViewById(R.id.EditText_Year);
        EditText_Comment=(EditText) myFragmentView.findViewById(R.id.EditText_Comment);


        TextFont= Typeface.createFromAsset(getActivity().getAssets(), "fonts/BYekan.ttf");

        SetComponentsFont();
        SetComponentsColor();

        GetNesbatList();
        GetDateList();
        GetTitleList();

        SetButtonsColor();
        GetButtonEvent();

        String _ContactName=businessContact.BusinessContact_SelectName(getContext(),ClassHelper.getContactId().toString());
        TextView_ContactName.setText(_ContactName);

        try {

            Bundle extras = getActivity().getIntent().getExtras();

            if (ClassHelper.getDetailsEdit_Mode().equals("Edit"))
            {
                String  TitleDate=extras.getString("_TitleDate");
                String  Name=extras.getString("_Name");
                String  Comment=extras.getString("_Comment");
                String  Nesbat=extras.getString("_Nesbat");
                String  Title=extras.getString("_Title");

                EditText_Comment.setText(Comment);
                EditText_Name.setText(Name);

                Spinner_Title.setSelection(Integer.parseInt(Title));
                Spinner_Nesbat.setSelection(Integer.parseInt(Nesbat));

                if (!TitleDate.equals(""))
                {
                    EditText_Year.setText(TitleDate.substring(0,4));
                    Integer TitleDate_Month=Integer.parseInt(TitleDate.substring(4,6));
                    Integer TitleDate_Day=Integer.parseInt(TitleDate.substring(6,8));

                    Spinner_Day.setSelection(TitleDate_Day);
                    Spinner_Month.setSelection(TitleDate_Month);
                }


            }//if (getEdit_Mode().equals("Edit"))
        }
        catch (Exception e)
        {

        }


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

        Btn_New.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_New.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_New.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });


        Btn_Delete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Delete.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Delete.setBackground(drawable_dark);
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






    }

    private void SetComponentsFont()
    {
        Btn_Save.setTypeface(TextFont);
        Btn_New.setTypeface(TextFont);
        Btn_Delete.setTypeface(TextFont);
        Btn_Cancel.setTypeface(TextFont);


        TextView_ContactName.setTypeface(TextFont);
        EditText_Name.setTypeface(TextFont);
        EditText_Year.setTypeface(TextFont);
        EditText_Comment.setTypeface(TextFont);


    }

    private void GetButtonEvent()
    {

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

        Btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DeleteDate();
            }
        });

        Btn_New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                New_Record();
            }
        });

    }

    private void SaveData()
    {
        Integer Id=0;

        String _Nesbat=Integer.toString(Spinner_Nesbat.getSelectedItemPosition());
        String _Title=Integer.toString(Spinner_Title.getSelectedItemPosition());
        String _Day=Integer.toString(Spinner_Day.getSelectedItemPosition());
        String _Month=Integer.toString(Spinner_Month.getSelectedItemPosition());

        String _Name=EditText_Name.getText().toString().trim();
        String _Year=EditText_Year.getText().toString().trim();
        String _Comment=EditText_Comment.getText().toString().trim();

        if (!_Day.equals("0"))
            if (_Day.length()==1)
                _Day="0"+_Day;

        if (!_Month.equals("0"))
            if (_Month.length()==1)
                _Month="0"+_Month;


        if (!_Year.equals(""))
            if (_Year.length()==2)
                _Year="13"+_Year;


        Boolean Check= DataValidation(_Nesbat,_Title,_Day,_Month,_Year);

        if (Check)
        {
            if (ClassHelper.getDetailsEdit_Mode().equals("New"))
            {
                String _Date=_Year+_Month+_Day;
                String _PersonelList_Id=ClassHelper.getContactId().toString();

                Id = businessContactDetails.BusinessContractDetails_Insert(getContext()
                        ,_PersonelList_Id,_Nesbat,_Name,_Title,_Date,_Comment);

                ClassHelper.setContactDetailsId(Id);

                customToast.ShowCustomToast(getContext(), "ثبت شد");
            }
            else if (ClassHelper.getDetailsEdit_Mode().equals("Edit"))
            {
                String _Date=_Year+_Month+_Day;

                String _Id=ClassHelper.getContactDetailsId().toString();

                businessContactDetails.BusinessContractDetails_Update(getContext(),_Id,_Nesbat,_Name,_Title,_Date,_Comment);

                customToast.ShowCustomToast(getContext(), "تغییرات ثبت شد");
            }


        }//if (Check && ClassHelper.getEdit_Mode().equals("New"))
    }

    private void DeleteDate()
    {
        final String Id=ClassHelper.getContactDetailsId().toString();

        if (!(Id.equals("0"))) {

            Snackbar snackbar = Snackbar
                    .make(getView(), "رکورد جاری حذف شود؟", Snackbar.LENGTH_LONG);

            snackbar.setAction("بلی", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    businessContactDetails.BusinessContractDetails_Delete(getContext(),Id);
                    customToast.ShowCustomToast(getContext(), "حذف شد");
                    getActivity().finish();

                }

            });//snackbar.setAction

            View snackview = snackbar.getView();

            TextView textViewAction = (TextView) snackview.findViewById(android.support.design.R.id.snackbar_action);
            textViewAction.setTextColor(Color.RED);
            textViewAction.setTypeface(TextFont);

            TextView textView = (TextView) snackview.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            textView.setTypeface(TextFont);

            snackbar.show();

        }//if (!(Id.equals("")))

    }

    private void New_Record()
    {
        Snackbar snackbar = Snackbar
                .make(getView(), "آیا شما مطمئن هستید ؟", Snackbar.LENGTH_LONG);

        snackbar.setAction("بلی", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setContactDetailsId(0);
                ClassHelper.setDetailsEdit_Mode("New");

                Spinner_Nesbat.setSelection(0);
                Spinner_Title.setSelection(0);
                Spinner_Month.setSelection(0);
                Spinner_Day.setSelection(0);

                EditText_Name.setText("");
                EditText_Comment.setText("");
                EditText_Year.setText("");

            }

        });//snackbar.setAction

        View snackview = snackbar.getView();

        TextView textViewAction = (TextView) snackview.findViewById(android.support.design.R.id.snackbar_action);
        textViewAction.setTextColor(Color.RED);
        textViewAction.setTypeface(TextFont);

        TextView textView = (TextView) snackview.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        textView.setTypeface(TextFont);

        snackbar.show();
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

    private void GetNesbatList()
    {
        ArrayList<String> List=new ArrayList<>();

        List.add("نسبت را انتخاب کنید");
        List.add("پدر");
        List.add("مادر");
        List.add("برادر");
        List.add("خواهر");
        List.add("همسر");
        List.add("فرزند");
        List.add("پدربزرگ");
        List.add("مادربزرگ");
        List.add("سایر");

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Nesbat.setAdapter(dataAdapter);

    }

    private void GetDateList()
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

        dataAdapter_Month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Month.setAdapter(dataAdapter_Month);

    }

    private void GetTitleList()
    {
        ArrayList<String> List=new ArrayList<>();

        List.add("عنوان را انتخاب کنید");
        List.add("تاریخ تولد");
        List.add("تاریخ عقد");
        List.add("تاریخ ازدواج");
        List.add("تاریخ وفات");
        List.add("سایر");

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Title.setAdapter(dataAdapter);

    }

    private Boolean DataValidation(String Nesbat,String Title,String Day,String Month,String Year)
    {
        if (Nesbat.equals("0"))
        {
            customToast.ShowCustomToast(getContext(),"نسبت را انتخاب کنید");
            return false;
        }

        if (Title.equals("0"))
        {
            customToast.ShowCustomToast(getContext(),"عنوان را انتخاب کنید");
            return false;
        }

        if (Day.equals("0"))
        {
            customToast.ShowCustomToast(getContext(),"روز را وارد کنید");
            return false;
        }

        if (Month.equals("0"))
        {
            customToast.ShowCustomToast(getContext(),"ماه را وارد کنید");
            return false;
        }

        if (Year.equals(""))
        {
            customToast.ShowCustomToast(getContext(),"سال را وارد کنید");
            return false;
        }

        if (!(Year.equals("")))
            if (Year.length()!=4)
            {
                customToast.ShowCustomToast(getContext(),"سال معتبر نیست");
                return false;
            }


        return true;

    }



}