package samaco.idepardazan.phoneplus.Common;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import samaco.idepardazan.phoneplus.R;


public class CustomToast {

    public  void ShowCustomToast(Context context,String MSG)
    {
        Toast T=new Toast(context);
        T.setGravity(Gravity.BOTTOM,0,200);
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflate.inflate(R.layout.custometost, null);
        TextView tvMessage = (TextView) view.findViewById(R.id.tvMessage);
        Typeface TextFont= Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
        tvMessage.setTypeface(TextFont);
        tvMessage.setText(MSG);
        T.setView(view);
        T.show();

    }

}
