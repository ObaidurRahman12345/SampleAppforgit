package com.example.sampleappforgit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sampleappforgit.R;
import com.example.sampleappforgit.model.Maintance;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MaintanceAdapter extends RecyclerView.Adapter<MaintanceAdapter.ViewHolder> {

    private Context context;
    private List<Maintance>maintances;
    public MaintanceAdapter(Context context,List<Maintance>maintances)
    {
      this.context =context;
      this.maintances =maintances;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.design,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
       Maintance maintance = maintances.get(position);
       holder.expenses.setText(maintance.getExpenses());
       holder.balance.setText(maintance.getBalance());
       holder.date.setText(maintance.getDate());
       holder.type.setText(maintance.getType());

    }

    @Override
    public int getItemCount()
    {
        return maintances.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView expenses,balance,date,type;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            expenses = itemView.findViewById(R.id.design_expanse);
            balance = itemView.findViewById(R.id.design_balance);
            date = itemView.findViewById(R.id.design_date);
            type = itemView.findViewById(R.id.design_shopping);


        }
    }
}
