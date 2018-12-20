package hangc.com.mvvm.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import hangc.com.mvvm.R;
import hangc.com.mvvm.databinding.ActivityMainBindingImpl;
import hangc.com.mvvm.viewmodel.MainViewModel;

/**
 * View层：
 */
public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBindingImpl binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        mainViewModel = new MainViewModel();

        binding.setHandler(this);
        binding.setMainViewModel(mainViewModel);

        textView = binding.textView;

    }

    public void onClickUpdate(View v) {
        mainViewModel.updata();
    }

    public void onClickClear(View v) {
        Toast.makeText(MainActivity.this, "---", Toast.LENGTH_SHORT).show();
        Snackbar snackbar = Snackbar.make(v,"snackbar",Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("yes", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.updata();

            }
        });
        snackbar.show();

        startActivity(new Intent(MainActivity.this, ContactsActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainViewModel != null) {
            //mainViewModel
        }
    }
}
