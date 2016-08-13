package com.devpicon.android.customviewpager;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager pager = null;
    private MainPagerAdapter pagerAdapter = null;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pagerAdapter = new MainPagerAdapter();
        pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(pagerAdapter);

        tabs = (TabLayout) findViewById(R.id.tabs);
        //tabs.setupWithViewPager(pager);

        LayoutInflater inflater = this.getLayoutInflater();
        FrameLayout v0 = (FrameLayout) inflater.inflate(R.layout.one_of_my_page_layouts, null);

        pagerAdapter.addView(v0);
        pagerAdapter.notifyDataSetChanged();
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
        tabs.addTab(tabs.newTab().setText("Tab 1"));


        FrameLayout v1 = (FrameLayout) inflater.inflate(R.layout.two_of_my_page_layouts, null);
        pagerAdapter.addView(v1);
        pagerAdapter.notifyDataSetChanged();
        tabs.addTab(tabs.newTab().setText("Tab 2"));
    }

    public void addView(View newPage) {
        Log.d(TAG, "Ingreso a addView");
        int pageIndex = pagerAdapter.addView(newPage);
        pager.setCurrentItem(pageIndex, true);
    }

    public void removeView(View defunctPage) {
        Log.d(TAG, "Ingreso a removeView");
        int pageIndex = pagerAdapter.removeView(pager, defunctPage);
        if (pageIndex == pagerAdapter.getCount()) {
            pageIndex--;
        }
        pager.setCurrentItem(pageIndex);
    }

    public View getCurrentPage() {
        Log.d(TAG, "Ingreso a getCurrentPage");
        return pagerAdapter.getView(pager.getCurrentItem());
    }

    public void setCurrentPage(View pageToShow) {
        Log.d(TAG, "Ingreso a setCurrentPage");
        pager.setCurrentItem(pagerAdapter.getItemPosition(pageToShow), true);

    }
}
