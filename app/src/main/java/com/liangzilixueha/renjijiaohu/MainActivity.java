package com.liangzilixueha.renjijiaohu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.liangzilixueha.renjijiaohu.databinding.ActivityMainBinding;
import com.liangzilixueha.renjijiaohu.tabs.BusinessFragment;
import com.liangzilixueha.renjijiaohu.tabs.D3Fragment;
import com.liangzilixueha.renjijiaohu.tabs.MapFragment;
import com.liangzilixueha.renjijiaohu.tabs.MyFragment;
import com.liangzilixueha.renjijiaohu.var.Info;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "主程序";
    private ActivityMainBinding binding;
    private String[] 标题 = {"3D视图", "地图", "我的", "商家"};
    private ArrayList<Fragment> FragmentList = new ArrayList<>();
    private List<String> 菜单内容 = Arrays.asList("扫一扫", "退出");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        testInfo();
        FragmentList.add(new D3Fragment());
        FragmentList.add(new MapFragment());
        FragmentList.add(new MyFragment());
        FragmentList.add(new BusinessFragment());
        binding.slidingLayout.setViewPager(binding.viewPage, 标题, this, FragmentList);
        binding.slidingLayout.setIndicatorStyle(2);
    }

    private void testInfo() {
        //测试数据
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE)
                .edit();
        editor.putString(Info.ID, "未登录");
        editor.putString(Info.PWD, "未登录");
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (int i = 0; i < 菜单内容.size(); i++) {
            menu.add(0, i, i, 菜单内容.get(i));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 1);
                break;
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
                /*
                粘贴到剪贴板
                 */
                android.content.ClipboardManager cm = (android.content.ClipboardManager) getSystemService(Activity.CLIPBOARD_SERVICE);
                android.content.ClipData mClipData = android.content.ClipData.newPlainText("Label", content);
                cm.setPrimaryClip(mClipData);
            }
        }
    }

}