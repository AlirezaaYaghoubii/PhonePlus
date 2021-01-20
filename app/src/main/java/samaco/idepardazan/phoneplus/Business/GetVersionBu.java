package samaco.idepardazan.phoneplus.Business;

import android.content.Context;

import samaco.idepardazan.phoneplus.DataAccess.GetVersionData;


public class GetVersionBu {

    public String GetCurrentVersion(Context context) {

        GetVersionData getVersionData=new GetVersionData();
        return  getVersionData.GetCurrentVersion(context);

    }

}
