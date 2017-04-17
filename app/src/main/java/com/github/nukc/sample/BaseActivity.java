package com.github.nukc.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.github.nukc.stateview.StateView;

/**
 * @author Nukc.
 */

public abstract class BaseActivity extends AppCompatActivity{

    private StateView mStateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        mStateView = StateView.inject(injectTarget());

        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                //do something
            }
        });
    }

    protected abstract @LayoutRes int setContentView();

    protected abstract View injectTarget();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_inject, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_empty:
                mStateView.showEmpty();
                break;
            case R.id.show_retry:
                mStateView.showRetry();
                break;
            case R.id.show_loading:
                mStateView.showLoading();
                break;
            case R.id.show_content:
                mStateView.showContent();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
