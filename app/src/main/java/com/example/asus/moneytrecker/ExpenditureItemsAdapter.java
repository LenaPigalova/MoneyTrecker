package com.example.asus.moneytrecker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 24.01.2019.
 */
class ExpenditureItemsAdapter extends RecyclerView.Adapter<ExpenditureItemsAdapter.RecordViewHolder> {


    private List<Record> records = new ArrayList<>();

    public ExpenditureItemsAdapter() {
        createData();
    }

    @Override
    public ExpenditureItemsAdapter.RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExpenditureItemsAdapter.RecordViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expenditure_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ExpenditureItemsAdapter.RecordViewHolder holder, int position) {
        Record record = this.records.get(position);
        holder.applyData(record);
    }

    @Override
    public int getItemCount() {
        return this.records.size();
    }

    static class RecordViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView price;

        public RecordViewHolder(View itemsView){
            super(itemsView);

            title = (TextView)itemsView.findViewById(R.id.name_expenditure_text_view);
            price = (TextView)itemsView.findViewById(R.id.price_expenditure_text_view);

        }

        public void applyData(Record record) {
            title.setText(record.getTitle());
            String s = String.format("%d" + title.getContext().getString(R.string.currency_rub), record.getPrice());
            price.setText(s);
        }
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
}
