package by.jum.locationbyip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import by.jum.locationbyip.LocationInformation;
import by.jum.locationbyip.R;

import java.util.List;

public class LocationInformationAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private LocationInformation information;
    private List<LocationInformation> informationList;

    public LocationInformationAdapter(Context context, List<LocationInformation> informationList) {
        this.informationList = informationList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return informationList.size();
    }

    @Override
    public Object getItem(int position) {
        return informationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.info, parent, false);
        }

        information = (LocationInformation) getItem(position);
        StringBuilder builder = new StringBuilder();
        builder.append(information.getIp()).append(" - ").append(information.getCountry()).
                append(", ").append(information.getCity());
        ((TextView) view.findViewById(R.id.textView1)).setText(builder.toString());
        ((ImageView) view.findViewById(R.id.imageView1)).setImageBitmap(information.getFlag());
        return view;
    }
}