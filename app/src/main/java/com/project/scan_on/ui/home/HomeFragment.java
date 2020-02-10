package com.project.scan_on.ui.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.scan_on.CategoryAdapter;
import com.project.scan_on.CategoryModel;
import com.project.scan_on.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;



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


        return view;
    }

}
