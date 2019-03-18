package kr.co.woobi.imyeon.fragmentcallbackexam296;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    private ColorFragment mColorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ColorListFragment colorListFragment = (ColorListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color_list);

        mColorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);
        mColorFragment.setColor(Color.GRAY);
        colorListFragment.setOnColorSelectedListener(new ColorListFragment.onColorSelectedListener() {
            @Override
            public void onColorSelected(int position) {
                String colorString = colorListFragment.mAdapter.mData.get(position);
                int r = new Random().nextInt(256);
                int g = new Random().nextInt(256);
                int b = new Random().nextInt(256);


                int color = Color.GREEN;
                switch (colorString) {
                    case "Red":
                        color = Color.RED;
                        break;
                    case "Green":
                        color = Color.GREEN;
                        break;
                    case "Blue":
                        color = Color.BLUE;
                        break;
                    case "Random":
                        color = Color.rgb(r,g,b);
                        break;
                }
                mColorFragment.setColor(color);
        }
    });

}

}
