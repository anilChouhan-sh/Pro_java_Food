package com.example.amla;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFood#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFood extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFood() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFood.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFood newInstance(String param1, String param2) {
        ListFood fragment = new ListFood();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_list_food, container, false);
        final ListView listView = view.findViewById(R.id.listview);

        final ArrayList<String> resto_name= new ArrayList<>();



        ParseQuery<ParseObject> query = ParseQuery.getQuery("Restaurants");
        query.addAscendingOrder("Restaurants");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {
                            Log.i("Resto_name", object.getString("Resto_name"));
                            try {
                                resto_name.add(object.getList("Resto_name").toString());
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,resto_name);
                    listView.setAdapter(arrayAdapter);
                }
            }
        });
        return view;
    }
}
