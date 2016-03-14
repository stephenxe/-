package com.xiaokai.viewpager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.Window;
import android.widget.Toast;

import com.xiaokai.view.ViewPagerIndicator;
import com.xiaokai.view.ViewPagerIndicator.PageOnchangeListen;
import com.xiaokai.view.VpSimpleFragment;

public class MainActivity extends FragmentActivity {
	
	private ViewPager mViewPager;
	private ViewPagerIndicator mIndicator;
	
	private List<String> mTitles = Arrays.asList("推荐","热点","深圳","视频","搞笑","图片","段子","风景","小说");
	private List<VpSimpleFragment> mContents = new ArrayList<VpSimpleFragment>();
	private FragmentPagerAdapter mAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main1);
        
        initViews();
        initDatas();
        
        mViewPager.setAdapter(mAdapter);
        
        mIndicator.setVisibaleTabCount(6);
        mIndicator.setTabItemTitles(mTitles);
        mIndicator.setViewPager(mViewPager, 0);
     
    }


    private void initDatas() {
		for(String title:mTitles){
			VpSimpleFragment fragment = VpSimpleFragment.newInstance(title);
			mContents.add(fragment);
		}
		mAdapter= new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return mContents.size();
			}
			
			@Override
			public Fragment getItem(int position) {
				return mContents.get(position);
			}
		};
	}


	private void initViews() {
		mViewPager=(ViewPager) findViewById(R.id.id_viewpager);
		mIndicator=(ViewPagerIndicator) findViewById(R.id.id_indicator);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
