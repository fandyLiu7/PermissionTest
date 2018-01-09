package com.tongdao.permissiontest;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * 权限的请求练习
 */
public class MainActivity extends BaseActvity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        requestRuntimePermission(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA}, new permissionListener() {
            @Override
            public void onGranted() {
                Toast.makeText(MainActivity.this, "权限全部授权了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDenied(List<String> deniedPermissions) {
                for (String deniedPermission : deniedPermissions) {
                    Toast.makeText(MainActivity.this, "某个权限被禁止了 :" + deniedPermission, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
