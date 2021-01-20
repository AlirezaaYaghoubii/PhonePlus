package samaco.idepardazan.phoneplus.Common;

/**
 * Created by Alireza on 12/09/2017.
 */
public class ClassGetListName {

    public String GetNesbatName(Integer PositionId)
    {
        String _Name="";

        switch (PositionId)
        {
            case 1:
                _Name="پدر";
                break;

            case 2:
                _Name="مادر";
                break;

            case 3:
                _Name="برادر";
                break;

            case 4:
                _Name="خواهر";
                break;

            case 5:
                _Name="همسر";
                break;

            case 6:
                _Name="فرزند";
                break;

            case 7:
                _Name = "پدربزرگ";
                break;
            case 8:
                _Name = "مادربزرگ";
                break;
            case 9:
                _Name = "سایر";
                break;

        }


        return _Name;

    }

    public String GetTitleName(Integer PositionId)
    {
        String _Name="";

        switch (PositionId)
        {
            case 1:
                _Name = "تاریخ تولد";
                break;

            case 2:
                _Name = "تاریخ عقد";
                break;

            case 3:
                _Name = "تاریخ ازدواج";
                break;

            case 4:
                _Name = "تاریخ وفات";
                break;

            case 5:
                _Name = "سایر";
                break;

        }

        return _Name;
    }
}
