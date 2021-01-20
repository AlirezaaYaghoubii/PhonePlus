package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.R;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityContacts> ContactsList;
    Typeface TextFont;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_TitleLabel;
        public TextView TextView_Mobile1;
        public CircleImageView circleImageView;



        public MyViewHolder(View view) {
            super(view);

            TextView_TitleLabel = (TextView) view.findViewById(R.id.TextView_TitleLabel);
            TextView_Mobile1 = (TextView) view.findViewById(R.id.TextView_Mobile1);
            circleImageView = (CircleImageView) view.findViewById(R.id.profile_image);

        }
    }


    public ContactsListAdapter(Activity _activity, Context _context, ArrayList<EntityContacts> _ContactsList) {

        activity = _activity;
        this.context = _context;
        this.ContactsList = _ContactsList;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityContacts Itm = ContactsList.get(position);

        holder.TextView_TitleLabel.setText(Itm.getName());
        holder.TextView_Mobile1.setText(Itm.getMobile1());


        holder.TextView_Mobile1.setTypeface(TextFont);
        holder.TextView_TitleLabel.setTypeface(TextFont, Typeface.BOLD);

        holder.TextView_TitleLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Tel= "tel:" +Itm.getMobile1();
                Intent callIntent = new Intent(Intent.ACTION_VIEW);
                callIntent.setData(Uri.parse(_Tel));
                activity.startActivity(callIntent);

            }
        });

        holder.TextView_Mobile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Tel= "tel:" +Itm.getMobile1();
                Intent callIntent = new Intent(Intent.ACTION_VIEW);
                callIntent.setData(Uri.parse(_Tel));
                activity.startActivity(callIntent);

            }
        });


        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Tel= "tel:" +Itm.getMobile1();
                Intent callIntent = new Intent(Intent.ACTION_VIEW);
                callIntent.setData(Uri.parse(_Tel));
                activity.startActivity(callIntent);

            }
        });



        if (!ContactsList.get(position).getPhotoaddress().equals("")) {

            File file=new File(ContactsList.get(position).getPhotoaddress());

            Glide
                    .with(context)
                    .load(file)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(holder.circleImageView);

        }

        else if (ContactsList.get(position).getJensiat().equals("1")) {

            Glide
                    .with(context)
                    .load(R.drawable.user_male)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(holder.circleImageView);

        }
        else if (ContactsList.get(position).getJensiat().equals("2")) {

            Glide
                    .with(context)
                    .load(R.drawable.user_female)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .into(holder.circleImageView);
        }


    }

    @Override
    public int getItemCount() {

        return ContactsList.size();
    }
}

