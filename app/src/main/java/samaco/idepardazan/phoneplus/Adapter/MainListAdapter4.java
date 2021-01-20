package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Common.SettingPage;
import samaco.idepardazan.phoneplus.Entities.EntityMainList;

import samaco.idepardazan.phoneplus.R;


public class MainListAdapter4 extends BaseAdapter {

    ArrayList<EntityMainList> Itm_MainList
            =new ArrayList<>();
    Context context;
    private static LayoutInflater inflater=null;
    Typeface TextFont;
    Activity activity;
    ActionBarActivity actionBarActivity;


    public MainListAdapter4(Context Activitycontext, Activity _activity, ArrayList<EntityMainList> MainList) {

        Itm_MainList=MainList;
        context=Activitycontext;
        activity=_activity;
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




         if (Itm_MainList.get(position).getId()=="401") {

             //holder.img.setImageResource(R.drawable.bank);

             Glide
                     .with(context)
                     .load(R.drawable.security)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);
         }
        else if (Itm_MainList.get(position).getId()=="402") {

          //   holder.img.setImageResource(R.drawable.person);

             Glide
                     .with(context)
                     .load(R.drawable.lock2)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);

         }
        else if (Itm_MainList.get(position).getId()=="403") {

            // holder.img.setImageResource(R.drawable.about);

             Glide
                     .with(context)
                     .load(R.drawable.unlock)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);
         }
        else if (Itm_MainList.get(position).getId()=="404") {

            // holder.img.setImageResource(R.drawable.market);

             Glide
                     .with(context)
                     .load(R.drawable.market)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);


         }
        else if (Itm_MainList.get(position).getId()=="405") {

            // holder.img.setImageResource(R.drawable.comment);

             Glide
                     .with(context)
                     .load(R.drawable.comment)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);

         }
        else if (Itm_MainList.get(position).getId()=="406") {

            // holder.img.setImageResource(R.drawable.security);

             Glide
                     .with(context)
                     .load(R.drawable.about)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);

         }
         else if (Itm_MainList.get(position).getId()=="407") {

             // holder.img.setImageResource(R.drawable.security);

             Glide
                     .with(context)
                     .load(R.drawable.backup)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);

         }
         else if (Itm_MainList.get(position).getId()=="408") {

             // holder.img.setImageResource(R.drawable.security);

             Glide
                     .with(context)
                     .load(R.drawable.recovery)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);

         }
        else if (Itm_MainList.get(position).getId()=="409") {

          //   holder.img.setImageResource(R.drawable.logout);

             Glide
                     .with(context)
                     .load(R.drawable.changecolor)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);
         }

         else if (Itm_MainList.get(position).getId()=="410") {

             //   holder.img.setImageResource(R.drawable.logout);

             Glide
                     .with(context)
                     .load(R.drawable.people3)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);
         }

         else if (Itm_MainList.get(position).getId()=="411") {

             //   holder.img.setImageResource(R.drawable.logout);

             Glide
                     .with(context)
                     .load(R.drawable.hireandroid)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);
         }

         else if (Itm_MainList.get(position).getId()=="412") {

             //   holder.img.setImageResource(R.drawable.logout);

             Glide
                     .with(context)
                     .load(R.drawable.logout)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(holder.img);
         }

        holder.tv.setTypeface(TextFont);


        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SettingPage settingPage=new SettingPage();

                switch (Itm_MainList.get(position).getId())
                {
                    case  "401":
                        settingPage.PasswordSet(context,activity);
                        break;

                    case  "402":
                        settingPage.PasswordChange(context,activity);
                        break;

                    case  "403":
                        settingPage.PasswordRemove(context,activity);
                        break;


                    case  "404":
                        settingPage.AppList(activity);
                        break;

                    case  "405":
                        settingPage.App_Comment(activity);
                        break;

                    case  "406":
                        settingPage.About_App(context,activity);
                        break;

                    case  "407":
                        settingPage.GernerateBackup(context,activity);
                        break;

                    case  "408":
                        settingPage.DatabaseRecovery(context,activity);
                        break;



                    case  "409":
                        settingPage.ChangeColor(context,activity);
                        break;

                    case  "410":
                        settingPage.AppShareTo_Others(activity);
                        break;

                    case  "411":
                        settingPage.About_Developer(context,activity);
                        break;

                    case  "412":
                        settingPage.Application_Finish(context,activity);
                        break;
                }


            }
        });

        return rowView;
    }

}

