package com.example.app1;

import android.widget.BaseAdapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app1.R;

import java.util.List;

public class MyFragmentAdapter extends BaseAdapter {
    private List<String> list;
    private LayoutInflater layoutInflater;
    public MyFragmentAdapter(List<String> list, Context context){
        this.list = list;
        this.layoutInflater =LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view=layoutInflater.inflate(R.layout.layout_item_video,null,false);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }
        //将数据库中内容加载到控件上
        String text= (String) getItem(i);
        holder.textView.setText(text);
        return view;
    }
    class ViewHolder{
        TextView textView;
        public ViewHolder(View view){
            textView=view.findViewById(R.id.tv_item);
        }
    }
}
