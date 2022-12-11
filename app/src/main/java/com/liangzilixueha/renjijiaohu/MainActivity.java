package com.liangzilixueha.renjijiaohu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.liangzilixueha.renjijiaohu.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

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
        //点击文字下降
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
        //切换页面
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, new GuidanceFragment());
        transaction.commit();
        binding.ivGuidance.setOnClickListener(v -> {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            t.replace(R.id.fragment, new GuidanceFragment());
            t.commit();
        });
        binding.ivLocation.setOnClickListener(v -> {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            t.replace(R.id.fragment, new LoactionFragment());
            t.commit();
        });
        binding.ivPersonal.setOnClickListener(v -> {
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            t.replace(R.id.fragment, new PersonFragment());
            t.commit();
        });
        //点击搜索事件
        binding.search.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                //获取焦点时，出现下拉菜单
                ListView listView = binding.listView;
                listView.setVisibility(View.VISIBLE);
                //系统默认简单适
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    list.add(i + "");
                }
                GodAdapter<String> adapter = new GodAdapter<String>((ArrayList) list, R.layout.simple_item) {

                    @Override
                    public void bindView(ViewHolder holder, String obj) {
                        TextView view = holder.getView(R.id.tv);
                        view.setOnClickListener(v -> {
                            binding.listView.setVisibility(View.GONE);
                            binding.search.clearFocus();
                        });
                        view.setText(obj);
                    }
                };
                listView.setAdapter(adapter);
                ObjectAnimator animator = ObjectAnimator.ofFloat(binding.cvSearch, "translationY", 0, +200);
                animator.setDuration(1000);
                animator.start();
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(binding.listView, "translationY", 0, +180);
                animator1.setDuration(1000);
                animator1.start();
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(binding.listView, "alpha", 0, 1);
                animator2.setDuration(1000);
                animator2.start();
                ObjectAnimator.ofFloat(binding.cvMore, "translationY", 0, +350).setDuration(1000).start();
            } else {
//                失去焦点时，执行动画
                ObjectAnimator animator = ObjectAnimator.ofFloat(binding.cvSearch, "translationY", +200, 0);
                animator.setDuration(1000);
                animator.start();
                ObjectAnimator.ofFloat(binding.cvMore, "translationY", +350,0).setDuration(1000).start();
                //关闭键盘
            }
        });
        //前往商家
        binding.iv1.setOnClickListener(v->{
            startActivity(new Intent(this, SearchBussionActivity.class));
        });
    }
}