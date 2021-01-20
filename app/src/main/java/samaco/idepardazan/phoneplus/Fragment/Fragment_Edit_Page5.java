package samaco.idepardazan.phoneplus.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import samaco.idepardazan.phoneplus.Business.BusinessContact;
import samaco.idepardazan.phoneplus.Business.BusinessContactDetails;
import samaco.idepardazan.phoneplus.Common.ClassHelper;
import samaco.idepardazan.phoneplus.Common.CustomToast;
import samaco.idepardazan.phoneplus.Common.ImageUtility;
import samaco.idepardazan.phoneplus.R;


public class Fragment_Edit_Page5 extends Fragment {

    private View myFragmentView;
    LinearLayout linearLayout;

    Button Btn_NewImg;
    Button Btn_SelectImg;
    Button Btn_Delete;
    Button Btn_Save;
    String Jensiat="";

    Integer Chenage_Code=0;

    CircleImageView circleImageView;

    Typeface TextFont;
    ImageUtility imageUtility=new ImageUtility();
    BusinessContact businessContact=new BusinessContact();
    CustomToast customToast=new CustomToast();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.item_edit_page5, container, false);
        linearLayout=(LinearLayout) myFragmentView.findViewById(R.id.FooterLayout);

        Btn_NewImg=(Button) myFragmentView.findViewById(R.id.Btn_NewImg);
        Btn_SelectImg=(Button) myFragmentView.findViewById(R.id.Btn_SelectImg);
        Btn_Delete=(Button) myFragmentView.findViewById(R.id.Btn_Delete);
        Btn_Save=(Button) myFragmentView.findViewById(R.id.Btn_Save);


        circleImageView=(CircleImageView) myFragmentView.findViewById(R.id.profile_image);

        TextFont= Typeface.createFromAsset(getActivity().getAssets(), "fonts/BYekan.ttf");

        SetComponentsFont();
        SetButtonsColor();
        SetComponentsColor();
        GetButtonsEvent();


        try {

            Bundle extras = getActivity().getIntent().getExtras();

            String _Photoaddress=extras.getString("_Photoaddress");


            if (ClassHelper.getEdit_Mode().equals("Edit"))
            {

                Jensiat=(extras.getString("_Jensiat"));

                if (!_Photoaddress.equals(""))
                {
                    File file=new File(_Photoaddress);
                    ClassHelper.Uri_MainFile=Uri.fromFile(file);

                    Glide
                            .with(getContext())
                            .load(ClassHelper.Uri_MainFile)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into(circleImageView);

                }//if (!_Photoaddress.equals(""))

                else if (Jensiat.equals("1"))
                {
                    Glide
                            .with(getContext())
                            .load(R.drawable.user_male)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into(circleImageView);
                }
                else if (Jensiat.equals("2"))
                {
                    Glide
                            .with(getContext())
                            .load(R.drawable.user_female)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into(circleImageView);
                }

            }//if (getEdit_Mode().equals("Edit"))
        }
        catch (Exception e)
        {

        }

        return myFragmentView;

    }

    private void SetComponentsFont() {

        Btn_NewImg.setTypeface(TextFont);
        Btn_SelectImg.setTypeface(TextFont);
        Btn_Delete.setTypeface(TextFont);
        Btn_Save.setTypeface(TextFont);

    }

    private void SetButtonsColor()
    {
        final Drawable drawable_dark = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_dark.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.switch_thumb_material_dark), PorterDuff.Mode.MULTIPLY));

        final Drawable drawable_light = getContext().getResources().getDrawable(android.R.drawable.dialog_holo_light_frame);
        drawable_light.setColorFilter(new PorterDuffColorFilter(getContext().getResources()
                .getColor(R.color.md_white_1000), PorterDuff.Mode.MULTIPLY));

        Btn_NewImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_NewImg.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_NewImg.setBackground(drawable_dark);
                        break;

                }

                return false;
            }
        });


        Btn_SelectImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_SelectImg.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_SelectImg.setBackground(drawable_dark);
                        break;

                }

                return false;
            }
        });




        Btn_Delete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Delete.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Delete.setBackground(drawable_dark);
                        break;

                }

                return false;
            }
        });


        Btn_Save.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int action = motionEvent.getAction();

                switch (action) {

                    case MotionEvent.ACTION_UP:
                        Btn_Save.setBackground(drawable_light);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Btn_Save.setBackground(drawable_dark);
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


    private void GetButtonsEvent()
    {
        Btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar snackbar = Snackbar
                        .make(getView(), "عکس حذف شود؟", Snackbar.LENGTH_LONG);

                snackbar.setAction("بلی", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (Jensiat.equals("1"))
                        {
                            Glide
                                    .with(getContext())
                                    .load(R.drawable.user_male)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .dontAnimate()
                                    .into(circleImageView);
                        }
                        else if (Jensiat.equals("2"))
                        {
                            Glide
                                    .with(getContext())
                                    .load(R.drawable.user_female)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .dontAnimate()
                                    .into(circleImageView);
                        }


                        businessContact.BusinessContact_PhotoAddress(getContext(), ClassHelper.getContactId().toString(),
                                "");
                        customToast.ShowCustomToast(getContext(), "عکس حذف شد");


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

        Btn_NewImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Chenage_Code=1;

                try
                {
                    File dir = new File(Environment.getExternalStorageDirectory() + "/PhonePlus/Temp");
                    if (dir.isDirectory()) {
                        String[] children = dir.list();
                        for (int i = 0; i < children.length; i++) {
                            new File(dir, children[i]).delete();
                        }
                    }
                }
                catch (Exception e)
                {

                }

                TakePicture();
            }
        });

        Btn_SelectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Chenage_Code=2;

                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 2);

            }
        });

        Btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Chenage_Code!=0)
                {
                    try {
                        File file = null;

                        if (Chenage_Code == 1)
                            file = new File(ClassHelper.Uri_TempFile.getPath());
                        else if (Chenage_Code == 2)
                            file = new File(getPath(ClassHelper.Uri_TempFile));

                        InputStream in = new FileInputStream(file);

                        File out = imageUtility.CopyImage(in);
                        ClassHelper.Uri_MainFile = Uri.fromFile(out);

                        businessContact.BusinessContact_PhotoAddress(getContext(), ClassHelper.getContactId().toString(),
                                ClassHelper.Uri_MainFile.getPath());


                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }



            }
        });
    }

    public String getPath(Uri uri) {

        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
        getActivity().startManagingCursor(cursor);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }


    private void TakePicture() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {

            try {

                ImageUtility imageUtility=new ImageUtility();
                ClassHelper.Uri_TempFile = Uri.fromFile(imageUtility.Temp_Image_File());

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, ClassHelper.Uri_TempFile);
                startActivityForResult(intent, 1);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }


    public  void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        switch(requestCode) {
            case 1:
            {
                if(resultCode == getActivity().RESULT_OK) {

                    Glide
                            .with(getContext())
                            .load(ClassHelper.Uri_TempFile)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into(circleImageView);
                }
            }
            break;

            case 2:
                if(resultCode == getActivity().RESULT_OK){

                    Uri selectedImage = imageReturnedIntent.getData();
                    ClassHelper.Uri_TempFile=selectedImage;

                    Glide
                            .with(getContext())
                            .load(ClassHelper.Uri_TempFile)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .dontAnimate()
                            .into(circleImageView);
                }
                break;


        }//switch(requestCode


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        if (isVisibleToUser){

            try
            {
                if (ClassHelper.getEdit_Page5()==1)
                {
                    ClassHelper.setEdit_Page5(0);

                    try
                    {
                        Glide
                                .with(getContext())
                                .load(R.drawable.user_male)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .dontAnimate()
                                .into(circleImageView);
                    }
                    catch (Exception e)
                    {

                    }

                }
            }
            catch (Exception e)
            {

            }

        }
    }


}

