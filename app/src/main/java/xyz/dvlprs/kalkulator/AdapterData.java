package xyz.dvlprs.kalkulator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    ArrayList<History> listData;
    LayoutInflater layoutInflater;

    public AdapterData(Context context, ArrayList<History> listData) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.history_data, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.historyAngka1.setText(String.valueOf(listData.get(position).getAngka1()));
        holder.historyAngka2.setText(String.valueOf(listData.get(position).getAngka2()));
        holder.historyHasil.setText(String.valueOf(listData.get(position).getHasil()));
        holder.historyOperator.setText(listData.get(position).getOperator());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder{
        TextView historyAngka1, historyAngka2, historyHasil, historyOperator;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            historyAngka1 = itemView.findViewById(R.id.historyAngka1);
            historyAngka2 = itemView.findViewById(R.id.historyAngka2);
            historyHasil = itemView.findViewById(R.id.historyHasil);
            historyOperator = itemView.findViewById(R.id.historyOperator);
        }
    }
}
