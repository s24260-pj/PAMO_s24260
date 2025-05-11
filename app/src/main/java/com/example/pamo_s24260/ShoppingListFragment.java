package com.example.pamo_s24260;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pamo_s24260.databinding.FragmentShoppingListBinding;
import com.example.pamo_s24260.model.ShoppingListItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListFragment extends Fragment {

    private FragmentShoppingListBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentShoppingListBinding.inflate(inflater, container, false);
        setupRecyclerView();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        List<ShoppingListItem> shoppingListItems = new ArrayList<>();
        shoppingListItems.add(new ShoppingListItem("2 jajka"));
        shoppingListItems.add(new ShoppingListItem("1 szklanka mleka"));
        shoppingListItems.add(new ShoppingListItem("200g mąki"));
        shoppingListItems.add(new ShoppingListItem("1 łyżka oleju"));
        shoppingListItems.add(new ShoppingListItem("Szczypta soli"));

        ShoppingListAdapter adapter = new ShoppingListAdapter(shoppingListItems);
        binding.shoppingListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.shoppingListRecycler.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
