package com.example.componentapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.base.AroutConstance;
import com.example.commonlibrary.base.BaseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BaseFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        BaseFragment home = (BaseFragment) ARouter.getInstance().build(AroutConstance.HOME).navigation();
        BaseFragment find = (BaseFragment) ARouter.getInstance().build(AroutConstance.FIND).navigation();
        BaseFragment mine = (BaseFragment) ARouter.getInstance().build(AroutConstance.MINE).navigation();
        fragments = new ArrayList<>();
        fragments.add(home);
        fragments.add(find);
        fragments.add(mine);

        switchFragment(0);


        BottomNavigationView navigationView = findViewById(R.id.NavigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        switchFragment(0);
                        break;
                    case R.id.menu_find:
                        switchFragment(1);
                        break;
                    case R.id.menu_mine:
                        switchFragment(2);
                        break;
                        default:
                            break;
                }
                return true;
            }
        });
    }

    private void switchFragment(int i) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,fragments.get(i));
        fragmentTransaction.commit();

    }
}
