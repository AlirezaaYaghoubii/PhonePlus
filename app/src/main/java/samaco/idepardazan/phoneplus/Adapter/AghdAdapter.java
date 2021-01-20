package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.ShareUtility;
import samaco.idepardazan.phoneplus.Entities.EntityReport;
import samaco.idepardazan.phoneplus.R;


public class AghdAdapter extends RecyclerView.Adapter<AghdAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityReport> LstReport;
    Typeface TextFont;
    public CheckBox CheckBox_UserName;
    public CheckBox CheckBox_Nesbat;
    public CheckBox CheckBox_Phone;
    public CheckBox CheckBox_BirthDate;
    public CheckBox CheckBox_MiladiDate;
    public CheckBox CheckBox_Sen;
    public CheckBox CheckBox_Mandeh;
    public CheckBox CheckBox_Days;
    public CheckBox CheckBox_Hour;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_NameLabel;
        public TextView TextView_NameData;


        public TextView TextView_NesbatData;

        public TextView TextView_PhoneLabel;
        public TextView TextView_PhoneData;

        public TextView TextView_MiladiLabel;
        public TextView TextView_MiladiData;

        public TextView TextView_CommentData;

        public TextView TextView_TavalodLabel;
        public TextView TextView_TavalodData;

        public TextView TextView_MandehLabel;
        public TextView TextView_MandehData;

        public TextView TextView_DescriptionData;

        public Button Btn_Telegram;
        public Button Btn_ShareWith;


        public MyViewHolder(View view) {
            super(view);

            TextView_NameLabel = (TextView) view.findViewById(R.id.TextView_NameLabel);
            TextView_NameData = (TextView) view.findViewById(R.id.TextView_NameData);

            TextView_PhoneLabel = (TextView) view.findViewById(R.id.TextView_PhoneLabel);
            TextView_PhoneData = (TextView) view.findViewById(R.id.TextView_PhoneData);

            TextView_TavalodLabel = (TextView) view.findViewById(R.id.TextView_TavalodLabel);
            TextView_TavalodData = (TextView) view.findViewById(R.id.TextView_TavalodData);


            TextView_NesbatData = (TextView) view.findViewById(R.id.TextView_NesbatData);

            TextView_CommentData = (TextView) view.findViewById(R.id.TextView_CommentData);


            TextView_MiladiLabel = (TextView) view.findViewById(R.id.TextView_MiladiLabel);
            TextView_MiladiData = (TextView) view.findViewById(R.id.TextView_MiladiData);

            TextView_MandehLabel = (TextView) view.findViewById(R.id.TextView_MandehLabel);
            TextView_MandehData = (TextView) view.findViewById(R.id.TextView_MandehData);

            TextView_DescriptionData = (TextView) view.findViewById(R.id.TextView_DescriptionData);


            Btn_Telegram = (Button) view.findViewById(R.id.Btn_Telegram);
            Btn_ShareWith = (Button) view.findViewById(R.id.Btn_ShareWith);

        }


    }


    public AghdAdapter(Activity _activity, Context _context, ArrayList<EntityReport> _List) {

        activity = _activity;
        this.context = _context;
        this.LstReport = _List;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_aghd, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityReport Itm = LstReport.get(position);

        holder.TextView_NameData.setText(Itm.getName());
        holder.TextView_PhoneData.setText(Itm.getMobile());
        holder.TextView_TavalodData.setText(Itm.get_DateDayName()+" "+Itm.get_DateWithMonthWord());

        String _Value="";

        if (!Itm.getNesbatName().equals(""))
            _Value=Itm.getNesbatName();

        if (!Itm.getNesbat().equals(""))
            if (_Value.equals(""))
                _Value=Itm.getNesbat();
            else
                _Value=_Value+" - "+Itm.getNesbat();

        holder.TextView_NesbatData.setText(_Value);


        holder.TextView_CommentData.setText(Itm.get_DateDiff());
        holder.TextView_MiladiData.setText(Itm.get_DateMiladiWithMonthWord());
        holder.TextView_MandehData.setText(Itm.get_DateDiffMandeh());

        holder.TextView_DescriptionData.setText(Itm.get_DateDiffDay()+"به روز "+"-"+Itm.get_DateDiffHour()+" به ساعت "+"-"+
                Itm.get_DateDiffMinute()+" به دقیقه");


        holder.TextView_NameLabel.setTypeface(TextFont);
        holder.TextView_PhoneLabel.setTypeface(TextFont);
        holder.TextView_TavalodLabel.setTypeface(TextFont);
        holder.TextView_CommentData.setTypeface(TextFont);
        holder.TextView_MiladiLabel.setTypeface(TextFont);
        holder.TextView_MandehLabel.setTypeface(TextFont);
        holder.TextView_DescriptionData.setTypeface(TextFont);


        holder.TextView_NameData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_PhoneData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_TavalodData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_NesbatData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_CommentData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_MiladiData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_MandehData.setTypeface(TextFont, Typeface.BOLD);

        holder.Btn_Telegram.setTypeface(TextFont);
        holder.Btn_ShareWith.setTypeface(TextFont);


        holder.Btn_Telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Show_Before_Share(activity,"Telegram",Itm);

            }
        });

        holder.Btn_ShareWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Show_Before_Share(activity,"ShareWith",Itm);

            }
        });

    }

    @Override
    public int getItemCount() {
        return LstReport.size();
    }

    private String GetShareValue(Boolean _UserName,Boolean _Nesbat,Boolean _Phone
            ,Boolean _BirthDate,Boolean _MiladiDate,Boolean _Sen,Boolean _Mandeh,Boolean _Days,Boolean _Hour,EntityReport Itm)
    {
        String Val = "";

        if (_UserName)
            Val="نام : "+Itm.getName();

        if (_Nesbat && !Itm.getNesbatName().equals(""))
            Val=Val+"\n"+Itm.getNesbatName()+" - "+Itm.getNesbat();

        if (_Phone)
            Val=Val+"\n"+"تلفن : "+Itm.getMobile();

        if (_BirthDate)
            Val=Val+"\n"+"تاریخ عقد : "+Itm.get_DateWithMonthWord();

        if (_MiladiDate)
            Val=Val+"\n"+"تاریخ میلادی : "+Itm.get_DateMiladiWithMonthWord();

        if (_Sen)
            Val=Val+"\n"+"سن : "+Itm.get_DateDiff();

        if (_Mandeh)
            Val=Val+"\n"+"مانده به سالگرد : "+Itm.get_DateDiffMandeh();

        if (_Days)
            Val=Val+"\n"+"سن به روز : "+Itm.get_DateDiffDay();

        if (_Hour)
            Val=Val+"\n"+"سن به ساعت : "+Itm.get_DateDiffHour();

        return Val;
    }

    private String GetCheckedItems(EntityReport Itm)
    {
        Boolean _UserName=false;
        Boolean _Nesbat=false;
        Boolean _Phone=false;
        Boolean _BirthDate=false;
        Boolean _MiladiDate=false;
        Boolean _Sen=false;
        Boolean _Mandeh=false;
        Boolean _Days=false;
        Boolean _Hour=false;

        if (CheckBox_UserName.isChecked())
            _UserName=true;

        if (CheckBox_Nesbat.isChecked())
            _Nesbat=true;

        if (CheckBox_Phone.isChecked())
            _Phone=true;

        if (CheckBox_BirthDate.isChecked())
            _BirthDate=true;

        if (CheckBox_MiladiDate.isChecked())
            _MiladiDate=true;

        if (CheckBox_Sen.isChecked())
            _Sen=true;

        if (CheckBox_Mandeh.isChecked())
            _Mandeh=true;

        if (CheckBox_Days.isChecked())
            _Days=true;

        if (CheckBox_Hour.isChecked())
            _Hour=true;


        return GetShareValue(_UserName,_Nesbat,_Phone
                ,_BirthDate,_MiladiDate,_Sen,_Mandeh,_Days,_Hour,Itm);

    }

    private void Show_Before_Share(final Activity activity,final String Messenger,final EntityReport Itm)
    {
        TextFont= Typeface.createFromAsset(activity.getAssets(), "fonts/BYekan.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final AlertDialog alert = builder.create();

        View view=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
        View view2=alert.getLayoutInflater().inflate(R.layout.item_aghd_share, null);

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


        CheckBox_UserName = (CheckBox) alert.findViewById(R.id.CheckBox_UserName);
        CheckBox_Nesbat = (CheckBox) alert.findViewById(R.id.CheckBox_Nesbat);
        CheckBox_Phone = (CheckBox) alert.findViewById(R.id.CheckBox_Phone);
        CheckBox_BirthDate = (CheckBox) alert.findViewById(R.id.CheckBox_BirthDate);
        CheckBox_MiladiDate = (CheckBox) alert.findViewById(R.id.CheckBox_MiladiDate);
        CheckBox_Sen = (CheckBox) alert.findViewById(R.id.CheckBox_Sen);
        CheckBox_Mandeh = (CheckBox) alert.findViewById(R.id.CheckBox_Mandeh);
        CheckBox_Days = (CheckBox) alert.findViewById(R.id.CheckBox_Days);
        CheckBox_Hour = (CheckBox) alert.findViewById(R.id.CheckBox_Hour);

        CheckBox_UserName.setTypeface(TextFont);
        CheckBox_Nesbat.setTypeface(TextFont);
        CheckBox_Phone.setTypeface(TextFont);
        CheckBox_BirthDate.setTypeface(TextFont);
        CheckBox_MiladiDate.setTypeface(TextFont);
        CheckBox_Sen.setTypeface(TextFont);
        CheckBox_Mandeh.setTypeface(TextFont);
        CheckBox_Days.setTypeface(TextFont);
        CheckBox_Hour.setTypeface(TextFont);

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



        TextView_Message.setText(GetCheckedItems(Itm));

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

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_Nesbat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_Phone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_BirthDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_MiladiDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });


        CheckBox_Sen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_Mandeh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_Days.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

        CheckBox_Hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                TextView_Message.setText(GetCheckedItems(Itm));

            }
        });

    }


}