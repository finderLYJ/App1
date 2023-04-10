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


public class Fragment4 extends Fragment {
    private MyFragmentAdapter myAdapter;
    private ListView listView;
    private List<String> list = new ArrayList<>();
    private String uri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout4, null);
        listView = view.findViewById(R.id.listView4);
        list.add("欢迎");//3
        list.add("问路");//10
        list.add("邀请");//6
        list.add("道别");//9
        list.add("赞美");//4
        list.add("祝愿");//5
        list.add("介绍");//2
        list.add("问候");//1
        list.add("致谢");//7
        list.add("道歉");//8
        myAdapter = new MyFragmentAdapter(list, getActivity());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), VideoPlayActivity.class);
                switch (i) {
                    case 0:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage1;
                        break;
                    case 1:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage2;
                        break;
                    case 2:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage3;
                        break;
                    case 3:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage4;
                        break;
                    case 4:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage5;
                        break;
                    case 5:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage6;
                        break;
                    case 6:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage7;
                        break;
                    case 7:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage8;
                        break;
                    case 8:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage9;
                        break;
                    case 9:
                        uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.signlanguage10;
                        break;
                    default:
                        break;
                }
                intent.putExtra("uri", uri);
                intent.putExtra("title","标准手语");
                startActivity(intent);
            }
        });
        return view;
    }
}

