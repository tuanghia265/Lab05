package com.example.quickcallapp;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        findViewById(R.id.fr_mom).setOnClickListener(this);
        findViewById(R.id.fr_dad).setOnClickListener(this);
        findViewById(R.id.fr_crush).setOnClickListener(this);
        findViewById(R.id.fr_best_friend).setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_popup_enter));
        if (v instanceof FrameLayout) {
            processCall((String) v.getTag());
            return;
        }
        gotoDialPad();
    }
    private void gotoDialPad() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
    private void processCall(String phone) {
        if (checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 101);
            Toast.makeText(this, "Hãy thực hiện lại sau khi cấp quyền!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: " + phone));
        startActivity(intent);
    }
}
