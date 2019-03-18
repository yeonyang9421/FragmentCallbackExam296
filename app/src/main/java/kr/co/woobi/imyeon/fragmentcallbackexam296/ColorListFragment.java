package kr.co.woobi.imyeon.fragmentcallbackexam296;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ColorListFragment extends Fragment {

    interface onColorSelectedListener {
        void onColorSelected(int position);
    }

    onColorSelectedListener mListener;

    public void setOnColorSelectedListener(onColorSelectedListener listener) {
        mListener = listener;
    }

    List<String> colorList = new ArrayList<>();
    RecyclerView mRecycler;
    RecyclerAdapter mAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        colorList.add("Red");
        colorList.add("Green");
        colorList.add("Blue");
        colorList.add("Random");

        mRecycler = view.findViewById(R.id.recycler);
        mAdapter = new RecyclerAdapter(colorList);
        mRecycler.setAdapter(mAdapter);

        mAdapter.setOnSendItemListener(new RecyclerAdapter.onSendItemListener() {
            @Override
            public void onSend(int position) {
                mListener.onColorSelected(position);
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_color_list, container, false);



        return view;
    }
}
