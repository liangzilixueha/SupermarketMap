package com.liangzilixueha.renjijiaohu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.liangzilixueha.renjijiaohu.databinding.ActivityMainBinding;
import com.liangzilixueha.renjijiaohu.databinding.ActivitySrarchBussionBinding;

import java.util.ArrayList;
import java.util.Random;

public class SearchBussionActivity extends AppCompatActivity {

    private ActivitySrarchBussionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srarch_bussion);
        binding = ActivitySrarchBussionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //取消标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ArrayList<Bussion> bussions = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            bussions.add(new Bussion("测试", "测试", i + ""));
        }
        GodAdapter<Bussion> adapter = new GodAdapter<Bussion>(bussions, R.layout.item_bussion) {
            @Override
            public void bindView(ViewHolder holder, Bussion obj) {
                holder.setText(R.id.name, obj.name);
                holder.setText(R.id.more, obj.more);
                holder.setText(R.id.score, "评分:" + obj.score);
                holder.setImageResource(R.id.iv, R.drawable.ic_launcher_background);

            }
        };
        binding.listview.setAdapter(adapter);
    }

    class Bussion {
        public Bitmap bitmap;
        public String name;
        public String more;
        public String score;

        public Bussion(String name, String more, String score) {
            this.name = name;
            this.more = more;
            this.score = score;
        }
    }
}