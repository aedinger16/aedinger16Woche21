package htl.grieskirchen.aedinger16woche21;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    List<Rechnung> dataList = new ArrayList<>();

    public void addRechnung(Rechnung rechnung){
        dataList.add(rechnung);
    }

    public List<Rechnung> getDataList(){
        return dataList;
    }
}
