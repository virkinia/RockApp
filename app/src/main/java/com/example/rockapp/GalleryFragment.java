package com.example.rockapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements MyPagerAdapter.OnImageClickListener {


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);


        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getContext(), this);
        ViewPager viewPager = v.findViewById(R.id.view_pager);
        viewPager.setAdapter(myPagerAdapter);
        CircleIndicator circleIndicator = v.findViewById(R.id.circle);
        circleIndicator.setViewPager(viewPager);

        return v;
    }


    /*
    *
    *
    *      return R.drawable.ic_home_black_24dp;
            case 1:
                return R.drawable.ic_music_note_black_24dp;
            case 2:
                return R.drawable.ic_launcher_background;
            case 3:
                return R.drawable.ic_pause_24dp;
            default:
                return R.drawable.ic_home_black_24dp;
    * */

    @Override
    public void onItemClick(int position) {
        String namePhoto;
        switch (position) {
            case 0:
                namePhoto = "HOME";
                break;
            case 1:
                namePhoto = "MUSIC";
                break;
            case 2:
                namePhoto = "LAUNCHER";
                break;
            case 3:
                namePhoto = "PAUSE";
                break;
            default:
                namePhoto = "HOME";
                break;

        }

        Toast.makeText(getContext(),
                "Ha pulsado la foto" + namePhoto, Toast.LENGTH_LONG).show();
    }
}
