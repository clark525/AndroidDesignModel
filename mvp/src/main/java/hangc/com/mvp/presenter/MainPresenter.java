package hangc.com.mvp.presenter;

import android.content.Context;

import hangc.com.mvp.model.MainModel;

public class MainPresenter {

    private Context context;
    private MainInterface mainInterface;

    private MainModel mainModel;

    public MainPresenter(Context context, MainInterface mainInterface) {
        this.context = context;
        this.mainInterface = mainInterface;

        mainModel = new MainModel();
    }

    public void update() {
        String s = mainModel.getData();
        mainInterface.update(s);

    }

    public void clear() {
        mainInterface.clear();
    }
}
