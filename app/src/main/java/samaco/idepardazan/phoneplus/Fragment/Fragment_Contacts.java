package samaco.idepardazan.phoneplus.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Adapter.ContactsAdapter;
import samaco.idepardazan.phoneplus.Adapter.SimContactsListAdapter;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.R;

public class Fragment_Contacts extends Fragment {

    private View myFragmentView;
    private RecyclerView recyclerView;
    private ArrayList<EntityContacts> ContactsList=new ArrayList();

    private EditText TxtSearch;
    Typeface TextFont;

    ContactsAdapter contactsAdapter;
    LinearLayout linearLayout;

    BusinessContact businessContact=new BusinessContact();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.content_contacts, container, false);
        recyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recycler_view);
        TxtSearch=(EditText) myFragmentView.findViewById(R.id.TxtSearch);

        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);


        TextFont= Typeface.createFromAsset(getContext().getAssets(), "fonts/BYekan.ttf");
        TxtSearch.setTypeface(TextFont);

        contactsAdapter=new ContactsAdapter(getActivity(),myFragmentView.getContext(),GetContactList(""));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsAdapter);

        TxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                String _Data=TxtSearch.getText().toString().trim();

                contactsAdapter=new ContactsAdapter(getActivity(),myFragmentView.getContext(),GetContactList(_Data));

                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(myFragmentView.getContext(), 1);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(contactsAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        SetComponentsColor();

        return myFragmentView;
    }

    private ArrayList<EntityContacts> GetContactList(String Data)
    {
        ArrayList<EntityContacts> List=new ArrayList<>();

        List=businessContact.BusinessContact_Select(getContext(),Data);


        return List;
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
}

