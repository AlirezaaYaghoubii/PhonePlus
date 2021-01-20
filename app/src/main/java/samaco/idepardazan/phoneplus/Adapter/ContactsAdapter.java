package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.ClipBoardClass;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.ShareUtility;
import samaco.idepardazan.phoneplus.ContactsEdit;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.R;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityContacts> ContactsList;
    Typeface TextFont;
    BusinessContact businessContact=new BusinessContact();
    CustomToast customToast=new CustomToast();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_TitleLabel;
        public TextView TextView_Mobile1;
        public CircleImageView circleImageView;

        public ImageView ImageViewOPenMenu;
        public ImageView ImageViewMobile;
        public ImageView ImageViewSms;

        public LinearLayout LinearLayoutOPenMenu;
        public LinearLayout LinearLayoutCall;
        public LinearLayout LinearLayoutSendSms;


        public MyViewHolder(View view) {
            super(view);

            TextView_TitleLabel = (TextView) view.findViewById(R.id.TextView_TitleLabel);
            TextView_Mobile1 = (TextView) view.findViewById(R.id.TextView_Mobile1);
            circleImageView = (CircleImageView) view.findViewById(R.id.profile_image);

            ImageViewOPenMenu = (ImageView) view.findViewById(R.id.ImageViewOPenMenu);
            ImageViewMobile = (ImageView) view.findViewById(R.id.ImageViewMobile);
            ImageViewSms = (ImageView) view.findViewById(R.id.ImageViewSms);

            LinearLayoutOPenMenu = (LinearLayout) view.findViewById(R.id.LinearLayoutOPenMenu);
            LinearLayoutCall = (LinearLayout) view.findViewById(R.id.LinearLayoutCall);
            LinearLayoutSendSms = (LinearLayout) view.findViewById(R.id.LinearLayoutSendSms);

        }
    }


    public ContactsAdapter(Activity _activity, Context _context, ArrayList<EntityContacts> _ContactsList) {

        activity = _activity;
        this.context = _context;
        this.ContactsList = _ContactsList;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacts, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityContacts Itm = ContactsList.get(position);

        holder.TextView_TitleLabel.setText(Itm.getName());
        holder.TextView_Mobile1.setText(Itm.getMobile1());

        holder.TextView_Mobile1.setTypeface(TextFont);
        holder.TextView_TitleLabel.setTypeface(TextFont, Typeface.BOLD);

       holder.LinearLayoutCall.setOnClickListener(new View.OnClickListener() {
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


        holder.LinearLayoutSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _Tel=Itm.getMobile1();
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", _Tel);
                smsIntent.putExtra("sms_body", "");
                activity.startActivity(smsIntent);
            }
        });


        holder.LinearLayoutOPenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final AlertDialog alert = builder.create();

                View view1=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
                View view2=alert.getLayoutInflater().inflate(R.layout.item_contact_menu, null);

                alert.setCustomTitle(view1);
                alert.setView(view2);

                alert.show();

                try {

                    Resources resources = alert.getContext().getResources();

                    int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
                    View titleDivider = alert.getWindow().getDecorView().findViewById(titleDividerId);
                    titleDivider.setBackgroundColor(Color.WHITE);

                } catch (Exception ex) {

                }

                Button Btn_Clipboard=(Button) alert.findViewById(R.id.Btn_Clipboard);
                Button Btn_ShareWith=(Button) alert.findViewById(R.id.Btn_ShareWith);
                Button Btn_Telegram=(Button) alert.findViewById(R.id.Btn_Telegram);
                Button Btn_Cancel=(Button) alert.findViewById(R.id.Btn_Cancel);
                Button Btn_Edit=(Button) alert.findViewById(R.id.Btn_Edit);
                Button Btn_Delete=(Button) alert.findViewById(R.id.Btn_Delete);
                final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

                final ShareUtility shareUtility=new ShareUtility();

                Btn_Clipboard.setTypeface(TextFont);
                Btn_ShareWith.setTypeface(TextFont);
                Btn_Telegram.setTypeface(TextFont);
                Btn_Cancel.setTypeface(TextFont);
                Btn_Edit.setTypeface(TextFont);
                Btn_Delete.setTypeface(TextFont);


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


                Btn_Clipboard.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {

                        alert.dismiss();
                        String text = Itm.getName()+"\n"+Itm.getMobile1();
                        ClipBoardClass clipBoardClass=new ClipBoardClass();
                        clipBoardClass.Set_Clipboard(context,text);
                    }
                });



                Btn_Telegram.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alert.dismiss();
                        String text = Itm.getName()+"\n"+Itm.getMobile1();
                        shareUtility.ShareWith_Telegram(activity,text);
                    }
                });

                Btn_ShareWith.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alert.dismiss();
                        String text = Itm.getName()+"\n"+Itm.getMobile1();
                        shareUtility.ShareWith_EveryThing(activity,text,"مخاطب");

                    }
                });


                Btn_Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alert.dismiss();
                    }
                });


                Btn_Delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view2) {

                        alert.dismiss();

                        Snackbar snackbar = Snackbar
                                .make(view, "حساب کاربری حذف شود ؟", Snackbar.LENGTH_LONG);


                        snackbar.setAction("بلی", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                businessContact.BusinessContact_Delete(context, Itm.getId());
                                customToast.ShowCustomToast(context,"حذف شد");
                                ContactsList.remove(Itm);
                                notifyDataSetChanged();

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
                });



                Btn_Edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alert.dismiss();

                        Intent intent_main=new Intent(context, ContactsEdit.class);

                        ClassHelper.setEdit_Mode("Edit");
                        ClassHelper.setContactId(Integer.parseInt(Itm.getId()));

                        intent_main.putExtra("_Jensiat",Itm.getJensiat().toString());
                        intent_main.putExtra("_Name",Itm.getName().toString());
                        intent_main.putExtra("_Mobile1",Itm.getMobile1().toString());
                        intent_main.putExtra("_Mobile2",Itm.getMobile2().toString());

                        intent_main.putExtra("_Email",Itm.getEmail().toString());
                        intent_main.putExtra("_Website",Itm.getWebsite().toString());

                        intent_main.putExtra("_Address",Itm.getAddress().toString());
                        intent_main.putExtra("_Postid",Itm.getPostid().toString());

                        intent_main.putExtra("_Shenasnameh",Itm.getShenasnameh().toString());
                        intent_main.putExtra("_Mellicardid",Itm.getMellicardid().toString());
                        intent_main.putExtra("_Govahinamehid",Itm.getGovahinamehid().toString());

                        intent_main.putExtra("_Birthdate",Itm.getBirthdate().toString());
                        intent_main.putExtra("_Aghddate",Itm.getAghddate().toString());
                        intent_main.putExtra("_Ezdevajdate",Itm.getEzdevajdate().toString());


                        intent_main.putExtra("_Bank1",Itm.getBank1().toString());
                        intent_main.putExtra("_Hesab1",Itm.getHesab1().toString());
                        intent_main.putExtra("_Card1",Itm.getCard1().toString());


                        intent_main.putExtra("_Bank2",Itm.getBank2().toString());
                        intent_main.putExtra("_Hesab2",Itm.getHesab2().toString());
                        intent_main.putExtra("_Card2",Itm.getCard2().toString());

                        intent_main.putExtra("_Photoaddress",Itm.getPhotoaddress().toString());


                        activity.startActivity(intent_main);

                    }
                });


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




        Glide
                .with(context)
                .load(R.mipmap.iconopen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(holder.ImageViewOPenMenu);


        Glide
                .with(context)
                .load(R.drawable.phoneicon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(holder.ImageViewMobile);

        Glide
                .with(context)
                .load(R.drawable.emailicon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(holder.ImageViewSms);


    }

    @Override
    public int getItemCount() {
        return ContactsList.size();
    }
}

