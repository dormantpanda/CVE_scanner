package com.example.possible_vulnerabilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<CVE> cves;
    private OnItemClickListener onItemClickListener;

    DataAdapter(Context context, List<CVE> cves, OnItemClickListener onItemClickListener) {
        this.cves = cves;
        this.inflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        CVE cve = cves.get(position);
        holder.cveID.setText(cve.getCveId());
        holder.CVSSScore.setText("CVSS Score: " + cve.getCvssScore());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView cveID, CVSSScore;
        final LinearLayout linearLayoutWrap;
        ViewHolder(View view){
            super(view);
            cveID = (TextView) view.findViewById(R.id.cveID);
            CVSSScore = (TextView) view.findViewById(R.id.CVSSScore);
            linearLayoutWrap = view.findViewById(R.id.linearLayoutWrap);
            linearLayoutWrap.setOnClickListener(v -> {
                onItemClickListener.onItemClick(cves.get(getAdapterPosition()));
            });
        }
    }

    @Override
    public int getItemCount() {
        return cves.size();
    }

    interface OnItemClickListener {
        void onItemClick(CVE cve);
    }
}
