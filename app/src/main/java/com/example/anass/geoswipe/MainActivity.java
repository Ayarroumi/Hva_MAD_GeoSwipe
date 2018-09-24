package com.example.anass.geoswipe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int AMOUNT_OF_IMAGES = 7;
    private List<GeoObject> mGeoObjects = new ArrayList<>();
    private RecyclerView mGeoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGeoObjects();

        mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);



        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        int position = viewHolder.getAdapterPosition();

                        if( (mGeoObjects.get(viewHolder.getAdapterPosition()).isEurope() && swipeDir == ItemTouchHelper.LEFT)
                                ||
                            (!mGeoObjects.get(viewHolder.getAdapterPosition()).isEurope() && swipeDir == ItemTouchHelper.RIGHT)){
                                mGeoObjects.get(position).setBackgroundColor(Color.parseColor("#00ff00"));
                        }else{
                            mGeoObjects.get(position).setBackgroundColor(Color.parseColor("#ff0000"));
                        }

                        mAdapter.notifyItemChanged(viewHolder.getAdapterPosition());
                    }
                };
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
            itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
    }

    private void createGeoObjects(){

        for(int i = 0; i <= AMOUNT_OF_IMAGES; i++){
            GeoObject geoObject = new GeoObject();
            switch (i){
                case 0:
                    geoObject.setGeoName("Denmark");
                    geoObject.setImageName(R.drawable.img1_yes_denmark);
                    geoObject.setEurope(true);
                    break;
                case 1:
                    geoObject.setGeoName("Canada");
                    geoObject.setImageName(R.drawable.img2_no_canada);
                    geoObject.setEurope(false);
                    break;
                case 2:
                    geoObject.setGeoName("Bangladesh");
                    geoObject.setImageName(R.drawable.img3_no_bangladesh);
                    geoObject.setEurope(false);
                    break;
                case 3:
                    geoObject.setGeoName("Kazakhstan");
                    geoObject.setImageName(R.drawable.img4_yes_kazachstan);
                    geoObject.setEurope(false);
                    break;
                case 4:
                    geoObject.setGeoName("Colombia");
                    geoObject.setImageName(R.drawable.img5_no_colombia);
                    geoObject.setEurope(false);
                    break;
                case 5:
                    geoObject.setGeoName("Poland");
                    geoObject.setImageName(R.drawable.img6_yes_poland);
                    geoObject.setEurope(true);
                    break;
                case 6:
                    geoObject.setGeoName("Malta");
                    geoObject.setImageName(R.drawable.img7_yes_malta);
                    geoObject.setEurope(true);
                    break;
                case 7:
                    geoObject.setGeoName("Malta");
                    geoObject.setImageName(R.drawable.img8_no_thailand);
                    geoObject.setEurope(false);
                    break;
            }
            mGeoObjects.add(geoObject);
        }

    }
}
