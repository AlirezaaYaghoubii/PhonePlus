package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.ShareUtility;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.R;


public class ContactsInfoReportAdapter extends RecyclerView.Adapter<ContactsInfoReportAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityContacts> ContactsList;
    Typeface TextFont;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_NameLabel;
        public TextView TextView_NameData;

        public TextView TextView_PhoneLabel;
        public TextView TextView_PhoneData;

        public TextView TextView_TavalodLabel;
        public TextView TextView_TavalodData;

        public TextView TextView_MelliIdLabel;
        public TextView TextView_MelliIdData;

        public TextView TextView_ShenasnamehIdLabel;
        public TextView TextView_ShenasnamehIdData;

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

            TextView_MelliIdLabel = (TextView) view.findViewById(R.id.TextView_MelliIdLabel);
            TextView_MelliIdData = (TextView) view.findViewById(R.id.TextView_MelliIdData);

            TextView_ShenasnamehIdLabel = (TextView) view.findViewById(R.id.TextView_ShenasnamehIdLabel);
            TextView_ShenasnamehIdData = (TextView) view.findViewById(R.id.TextView_ShenasnamehIdData);


            Btn_Telegram = (Button) view.findViewById(R.id.Btn_Telegram);
            Btn_ShareWith = (Button) view.findViewById(R.id.Btn_ShareWith);



        }


    }


    public ContactsInfoReportAdapter(Activity _activity, Context _context, ArrayList<EntityContacts> _ContactsList) {

        activity = _activity;
        this.context = _context;
        this.ContactsList = _ContactsList;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacts_info_report, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityContacts Itm = ContactsList.get(position);


        holder.TextView_NameData.setText(Itm.getName());
        holder.TextView_PhoneData.setText(Itm.getMobile1());
        holder.TextView_TavalodData.setText(Itm.getBirthdatewithslash());
        holder.TextView_MelliIdData.setText(Itm.getMellicardid());
        holder.TextView_ShenasnamehIdData.setText(Itm.getShenasnameh());


        holder.TextView_NameLabel.setTypeface(TextFont);
        holder.TextView_PhoneLabel.setTypeface(TextFont);
        holder.TextView_TavalodLabel.setTypeface(TextFont);
        holder.TextView_MelliIdLabel.setTypeface(TextFont);
        holder.TextView_ShenasnamehIdLabel.setTypeface(TextFont);


        holder.TextView_NameData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_PhoneData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_TavalodData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_MelliIdData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_ShenasnamehIdData.setTypeface(TextFont, Typeface.BOLD);

        holder.Btn_Telegram.setTypeface(TextFont);
        holder.Btn_ShareWith.setTypeface(TextFont);

        holder.Btn_Telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Val = "";
                Val="نام : "+Itm.getName();
                Val=Val+"\n"+"تلفن : "+Itm.getMobile1();

                if (!Itm.getBirthdate().equals(""))
                    Val=Val+"\n"+"تاریخ تولد : "+Itm.getBirthdatewithslash();

                if (!Itm.getMellicardid().equals(""))
                    Val=Val+"\n"+"کد ملی : "+Itm.getMellicardid();

                if (!Itm.getShenasnameh().equals(""))
                    Val=Val+"\n"+"شماره شناسنامه : "+Itm.getShenasnameh();

                ShareUtility shareUtility=new ShareUtility();
                shareUtility.ShareWith_Telegram(activity,Val);

            }
        });

        holder.Btn_ShareWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Val = "";
                Val="نام : "+Itm.getName();
                Val=Val+"\n"+"تلفن : "+Itm.getMobile1();

                if (!Itm.getBirthdate().equals(""))
                    Val=Val+"\n"+"تاریخ تولد : "+Itm.getBirthdatewithslash();

                if (!Itm.getMellicardid().equals(""))
                    Val=Val+"\n"+"کد ملی : "+Itm.getMellicardid();

                if (!Itm.getShenasnameh().equals(""))
                    Val=Val+"\n"+"شماره شناسنامه : "+Itm.getShenasnameh();

                ShareUtility shareUtility=new ShareUtility();
                shareUtility.ShareWith_EveryThing(activity, Val, "مخاطب");

            }
        });


    }

    @Override
    public int getItemCount() {
        return ContactsList.size();
    }
}


