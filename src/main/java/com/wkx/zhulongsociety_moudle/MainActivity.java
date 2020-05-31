package com.wkx.zhulongsociety_moudle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wkx.fragment.BarrageFragment;
import com.wkx.fragment.CourseFragment;
import com.wkx.fragment.DataFragment;
import com.wkx.fragment.HomeFragment;
import com.wkx.fragment.MyselfFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CourseFragment());
        fragmentList.add(new BarrageFragment());
        fragmentList.add(new DataFragment());
        fragmentList.add(new MyselfFragment());


        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        View home = setLayout(R.drawable.home_img, "首页");
        View course = setLayout(R.drawable.classes_img, "课程");
        View barrage = setLayout(R.drawable.barrage_img, "VIp");
        View data = setLayout(R.drawable.data_img, "资料");
        View myself = setLayout(R.drawable.myself_img, "我的");


        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setCustomView(home);
        tabLayout.getTabAt(1).setCustomView(course);
        tabLayout.getTabAt(2).setCustomView(barrage);
        tabLayout.getTabAt(3).setCustomView(data);
        tabLayout.getTabAt(4).setCustomView(myself);
    }

    public View setLayout(int img, String title) {
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.select_item, null);
        ImageView imageViewTab = inflate.findViewById(R.id.imageViewTab);
        TextView titleTab = inflate.findViewById(R.id.titleTab);
        imageViewTab.setImageResource(img);
        titleTab.setText(title);
        return inflate;
    }
}