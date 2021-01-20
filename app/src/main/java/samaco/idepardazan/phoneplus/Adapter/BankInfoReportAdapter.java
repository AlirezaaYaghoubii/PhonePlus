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


public class BankInfoReportAdapter extends RecyclerView.Adapter<BankInfoReportAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityContacts> ContactsList;
    Typeface TextFont;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_NameLabel;
        public TextView TextView_NameData;

        public TextView TextView_PhoneLabel;
        public TextView TextView_PhoneData;

        public TextView TextView_BankLabel;
        public TextView TextView_BankData;

        public TextView TextView_HesabIdLabel;
        public TextView TextView_HesabIdData;

        public TextView TextView_CardIdLabel;
        public TextView TextView_CardIdData;

        public TextView TextView_BankLabel2;
        public TextView TextView_BankData2;

        public TextView TextView_HesabIdLabel2;
        public TextView TextView_HesabIdData2;

        public TextView TextView_CardIdLabel2;
        public TextView TextView_CardIdData2;

        public Button Btn_Telegram;
        public Button Btn_ShareWith;



        public MyViewHolder(View view) {
            super(view);

            TextView_NameLabel = (TextView) view.findViewById(R.id.TextView_NameLabel);
            TextView_NameData = (TextView) view.findViewById(R.id.TextView_NameData);

            TextView_PhoneLabel = (TextView) view.findViewById(R.id.TextView_PhoneLabel);
            TextView_PhoneData = (TextView) view.findViewById(R.id.TextView_PhoneData);

            TextView_BankLabel = (TextView) view.findViewById(R.id.TextView_BankLabel);
            TextView_BankData = (TextView) view.findViewById(R.id.TextView_BankData);

            TextView_HesabIdLabel = (TextView) view.findViewById(R.id.TextView_HesabIdLabel);
            TextView_HesabIdData = (TextView) view.findViewById(R.id.TextView_HesabIdData);

            TextView_CardIdLabel = (TextView) view.findViewById(R.id.TextView_CardIdLabel);
            TextView_CardIdData = (TextView) view.findViewById(R.id.TextView_CardIdData);

            TextView_BankLabel2 = (TextView) view.findViewById(R.id.TextView_BankLabel2);
            TextView_BankData2 = (TextView) view.findViewById(R.id.TextView_BankData2);

            TextView_HesabIdLabel2 = (TextView) view.findViewById(R.id.TextView_HesabIdLabel2);
            TextView_HesabIdData2 = (TextView) view.findViewById(R.id.TextView_HesabIdData2);

            TextView_CardIdLabel2 = (TextView) view.findViewById(R.id.TextView_CardIdLabel2);
            TextView_CardIdData2 = (TextView) view.findViewById(R.id.TextView_CardIdData2);

            Btn_Telegram = (Button) view.findViewById(R.id.Btn_Telegram);
            Btn_ShareWith = (Button) view.findViewById(R.id.Btn_ShareWith);


        }


    }


    public BankInfoReportAdapter(Activity _activity, Context _context, ArrayList<EntityContacts> _ContactsList) {

        activity = _activity;
        this.context = _context;
        this.ContactsList = _ContactsList;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bank_info_report, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityContacts Itm = ContactsList.get(position);


        holder.TextView_NameData.setText(Itm.getName());
        holder.TextView_PhoneData.setText(Itm.getMobile1());

        holder.TextView_BankData.setText(Itm.getBankname1());
        holder.TextView_BankData2.setText(Itm.getBankname2());

        holder.TextView_HesabIdData.setText(Itm.getHesab1());
        holder.TextView_HesabIdData2.setText(Itm.getHesab2());

        holder.TextView_CardIdData.setText(Itm.getCard1());
        holder.TextView_CardIdData2.setText(Itm.getCard2());


        holder.TextView_NameLabel.setTypeface(TextFont);
        holder.TextView_PhoneLabel.setTypeface(TextFont);
        holder.TextView_BankLabel.setTypeface(TextFont);
        holder.TextView_BankLabel2.setTypeface(TextFont);
        holder.TextView_HesabIdLabel.setTypeface(TextFont);
        holder.TextView_HesabIdLabel2.setTypeface(TextFont);
        holder.TextView_CardIdLabel.setTypeface(TextFont);
        holder.TextView_CardIdLabel2.setTypeface(TextFont);

        holder.TextView_NameData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_PhoneData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_BankData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_BankData2.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_HesabIdData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_HesabIdData2.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_CardIdData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_CardIdData2.setTypeface(TextFont, Typeface.BOLD);

        holder.Btn_Telegram.setTypeface(TextFont);
        holder.Btn_ShareWith.setTypeface(TextFont);


        holder.Btn_Telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Val = "";
                Val="نام : "+Itm.getName();
                Val=Val+"\n"+"تلفن : "+Itm.getMobile1();

                if (!Itm.getBankname1().equals(""))
                    Val=Val+"\n"+"نام بانک : "+Itm.getBankname1();

                if (!Itm.getHesab1().equals(""))
                    Val=Val+"\n"+"شماره حساب : "+Itm.getHesab1();

                if (!Itm.getCard1().equals(""))
                    Val=Val+"\n"+"شماره کارت : "+Itm.getCard1();

                if (!Itm.getBankname2().equals(""))
                    Val=Val+"\n"+"نام بانک : "+Itm.getBankname2();

                if (!Itm.getHesab2().equals(""))
                    Val=Val+"\n"+"شماره حساب : "+Itm.getHesab2();

                if (!Itm.getCard2().equals(""))
                    Val=Val+"\n"+"شماره کارت : "+Itm.getCard2();

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

                if (!Itm.getBankname1().equals(""))
                    Val=Val+"\n"+"نام بانک : "+Itm.getBankname1();

                if (!Itm.getHesab1().equals(""))
                    Val=Val+"\n"+"شماره حساب : "+Itm.getHesab1();

                if (!Itm.getCard1().equals(""))
                    Val=Val+"\n"+"شماره کارت : "+Itm.getCard1();

                if (!Itm.getBankname2().equals(""))
                    Val=Val+"\n"+"نام بانک : "+Itm.getBankname2();

                if (!Itm.getHesab2().equals(""))
                    Val=Val+"\n"+"شماره حساب : "+Itm.getHesab2();

                if (!Itm.getCard2().equals(""))
                    Val=Val+"\n"+"شماره کارت : "+Itm.getCard2();

                ShareUtility shareUtility=new ShareUtility();
                shareUtility.ShareWith_EveryThing(activity, Val, "اطلاعات حساب");

            }
        });

    }

    @Override
    public int getItemCount() {
        return ContactsList.size();
    }
}
