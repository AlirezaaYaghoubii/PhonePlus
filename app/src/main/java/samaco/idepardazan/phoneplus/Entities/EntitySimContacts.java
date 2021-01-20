package samaco.idepardazan.phoneplus.Entities;

/**
 * Created by Alireza on 12/15/2017.
 */
public class EntitySimContacts {

    private  String Name;
    private  String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Boolean getFlag() {
        return Flag;
    }

    public void setFlag(Boolean flag) {
        Flag = flag;
    }

    private  Boolean Flag;
}
