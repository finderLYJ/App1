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


public class Fragment3 extends Fragment {
    private MyFragmentAdapter myAdapter;
    private ListView listView;
    private List<String> list=new ArrayList<>();
    private String uri;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout3,null);
        listView=view.findViewById(R.id.listView3);
        list.add("分段计费问题");
        list.add("简单的牛吃草问题");
        list.add("工程问题");
        list.add("相同出发点的往返相遇问题");
        list.add("不同出发点的往返相遇问题");
        list.add("神龟上的幻方问题");
        myAdapter=new MyFragmentAdapter(list,getActivity());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), VideoPlayActivity.class);
                switch (i){
                    case 0:
                        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math1;
                        break;
                    case 1:
                        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math2;
                        break;
                    case 2:
                        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math3;
                        break;
                    case 3:
                        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math4;
                        break;
                    case 4:
                        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math5;
                        break;
                    case 5:
                        uri="android.resource://"+getActivity().getPackageName()+"/"+R.raw.math6;
                        break;
                    default:
                        break;
                }
                intent.putExtra("uri",uri);
                intent.putExtra("title","口音标音");
                startActivity(intent);
            }
        });
        return view;
    }
}

