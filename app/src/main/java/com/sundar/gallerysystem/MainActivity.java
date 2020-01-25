package com.sundar.gallerysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mySelection;
    Gallery myGallery;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final int[] myImageIds = {
                R.drawable.android,
                R.drawable.androids,
                R.drawable.animation,
                R.drawable.network,
                R.drawable.password,
                R.drawable.register,
                R.drawable.smile,
                R.drawable.speak,
                R.drawable.sqlserver
        };

        mySelection = (TextView) findViewById(R.id.textView2);
        myGallery = (Gallery) findViewById(R.id.myGallery);
        img = (ImageView) findViewById(R.id.imageView1);

        myGallery.setAdapter(new ImageAdapter(this));

        myGallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {

                mySelection.setText(" selected option: " + position );

                img.setImageResource(myImageIds[position]);
            }

            public void onNothingSelected(AdapterView<?> parent) {

                mySelection.setText("Nothing selected");
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {

        private Context myContext;

        private int[] myImageIds = {
                R.drawable.android,
                R.drawable.smile,
                R.drawable.speak,
                R.drawable.animation,
                R.drawable.androids,
                R.drawable.android,
                R.drawable.password,
                R.drawable.sqlserver,
                R.drawable.network
        };

        public ImageAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return this.myImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }
        // Returns a new ImageView to be displayed,
        public View getView(int position, View convertView,
                            ViewGroup parent) {

            ImageView iv = new ImageView(this.myContext);
            iv.setImageResource(this.myImageIds[position]);

            iv.setScaleType(ImageView.ScaleType.FIT_END);

            // Set the Width & Height of the individual images
            iv.setLayoutParams(new Gallery.LayoutParams(95, 70));

            return iv;
        }
    }


}
