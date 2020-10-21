package com.example.lv9_zadaca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class simpleTabs extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ActionBar toolbar;

    private TabItem tabOne;
    private TabItem tabTwo;
    private TabItem tabThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_tabs);

        tabLayout = findViewById ( R.id.tabLayout );
        tabOne = findViewById ( R.id.tabOne );
        tabTwo = findViewById ( R.id.tabTwo );
        tabThree = findViewById ( R.id.tabThree );

        tabLayout.bringToFront ();
        viewPager = findViewById ( R.id.viewPager );

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager ( viewPager );

        //setupTabIcons ();
    }

    /*private void setupTabIcons(){
        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);
        tabLayout.getTabAt(2);
    }*/
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment01(), "ONE");
        adapter.addFragment(new Fragment02(), "TWO");
        adapter.addFragment(new Fragment03(), "THREE");
        viewPager.setAdapter ( adapter );
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> myFragmentList = new ArrayList<> ();
        private List<String> myTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return myFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return myFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return myTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            myFragmentList.add(fragment);
            myTitleList.add(title);
        }
    }

}