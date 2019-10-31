package com.li.gohome.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.gohome.R;
import com.li.gohome.adapter.HomePageAdapter;
import com.li.gohome.baen.HomeModel;
import com.li.gohome.presenter.MainPresenter;

public class HomePageActivity extends Fragment implements IMainView{
    HomePageAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainPresenter presenter = new MainPresenter(this);
        presenter.getNetWorkInfo();
        View view = inflater.inflate(R.layout.activity_main, null);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new HomePageAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void getHomeModel(HomeModel homeModel) {
        if(adapter != null){
            adapter.addData(homeModel);
        }
    }
}
