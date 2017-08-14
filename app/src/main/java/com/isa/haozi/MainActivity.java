package com.isa.haozi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

import com.dianrong.android.dialog.CommonDialogBuilder;
import com.dianrong.android.dialog.ICommonDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ImageButton ibAdd;

    private List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        gridView = (GridView) findViewById(R.id.gridView);
        ibAdd = (ImageButton) findViewById(R.id.ibAdd);
        initData();

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.layout_item, new String[] {"image", "name"}, new int[] {R.id.image, R.id.tvName});
        gridView.setAdapter(adapter);

        ibAdd.setOnClickListener(v -> {
            // show set folder dialog
            createFolderDialog();
        });
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

    private void createFolderDialog() {
        CommonDialogBuilder builder = new CommonDialogBuilder(this);
        builder.setTitle("Create folder");
        builder.setCanceledOnTouchOutside(true);
        builder.setCustomView(getLayoutInflater().inflate(R.layout.layout_create_folder, null));
        builder.setButton(DialogInterface.BUTTON_POSITIVE, "OK");
        builder.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel");

        builder.setOnClickListener((dialogInterface, i) -> {
            dialogInterface.dismiss();
        });

        ICommonDialog iCommonDialog = builder.create();
        iCommonDialog.show();
    }
}
