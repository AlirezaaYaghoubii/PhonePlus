package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntitySimContacts;
import samaco.idepardazan.phoneplus.R;


public class SimContactsListAdapter extends RecyclerView.Adapter<SimContactsListAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntitySimContacts> ContactsList;
    Typeface TextFont;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_NameLabel;
        public TextView TextView_NameData;

        public TextView TextView_PhoneLabel;
        public TextView TextView_PhoneData;

        public CheckBox CheckBox_Transfer;




        public MyViewHolder(View view) {
            super(view);

            TextView_NameLabel = (TextView) view.findViewById(R.id.TextView_NameLabel);
            TextView_NameData = (TextView) view.findViewById(R.id.TextView_NameData);

            TextView_PhoneLabel = (TextView) view.findViewById(R.id.TextView_PhoneLabel);
            TextView_PhoneData = (TextView) view.findViewById(R.id.TextView_PhoneData);


            CheckBox_Transfer = (CheckBox) view.findViewById(R.id.CheckBox_Transfer);


        }
    }


    public SimContactsListAdapter(Activity _activity, Context _context, ArrayList<EntitySimContacts> _ContactsList) {

        activity = _activity;
        this.context = _context;
        this.ContactsList = _ContactsList;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sim_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final EntitySimContacts Itm = ContactsList.get(position);

        holder.TextView_NameData.setText(Itm.getName());
        holder.TextView_PhoneData.setText(Itm.getPhone());

        if (Itm.getFlag())
            holder.CheckBox_Transfer.setChecked(true);
        else
            holder.CheckBox_Transfer.setChecked(false);




        holder.TextView_NameLabel.setTypeface(TextFont);
        holder.TextView_NameData.setTypeface(TextFont, Typeface.BOLD);

        holder.TextView_PhoneLabel.setTypeface(TextFont);
        holder.TextView_PhoneData.setTypeface(TextFont, Typeface.BOLD);

        holder.CheckBox_Transfer.setTypeface(TextFont,Typeface.BOLD);

        holder.CheckBox_Transfer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (holder.CheckBox_Transfer.isChecked())
                    ClassHelper.SimContactsList.get(position).setFlag(true);
                else
                    ClassHelper.SimContactsList.get(position).setFlag(false);


            }
        });




    }

    @Override
    public int getItemCount() {
        return ContactsList.size();
    }
}
