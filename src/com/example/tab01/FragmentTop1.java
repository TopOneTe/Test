package com.example.tab01;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment_fragemt.R;

public class FragmentTop1 extends Fragment implements OnClickListener{
	
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	
	private ViewPager viewPager;
	private FragmentPagerAdapter mAdapter;
	private List mViews = new ArrayList();
	private View v;
	private View v1;
	private View v2;
	private View v3;
	private View v4;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 v = inflater.inflate(R.layout.topall, container, false);
		 initLayout();
		 
		 mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mViews.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return (Fragment) mViews.get(arg0);
			}
		};
		viewPager.setAdapter(mAdapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			private int currentIndex;
			@Override
			public void onPageSelected(int arg0) {
				resetColor();
				switch(arg0){
				case 0:
					tv1.setTextColor(Color.rgb(87, 153, 8));
					break;
				case 1:
					tv2.setTextColor(Color.rgb(87, 153, 8));
					break;
				case 2:
					tv3.setTextColor(Color.rgb(87, 153, 8));
					break;
				case 3:
					tv4.setTextColor(Color.rgb(87, 153, 8));
					break;
				default:
					break;
				}
				currentIndex = arg0;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		return v;
	}

	private void initLayout() {
		
		tv1 = (TextView) v.findViewById(R.id.tv1);
		tv2 = (TextView) v.findViewById(R.id.tv2);
		tv3 = (TextView) v.findViewById(R.id.tv3);
		tv4 = (TextView) v.findViewById(R.id.tv4);
		viewPager = (ViewPager) v.findViewById(R.id.viewPager);
		
		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);
		tv4.setOnClickListener(this);
		
		Fragment1 f1 = new Fragment1();
		Fragment2 f2 = new Fragment2();
		Fragment3 f3 = new Fragment3();
		Fragment4 f4 = new Fragment4();
		
		mViews.add(f1);
		mViews.add(f2);
		mViews.add(f3);
		mViews.add(f4);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.tv1:
			resetColor();
			tv1.setTextColor(Color.rgb(87, 153, 8));
			viewPager.setCurrentItem(0);
			break;
		case R.id.tv2:
			resetColor();
			tv2.setTextColor(Color.rgb(87, 153, 8));
			viewPager.setCurrentItem(1);
			break;
		case R.id.tv3:
			resetColor();
			tv3.setTextColor(Color.rgb(87, 153, 8));
			viewPager.setCurrentItem(2);
			break;
		case R.id.tv4:
			resetColor();
			tv4.setTextColor(Color.rgb(87, 153, 8));
			viewPager.setCurrentItem(3);
			break;
		default:
			break;
		}
	}
	public void resetColor(){
		tv1.setTextColor(Color.rgb(56,56,56));
		tv2.setTextColor(Color.rgb(56,56,56));
		tv3.setTextColor(Color.rgb(56,56,56));
		tv4.setTextColor(Color.rgb(56,56,56));
	}
	public class MyPagerAdapter extends PagerAdapter { 
        public List<Activity> mListViews; 
 
        public MyPagerAdapter(List<Activity> mListViews) { 
            this.mListViews = mListViews; 
        } 
 
       
        @Override 
        public void finishUpdate(View arg0) { 
        } 
 
        @Override 
        public int getCount() { 
            return mListViews.size(); 
        } 
 
      
 
        @Override 
        public boolean isViewFromObject(View arg0, Object arg1) { 
            return arg0 == (arg1); 
        } 
 
        @Override 
        public void restoreState(Parcelable arg0, ClassLoader arg1) { 
        } 
 
        @Override 
        public Parcelable saveState() { 
            return null; 
        } 
 
        @Override 
        public void startUpdate(View arg0) { 
        } 
	}
}
