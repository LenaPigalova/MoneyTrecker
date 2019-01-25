package com.example.asus.moneytrecker;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmrntItemsActivity extends Fragment {

    private RecyclerView recyclerView;
    ExpenditureItemsAdapter adapter;
    private static final String key = "KEY";

    private int type;

    public static FragmrntItemsActivity createFragmentItem (int type){
        FragmrntItemsActivity fragmrntItems = new FragmrntItemsActivity();

        Bundle bundle = new Bundle();
        bundle.putInt(key, type);
        fragmrntItems.setArguments(bundle);
        return fragmrntItems;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ExpenditureItemsAdapter();
        Bundle bundle = getArguments();
        type = bundle.getInt(key);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new myItemDecorator(16));
    }

    private class myItemDecorator extends RecyclerView.ItemDecoration{

        private int offset;

        public myItemDecorator(int offset){
            this.offset = offset;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.right = offset;
            outRect.left = offset;
            outRect.top = offset;
        }

    }
}
