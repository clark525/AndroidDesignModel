package hangc.com.mvvm.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import hangc.com.mvvm.model.MainModel;
import hangc.com.mvvm.BR;


public class MainViewModel extends BaseObservable {
    private MainModel mainModel;

    public MainViewModel() {
        mainModel = new MainModel();

    }

    @Bindable
    public String getData() {
        return mainModel.getData();
    }

    public void updata() {
        mainModel.update();
        notifyPropertyChanged(BR.data);
    }
}
