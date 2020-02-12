package com.project.scan_on.ui.home;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.project.scan_on.CategoryAdapter;
import com.project.scan_on.CategoryModel;
import com.project.scan_on.GridProductLayoutAdapter;
import com.project.scan_on.HomePageAdapter;
import com.project.scan_on.HomePageModel;
import com.project.scan_on.HorizontalProductScrollAdapter;
import com.project.scan_on.HorizontalProductScrollModel;
import com.project.scan_on.R;
import com.project.scan_on.SliderAdapter;
import com.project.scan_on.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    //////////// Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    /////////// Banner Slider
    ////////// Strip Ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;
    ////////// Strip Ad
    ///////// Horizontal Product Layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;
    ///////// Horizontal Product Layout

    //////////////////////////

    //////////////////////////




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("Link","Home"));
        categoryModelList.add(new CategoryModel("Link","Electronics"));
        categoryModelList.add(new CategoryModel("Link","Appliances"));
        categoryModelList.add(new CategoryModel("Link","Furniture"));
        categoryModelList.add(new CategoryModel("Link","Fashion"));
        categoryModelList.add(new CategoryModel("Link","Toys"));
        categoryModelList.add(new CategoryModel("Link","Sports"));
        categoryModelList.add(new CategoryModel("Link","Wall Arts"));
        categoryModelList.add(new CategoryModel("Link","Books"));
        categoryModelList.add(new CategoryModel("Link","Shoes"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        //////////// Banner Slider

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail,"#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.red_mail,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.app_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_black,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.home_icon,"#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_mail,"#077AE4"));



        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state ==ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }

            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();
        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });
        //////////// Banner Slider
        ////////// Strip Ad
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);
        stripAdImage.setImageResource(R.mipmap.stripadd);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));
        ////////// Strip Ad
        ///////// Horizontal Product Layout
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_layout_scroll_tittle);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.image2,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.app_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.app_round_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.custom_error_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.green_mail,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.red_mail,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.home_icon,"Redmi 5A","SD 625 Processor","Rs.5999/-"));
        //horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.cart_black,"Redmi 5A","SD 625 Processor","Rs.5999/-"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();
        ///////// Horizontal Product Layout
        //////// Grid Product Layout
        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));
        //////// Grid Product Layout

        //////////////////////
        RecyclerView testing = view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(RecyclerView.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();

        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.stripadd,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day",horizontalProductScrollModelList));
        //homePageModelList.add(new HomePageModel(1,R.mipmap.stripadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner2,"#ffff00"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

 

        /////////////////////




        return view;
    }
    //////////// Banner Slider
    private void pageLooper(){
        if(currentPage == sliderModelList.size() - 2){
            currentPage =2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage == 1  ){
            currentPage =sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }


    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage =1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }
    //////////// Banner Slider


}
