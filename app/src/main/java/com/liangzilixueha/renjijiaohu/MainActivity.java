package com.liangzilixueha.renjijiaohu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.liangzilixueha.renjijiaohu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //取消标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        binding.tab.setOnClickListener(v -> {
            binding.tvGuidance.getVisibility();
            binding.tvLocation.getVisibility();
            binding.tvPersonal.getVisibility();
            //转换能见性
            if (binding.tvGuidance.getVisibility() == View.VISIBLE) {
                binding.tvGuidance.setVisibility(View.GONE);
                binding.tvLocation.setVisibility(View.GONE);
                binding.tvPersonal.setVisibility(View.GONE);
            } else {
                binding.tvGuidance.setVisibility(View.VISIBLE);
                binding.tvLocation.setVisibility(View.VISIBLE);
                binding.tvPersonal.setVisibility(View.VISIBLE);
            }
        });
    }
}