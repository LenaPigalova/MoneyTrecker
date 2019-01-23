package com.example.asus.moneytrecker;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExpenditureItemsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Record> records = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenditure_items);

        recyclerView = (RecyclerView)findViewById(R.id.list);
        createData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ExpenditureItemsAdapter());
        recyclerView.addItemDecoration(new myItemDecorator(16));
    }

    private void createData(){
        records.add(new Record("Молоко", 35));
        records.add(new Record("Мыло", 5));
        records.add(new Record("Телевизор", 3000000));
        records.add(new Record("Освежитель воздуха", 10));
        records.add(new Record("Борщ", 50));
        records.add(new Record("Та самая крутая вечеринка, которую устроила я", 1000000));
        records.add(new Record("", 0));
        records.add(new Record("Чай", 2));
        records.add(new Record("Кошачий корм", 5000));
        records.add(new Record("Ужин в ресторане", 30000));
        records.add(new Record("Новое платье", 8000));
    }

    private class ExpenditureItemsAdapter extends RecyclerView.Adapter<RecordViewHolder> {

        @Override
        public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecordViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expenditure_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecordViewHolder holder, int position) {
            Record record = records.get(position);
            holder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return records.size();
        }
    }

    private class RecordViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView price;

        public RecordViewHolder(View itemsView){
            super(itemsView);

            title = (TextView)itemsView.findViewById(R.id.name_expenditure_text_view);
            price = (TextView)itemsView.findViewById(R.id.price_expenditure_text_view);

        }

        public void applyData(Record record) {
            title.setText(record.getTitle());
            String s = String.format("%d" + getString(R.string.currency_rub), record.getPrice());
            price.setText(s);
        }
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
