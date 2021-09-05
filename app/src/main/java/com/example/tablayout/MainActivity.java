package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.tablayout.Fragment.Fragment1;
import com.example.tablayout.Fragment.Fragment2;
import com.example.tablayout.Fragment.TabFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabs;
    View mIndicator;
    ViewPager mViewPager;
    private int indicatorWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabs  = findViewById(R.id.tab);
        mIndicator  = findViewById(R.id.indicator);
        mViewPager  = findViewById(R.id.viewPager);
        TabFragmentAdapter();
    }

    private void TabFragmentAdapter() {
        //Set up the view pager and fragments
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(Fragment1.newInstance(), "Tab 1");
        adapter.addFragment(Fragment2.newInstance(), "Tab 2");



        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager);
        //Determine indicator width at runtime
        mTabs.post(new Runnable() {
            @Override
            public void run() {
                indicatorWidth = mTabs.getWidth() / mTabs.getTabCount();

                //Assign new width
                FrameLayout.LayoutParams indicatorParams = (FrameLayout.LayoutParams) mIndicator.getLayoutParams();
                indicatorParams.width = indicatorWidth;
                mIndicator.setLayoutParams(indicatorParams);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPx) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)mIndicator.getLayoutParams();

                //Multiply positionOffset with indicatorWidth to get translation
                float translationOffset =  (positionOffset+i) * indicatorWidth ;
                params.leftMargin = (int) translationOffset;
                mIndicator.setLayoutParams(params);
            }
            @Override
            public void onPageSelected(int i) {
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
