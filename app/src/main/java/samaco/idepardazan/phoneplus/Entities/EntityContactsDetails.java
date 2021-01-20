package samaco.idepardazan.phoneplus.Entities;

/**
 * Created by Alireza on 12/08/2017.
 */
public class EntityContactsDetails {
    private  String TitleDate;
    private  String Comment;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPerson_Id() {
        return Person_Id;
    }


    private  String Id;
    private  String Person_Id;
    private  String Nesbat;
    private  String Name;
    private  String Title;
    public void setPerson_Id(String person_Id) {
        Person_Id = person_Id;
    }

    public String getNesbat() {
        return Nesbat;
    }

    public void setNesbat(String nesbat) {
        Nesbat = nesbat;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleDate() {
        return TitleDate;
    }

    public void setTitleDate(String titleDate) {
        TitleDate = titleDate;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }




}
