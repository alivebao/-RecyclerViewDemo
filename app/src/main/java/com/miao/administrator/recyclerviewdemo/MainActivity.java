package com.miao.administrator.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnRecyclerViewListener {
    private ArrayList<Person> list = new ArrayList<Person>();
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        initData();

        mAdapter = new MyAdapter(list);
        mAdapter.setOnRecyclerViewListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 30; ++i) {
            list.add(new Person(i, "name_" + i));
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplication(), "clicked:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(int position) {
        mAdapter.notifyItemRemoved(position);
        list.remove(position);
        mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
