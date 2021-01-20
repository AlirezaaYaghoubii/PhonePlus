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



public class Fragment_Edit_Page3 extends Fragment {

    private View myFragmentView;
    Spinner Spinner_Bank1;
    Spinner Spinner_Bank2;
    LinearLayout linearLayout;

    Button Btn_Save;
    Button Btn_Cancel;
    Button Btn_Telegram;
    Button Btn_ShareWith;

    EditText EditText_AccountId;
    EditText EditText_CardId;
    EditText EditText_AccountId2;
    EditText EditText_CardId2;

    CheckBox CheckBox_UserName;
    CheckBox CheckBox_Phone1;
    CheckBox CheckBox_Phone2;


    CheckBox CheckBox_Bank1;
    CheckBox CheckBox_Hesab1;
    CheckBox CheckBox_Card1;

    CheckBox CheckBox_Bank2;
    CheckBox CheckBox_Hesab2;
    CheckBox CheckBox_Card2;


    Typeface TextFont;

    BusinessContact businessContact=new BusinessContact();
    CustomToast customToast=new CustomToast();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_edit_page3, container, false);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);

        Btn_Save=(Button) myFragmentView.findViewById(R.id.Btn_Save);
        Btn_Cancel=(Button) myFragmentView.findViewById(R.id.Btn_Cancel);
        Btn_Telegram=(Button) myFragmentView.findViewById(R.id.Btn_Telegram);
        Btn_ShareWith=(Button) myFragmentView.findViewById(R.id.Btn_ShareWith);

        EditText_AccountId=(EditText) myFragmentView.findViewById(R.id.EditText_AccountId);
        EditText_CardId=(EditText) myFragmentView.findViewById(R.id.EditText_CardId);
        EditText_AccountId2=(EditText) myFragmentView.findViewById(R.id.EditText_AccountId2);
        EditText_CardId2=(EditText) myFragmentView.findViewById(R.id.EditText_CardId2);

        TextFont= Typeface.createFromAsset(getActivity().getAssets(), "fonts/BYekan.ttf");

        SetComponentsFont();
        SetButtonsColor();
        SetComponentsColor();
        Get_Group_List();
        GetButtonEvent();

        try {

            Bundle extras = getActivity().getIntent().getExtras();

            if (ClassHelper.getEdit_Mode().equals("Edit"))
            {
                String _Bank1=extras.getString("_Bank1");
                String _Bank2=extras.getString("_Bank2");


                EditText_AccountId.setText(extras.getString("_Hesab1"));
                EditText_AccountId2.setText(extras.getString("_Hesab2"));

                EditText_CardId.setText(extras.getString("_Card1"));
                EditText_CardId2.setText(extras.getString("_Card2"));

                if (!_Bank1.equals(""))Spinner_Bank1.setSelection(Integer.parseInt(_Bank1));
                if (!_Bank2.equals(""))Spinner_Bank2.setSelection(Integer.parseInt(_Bank2));


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

        EditText_AccountId.setTypeface(TextFont);
        EditText_CardId.setTypeface(TextFont);
        EditText_AccountId2.setTypeface(TextFont);
        EditText_CardId2.setTypeface(TextFont);

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

    private void Get_Group_List()
    {
        ArrayList<String> List_Group=new ArrayList<>();

        List_Group.add("بانک را انتخاب کنید");
        List_Group.add("ملت");
        List_Group.add("ملی");
        List_Group.add("مسکن");
        List_Group.add("تجارت");
        List_Group.add("صادرات");
        List_Group.add("آینده");
        List_Group.add("انصار");
        List_Group.add("پارسیان");
        List_Group.add("پاسارگاد");
        List_Group.add("سامان");
        List_Group.add("سپه");
        List_Group.add("سرمایه");
        List_Group.add("سینا");
        List_Group.add("شهر");
        List_Group.add("کشاورزی");
        List_Group.add("قوامین");
        List_Group.add("سایر");

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group);

        Spinner_Bank1 = (Spinner) myFragmentView.findViewById(R.id.Spinner_Bank1);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Bank1.setAdapter(dataAdapter);


        ArrayList<String> List_Group2=new ArrayList<>();

        List_Group2.add("بانک را انتخاب کنید");
        List_Group2.add("ملت");
        List_Group2.add("ملی");
        List_Group2.add("مسکن");
        List_Group2.add("تجارت");
        List_Group2.add("صادرات");
        List_Group2.add("آینده");
        List_Group2.add("انصار");
        List_Group2.add("پارسیان");
        List_Group2.add("پاسارگاد");
        List_Group2.add("سامان");
        List_Group2.add("سپه");
        List_Group2.add("سرمایه");
        List_Group2.add("سینا");
        List_Group2.add("شهر");
        List_Group2.add("کشاورزی");
        List_Group2.add("قوامین");
        List_Group2.add("سایر");

        MySpinnerAdapter dataAdapter2 = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group2);

        Spinner_Bank2 = (Spinner) myFragmentView.findViewById(R.id.Spinner_Bank2);

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Bank2.setAdapter(dataAdapter2);

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
        Integer _Id = ClassHelper.getContactId();

        String _Spinner_Bank1=Integer.toString(Spinner_Bank1.getSelectedItemPosition());
        String _Spinner_Bank2=Integer.toString(Spinner_Bank2.getSelectedItemPosition());

        String _AccountId=EditText_AccountId.getText().toString().trim();
        String _AccountId2=EditText_AccountId2.getText().toString().trim();

        String _CardId=EditText_CardId.getText().toString().trim();
        String _CardId2=EditText_CardId2.getText().toString().trim();

        if (_Spinner_Bank1.equals("0"))_Spinner_Bank1="";
        if (_Spinner_Bank2.equals("0"))_Spinner_Bank2="";

        Boolean Check= DataValidation(_Id,_Spinner_Bank1,_Spinner_Bank2,_AccountId
                ,_AccountId2,_CardId,_CardId2);

        if(Check)
        {
            if (!_Spinner_Bank1.equals("") || !_Spinner_Bank2.equals(""))
            {
                businessContact.BusinessContact_UpdateAccount(getContext(),_Id.toString()
                        ,_Spinner_Bank1,_AccountId,_CardId
                        ,_Spinner_Bank2,_AccountId2,_CardId2);

                customToast.ShowCustomToast(getContext(),"تغییرات ثبت شد");
            }
            else
            {
                customToast.ShowCustomToast(getContext(),"تمام آیتم ها خالی است");
            }

        }
    }

    private Boolean DataValidation(Integer _Id,String _Spinner_Bank1,String _Spinner_Bank2
    ,String _AccountId,String _AccountId2,String _CardId,String _CardId2)
    {
        if (_Id==0)
        {
            customToast.ShowCustomToast(getContext(),"مخاطب ثبت نشده است");
            return false;
        }

        if (_Spinner_Bank1.equals(""))
            if (!_AccountId.equals("") || !_CardId.equals(""))
            {
                customToast.ShowCustomToast(getContext(),"بانک را انتخاب کنید");
                return false;
            }

        if (_Spinner_Bank2.equals(""))
            if (!_AccountId2.equals("") || !_CardId2.equals(""))
            {
                customToast.ShowCustomToast(getContext(),"بانک را انتخاب کنید");
                return false;
            }

        if (!_Spinner_Bank1.equals(""))
            if (_AccountId.equals("") && _CardId.equals(""))
            {
                customToast.ShowCustomToast(getContext(),"شماره حساب یا شماره کارت را وارد کنید");
                return false;
            }

        if (!_Spinner_Bank2.equals(""))
            if (_AccountId2.equals("") && _CardId2.equals(""))
            {
                customToast.ShowCustomToast(getContext(),"شماره حساب یا شماره کارت را وارد کنید");
                return false;
            }

        if (!_CardId.equals(""))
            if (_CardId.length()!=16)
            {
                customToast.ShowCustomToast(getContext(),"شماره کارت معتبر نیست");
                return false;
            }

        if (!_CardId2.equals(""))
            if (_CardId2.length()!=16)
            {
                customToast.ShowCustomToast(getContext(),"شماره کارت معتبر نیست");
                return false;
            }


        return true;
    }


    private String GetShareValue(Boolean _UserName,Boolean _Phone1,Boolean _Phone2
            ,Boolean _Bank1,Boolean _Hesab1,Boolean _Card1
            ,Boolean _Bank2,Boolean _Hesab2,Boolean _Card2)
    {
        String Val="";

        EntityContacts entityContacts=businessContact.BusinessContact_Select_Contact(getContext(), ClassHelper.getContactId().toString());

        if (_UserName)
            Val="نام : "+entityContacts.getName();

        if (_Phone1)
            Val=Val+"\n"+"تلفن : "+entityContacts.getMobile1();

        if (_Phone2)
            Val=Val+"\n"+"تلفن دو :"+entityContacts.getMobile2();

        if (_Bank1)
            Val=Val+"\n"+"بانک : "+entityContacts.getBankname1();

        if (_Hesab1)
            Val=Val+"\n"+"شماره حساب : "+entityContacts.getHesab1();

        if (_Card1)
            Val=Val+"\n"+"شماره کارت : " +entityContacts.getCard1();

        if (_Bank2)
            Val=Val+"\n"+"بانک : "+entityContacts.getBankname2();

        if (_Hesab2)
            Val=Val+"\n"+"شماره حساب : "+entityContacts.getHesab2();

        if (_Card2)
            Val=Val+"\n"+"شماره کارت : " +entityContacts.getCard2();

        return Val;
    }

    private String GetCheckedItems()
    {
        Boolean _UserName=false;
        Boolean _Phone1=false;
        Boolean _Phone2=false;

        Boolean _Bank1=false;
        Boolean _Hesab1=false;
        Boolean _Card1=false;

        Boolean _Bank2=false;
        Boolean _Hesab2=false;
        Boolean _Card2=false;

        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Phone1.isChecked())
            _Phone1=true;

        if (CheckBox_Phone2.isChecked())
            _Phone2=true;

        if (CheckBox_Bank1.isChecked())
            _Bank1=true;

        if (CheckBox_Hesab1.isChecked())
            _Hesab1=true;

        if (CheckBox_Card1.isChecked())
            _Card1=true;

        if (CheckBox_Bank2.isChecked())
            _Bank2=true;

        if (CheckBox_Hesab2.isChecked())
            _Hesab2=true;

        if (CheckBox_Card2.isChecked())
            _Card2=true;

        return (GetShareValue(_UserName, _Phone1, _Phone2,_Bank1,_Hesab1,_Card1,_Bank2,_Hesab2,_Card2));
    }

    private void Show_Before_Share(final Activity activity,final String Messenger)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_account_share, null);

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

        CheckBox_Bank1=(CheckBox) alert.findViewById(R.id.CheckBox_Bank1);
        CheckBox_Hesab1=(CheckBox) alert.findViewById(R.id.CheckBox_Hesab1);
        CheckBox_Card1=(CheckBox) alert.findViewById(R.id.CheckBox_Card1);

        CheckBox_Bank2=(CheckBox) alert.findViewById(R.id.CheckBox_Bank2);
        CheckBox_Hesab2=(CheckBox) alert.findViewById(R.id.CheckBox_Hesab2);
        CheckBox_Card2=(CheckBox) alert.findViewById(R.id.CheckBox_Card2);


        CheckBox_UserName.setTypeface(TextFont);
        CheckBox_Phone1.setTypeface(TextFont);
        CheckBox_Phone2.setTypeface(TextFont);

        CheckBox_Bank1.setTypeface(TextFont);
        CheckBox_Hesab1.setTypeface(TextFont);
        CheckBox_Card1.setTypeface(TextFont);

        CheckBox_Bank2.setTypeface(TextFont);
        CheckBox_Hesab2.setTypeface(TextFont);
        CheckBox_Card2.setTypeface(TextFont);

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

        Boolean _Bank1=false;
        Boolean _Hesab1=false;
        Boolean _Card1=false;

        Boolean _Bank2=false;
        Boolean _Hesab2=false;
        Boolean _Card2=false;


        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Phone1.isChecked())
            _Phone1=true;

        if (CheckBox_Phone2.isChecked())
            _Phone2=true;

        if (CheckBox_Bank1.isChecked())
            _Bank1=true;

        if (CheckBox_Hesab1.isChecked())
            _Hesab1=true;

        if (CheckBox_Card1.isChecked())
            _Card1=true;

        if (CheckBox_Bank2.isChecked())
            _Bank2=true;

        if (CheckBox_Hesab2.isChecked())
            _Hesab2=true;

        if (CheckBox_Card2.isChecked())
            _Card2=true;

        TextView_Message.setText(GetShareValue(_UserName,_Phone1,_Phone2,_Bank1,_Hesab1,_Card1,_Bank2,_Hesab2,_Card2));

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

        CheckBox_Bank1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });


        CheckBox_Hesab1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });


        CheckBox_Card1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });

        CheckBox_Bank2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });

        CheckBox_Hesab2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });

        CheckBox_Card2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        if (isVisibleToUser){
            //This means this fragment is visible to user so you can write code to refresh the fragment here by reloaded the data.

            try
            {
                if (ClassHelper.getEdit_Page3()==1)
                {
                    ClassHelper.setEdit_Page3(0);
                    Spinner_Bank1.setSelection(0);
                    Spinner_Bank2.setSelection(0);
                    EditText_AccountId.setText("");
                    EditText_AccountId2.setText("");
                    EditText_CardId.setText("");
                    EditText_CardId2.setText("");
                }
            }
            catch (Exception e)
            {

            }

        }
    }

}

