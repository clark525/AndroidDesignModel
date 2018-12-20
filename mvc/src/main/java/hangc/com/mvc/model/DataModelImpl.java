package hangc.com.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class DataModelImpl implements DataModel {

    @Override
    public void getData(String s, DataListener dataListener) {

        try {
            dataListener.onSuccess(formData(s));
        } catch (Exception e) {
            dataListener.onFail("fail");
        }

    }

    private List<String> formData(String s) throws Exception {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("item_" + s + i);
        }

        //throw new Exception("sd");

        return list;
    }

    public interface DataListener{

        void onSuccess(List<String> list);

        void onFail(String fail);
    }
}
