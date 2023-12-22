package com.yangqi.sfstools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SFS ToolBox");
    }

    public void About(View view) {
        Intent intent = new Intent(this,AboutActivity.class);
        startActivity(intent);
    }

    public void DownloadSFS(View view) {
        Toast.makeText(MainActivity.this, "正在下载SFS...", Toast.LENGTH_SHORT).show();
    }

    public void StartSFS(View view) {
        Toast.makeText(MainActivity.this, "正在启动SFS...", Toast.LENGTH_SHORT).show();
    }
}