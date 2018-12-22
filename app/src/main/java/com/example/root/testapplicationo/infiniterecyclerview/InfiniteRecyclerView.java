package com.example.root.testapplicationo.infiniterecyclerview;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.anewhome.HomeActivityViewModel;
import com.example.root.testapplicationo.retofit_test.viewmodels.viewmodelstate.UserAuthenticationState;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecyclerView extends AppCompatActivity {
    HomeActivityViewModel homeActivityViewModel;
    RecyclerView mRecyclerView;
    List<ResponseModel.Item> reItems = new ArrayList<>();
    ItemAdapter itemAdapter;

    //the size of a page that we want
    public static final int PAGE_SIZE = 10;

    //we will start from the first page which is 1
    int FIRST_PAGE = 0;

    //we need to fetch from stackoverflow
    private static final String SITE_NAME = "stackoverflow";
    // private Object totalItemCount;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;


    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private int mloadMoreData;
    private int firstVisibleItem;

    private boolean mLoadingStarted = false;
    // private OnLoadMoreListener onLoadMoreListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_infinite_recycler_view);
        initView();

        homeActivityViewModel = ViewModelProviders.of(InfiniteRecyclerView.this).get(HomeActivityViewModel.class);
          subscribeForAnswer();
        scrollListener();

    }

    @Override
    protected void onResume() {
        super.onResume();

        homeActivityViewModel.getAnswer(FIRST_PAGE, PAGE_SIZE, SITE_NAME);

    }

    private void scrollListener() {
        //  if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        //RecyclerView.OnScrollListener scrooll = new RecyclerView.OnScrollListener( )
        //  mRecyclerView.setOnScrollListener(this);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                mloadMoreData = totalItemCount - lastVisibleItem;
                //  if (mloadMoreData != 0 && mloadMoreData == firstVisibleItem	&& !mLoadingStarted) {
                if (mloadMoreData != 0 && mloadMoreData == firstVisibleItem && !mLoadingStarted) {

                    // mLoadingStarted = true;
                    homeActivityViewModel.getAnswer(FIRST_PAGE + 1, PAGE_SIZE, SITE_NAME);

                    //    Toast.makeText(this,totalItemCount+" "+lastVisibleItem +" "+ firstVisibleItem,Toast.LENGTH_LONG).show();
                    // getDestFeedsFromServer(false);

                }


            }
        });

    }

    private void initView() {

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        itemAdapter = new ItemAdapter(this, reItems);

    }

    private void subscribeForAnswer() {
        homeActivityViewModel.subscribefordata().observe(this, new Observer<UserAuthenticationState<ResponseModel>>() {
            @Override
            public void onChanged(@Nullable UserAuthenticationState<ResponseModel> responseModel) {

                switch (responseModel.getStatus()) {
                    case LOADING:
                        break;
                    case SUCCESS:
                      //  if(responseModel.getUserData().getItems() != null)
                        reItems = responseModel.getUserData().getItems();
                        itemAdapter.setAdapterItem(reItems);
                        mRecyclerView.setAdapter(itemAdapter);
                        mLoadingStarted = false;
                        break;
                }

            }
        });

    }


}
