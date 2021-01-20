package samaco.idepardazan.phoneplus.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Business.BusinessContactDetails;
import samaco.idepardazan.phoneplus.Common.ClassGetListName;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.ClipBoardClass;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.ShareUtility;
import samaco.idepardazan.phoneplus.ContactsDetailsEdit;
import samaco.idepardazan.phoneplus.ContactsEdit;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntityContactsDetails;
import samaco.idepardazan.phoneplus.R;



public class ContactsDetailsAdapter extends RecyclerView.Adapter<ContactsDetailsAdapter.MyViewHolder> {

    Activity activity;
    private Context context;
    private ArrayList<EntityContactsDetails> ContactsList;
    Typeface TextFont;
    BusinessContactDetails businessContactDetails=new BusinessContactDetails();
    CustomToast customToast=new CustomToast();

    ClassGetListName classGetListName=new ClassGetListName();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView TextView_NesbatLabel;
        public TextView TextView_NesbatData;

        public TextView TextView_TitleLabel;
        public TextView TextView_TitleData;

        public TextView TextView_DateLabel;
        public TextView TextView_DateData;

        public TextView TextView_CommentLabel;
        public TextView TextView_CommentData;


        public ImageView ImageViewOPenMenu;


        public LinearLayout LinearLayoutOPenMenu;


        public MyViewHolder(View view) {
            super(view);

            TextView_NesbatLabel = (TextView) view.findViewById(R.id.TextView_NesbatLabel);
            TextView_NesbatData = (TextView) view.findViewById(R.id.TextView_NesbatData);

            TextView_TitleLabel = (TextView) view.findViewById(R.id.TextView_TitleLabel);
            TextView_TitleData = (TextView) view.findViewById(R.id.TextView_TitleData);

            TextView_DateLabel = (TextView) view.findViewById(R.id.TextView_DateLabel);
            TextView_DateData = (TextView) view.findViewById(R.id.TextView_DateData);

            TextView_CommentLabel = (TextView) view.findViewById(R.id.TextView_CommentLabel);
            TextView_CommentData = (TextView) view.findViewById(R.id.TextView_CommentData);

            ImageViewOPenMenu = (ImageView) view.findViewById(R.id.ImageViewOPenMenu);

            LinearLayoutOPenMenu = (LinearLayout) view.findViewById(R.id.LinearLayoutOPenMenu);

        }
    }


    public ContactsDetailsAdapter(Activity _activity, Context _context, ArrayList<EntityContactsDetails> _ContactsList) {

        activity = _activity;
        this.context = _context;
        this.ContactsList = _ContactsList;
        TextFont = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacts_details, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final EntityContactsDetails Itm = ContactsList.get(position);

        String _NesbatName=classGetListName.GetNesbatName(Integer.parseInt(Itm.getNesbat()));
        String _TitleData=classGetListName.GetTitleName(Integer.parseInt(Itm.getTitle()));

        if (Itm.getName().equals(""))
            holder.TextView_NesbatData.setText(_NesbatName);
        else
            holder.TextView_NesbatData.setText(_NesbatName +" - "+Itm.getName());


        holder.TextView_TitleData.setText(_TitleData);
        holder.TextView_CommentData.setText(Itm.getComment());

        String  _Date=Itm.getTitleDate();

        if (_Date.length()==8)
        holder.TextView_DateData.setText(_Date.substring(0,4)+"/"+_Date.substring(4,6)+"/"+_Date.substring(6,8));


        holder.TextView_NesbatLabel.setTypeface(TextFont);
        holder.TextView_NesbatData.setTypeface(TextFont, Typeface.BOLD);

        holder.TextView_TitleLabel.setTypeface(TextFont);
        holder.TextView_TitleData.setTypeface(TextFont, Typeface.BOLD);

        holder.TextView_DateLabel.setTypeface(TextFont);
        holder.TextView_DateData.setTypeface(TextFont, Typeface.BOLD);

        holder.TextView_CommentLabel.setTypeface(TextFont);
        holder.TextView_CommentData.setTypeface(TextFont, Typeface.BOLD);

        holder.LinearLayoutOPenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final AlertDialog alert = builder.create();

                View view1=alert.getLayoutInflater().inflate(R.layout.item_alert_title, null);
                View view2=alert.getLayoutInflater().inflate(R.layout.item_contact_details_menu, null);

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


                Button Btn_Cancel=(Button) alert.findViewById(R.id.Btn_Cancel);
                Button Btn_Edit=(Button) alert.findViewById(R.id.Btn_Edit);
                Button Btn_Delete=(Button) alert.findViewById(R.id.Btn_Delete);
                final LinearLayout LayerHead=(LinearLayout) alert.findViewById(R.id.LayerHead);

                          
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
                                .make(view, "رکورد جاری حذف شود؟", Snackbar.LENGTH_LONG);


                        snackbar.setAction("بلی", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                businessContactDetails.BusinessContractDetails_Delete(context, Itm.getId());
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

                        Intent intent_main=new Intent(context, ContactsDetailsEdit.class);

                        ClassHelper.setDetailsEdit_Mode("Edit");
                        ClassHelper.setContactDetailsId(Integer.parseInt(Itm.getId()));


                        intent_main.putExtra("_Name",Itm.getName().toString());
                        intent_main.putExtra("_Comment",Itm.getComment().toString());
                        intent_main.putExtra("_Nesbat",Itm.getNesbat().toString());
                        intent_main.putExtra("_Title",Itm.getTitle().toString());
                        intent_main.putExtra("_TitleDate",Itm.getTitleDate().toString());


                        activity.startActivity(intent_main);

                    }
                });


            }
        });

        Glide
                .with(context)
                .load(R.mipmap.iconopen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(holder.ImageViewOPenMenu);


    }

    @Override
    public int getItemCount() {
        return ContactsList.size();
    }
}
