package com.example.app1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.app1.MyFragmentAdapter;
import com.example.app1.R;
import com.example.app1.VideoPlayActivity;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {
    private MyFragmentAdapter myAdapter;
    private ListView listView;
    private List<String> list=new ArrayList<>();
    private String uri;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout2,null);
        listView=view.findViewById(R.id.listView2);
        list.add("视频1");
        list.add("视频2");
        list.add("视频3");
        myAdapter=new MyFragmentAdapter(list,getActivity());
        listView.setAdapter(myAdapter);
        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math1;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), VideoPlayActivity.class);
                intent.putExtra("uri",uri);
                intent.putExtra("title","素质教育");
                startActivity(intent);
            }
        });
        return view;
    }
}

