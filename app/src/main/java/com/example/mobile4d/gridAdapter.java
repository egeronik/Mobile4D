package com.example.mobile4d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class gridAdapter extends ArrayAdapter<String> {


    private final LayoutInflater layoutInflater;

    int mResource;

    public gridAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.mResource = resource;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textView = convertView.findViewById(R.id.nameTV);
        ImageView imageView = convertView.findViewById(R.id.imageV);

        String img = getItem(position);


        try {
            imageView.setImageBitmap(new ImgBgTask().execute(img).get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        String br = img.split("/")[4];
        textView.setText(br);

        return convertView;

    }

    class ImgBgTask extends AsyncTask<String, Void, Bitmap> {

        private Exception exception;

        @SafeVarargs
        @Override
        protected final Bitmap doInBackground(String... pairs) {


            try {
                java.net.URL url = new URL(pairs[0]);
                Log.d("ADAPTER", pairs[0]);
                return BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
