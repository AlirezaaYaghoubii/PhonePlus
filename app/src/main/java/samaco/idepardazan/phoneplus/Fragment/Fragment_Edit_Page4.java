package samaco.idepardazan.phoneplus.Fragment;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.ContactsAdapter;
import samaco.idepardazan.phoneplus.Adapter.ContactsDetailsAdapter;
import samaco.idepardazan.phoneplus.Adapter.MySpinnerAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessContactDetails;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.ContactsDetailsEdit;
import samaco.idepardazan.phoneplus.ContactsEdit;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntityContactsDetails;
import samaco.idepardazan.phoneplus.R;



public class Fragment_Edit_Page4 extends Fragment {

    private View myFragmentView;
    private RecyclerView recyclerView;
    LinearLayout linearLayout;

    Button Btn_New;
    Button Btn_Cancel;

    ContactsDetailsAdapter contactsDetailsAdapter;

    BusinessContactDetails businessContactDetails=new BusinessContactDetails();

    Typeface TextFont;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_edit_page4, container, false);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);
        recyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view);


        Btn_New=(Button) myFragmentView.findViewById(R.id.Btn_New);
        Btn_Cancel=(Button) myFragmentView.findViewById(R.id.Btn_Cancel);

        TextFont= Typeface.createFromAsset(getActivity().getAssets(), "fonts/BYekan.ttf");

        SetComponentsFont();
        SetComponentsColor();
        SetButtonsColor();
        GetButtonEvent();

        contactsDetailsAdapter=new ContactsDetailsAdapter(getActivity(),myFragmentView.getContext(),GetContactDetailsList());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsDetailsAdapter);

        return myFragmentView;

    }

    private void GetButtonEvent() {

        Btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().finish();
            }
        });

        Btn_New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ClassHelper.getContactId()!=0)
                {
                    ClassHelper.setCheckBackUpdate(1);

                    Intent intent = new Intent(getContext(), ContactsDetailsEdit.class);
                    ClassHelper.setDetailsEdit_Mode("New");
                    ClassHelper.setContactDetailsId(ClassHelper.getContactId());
                    getActivity().startActivity(intent);

                }//if (ClassHelper.getContactId()!=0)

            }
        });
    }

    private void SetComponentsFont() {

        Btn_New.setTypeface(TextFont);
        Btn_Cancel.setTypeface(TextFont);

    }


    private void SetButtonsColor()
    {
        final Drawable drawable_dark = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_New.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_New.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_New.setBackground(drawable_dark);
                        break;

                }

                return false;
            }
        });



        Btn_Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Cancel.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Cancel.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });






    }

    private void SetComponentsColor()
    {
        if (ClassHelper.getApp_Color_Code().equals("0")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footergreen);
            else
                linearLayout.setBackgroundResource(R.drawable.footergreendark);
        }
        else  if (ClassHelper.getApp_Color_Code().equals("1")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footerblue);
            else
                linearLayout.setBackgroundResource(R.drawable.footerbluedark);
        }
        else  if (ClassHelper.getApp_Color_Code().equals("2")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footer);
            else
                linearLayout.setBackgroundResource(R.drawable.footerdark);
        }

        else  if (ClassHelper.getApp_Color_Code().equals("3")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footergold);
            else
                linearLayout.setBackgroundResource(R.drawable.footergolddark);
        }

        else  if (ClassHelper.getApp_Color_Code().equals("4")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footerbrown);
            else
                linearLayout.setBackgroundResource(R.drawable.footerbrowndark);
        }

        else  if (ClassHelper.getApp_Color_Code().equals("5")) {

            if (ClassHelper.getApp_Color_Code2().equals("0"))
                linearLayout.setBackgroundResource(R.drawable.footerblack);
            else
                linearLayout.setBackgroundResource(R.drawable.footerblack);
        }

    }

    private ArrayList<EntityContactsDetails> GetContactDetailsList()
    {
        ArrayList<EntityContactsDetails> List=new ArrayList<>();

        List=businessContactDetails.BusinessContractDetails_Select(getContext(),ClassHelper.getContactId().toString());


        return List;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        if (isVisibleToUser){
            //This means this fragment is visible to user so you can write code to refresh the fragment here by reloaded the data.

            try
            {
                if (ClassHelper.getEdit_Page4()==1)
                {
                    ClassHelper.setEdit_Page4(0);

                    ArrayList<EntityContactsDetails> Lst=GetContactDetailsList();
                    Lst.clear();

                    contactsDetailsAdapter=new ContactsDetailsAdapter(getActivity(),myFragmentView.getContext(),Lst);

                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(contactsDetailsAdapter);

                }
            }
            catch (Exception e)
            {

            }

        }
    }


}

