package com.yangqi.sfstools;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
        new Thread("dsfsdata") {
            // 步骤2：复写run（），内容 = 定义线程行为
            @Override
            public void run() {
                // 步骤3：通过 线程对象 控制线程的状态，如 运行、睡眠、挂起  / 停止
                //下载路径，如果路径无效了，可换成你的下载路径
                String url = "https://gitee.com/yangqicn/sfs-toolbox-data/raw/master/Data/sfsdata.txt";
                //创建下载任务,downloadUrl就是下载链接
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                //指定下载路径和下载文件名
                request.setDestinationInExternalPublicDir("/sdcard/Download/SFSTOOLBOX/data.txt", url.substring(url.lastIndexOf("/") + 1));
                //获取下载管理器
                DownloadManager downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                //将下载任务加入下载队列，否则不会进行下载
                downloadManager.enqueue(request);
            }

            public void start() {

            }
        };
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