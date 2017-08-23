package com.isa.haozi.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Izumi on 17/8/21.
 */

public class AddImageGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageList;
    private int maxImageCount;

    public AddImageGridAdapter(Context context, ArrayList<String> imageList, int maxImageCount) {
        this.context = context;
        this.imageList = imageList;
        this.maxImageCount = maxImageCount;
    }

    @Override
    public int getCount() {
        if (imageList.size() <= maxImageCount) {
            return imageList.size();
        } else {
            return maxImageCount;
        }
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    private class ViewHolder {
        ImageView ivItemDelete;
        ImageView ivItemAdd;
    }
}
