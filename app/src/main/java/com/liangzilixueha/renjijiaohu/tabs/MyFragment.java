package com.liangzilixueha.renjijiaohu.tabs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangzilixueha.renjijiaohu.R;
import com.liangzilixueha.renjijiaohu.card.ShoppingCarActivity;
import com.liangzilixueha.renjijiaohu.databinding.FragmentMyBinding;

import java.util.Objects;


public class MyFragment extends Fragment {

    private FragmentMyBinding binding;
    private SharedPreferences pref;

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyBinding.inflate(inflater, container, false);
        binding.button2.setOnClickListener(v -> startActivity(new Intent(getActivity()
                , ShoppingCarActivity.class)));
        pref = requireActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        binding.name.setOnClickListener(v -> {
            if (pref.getString("id", "未登录").equals("未登录")) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("id", "123");
                editor.putString("pwd", "123");
                editor.apply();
                binding.name.setText("123");
            } else {
                //弹出退出登录对话框
                new AlertDialog.Builder(requireActivity())
                        .setTitle("退出登录")
                        .setMessage("是否退出登录？")
                        .setPositiveButton("确定", (dialog, which) -> {
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("id", "未登录");
                            editor.putString("pwd", "未登录");
                            editor.apply();
                            binding.name.setText("未登录");
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
        return binding.getRoot();
    }
}