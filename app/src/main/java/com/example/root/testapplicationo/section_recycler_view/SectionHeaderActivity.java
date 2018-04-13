/*
package com.example.root.testapplicationo.section_recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.root.testapplicationo.R;
import com.timehop.stickyheadersrecyclerview.stStickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionHeaderActivity extends AppCompatActivity {

    private static final String TAG = SectionHeaderActivity.class.getSimpleName();

    private String[] names = Constant.name;
    private  String[] images = Constant.image;


    RecyclerView recyclerView;

    RecyclerHeaderItemAdapter mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_header);
        ButterKnife.bind(this);
    recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List listItems = getList();
        mAdapter = new RecyclerHeaderItemAdapter(this, listItems);
        recyclerView.setAdapter(mAdapter);


        // Add the sticky headers decoration
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(mAdapter);
        recyclerView.addItemDecoration(headersDecor);

        // Add decoration for dividers between list items
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        StickyRecyclerHeadersTouchListener touchListener =
                new StickyRecyclerHeadersTouchListener(recyclerView, headersDecor);
        recyclerView.addOnItemTouchListener(touchListener);

    }

    private List getList(){
        List list = new ArrayList<>();
        for (int index =0; index < names.length; index++){
            ItemModel itemModel = new ItemModel();
            itemModel.setName(names[index]);
            itemModel.setImagePath(images[index]);
            list.add(itemModel);
        }
        if (list.size() > 0) {
            Collections.sort(list, new Comparator() {
                @Override
                public int compare(Object o, Object t1) {
                    return 0;
                }


                public int compare(final ItemModel object1, final ItemModel object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
        }
        return list;
    }
}
*/
