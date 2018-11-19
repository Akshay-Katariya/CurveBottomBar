package com.akshay.example.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.akshay.example.R;
import com.akshay.library.CurveBottomBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshay Katariya on 15/11/18.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CurveBottomBar cbb;

    private List<Integer> moviesList = new ArrayList<Integer>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        prepareData();
        prepareAdapter();

        //Set values at runtime
        cbb.setBottomBarColor(getResources().getColor(R.color.yellow));
        cbb.setCurveRadius(52);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) cbb.getLayoutParams();
        layoutParams.setBehavior(new BottomBarBehavior());

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv);

        cbb = findViewById(R.id.customBottomBar);
        cbb.inflateMenu(R.menu.bottom_menu);
    }

    private void prepareData() {
        for (int i = 0; i < 50; i++) {
            moviesList.add(i);
        }
    }

    private void prepareAdapter() {
        MyAdapter mAdapter = new MyAdapter(moviesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

}
