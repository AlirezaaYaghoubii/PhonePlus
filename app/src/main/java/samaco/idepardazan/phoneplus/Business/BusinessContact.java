package samaco.idepardazan.phoneplus.Business;


import android.content.Context;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.DataAccess.DataContact;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;

public class BusinessContact {

    DataContact dataContact=new DataContact();

    public Integer BusinessContact_Insert(Context context,String lname,String phone1,String phone2,String email
            ,String website,String address,String postid
            ,String shenasnameh,String mellicardid,String govahinamehid,String jensiat)
    {
        return dataContact.DataContact_Insert(context,lname,phone1,phone2,email
                ,website,address,postid,shenasnameh, mellicardid,govahinamehid,jensiat);
    }

    public ArrayList<EntityContacts> BusinessContact_Select(Context context,String Data)
    {

        return dataContact.DataContact_Select(context,Data);

    }

    public ArrayList<EntityContacts> BusinessContact_SelectForGrid(Context context,String Data)
    {

        return dataContact.DataContact_SelectForGrid(context,Data);

    }

    public ArrayList<EntityContacts> BusinessContact_OnlyBankSelect(Context context,String Data)
    {

        return dataContact.DataContact_OnlyBankSelect(context,Data);

    }

    public ArrayList<EntityContacts> BusinessContact_OnlyContactSelect(Context context,String Data)
    {

        return dataContact.DataContact_OnlyContactSelect(context,Data);

    }


    public void BusinessContact_Delete(Context context,String Id)
    {
        dataContact.DataContact_Delete(context,Id);
    }

    public void BusinessContact_UpdateMain(Context context,String Id,String lname,String phone1,String phone2,String email
            ,String website,String address,String postid,String shenasnameh
            ,String mellicardid,String govahinamehid,String jensiat)
    {
        dataContact.DataContact_UpdateMain(context,Id,lname,phone1,phone2,email
                ,website,address,postid,shenasnameh, mellicardid,govahinamehid,jensiat);
    }

    public void BusinessContact_UpdateDate(Context context,String Id
            ,String birthdate,String aghddate,String ezdevajdate)
    {
        dataContact.DataContact_UpdateDate(context,Id,birthdate,aghddate,ezdevajdate);
    }

    public void BusinessContact_UpdateAccount(Context context,String Id
            ,String bank1,String hesab1,String card1,String bank2,String hesab2,String card2)
    {
        dataContact.DataContact_UpdateAccount(context,Id,bank1,hesab1,card1,bank2,hesab2,card2);
    }

    public String BusinessContact_SelectName(Context context,String Id)
    {
        return dataContact.DataContact_SelectName(context,Id);
    }

    public void BusinessContact_PhotoAddress(Context context,String Id
            ,String PhotoAddress)

    {
        dataContact.DataContact_PhotoAddress(context,Id,PhotoAddress);

    }

    public EntityContacts BusinessContact_Select_Contact(Context context,String Id)
    {
        return dataContact.DataContact_Select_Contact(context,Id);
    }

    public void BusinessContact_InsertFromSim(Context context,String Name,String Phone)
    {
        dataContact.DataContact_InsertFromSim(context,Name,Phone);
    }


}
