package hangc.com.mvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hangc.com.mvp.R;
import hangc.com.mvp.presenter.MainInterface;
import hangc.com.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainInterface {

    private TextView textView;
    private Button clearButton;
    private Button updateButton;

    private MainPresenter viewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        viewPresenter = new MainPresenter(this, this);
    }

    private void initEvent() {
        clearButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
    }

    private void initView() {
        textView = findViewById(R.id.textView);
        clearButton = findViewById(R.id.clearButton);
        updateButton = findViewById(R.id.updateButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updateButton:
                viewPresenter.update();
                break;
            case R.id.clearButton:
                viewPresenter.clear();
                break;
        }
    }

    @Override
    public void update(String s) {
        textView.setText(s);

    }

    @Override
    public void clear() {
        textView.setText("");
    }
}
