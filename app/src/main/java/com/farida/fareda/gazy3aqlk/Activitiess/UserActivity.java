package com.farida.fareda.gazy3aqlk.Activitiess;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.farida.fareda.gazy3aqlk.Adapter.Adapter;
import com.farida.fareda.gazy3aqlk.DB.DBManager;
import com.farida.fareda.gazy3aqlk.MOdle.Model;
import com.farida.fareda.gazy3aqlk.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    Adapter mAdapter;
    RecyclerView mRecyclerView;

    Model mModel;

    List<Model> mArrayList;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        mArrayList =new ArrayList<Model>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyc);

        dbManager =new DBManager(UserActivity.this);

        dbManager.open();

        dbManager.insert("ss","fdfd","elmy");
        dbManager.insert("ssdss","fdfd","elmy");


        mArrayList=dbManager.fetchtit("elmy");

        mAdapter =new Adapter(UserActivity.this,mArrayList);


        Log.i("HIteshdata",""+mArrayList);
        RecyclerView.LayoutManager reLayoutManager =new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(reLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }
}
