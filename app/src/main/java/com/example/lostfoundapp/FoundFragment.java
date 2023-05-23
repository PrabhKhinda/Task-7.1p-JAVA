package com.example.lostfoundapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FoundFragment extends Fragment {

    private List<Advert> adsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_found, container, false);

        ListView adsListView = rootView.findViewById(R.id.ads_list_view2);
        adsList = retrieveLostAdsFromDatabase();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, adsListToStringList(adsList));
        adsListView.setAdapter(adapter);

        adsListView.setOnItemClickListener((parent, view, position, id) -> {
            Advert selectedAdvert = adsList.get(position);
            showAdDetailsFragment(selectedAdvert);
        });

        return rootView;
    }

    private List<String> adsListToStringList(List<Advert> adsList) {
        List<String> stringList = new ArrayList<>();
        for (Advert advert : adsList) {
            stringList.add(advert.getName());
        }
        return stringList;
    }

    private void showAdDetailsFragment(Advert advert) {
        AdDetailsFragment fragment = new AdDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedAdvert", advert);
        fragment.setArguments(bundle);

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    private List<Advert> retrieveLostAdsFromDatabase() {
        DatabaseHelper databaseHelper = new DatabaseHelper(requireContext());
        return databaseHelper.getFoundAds();
    }
}
