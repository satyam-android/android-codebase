package com.example.codebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.codebase.ui.main.RecyclerFragment;
import com.example.codebase.utils.AppFragmentManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout rlAppBar;
    ImageView ivBackArrow;
    TextView tvTitleAppBar;
    AppFragmentManager appFragmentManager;
    RelativeLayout progressBarContainer;
    TextView tvProgressTitle;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.main_activity);
        rlAppBar = findViewById(R.id.app_bar);
        ivBackArrow = findViewById(R.id.iv_back_arrow);
        tvTitleAppBar = findViewById(R.id.tv_app_title);
        progressBarContainer = findViewById(R.id.rl_progress_bar_container);
        tvProgressTitle = findViewById(R.id.tv_progress_title);
        ivBackArrow.setOnClickListener(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RecyclerFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(currentFragment!=null)
        currentFragment.onActivityResult(requestCode,resultCode,data);
    }

    public void setCurrentFragment(Fragment currentFragment){
        this.currentFragment=currentFragment;
    }

    public void hideAppBar() {
        rlAppBar.setVisibility(View.GONE);

    }

    public void showGlobalProgressBar(String progressTitle) {
        progressBarContainer.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        if (TextUtils.isEmpty(progressTitle)) {
            tvProgressTitle.setVisibility(View.GONE);
        } else {
            tvProgressTitle.setVisibility(View.VISIBLE);
            tvProgressTitle.setText(progressTitle);
        }
    }

    public void hideGlobalProgressBar() {

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        progressBarContainer.setVisibility(View.INVISIBLE);
    }

    public void showAppBar(String title) {

        rlAppBar.setVisibility(View.VISIBLE);
        tvTitleAppBar.setText(title);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_arrow:
                AppFragmentManager.getInstance().removeFragment();
                break;

            case R.id.tv_app_title:

                break;
        }
    }
}