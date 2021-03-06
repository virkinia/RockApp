package com.example.rockapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MyPagerAdapter extends PagerAdapter {

    //Tutorial : https://androidclarified.com/viewpager-example-sliding-images/


    private Context context;
    private  OnImageClickListener mListener;
    private ImageView imageView;

    public MyPagerAdapter(Context context, OnImageClickListener listener) {
        this.context = context;
        mListener = listener;
    }



    /*
   This callback is responsible for creating a page. We inflate the layout and set the drawable
   to the ImageView based on the position. In the end we add the inflated layout to the parent
   container .This method returns an object key to identify the page view, but in this example page view
   itself acts as the object key
   */
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager_item_layout, null);
        imageView= view.findViewById(R.id.image);
        if(position == 0) {
            getImageWithPicasso();
        } else {
            imageView.setImageDrawable(context.getResources().getDrawable(getImageAt(position)));
        }


        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(position);
            }
        });
        return view;
    }
    /*
    This callback is responsible for destroying a page. Since we are using view only as the
    object key we just directly remove the view from parent container
    */
    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }
    /*
    Returns the count of the total pages
    */
    @Override
    public int getCount() {
        return 4;
    }
    /*
    Used to determine whether the page view is associated with object key returned by instantiateItem.
    Since here view only is the key we return view==object
    */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    private  void getImageWithPicasso() {
        Picasso.get()
                .load("https://www.christies.com/img/LotImages/2016/NYR/2016_NYR_12145_0013B_000(pablo_picasso_buste_de_femme).jpg")
                //Imagen mientras carga
                .placeholder(context.getResources().getDrawable(R.drawable.ic_radio_24dp))
                //Imagen si hay un error
                .error(context.getResources().getDrawable(R.drawable.ic_home_black_24dp))
                .into(imageView);
    }
    private int  getImageAt(int position) {
        switch (position) {

                case 1:
                return R.drawable.ic_music_note_black_24dp;
            case 2:
                return R.drawable.ic_launcher_background;
            case 3:
                return R.drawable.ic_pause_24dp;
            default:
                return R.drawable.ic_home_black_24dp;
        }
    }

    public interface OnImageClickListener  {
         void onItemClick(int position);
    }

}
