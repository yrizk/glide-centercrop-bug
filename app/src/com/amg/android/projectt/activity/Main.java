package com.amg.android.projectt.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.amg.android.projectt.R;
import com.amg.android.projectt.fragment.ImgurListFragment;

public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ImgurListFragment())
                    .commit();
        }
    }

}
