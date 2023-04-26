package com.example.ktratrenlop_tablayout.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ktratrenlop_tablayout.HorizontalFlipTransfromation;
import com.example.ktratrenlop_tablayout.R;
import com.example.ktratrenlop_tablayout.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
//                Toast.makeText(MainActivity.this, "Them", Toast.LENGTH_SHORT).show();
            }
        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new HorizontalFlipTransfromation());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Danh sach");
        tabLayout.getTabAt(1).setText("Thong tin");
        tabLayout.getTabAt(2).setText("Tim kiem");
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position){
//                    case 0: navigationView.getMenu().findItem(R.id.mDanhSach).setChecked(true);
//                        break;
//                    case 1: navigationView.getMenu().findItem(R.id.mThongTin).setChecked(true);
//                        break;
//                    case 2: navigationView.getMenu().findItem(R.id.mTimKiem).setChecked(true);
//                        break;
//                }
//            }

//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.mDanhSach: viewPager.setCurrentItem(0);
//                        break;
//                    case R.id.mThongTin: viewPager.setCurrentItem(1);
//                        break;
//                    case R.id.mTimKiem: viewPager.setCurrentItem(2);
//                        break;
//                }
//                return true;
//            }
//        });
    }
}