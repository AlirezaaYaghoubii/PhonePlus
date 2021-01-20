package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
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


public class FullReportAdapter extends RecyclerView.Adapter<FullReportAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityContacts> LstReport;
    Typeface TextFont;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_NameLabel;
        public TextView TextView_NameData;

        public TextView TextView_PhoneLabel;
        public TextView TextView_PhoneData;

        public TextView TextView_TavalodLabel;
        public TextView TextView_TavalodData;

        public TextView TextView_AghdLabel;
        public TextView TextView_AghdData;

        public TextView TextView_EzdevajLabel;
        public TextView TextView_EzdevajData;

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

            TextView_AghdLabel = (TextView) view.findViewById(R.id.TextView_AghdLabel);
            TextView_AghdData = (TextView) view.findViewById(R.id.TextView_AghdData);

            TextView_EzdevajLabel = (TextView) view.findViewById(R.id.TextView_EzdevajLabel);
            TextView_EzdevajData = (TextView) view.findViewById(R.id.TextView_EzdevajData);

            Btn_Telegram = (Button) view.findViewById(R.id.Btn_Telegram);
            Btn_ShareWith = (Button) view.findViewById(R.id.Btn_ShareWith);

        }

    }


    public FullReportAdapter(Activity _activity, Context _context, ArrayList<EntityContacts> _List) {

        activity = _activity;
        this.context = _context;
        this.LstReport = _List;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fullreport, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityContacts Itm = LstReport.get(position);

        holder.TextView_NameData.setText(Itm.getName());
        holder.TextView_PhoneData.setText(Itm.getMobile1());

        holder.TextView_TavalodData.setText(Itm.getBirthdate());
        holder.TextView_AghdData.setText(Itm.getAghddate());
        holder.TextView_EzdevajData.setText(Itm.getEzdevajdate());

        holder.TextView_NameLabel.setTypeface(TextFont);
        holder.TextView_PhoneLabel.setTypeface(TextFont);
        holder.TextView_TavalodLabel.setTypeface(TextFont);
        holder.TextView_AghdLabel.setTypeface(TextFont);
        holder.TextView_EzdevajLabel.setTypeface(TextFont);

        holder.TextView_NameData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_PhoneData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_AghdData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_TavalodData.setTypeface(TextFont, Typeface.BOLD);
        holder.TextView_EzdevajData.setTypeface(TextFont, Typeface.BOLD);

        holder.Btn_Telegram.setTypeface(TextFont);
        holder.Btn_ShareWith.setTypeface(TextFont);


        holder.Btn_Telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Val = "";
                Val="نام : "+Itm.getName();
                Val=Val+"\n"+"تلفن : "+Itm.getMobile1();

                if (!Itm.getBirthdate().equals(""))
                    Val=Val+"\n"+"تاریخ تولد : "+Itm.getBirthdate();

                if (!Itm.getAghddate().equals(""))
                    Val=Val+"\n"+"تاریخ عقد : "+Itm.getAghddate();

                if (!Itm.getEzdevajdate().equals(""))
                    Val=Val+"\n"+"تاریخ ازدواج : "+Itm.getEzdevajdate();

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
                    Val=Val+"\n"+"تاریخ تولد : "+Itm.getBirthdate();

                if (!Itm.getAghddate().equals(""))
                    Val=Val+"\n"+"تاریخ عقد : "+Itm.getAghddate();

                if (!Itm.getEzdevajdate().equals(""))
                    Val=Val+"\n"+"تاریخ ازدواج : "+Itm.getEzdevajdate();

                ShareUtility shareUtility=new ShareUtility();
                shareUtility.ShareWith_EveryThing(activity, Val, "مخاطب");

            }
        });

    }

    @Override
    public int getItemCount() {
        return LstReport.size();
    }



}

