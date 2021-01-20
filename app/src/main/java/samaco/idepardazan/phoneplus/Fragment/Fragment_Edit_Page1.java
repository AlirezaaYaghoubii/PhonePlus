package samaco.idepardazan.phoneplus.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

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
import samaco.idepardazan.phoneplus.Common.ImageUtility;
import samaco.idepardazan.phoneplus.Common.ShareUtility;
import samaco.idepardazan.phoneplus.R;


public class Fragment_Edit_Page1 extends Fragment {

    private View myFragmentView;
    Spinner spinner;
    LinearLayout linearLayout;

    Button Btn_Save;
    Button Btn_New;
    Button Btn_Delete;
    Button Btn_Cancel;
    Button Btn_Telegram;
    Button Btn_ShareWith;

    EditText EditText_UserName;
    EditText EditText_Mobile1;
    EditText EditText_Mobile2;
    EditText EditText_Email;
    EditText EditText_WebSite;
    EditText EditText_Address;
    EditText EditText_PostId;
    EditText EditText_ShenasNameh;
    EditText EditText_MelliId;
    EditText EditText_GovahinamehId;

    CheckBox CheckBox_UserName;
    CheckBox CheckBox_Phone1;
    CheckBox CheckBox_Phone2;
    CheckBox CheckBox_PostId;
    CheckBox CheckBox_ShenasNameh;
    CheckBox CheckBox_MelliId;

    Typeface TextFont;

    BusinessContact businessContact=new BusinessContact();
    CustomToast customToast=new CustomToast();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_edit_page1, container, false);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);

        Btn_Save=(Button) myFragmentView.findViewById(R.id.Btn_Save);
        Btn_New=(Button) myFragmentView.findViewById(R.id.Btn_New);
        Btn_Delete=(Button) myFragmentView.findViewById(R.id.Btn_Delete);
        Btn_Cancel=(Button) myFragmentView.findViewById(R.id.Btn_Cancel);
        Btn_Telegram=(Button) myFragmentView.findViewById(R.id.Btn_Telegram);
        Btn_ShareWith=(Button) myFragmentView.findViewById(R.id.Btn_ShareWith);


        EditText_UserName=(EditText) myFragmentView.findViewById(R.id.EditText_UserName);
        EditText_Mobile1=(EditText) myFragmentView.findViewById(R.id.EditText_Mobile1);
        EditText_Mobile2=(EditText) myFragmentView.findViewById(R.id.EditText_Mobile2);
        EditText_Email=(EditText) myFragmentView.findViewById(R.id.EditText_Email);
        EditText_WebSite=(EditText) myFragmentView.findViewById(R.id.EditText_WebSite);
        EditText_Address=(EditText) myFragmentView.findViewById(R.id.EditText_Address);
        EditText_PostId=(EditText) myFragmentView.findViewById(R.id.EditText_PostId);
        EditText_ShenasNameh=(EditText) myFragmentView.findViewById(R.id.EditText_ShenasNameh);
        EditText_MelliId=(EditText) myFragmentView.findViewById(R.id.EditText_MelliId);
        EditText_GovahinamehId=(EditText) myFragmentView.findViewById(R.id.EditText_GovahinamehId);

        TextFont= Typeface.createFromAsset(getActivity().getAssets(), "fonts/BYekan.ttf");


        SetComponentsFont();
        SetComponentsColor();
        Get_Group_List();
        GetButtonEvent();


        try {

            Bundle extras = getActivity().getIntent().getExtras();

            if (ClassHelper.getEdit_Mode().equals("Edit"))
            {

                spinner.setSelection(Integer.parseInt(extras.getString("_Jensiat")));
                EditText_UserName.setText(extras.getString("_Name"));
                EditText_Mobile1.setText(extras.getString("_Mobile1"));
                EditText_Mobile2.setText(extras.getString("_Mobile2"));

                EditText_Email.setText(extras.getString("_Email"));
                EditText_WebSite.setText(extras.getString("_Website"));

                EditText_Address.setText(extras.getString("_Address"));
                EditText_PostId.setText(extras.getString("_Postid"));

                EditText_ShenasNameh.setText(extras.getString("_Shenasnameh"));
                EditText_MelliId.setText(extras.getString("_Mellicardid"));
                EditText_GovahinamehId.setText(extras.getString("_Govahinamehid"));


            }//if (getEdit_Mode().equals("Edit"))
        }
        catch (Exception e)
        {

        }


        return myFragmentView;

    }

    private void SetComponentsFont()
    {
        Btn_Save.setTypeface(TextFont);
        Btn_New.setTypeface(TextFont);
        Btn_Delete.setTypeface(TextFont);
        Btn_Cancel.setTypeface(TextFont);
        Btn_Telegram.setTypeface(TextFont);
        Btn_ShareWith.setTypeface(TextFont);


        EditText_UserName.setTypeface(TextFont);
        EditText_Mobile1.setTypeface(TextFont);
        EditText_Mobile2.setTypeface(TextFont);
        EditText_Email.setTypeface(TextFont);
        EditText_WebSite.setTypeface(TextFont);
        EditText_Address.setTypeface(TextFont);
        EditText_MelliId.setTypeface(TextFont);
        EditText_PostId.setTypeface(TextFont);
        EditText_ShenasNameh.setTypeface(TextFont);
        EditText_GovahinamehId.setTypeface(TextFont);

    }

    private void GetButtonEvent()
    {

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
        String jensiat=Integer.toString(spinner.getSelectedItemPosition());
        String lname=EditText_UserName.getText().toString().trim();
        String phone1=EditText_Mobile1.getText().toString().trim();
        String phone2=EditText_Mobile2.getText().toString().trim();
        String email=EditText_Email.getText().toString().trim();
        String website=EditText_WebSite.getText().toString().trim();
        String address=EditText_Address.getText().toString().trim();
        String postid=EditText_PostId.getText().toString().trim();
        String shenasnameh=EditText_ShenasNameh.getText().toString().trim();
        String mellicardid=EditText_MelliId.getText().toString().trim();
        String govahinamehid=EditText_GovahinamehId.getText().toString().trim();

        Boolean Check= DataValidation(jensiat,lname,phone1);

        if (Check)
        {
            if (ClassHelper.getEdit_Mode().equals("New"))
            {
                Id = businessContact.BusinessContact_Insert(getContext(), lname, phone1, phone2, email, website
                        , address, postid, shenasnameh, mellicardid, govahinamehid, jensiat);

                ClassHelper.setContactId(Id);

                customToast.ShowCustomToast(getContext(), "مخاطب جدید ثبت شد");
            }
            else if (ClassHelper.getEdit_Mode().equals("Edit"))
            {
                String _Id=ClassHelper.getContactId().toString();
                businessContact.BusinessContact_UpdateMain(getContext(),_Id, lname, phone1, phone2, email, website
                        , address, postid, shenasnameh, mellicardid, govahinamehid, jensiat);

                customToast.ShowCustomToast(getContext(), "تغییرات ثبت شد");
            }


        }//if (Check && ClassHelper.getEdit_Mode().equals("New"))
    }

    private void DeleteDate()
    {
        final String Id=ClassHelper.getContactId().toString();

        if (!(Id.equals("0"))) {

            Snackbar snackbar = Snackbar
                    .make(getView(), "مخاطب حذف شود؟", Snackbar.LENGTH_LONG);

            snackbar.setAction("بلی", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    businessContact.BusinessContact_Delete(getContext(),Id);
                    customToast.ShowCustomToast(getContext(), "مخاطب حذف شد");
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

                spinner.setSelection(0);
                EditText_UserName.setText("");
                EditText_Mobile1.setText("");
                EditText_Mobile2.setText("");
                EditText_Email.setText("");
                EditText_WebSite.setText("");
                EditText_Address.setText("");
                EditText_PostId.setText("");
                EditText_ShenasNameh.setText("");
                EditText_MelliId.setText("");
                EditText_GovahinamehId.setText("");

                ClassHelper.setContactId(0);
                ClassHelper.setEdit_Page2(1);
                ClassHelper.setEdit_Page3(1);

                ClassHelper.setEdit_Mode("New");

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

    private void Get_Group_List()
    {
        ArrayList<String> List_Group=new ArrayList<>();

        List_Group.add("جنسیت را انتخاب کنید");
        List_Group.add("مرد");
        List_Group.add("زن");

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(getContext(),
                android.R.layout.simple_spinner_item, List_Group);

        spinner = (Spinner) myFragmentView.findViewById(R.id.Spinner_Sex);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    private Boolean DataValidation(String jensiat,String lname,String phone1)
    {
        if (jensiat.equals("0"))
        {
            customToast.ShowCustomToast(getContext(),"جنسیت را انتخاب کنید");
            return false;
        }

        if (lname.equals(""))
        {
            customToast.ShowCustomToast(getContext(),"نام مخاطب را وارد کنید");
            return false;
        }

        if (phone1.equals(""))
        {
            customToast.ShowCustomToast(getContext(),"تلفن مخاطب را وارد کنید");
            return false;
        }


        return true;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        if (isVisibleToUser){
            //This means this fragment is visible to user so you can write code to refresh the fragment here by reloaded the data.

            try
            {

            }
            catch (Exception e)
            {

            }

        }
    }

    private String GetShareValue(Boolean _UserName,Boolean _Phone1,Boolean _Phone2
            ,Boolean _PostId,Boolean _ShenasNameh,Boolean _MelliId)
    {
        String Val="";

        String Text_UserName=EditText_UserName.getText().toString();
        String Text_Mobile1=EditText_Mobile1.getText().toString();
        String Text_Mobile2=EditText_Mobile2.getText().toString();

        String Text_PostId=EditText_PostId.getText().toString();
        String Text_ShenasNameh=EditText_ShenasNameh.getText().toString();
        String Text_MelliId=EditText_MelliId.getText().toString();


        if (_UserName)
            Val="نام : "+Text_UserName;

        if (_Phone1)
            Val=Val+"\n"+"تلفن : "+Text_Mobile1;

        if (_Phone2)
            Val=Val+"\n"+"تلفن دو :"+Text_Mobile2;

        if (_PostId)
            Val=Val+"\n"+" کد پستی : "+Text_PostId;

        if (_ShenasNameh)
            Val=Val+"\n"+"شماره شناسنامه : "+Text_ShenasNameh;

        if (_MelliId)
            Val=Val+"\n"+"کد ملی : " +Text_MelliId;


        return Val;
    }

    private void Show_Before_Share(final Activity activity,final String Messenger)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_contacts_share, null);

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
        CheckBox_PostId=(CheckBox) alert.findViewById(R.id.CheckBox_PostId);
        CheckBox_ShenasNameh=(CheckBox) alert.findViewById(R.id.CheckBox_ShenasNameh);
        CheckBox_MelliId=(CheckBox) alert.findViewById(R.id.CheckBox_MelliId);

        CheckBox_UserName.setTypeface(TextFont);
        CheckBox_Phone1.setTypeface(TextFont);
        CheckBox_Phone2.setTypeface(TextFont);

        CheckBox_PostId.setTypeface(TextFont);
        CheckBox_ShenasNameh.setTypeface(TextFont);
        CheckBox_MelliId.setTypeface(TextFont);

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
        Boolean _PostId=false;
        Boolean _ShenasNameh=false;
        Boolean _MelliId=false;


        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Phone1.isChecked())
            _Phone1=true;

        if (CheckBox_Phone2.isChecked())
            _Phone2=true;

        if (CheckBox_PostId.isChecked())
            _PostId=true;

        if (CheckBox_ShenasNameh.isChecked())
            _ShenasNameh=true;

        if (CheckBox_MelliId.isChecked())
            _MelliId=true;

        TextView_Message.setText(GetShareValue(_UserName,_Phone1,_Phone2,_PostId,_ShenasNameh,_MelliId));

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

        CheckBox_PostId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });


        CheckBox_ShenasNameh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });


        CheckBox_MelliId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems());

            }
        });
    }

    private String GetCheckedItems()
    {
        Boolean _UserName=false;
        Boolean _Phone1=false;
        Boolean _Phone2=false;
        Boolean _PostId=false;
        Boolean _ShenasNameh=false;
        Boolean _MelliId=false;

        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Phone1.isChecked())
            _Phone1=true;

        if (CheckBox_Phone2.isChecked())
            _Phone2=true;

        if (CheckBox_PostId.isChecked())
            _PostId=true;

        if (CheckBox_ShenasNameh.isChecked())
            _ShenasNameh=true;

        if (CheckBox_MelliId.isChecked())
            _MelliId=true;


        return (GetShareValue(_UserName, _Phone1, _Phone2,_PostId,_ShenasNameh,_MelliId));
    }

}
