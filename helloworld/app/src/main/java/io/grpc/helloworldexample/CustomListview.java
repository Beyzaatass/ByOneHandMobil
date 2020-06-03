package io.grpc.helloworldexample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListview extends ArrayAdapter<String> {

    private String[] ilanbaslik;
    private String[] ilanbilgi;
    private Integer[] imgid;
    private Activity context;


    public CustomListview(Activity context,String[] ilanbaslik,String[] ilanbilgi,Integer[] imgid) {
        super(context, R.layout.layout,ilanbaslik);

        this.context=context;
        this.ilanbaslik=ilanbaslik;
        this.ilanbilgi=ilanbilgi;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder = null;
        if(r==null)
        {
            LayoutInflater layoutInflater= context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);

        }
        else
        {
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.imgtv.setImageResource(imgid[position]);

        viewHolder.basliktv.setText(ilanbaslik[position]);
        viewHolder.bilgitv.setText(ilanbilgi[position]);



        return r;
    }
    class ViewHolder
    {
        TextView basliktv;
        TextView bilgitv;
        ImageView imgtv;

        ViewHolder(View v)
        {
            basliktv=v.findViewById(R.id.name);
            bilgitv=v.findViewById(R.id.bilgi);
            imgtv=v.findViewById(R.id.imageView);

        }




    }
}
