package com.daimajia.slider.demo;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.daimajia.slider.demo.adapter.GridViewAdapter;
import com.daimajia.slider.demo.adapter.GridViewAdapter.OnGridViewItemClickedListener;
import com.daimajia.slider.demo.model.GridViewItem;
import com.daimajia.slider.demo.util.DFragment;
import com.daimajia.slider.demo.util.UiHelper;
import com.hkm.slider.Animations.DescriptionAnimation;
import com.hkm.slider.Indicators.PagerIndicator;
import com.hkm.slider.SliderLayout;
import com.hkm.slider.SliderTypes.BaseSliderView;
import com.hkm.slider.SliderTypes.TextSliderView;
import com.hkm.slider.TransformerL;
import com.hkm.slider.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends ActionBarActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener, OnGridViewItemClickedListener {

    private SliderLayout mDemoSlider;
    private FragmentManager fm = getSupportFragmentManager();


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    @Override
    public void onGridViewItemClicked(GridViewItem.ItemType type) {

        switch (type) {
            case BROWSER:{

                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            }
            case MAP:{

                String url = "http://maps.google.com/maps";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            }

            case WEATHER:{

                String url = "https://weather.yahoo.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            }
            case LOGO:{

                String url = "http://www.ihg.com/hotels/gb/en/reservation";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            }

            case KODI: {

                String url = "https://play.google.com/store?hl=en";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            }

            case EXIT: {

                DFragment dFragment = new DFragment();
                dFragment.show(fm, "Dialog Fragment");
                break;
            }

            default:
                break;
        }

    }

    public void onBackPressed() {
        ;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("IMAGE-1", R.drawable.white_beach_and_blue_sky);
        file_maps.put("IMAGE-2", R.drawable.stream_in_autumn);
        file_maps.put("IMAGE-3", R.drawable.mountain_stream_in_autumn);
        file_maps.put("IMAGE-4", R.drawable.autumn_scene_1);
        file_maps.put("IMAGE-5", R.drawable.autumn_scene_2);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(MainActivity.this);
            //add your extra information
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(TransformerL.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(MainActivity.this);
        mDemoSlider.setOffscreenPageLimit(3);
        mDemoSlider.setSliderTransformDuration(400, new LinearOutSlowInInterpolator());
        //        ListView l = (ListView) findViewById(R.id.transformers);
        //        l.setAdapter(new TransformerAdapter(this));
        //        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //            @Override
        //            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
        //                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
        //            }
        //        });

        GridViewAdapter adapter = new GridViewAdapter(this, UiHelper.getHomeScreenItems(), MainActivity.this);
        GridView gridView = (GridView)findViewById(R.id.gridViewRoot);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //                items.add(logo);
                //                items.add(weather);
                //                items.add(guest_service);
                //                items.add(map);
                //                items.add(kodi);
                //                items.add(browser);

                switch (i) {
                    case 0: // logo
                        onGridViewItemClicked(GridViewItem.ItemType.LOGO);
                        break;
                    case 1: // weather
                        onGridViewItemClicked(GridViewItem.ItemType.WEATHER);
                        break;
                    case 2: // guest_service
                        onGridViewItemClicked(GridViewItem.ItemType.LOGO);
                        break;
                    case 3: // map
                        //http://maps.google.com/maps
                        onGridViewItemClicked(GridViewItem.ItemType.MAP);
                        break;
                    case 4: // kodi

                        //                        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("org.xbmc.kodi");
                        //                        startActivity( LaunchIntent );
                        onGridViewItemClicked(GridViewItem.ItemType.KODI);

                        break;
                    case 5:
                        onGridViewItemClicked(GridViewItem.ItemType.BROWSER);
                        break;

                    case 6:
                        onGridViewItemClicked(GridViewItem.ItemType.EXIT);
                        break;

                    default:
                        break;

                }

            }
        });

    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        //        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mDemoSlider.stopAutoCycle();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_custom_indicator:
                mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:
                mDemoSlider.setCustomAnimation(new ChildAnimationExample());
                break;
            case R.id.action_restore_default:
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
