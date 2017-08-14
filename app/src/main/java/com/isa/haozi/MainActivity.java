package com.isa.haozi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        gridView = (GridView) findViewById(R.id.gridView);
        initData();

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.layout_item, new String[] {"image", "name"}, new int[] {R.id.image, R.id.tvName});
        gridView.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("image", R.drawable.cat_orange);
        map.put("name", getString(R.string.daily));
        list.add(map);

        map = new HashMap<>();
        map.put("image", R.drawable.cat_pink);
        map.put("name", getString(R.string.specialMoment));
        list.add(map);
    }
}
