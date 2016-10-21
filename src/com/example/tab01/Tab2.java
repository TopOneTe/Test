package com.example.tab01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.fragment_fragemt.R;

public class Tab2 extends FragmentActivity implements OnClickListener{
	private LinearLayout weixinTab;
	private LinearLayout friendTab;
	private LinearLayout findTab;
	private LinearLayout setTab;
	
	private ImageButton wxImg;
	private ImageButton friImg;
	private ImageButton findImg;
	private ImageButton setImg;
	
	private Fragment f1;
	private Fragment f2;
	private Fragment f3;
	private Fragment f4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_activity);
		initView();
		initEvent();
		setSelect(0);
	}
	//初始化布局
	private void initView() {
		weixinTab = (LinearLayout) findViewById(R.id.tabWeixin);
		friendTab = (LinearLayout) findViewById(R.id.tab_friend);
		findTab = (LinearLayout) findViewById(R.id.tabFing);
		setTab = (LinearLayout) findViewById(R.id.tabSetting);
		
		wxImg = (ImageButton) findViewById(R.id.wxImg);
		friImg = (ImageButton) findViewById(R.id.friImg);
		findImg = (ImageButton) findViewById(R.id.findImg);
		setImg = (ImageButton) findViewById(R.id.setImg);
		
	}
	//初始化监听事件
	private void initEvent() {
		weixinTab.setOnClickListener(this);
		friendTab.setOnClickListener(this);
		findTab.setOnClickListener(this);
		setTab.setOnClickListener(this);
		}

	@Override
	public void onClick(View v) {
		resetImg();
		switch (v.getId()) {
		case R.id.tabWeixin:
			setSelect(0);
			break;
		case R.id.tab_friend:
			setSelect(1);
			break;
		case R.id.tabFing:
			setSelect(2);
			break;
		case R.id.tabSetting:
			setSelect(3);
			break;
        
		default:
			break;
		}
	}
	
    private void setSelect(int i){
    	FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction transaction = fm.beginTransaction();
    	hideFragment(transaction);
    	switch (i) {
		case 0:
			if(f1 == null){
				f1 = new FragmentTop1();
				transaction.add(R.id.context, f1);
			}else{
				transaction.show(f1);
			}
			wxImg.setImageResource(R.drawable.tab_weixin_pressed);
			break;
        case 1:
        	if(f2 == null){
				f2 = new Fragment2();
				transaction.add(R.id.context, f2);
			}else{
				transaction.show(f2);
			}
        	friImg.setImageResource(R.drawable.tab_address_pressed);
			break;
        case 2:
        	if(f3 == null){
				f3 = new Fragment3();
				transaction.add(R.id.context, f3);
			}else{
				transaction.show(f3);
			}
        	findImg.setImageResource(R.drawable.tab_find_frd_pressed);
	        break;
        case 3:
        	if(f4 == null){
				f4 = new Fragment4();
				transaction.add(R.id.context, f4);
			}else{
				transaction.show(f4);
			}
        	setImg.setImageResource(R.drawable.tab_settings_pressed);
	        break;

		default:
			break;
		}
    	transaction.commit();
    }
	private void hideFragment(FragmentTransaction transaction) {
		if(f1 != null){
			transaction.hide(f1);
		}
		if(f2 != null){
			transaction.hide(f2);
		}
		if(f3 != null){
			transaction.hide(f3);
		}
		if(f4 != null){
			transaction.hide(f4);
		}
	}

	private void resetImg() {
		wxImg.setImageResource(R.drawable.tab_weixin_normal);
		friImg.setImageResource(R.drawable.tab_address_normal);
		findImg.setImageResource(R.drawable.tab_find_frd_normal);
		setImg.setImageResource(R.drawable.tab_settings_normal);
	}

}
