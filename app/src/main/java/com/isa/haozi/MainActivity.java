package com.isa.haozi;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.isa.haozi.widgets.FloatButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private FloatButton btAdd;

    private List<Map<String, Object>> list;

    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        gridView = (GridView) findViewById(R.id.gridView);
        btAdd = (FloatButton) findViewById(R.id.btAdd);
        initData();
        initGridView();

        btAdd.setOnClickListener(v -> {
            // show set folder dialog
            createFolderDialog();
        });
    }

    private void initData() {
        list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        //        map.put("image", R.drawable.cat_orange);
        map.put("name", "201706");
        list.add(map);
        //
        map = new HashMap<>();
        //        map.put("image", R.drawable.cat_pink);
        map.put("name", "201707");
        list.add(map);
    }

    private void initGridView() {
        adapter = new SimpleAdapter(this, list, R.layout.layout_folder_item, new String[] {"name"}, new int[] {R.id.tvName});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, position, id) -> {

        });

        gridView.setOnItemLongClickListener((adapterView, view, position, id) -> {
            return false;
        });
    }

    private void createFolderDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create folder");
        View customView = getLayoutInflater().inflate(R.layout.layout_create_folder, null);
        EditText etFolderName = (EditText) customView.findViewById(R.id.etInputFolderName);
        builder.setView(customView);

        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            String folderName = etFolderName.getEditableText().toString();
            if (!TextUtils.isEmpty(folderName)) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", folderName);
                list.add(map);
                adapter.notifyDataSetChanged();
            }
            dialogInterface.dismiss();
        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        builder.create().show();
    }
}
