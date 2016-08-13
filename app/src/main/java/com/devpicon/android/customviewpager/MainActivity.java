package com.devpicon.android.customviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager = null;
    private MainPagerAdapter pagerAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new MainPagerAdapter();
        pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(pagerAdapter);

        LayoutInflater inflater = this.getLayoutInflater();
        FrameLayout v0 = (FrameLayout) inflater.inflate(R.layout.one_of_my_page_layouts, null);
        pagerAdapter.addView(v0);
        pagerAdapter.notifyDataSetChanged();

        FrameLayout v1 = (FrameLayout) inflater.inflate(R.layout.one_of_my_page_layouts, null);
        pagerAdapter.addView(v1);
        pagerAdapter.notifyDataSetChanged();
    }

    public void addView(View newPage){
        int pageIndex = pagerAdapter.addView(newPage);
        pager.setCurrentItem(pageIndex, true);
    }

    public void removeView(View defunctPage){
        int pageIndex = pagerAdapter.removeView(pager, defunctPage);
        if(pageIndex == pagerAdapter.getCount()){
            pageIndex--;
        }
        pager.setCurrentItem(pageIndex);
    }

    public View getCurrentPage(){
        return pagerAdapter.getView(pager.getCurrentItem());
    }

    public void setCurrentPage(View pageToShow){
        pager.setCurrentItem(pagerAdapter.getItemPosition(pageToShow), true);
    }
}
