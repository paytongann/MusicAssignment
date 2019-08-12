package com.example.musicassignment;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements SongFragment.Communicator {

    private static final String TAG = "";
    SongRepository songRepository;
    SongFragment fragment;
    ArrayList<SongFragment> queue = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        CustomPagerAdapter pageAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        recyclerView = findViewById(R.id.recycler_view);

        SongFragment rockFragment = new SongFragment();
        rockFragment.setCommunicator(this);
        rockFragment.genre = "rock";
        pageAdapter.addPages(rockFragment);

        SongFragment classicFragment = new SongFragment();
        classicFragment.setCommunicator(this);
        classicFragment.genre = "classic";
        pageAdapter.addPages(classicFragment);

        SongFragment popFragment = new SongFragment();
        popFragment.setCommunicator(this);
        popFragment.genre = "pop";
        pageAdapter.addPages(popFragment);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dashboard_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_notifications_black_24dp);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //todo change background colors based on tab position
                if (tab.getText().toString().equals("classic")){

                } else if (tab.getText().toString().equals("pop")){

                } else {

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        songRepository = new SongRepository(getApplication());
    }

    public void initNetwork(String genre) {
        Retrofit rock = new Retrofit(
                this);
        rock.initRetrofit(genre);
    }

    public void getResults() {
        fragment.getResults();
        fragment = null;
        List<SongPojo> songsReturned;
        songsReturned = Retrofit.musicResult.getResults();

        for (SongPojo songPojo : songsReturned){
            songRepository.insert(songPojo);
        }

        if (queue.size() > 0) {
            queue.get(0).requestSongs();
            queue.remove(0);
        }
    }

    @Override
    public void requestSongs(String genre, SongFragment fragment) {
        if (this.fragment == null) {
            this.fragment = fragment;
            initNetwork(genre);
        } else {
            queue.add(fragment);
        }
    }
}
