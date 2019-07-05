package com.example.rockapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);


        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getContext());
        ViewPager viewPager = v.findViewById(R.id.view_pager);
        viewPager.setAdapter(myPagerAdapter);
        CircleIndicator circleIndicator = v.findViewById(R.id.circle);
        circleIndicator.setViewPager(viewPager);

        return v;
    }

}
