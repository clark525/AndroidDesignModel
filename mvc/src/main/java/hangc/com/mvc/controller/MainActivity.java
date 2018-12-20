package hangc.com.mvc.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hangc.com.mvc.R;
import hangc.com.mvc.adapter.MyAdapter;
import hangc.com.mvc.model.DataModel;
import hangc.com.mvc.model.DataModelImpl;

public class MainActivity extends AppCompatActivity implements DataModelImpl.DataListener {


    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;


    private DataModel dataModel;
    private List<String> mList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        dataModel = new DataModelImpl();
        mList = new ArrayList<>();
        myAdapter = new MyAdapter(MainActivity.this, mList);
        recyclerView.setAdapter(myAdapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycleView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataModel.getData(editText.getText().toString(), MainActivity.this);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void onSuccess(List<String> list) {
        mList.addAll(list);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

}
