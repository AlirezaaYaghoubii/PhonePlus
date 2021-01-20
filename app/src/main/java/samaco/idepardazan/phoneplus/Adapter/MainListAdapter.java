package samaco.idepardazan.phoneplus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Aghd;
import samaco.idepardazan.phoneplus.BankInfoReport;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Contacts;
import samaco.idepardazan.phoneplus.ContactsGridView;
import samaco.idepardazan.phoneplus.ContactsInfoReport;
import samaco.idepardazan.phoneplus.ContactsList;
import samaco.idepardazan.phoneplus.Entities.EntityMainList;
import samaco.idepardazan.phoneplus.Ezdevaj;
import samaco.idepardazan.phoneplus.FullReport;
import samaco.idepardazan.phoneplus.R;
import samaco.idepardazan.phoneplus.SimContactsList;
import samaco.idepardazan.phoneplus.Taghvim;
import samaco.idepardazan.phoneplus.Tavalod;
import samaco.idepardazan.phoneplus.Vafat;

public class MainListAdapter extends BaseAdapter {

    ArrayList<EntityMainList> Itm_MainList
            =new ArrayList<>();
    Context context;
    private static LayoutInflater inflater=null;
    Typeface TextFont;

    public MainListAdapter(Context Activitycontext, ArrayList<EntityMainList> MainList) {

        Itm_MainList=MainList;
        context=Activitycontext;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        TextFont=Typeface.createFromAsset(context.getAssets(),"fonts/BYekan.ttf");
    }

    @Override
    public int getCount() {

        return Itm_MainList.size();
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.item_list_message, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(Itm_MainList.get(position).getTitle());




        if (Itm_MainList.get(position).getId()=="101") {

            //  holder.img.setImageResource(R.drawable.credit_card);

            Glide
                    .with(context)
                    .load(R.drawable.person)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if (Itm_MainList.get(position).getId()=="102") {

            // holder.img.setImageResource(R.drawable.minicar);

            Glide
                    .with(context)
                    .load(R.drawable.contactlist)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if (Itm_MainList.get(position).getId()=="103") {

            //  holder.img.setImageResource(R.drawable.wheel);

            Glide
                    .with(context)
                    .load(R.drawable.ifnetworkzoom)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if (Itm_MainList.get(position).getId()=="104") {

            //holder.img.setImageResource(R.drawable.umbrella);

            Glide
                    .with(context)
                    .load(R.drawable.mysim)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if (Itm_MainList.get(position).getId()=="105") {

            //   holder.img.setImageResource(R.drawable.house);

            Glide
                    .with(context)
                    .load(R.drawable.ifloginmanager)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if (Itm_MainList.get(position).getId()=="106") {

            Glide
                    .with(context)
                    .load(R.drawable.tejaratshetabcard)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }

        else if (Itm_MainList.get(position).getId()=="107") {

            Glide
                    .with(context)
                    .load(R.drawable.photocake)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if (Itm_MainList.get(position).getId()=="108") {

            Glide
                    .with(context)
                    .load(R.drawable.weddingrings)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if (Itm_MainList.get(position).getId()=="109") {

            Glide
                    .with(context)
                    .load(R.drawable.weddingganacheiso)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }

        else if (Itm_MainList.get(position).getId()=="110") {

            Glide
                    .with(context)
                    .load(R.drawable.grave2)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }


        else if (Itm_MainList.get(position).getId()=="111") {

            Glide
                    .with(context)
                    .load(R.drawable.ariaycalander)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }


        else if (Itm_MainList.get(position).getId()=="112") {

            Glide
                    .with(context)
                    .load(R.drawable.reporting)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }



        holder.tv.setTypeface(TextFont);


        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (Itm_MainList.get(position).getId()) {
                    case "101":
                        Intent IntentContacts=new Intent(context, Contacts.class);
                        context.startActivity(IntentContacts);
                        break;

                    case "102":
                        Intent IntentContactsList=new Intent(context, ContactsList.class);
                        context.startActivity(IntentContactsList);
                        break;

                    case "103":
                        Intent IntentContactsGridView=new Intent(context, ContactsGridView.class);
                        context.startActivity(IntentContactsGridView);
                        break;

                    case "104":
                        Intent IntentSim=new Intent(context, SimContactsList.class);
                        context.startActivity(IntentSim);
                        break;

                    case "105":
                        Intent IntentContactsInfoReport=new Intent(context, ContactsInfoReport.class);
                        context.startActivity(IntentContactsInfoReport);
                        break;

                    case "106":
                        Intent IntentBankInfoReport=new Intent(context, BankInfoReport.class);
                        context.startActivity(IntentBankInfoReport);
                        break;

                    case "107":
                        try
                        {
                            Intent IntentTavalod = new Intent(context, Tavalod.class);
                            context.startActivity(IntentTavalod);
                        }
                        catch (Exception e)
                        {
                            CustomToast customToast=new CustomToast();
                            customToast.ShowCustomToast(context,e.getMessage().toString());
                        }
                        break;

                    case "108":
                        Intent IntentAghd=new Intent(context, Aghd.class);
                        context.startActivity(IntentAghd);
                        break;

                    case "109":
                        Intent IntentEzdevaj=new Intent(context, Ezdevaj.class);
                        context.startActivity(IntentEzdevaj);
                        break;

                    case "110":
                        Intent IntentVafat=new Intent(context, Vafat.class);
                        context.startActivity(IntentVafat);
                        break;

                    case "111":
                        Intent IntentTaghvim=new Intent(context, Taghvim.class);
                        context.startActivity(IntentTaghvim);
                        break;

                    case "112":
                        Intent IntentFullReport=new Intent(context, FullReport.class);
                        context.startActivity(IntentFullReport);
                        break;
                }

                }
        });

        return rowView;
    }

}
