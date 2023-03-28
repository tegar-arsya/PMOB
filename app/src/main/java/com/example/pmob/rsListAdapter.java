package com.example.pmob;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.pmob.R;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class rsListAdapter extends ArrayAdapter<rsList> {
    public rsListAdapter(Activity context, ArrayList<rsList> RSnya) {

        super(context, 0, RSnya);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        listItemView = null;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_layout, parent, false);
        }else{
        }
        rsList currentrsList = getItem(position);
        TextView nameTextView = listItemView.findViewById(R.id.tvNamaCustom);
        nameTextView.setText(currentrsList.getnamaRS());
        TextView jarakTextView = listItemView.findViewById(R.id.tvJarak);
        jarakTextView.setText(new DecimalFormat("##.##").format(currentrsList.getJarakRS()) + "KM ");
        return listItemView;
    }

}