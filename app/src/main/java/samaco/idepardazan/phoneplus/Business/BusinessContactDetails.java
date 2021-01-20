package samaco.idepardazan.phoneplus.Business;

import android.content.Context;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.DataAccess.DataContractDetails;
import samaco.idepardazan.phoneplus.Entities.EntityContactsDetails;


public class BusinessContactDetails {

    DataContractDetails dataContractDetails=new DataContractDetails();

    public Integer BusinessContractDetails_Insert(Context context,String Person_Id,String Nesbat,String Name,String Title
            ,String TitleDate,String Comment)
    {
        return dataContractDetails.DataContractDetails_Insert(context,Person_Id,Nesbat,Name,Title
                ,TitleDate,Comment);
    }

    public void BusinessContractDetails_Delete(Context context,String Id)
    {
        dataContractDetails.DataContractDetails_Delete(context,Id);
    }

    public void BusinessContractDetails_Update(Context context,String Id,String Nesbat,String Name,String Title
            ,String TitleDate,String Comment)
    {
        dataContractDetails.DataContractDetails_Update(context,Id,Nesbat,Name,Title,TitleDate,Comment);
    }

    public ArrayList<EntityContactsDetails> BusinessContractDetails_Select(Context context,String Person_Id)
    {
        return dataContractDetails.DataContractDetails_Select(context,Person_Id);
    }

}
