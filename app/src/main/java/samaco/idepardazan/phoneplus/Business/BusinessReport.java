package samaco.idepardazan.phoneplus.Business;

import android.content.Context;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.DataAccess.DataReport;
import samaco.idepardazan.phoneplus.Entities.EntityContacts;
import samaco.idepardazan.phoneplus.Entities.EntityReport;


public class BusinessReport {

    DataReport dataReport=new DataReport();

    public ArrayList<EntityReport> BusinessReport_Tavalod(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        return dataReport.DataReport_Tavalod(context,Data,Month,_NextDate,_CurrentDate);
    }

    public ArrayList<EntityReport> BusinessReport_Aghd(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        return dataReport.DataReport_Aghd(context, Data, Month, _NextDate, _CurrentDate);
    }

    public ArrayList<EntityReport> BusinessReport_Ezdevaj(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        return dataReport.DataReport_Ezdevaj(context, Data, Month, _NextDate, _CurrentDate);
    }

    public ArrayList<EntityReport> BusinessReport_Vafat(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        return dataReport.DataReport_Vafat(context, Data, Month, _NextDate, _CurrentDate);
    }

    public ArrayList<EntityReport> BusinessReport_Taghvim(Context context,String Data,String Month,String _NextDate,String _CurrentDate)
    {
        return dataReport.DataReport_Taghvim(context, Data, Month, _NextDate, _CurrentDate);
    }

    public ArrayList<EntityContacts> BusinessReport_FullReport(Context context,String Data)
    {
        return dataReport.DataReport_FullReport(context, Data);
    }

}
