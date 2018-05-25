package com.example.qq_tab;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mViews=new ArrayList<View>();

    private LinearLayout mTabNews;
    private LinearLayout mTabPeople;
    private LinearLayout mTabDynamic;

    private ImageButton mNewsImg;
    private ImageButton mPeopleImg;
    private ImageButton mDynamicImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvents();
    }

    private void initEvents()
    {
        mTabNews.setOnClickListener(this);
        mTabPeople.setOnClickListener(this);
        mTabDynamic.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                int currentItem=mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem)
                {
                    case 0:
                        mNewsImg.setImageResource(R.drawable.news);

                        break;
                    case 1:
                        mPeopleImg.setImageResource(R.drawable.people);

                        break;
                    case 2:
                        mDynamicImg.setImageResource(R.drawable.dynamic);

                        break;
                    default:

                        break;
                }

                }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    private void initView()
    {
        mViewPager=(ViewPager)findViewById(R.id.id_viewpager);

        mTabNews=(LinearLayout)findViewById(R.id.id_tab_news);
        mTabPeople=(LinearLayout)findViewById(R.id.id_tab_people);
        mTabDynamic=(LinearLayout)findViewById(R.id.id_tab_dynamic);

        mNewsImg=(ImageButton)findViewById(R.id.id_tab_news_img);
        mPeopleImg=(ImageButton)findViewById(R.id.id_tab_people_img);
        mDynamicImg=(ImageButton)findViewById(R.id.id_tab_dynamic_img);

        LayoutInflater mInflater=LayoutInflater.from(this);
        View tab01=mInflater.inflate(R.layout.tab01,null);
        View tab02=mInflater.inflate(R.layout.tab02,null);
        View tab03=mInflater.inflate(R.layout.tab03,null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);

        mAdapter=new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0==arg1;
            }

            @Override
            public void destroyItem(ViewGroup container,int position,Object object)
            {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container,int position)
            {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }
        };
        mViewPager.setAdapter(mAdapter);
    }

    public void onClick(View v)
    {
        resetImg();
        switch (v.getId())
        {
            case R.id.id_tab_news:
                mViewPager.setCurrentItem(0);
                mNewsImg.setImageResource(R.drawable.news);

                break;
            case R.id.id_tab_people:
                mViewPager.setCurrentItem(1);
                mPeopleImg.setImageResource(R.drawable.people);

                break;
            case R.id.id_tab_dynamic:
                mViewPager.setCurrentItem(2);
                mDynamicImg.setImageResource(R.drawable.dynamic);

                break;
            default:

                break;

        }
    }
    private void resetImg()
    {
        mNewsImg.setImageResource(R.drawable.news1);
        mPeopleImg.setImageResource(R.drawable.people1);
        mDynamicImg.setImageResource(R.drawable.dynamic1);
    }
}
