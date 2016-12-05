package se07.smart_ble;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by QuanLM on 03-Dec-16.
 */
public class ItemAdapter extends BaseAdapter {
    private Context _context;
    private static final String _LOG = "Adapter";
    public String _array[];

    private int countString = 0;
    private String strPIN = "";

    public ItemAdapter(Context context, String str[]) {
        _context = context;
        _array = str;
    }

    @Override
    public int getCount() {
        return _array.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        LayoutInflater inflater =
                (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if(convertView == null){

            gridView = new View(_context);
            gridView = inflater.inflate(R.layout.grid_item, null);
            final TextView textView = (TextView) gridView.findViewById(R.id.textView_itemGridview);
            textView.setText(_array[position]);
        }else{
            gridView = (View)convertView;
        }
        return gridView;
    }
}
