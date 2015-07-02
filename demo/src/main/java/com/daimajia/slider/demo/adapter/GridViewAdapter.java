package com.daimajia.slider.demo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.demo.R;
import com.daimajia.slider.demo.model.GridViewItem;

import java.util.List;
/**
 * Created by soulivanh on 6/15/15 AD.
 */
public class GridViewAdapter extends BaseAdapter {

    public interface OnGridViewItemClickedListener {
        public void onGridViewItemClicked(GridViewItem.ItemType type);
    }

    private OnGridViewItemClickedListener listener;
    private Activity activity;
    private List<GridViewItem> items;

    public GridViewAdapter(Activity activity, List<GridViewItem> items, OnGridViewItemClickedListener listener) {
        super();
        this.items = items;
        this.activity = activity;
        this.listener = listener;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.gridview_item, null);
            holder.imgView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.title = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgView.setImageResource(items.get(i).getImgRes());
        holder.title.setText(items.get(i).getTitle());

        return convertView;
    }

    public static class ViewHolder {
        public ImageView imgView;
        public TextView title;
    }
}
