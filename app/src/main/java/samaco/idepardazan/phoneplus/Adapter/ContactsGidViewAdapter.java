package samaco.idepardazan.phoneplus.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.R;



 public class ContactsGidViewAdapter extends BaseAdapter {

        ArrayList<EntityContacts> ContactsList
                =new ArrayList<>();
        Context context;
        private static LayoutInflater inflater=null;
        Typeface TextFont;

        public ContactsGidViewAdapter(Context Activitycontext, ArrayList<EntityContacts> _ContactsList) {

            ContactsList=_ContactsList;
            context=Activitycontext;
            inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            TextFont=Typeface.createFromAsset(context.getAssets(),"fonts/BYekan.ttf");
        }

        @Override
        public int getCount() {

            return ContactsList.size();
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
            TextView Txt_ContactName;
            TextView Txt_ContactPhone;
            CircleImageView img;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            Holder holder=new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.item_grid_view, null);

            holder.Txt_ContactName=(TextView) rowView.findViewById(R.id.Txt_ContactName);
            holder.Txt_ContactPhone=(TextView) rowView.findViewById(R.id.Txt_ContactPhone);
            holder.img=(CircleImageView) rowView.findViewById(R.id.profile_image);

            holder.Txt_ContactName.setText(ContactsList.get(position).getName());
            holder.Txt_ContactPhone.setText(ContactsList.get(position).getMobile1());

            if (!ContactsList.get(position).getPhotoaddress().equals("")) {

                File file=new File(ContactsList.get(position).getPhotoaddress());

                Glide
                        .with(context)
                        .load(file)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into(holder.img);

            }

            else if (ContactsList.get(position).getJensiat().equals("1")) {

                Glide
                        .with(context)
                        .load(R.drawable.user_male)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into(holder.img);

            }
            else if (ContactsList.get(position).getJensiat().equals("2")) {

                Glide
                        .with(context)
                        .load(R.drawable.user_female)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into(holder.img);
            }


            holder.Txt_ContactName.setTypeface(TextFont);
            holder.Txt_ContactPhone.setTypeface(TextFont);


            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    String _Tel= "tel:" +ContactsList.get(position).getMobile1();
                    Intent callIntent = new Intent(Intent.ACTION_VIEW);
                    callIntent.setData(Uri.parse(_Tel));
                    context.startActivity(callIntent);

                }
            });

            return rowView;
        }

    }
