package eu.tutorials.dialoglistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import eu.tutorials.dialoglistview.R;
import eu.tutorials.dialoglistview.model.PhanMem;

public class PhanMemAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<PhanMem> phanMemList;

    public PhanMemAdapter(Context context, int layout, List<PhanMem> phanMemList) {
        this.context = context;
        this.layout = layout;
        this.phanMemList = phanMemList;
    }

    @Override
    public int getCount() {
        return phanMemList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txt_android = convertView.findViewById(R.id.txt_android);
        TextView txt_name = convertView.findViewById(R.id.txt_name);
        ImageView img_cake = convertView.findViewById(R.id.img_cake);

        PhanMem phanMem = phanMemList.get(position);
        txt_android.setText(phanMem.getTenPhienBan());
        txt_name.setText(phanMem.getTenBanh());
        img_cake.setImageResource(phanMem.getAnhBanh());



        return convertView;
    }
}
