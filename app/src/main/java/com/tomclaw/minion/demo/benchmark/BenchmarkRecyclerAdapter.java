package com.tomclaw.minion.demo.benchmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomclaw.minion.demo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by solkin on 03.08.17.
 */
@SuppressWarnings("WeakerAccess")
public class BenchmarkRecyclerAdapter extends RecyclerView.Adapter<BenchmarkItemViewHolder> {

    private final Context context;
    private final List<BenchmarkItem> list;

    public BenchmarkRecyclerAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        setHasStableIds(true);
    }

    public int appendItem(BenchmarkItem item) {
        list.add(item);
        return list.size() - 1;
    }

    @NonNull
    @Override
    public BenchmarkItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.benchmark_item, parent, false);
        return new BenchmarkItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BenchmarkItemViewHolder holder, int position) {
        BenchmarkItem item = list.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }
}
