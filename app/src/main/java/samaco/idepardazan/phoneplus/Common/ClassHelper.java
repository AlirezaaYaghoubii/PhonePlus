package samaco.idepardazan.phoneplus.Common;

import java.util.ArrayList;

import samaco.idepardazan.phoneplus.Entities.EntitySimContacts;

public class ClassHelper {

    private static String MarketName;
    private static String AppVersion;
    private static  String DataBase_Name;
    private static  String App_Color_Code;
    private static  String App_Color_Code2;
    private static  String PasswordCorrect;
    private static  Integer ContactId;
    private static String Edit_Mode;
    private static Integer Edit_Page2;
    private static Integer Edit_Page3;
    private static Integer Edit_Page4;
    private static Integer Edit_Page5;

    public static Integer getEdit_Page4() {
        return Edit_Page4;
    }

    public static void setEdit_Page4(Integer edit_Page4) {
        Edit_Page4 = edit_Page4;
    }

    public static Integer getEdit_Page5() {
        return Edit_Page5;
    }

    public static void setEdit_Page5(Integer edit_Page5) {
        Edit_Page5 = edit_Page5;
    }



    public static Integer getCheckBackUpdate() {
        return CheckBackUpdate;
    }

    public static void setCheckBackUpdate(Integer checkBackUpdate) {
        CheckBackUpdate = checkBackUpdate;
    }

    private static Integer CheckBackUpdate;

    public static String getApp_Color_Code_String() {
        return App_Color_Code_String;
    }

    public static void setApp_Color_Code_String(String app_Color_Code_String) {
        App_Color_Code_String = app_Color_Code_String;
    }

    private static  String App_Color_Code_String;

    private static String DetailsEdit_Mode;
    private static Integer PersonelList_Id;
    private static  Integer ContactDetailsId;

    public static android.net.Uri Uri_TempFile;
    public static android.net.Uri Uri_MainFile;

    public static ArrayList<EntitySimContacts> SimContactsList = new ArrayList<>();

    public static Integer getContactDetailsId() {
        return ContactDetailsId;
    }

    public static void setContactDetailsId(Integer contactDetailsId) {
        ContactDetailsId = contactDetailsId;
    }

    public static String getDetailsEdit_Mode() {
        return DetailsEdit_Mode;
    }

    public static void setDetailsEdit_Mode(String detailsEdit_Mode) {
        DetailsEdit_Mode = detailsEdit_Mode;
    }

    public static Integer getPersonelList_Id() {
        return PersonelList_Id;
    }

    public static void setPersonelList_Id(Integer personelList_Id) {
        PersonelList_Id = personelList_Id;
    }

    public static Integer getEdit_Page2() {
        return Edit_Page2;
    }

    public static void setEdit_Page2(Integer edit_Page2) {
        Edit_Page2 = edit_Page2;
    }

    public static Integer getEdit_Page3() {
        return Edit_Page3;
    }

    public static void setEdit_Page3(Integer edit_Page3) {
        Edit_Page3 = edit_Page3;
    }

    public static String getEdit_Mode() {
        return Edit_Mode;
    }

    public static void setEdit_Mode(String edit_Mode) {
        Edit_Mode = edit_Mode;
    }

    public static Integer getContactId() {
        return ContactId;
    }

    public static void setContactId(Integer contactId) {
        ContactId = contactId;
    }

    public static String getPasswordCorrect() {
        return PasswordCorrect;
    }

    public static void setPasswordCorrect(String passwordCorrect) {
        PasswordCorrect = passwordCorrect;
    }

    public static String getApp_Color_Code2() {
        return App_Color_Code2;
    }

    public static void setApp_Color_Code2(String app_Color_Code2) {
        App_Color_Code2 = app_Color_Code2;
    }

    public static String getApp_Color_Code() {
        return App_Color_Code;
    }

    public static void setApp_Color_Code(String app_Color_Code) {
        App_Color_Code = app_Color_Code;
    }

    public static String getDataBase_Name() {
        return DataBase_Name;
    }

    public static void setDataBase_Name(String dataBase_Name) {
        DataBase_Name = dataBase_Name;
    }

    public static String getMarketName() {
        return MarketName;
    }

    public static void setMarketName(String marketName) {
        MarketName = marketName;
    }

    public static String getAppVersion() {
        return AppVersion;
    }

    public static void setAppVersion(String appVersion) {
        AppVersion = appVersion;
    }






}
