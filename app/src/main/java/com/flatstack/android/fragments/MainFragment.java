package com.flatstack.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flatstack.android.R;
import com.flatstack.android.dagger.Dagger;
import com.flatstack.android.utils.ActionBars;
import com.flatstack.android.utils.DatabaseHelper;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.Lazy;

public class MainFragment extends Fragment {
  @Inject @NotNull Lazy<Picasso>        picasso; // application scope
  @Inject @NotNull Lazy<DatabaseHelper> databaseHelper; //activity scope

  @Override public View onCreateView(LayoutInflater inflater,
                                     ViewGroup container,
                                     Bundle savedInstanceState) {
    return inflater.inflate(R.layout.main, container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ActionBars.configure(this, actionBar -> {
        ActionBars.homeAsUp(actionBar, false);
        actionBar.setTitle(R.string.app_name);
    });
    Dagger.inject(this);
  }
}
