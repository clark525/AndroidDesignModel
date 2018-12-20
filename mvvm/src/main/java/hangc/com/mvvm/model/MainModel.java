package hangc.com.mvvm.model;

public class MainModel {

    private String data;

    public MainModel() {
        this.data = "ook-mvvm";
    }

    public String getData() {
        return data;
    }

    public void update() {
        data = "updated" + (int) (Math.random() * 10);
    }
}
