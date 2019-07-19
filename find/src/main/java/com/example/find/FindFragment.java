package com.example.find;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseFragment;

@Route(path = "/find/FindFragment")
public class FindFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("msg","findCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("msg","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("msg","onResume");
    }
}
