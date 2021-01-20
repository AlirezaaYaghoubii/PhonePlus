package samaco.idepardazan.phoneplus.Fragment;

import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.ContactsListAdapter;
import samaco.idepardazan.phoneplus.Adapter.SimContactsListAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntitySimContacts;
import samaco.idepardazan.phoneplus.R;



public class Fragment_SimContactsList extends Fragment {

    private View myFragmentView;
    private RecyclerView recyclerView;
    private ArrayList<EntityContacts> ContactsList = new ArrayList();

    private EditText TxtSearch;
    Typeface TextFont;
    Cursor cursor;
    String name, phonenumber ;

    SimContactsListAdapter simContactsListAdapter;
    LinearLayout linearLayout;

    Button Btn_SelectAll;
    Button Btn_UnSelect;
    Button Btn_TransferToApp;
    Button Btn_Cancel;

    BusinessContact businessContact=new BusinessContact();
    CustomToast customToast=new CustomToast();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.content_sim_contacts, container, false);
        recyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view);
        TxtSearch = (EditText) myFragmentView.findViewById(R.id.TxtSearch);

        Btn_SelectAll = (Button) myFragmentView.findViewById(R.id.Btn_SelectAll);
        Btn_UnSelect = (Button) myFragmentView.findViewById(R.id.Btn_UnSelect);
        Btn_TransferToApp = (Button) myFragmentView.findViewById(R.id.Btn_TransferToApp);
        Btn_Cancel = (Button) myFragmentView.findViewById(R.id.Btn_Cancel);


        linearLayout = (LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);


        TextFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/BYekan.ttf");
        TxtSearch.setTypeface(TextFont);

        simContactsListAdapter = new SimContactsListAdapter(getActivity(), myFragmentView.getContext(), GetContactList(""));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(simContactsListAdapter);


        TxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                String _Data=TxtSearch.getText().toString().trim();

                simContactsListAdapter = new SimContactsListAdapter(getActivity(), myFragmentView.getContext(), GetContactList(_Data));

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(simContactsListAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        SetButtonsColor();
        SetComponentsFont();
        SetComponentsColor();
        GetButtonEvent();

        return myFragmentView;
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

    private void SetComponentsFont() {

        Btn_SelectAll.setTypeface(TextFont);
        Btn_Cancel.setTypeface(TextFont);
        Btn_UnSelect.setTypeface(TextFont);
        Btn_TransferToApp.setTypeface(TextFont);

    }


    private void SetButtonsColor()
    {
        final Drawable drawable_dark = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_TransferToApp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_TransferToApp.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_TransferToApp.setBackground(drawable_dark);
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


        Btn_SelectAll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_SelectAll.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_SelectAll.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });



        Btn_UnSelect.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_UnSelect.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_UnSelect.setBackground(drawable_dark);
                        break;
                }

                return false;
            }
        });




    }

    private void GetButtonEvent() {


        Btn_TransferToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int Transfer=0;

                for(int i=0;i<ClassHelper.SimContactsList.size();i++)
                {
                    if (ClassHelper.SimContactsList.get(i).getFlag())
                    {
                        Transfer=1;
                        businessContact.BusinessContact_InsertFromSim(getContext()
                                ,ClassHelper.SimContactsList.get(i).getName(),ClassHelper.SimContactsList.get(i).getPhone());


                    }//if (ClassHelper.SimContactsList.get(i).getFlag())

                }//for(int i=0;i<ClassHelper.SimContactsList.size();i++)

                if (Transfer==1)
                {
                    customToast.ShowCustomToast(getContext(),"اطلاعات به برنامه منتقل شد");
                }
            }
        });


        Btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().finish();
            }
        });

        Btn_SelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0;i<ClassHelper.SimContactsList.size();i++)
                {
                    ClassHelper.SimContactsList.get(i).setFlag(true);
                }


                simContactsListAdapter = new SimContactsListAdapter(getActivity(), myFragmentView.getContext(),ClassHelper.SimContactsList);

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(simContactsListAdapter);
            }
        });

        Btn_UnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=0;i<ClassHelper.SimContactsList.size();i++)
                {
                    ClassHelper.SimContactsList.get(i).setFlag(false);
                }


                simContactsListAdapter = new SimContactsListAdapter(getActivity(), myFragmentView.getContext(),ClassHelper.SimContactsList);

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(simContactsListAdapter);
            }
        });


    }

    private ArrayList<EntitySimContacts> GetContactList(String Data) {


        ClassHelper.SimContactsList.clear();
        EntitySimContacts Itm;


        cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            Itm=new EntitySimContacts();
            Itm.setFlag(false);
            Itm.setName(name);
            Itm.setPhone(phonenumber);

            if (Data.equals(""))
              ClassHelper.SimContactsList.add(Itm);
            else if (name.contains(Data) || phonenumber.contains(Data))
                ClassHelper.SimContactsList.add(Itm);

        }

        cursor.close();


        return ClassHelper.SimContactsList;
    }

}

