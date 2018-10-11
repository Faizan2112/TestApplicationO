package com.example.root.testapplicationo.expandablelistview;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.custom_text_field.UrlConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, ArrayList<ChildList>> listDataChild;
    //private ArrayList<Object> headerLists , childLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                50, r.getDisplayMetrics());
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expListView.setIndicatorBounds(width - px, width);
        } else {
            expListView.setIndicatorBoundsRelative(width - px, width);
        }

        // preparing list data
        //loadJsonData();
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition).getId()
                               + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition).getName()

                        , Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }




    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, ArrayList<ChildList>>();

        // Adding child data
        listDataHeader.add("Fresh Up");
        listDataHeader.add("Rest Time");
        //listDataHeader.add("Coming Soon..");

        // Adding child data
        ChildList childList = new ChildList("Spring",3);
        ChildList childList1= new ChildList("Bonded",2);
        ChildList childList2 = new ChildList("Luxury",1);
        ArrayList<ChildList> spring = new ArrayList<>();
        spring.add(childList);
        spring.add(childList1);
        spring.add(childList2);
        //listDataChild.put()

        ArrayList<ChildList> rest = new ArrayList<ChildList>();
        rest.add(new ChildList("abc",4));
        rest.add(new ChildList("abc",5));

        childList.setId(3);
        childList.setName("Luxury");

       /* top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");
*/
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), spring); // Header, Child data
        listDataChild.put(listDataHeader.get(1), rest);
    //    listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}

/*private void loadJsonData() {
        final StringRequest categoryRequest = new StringRequest(Request.Method.POST,"http://webworldindia.com/freshup_oms/manage_product/fetchCategoryTreeApi", new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                // Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                try {
                    parseCategoryDetails(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //      mCustomProgressBar.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();

                //  mCustomProgressBar.show();
            }
        });
        RequestQueue startCategoryRequest = Volley.newRequestQueue(this);
        categoryRequest.setRetryPolicy(new DefaultRetryPolicy(60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        startCategoryRequest.add(categoryRequest);


    }
*/
/*
 * Preparing the list data
 */
    /*private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
    */

/*
    private void parseCategoryDetails(String response) throws JSONException {
        headerLists = new ArrayList<>();
        childLists = new ArrayList<>();


        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        for(int i = 0 ; i<= jsonArray.length() ; i++)
        {
            HeaderList headerList = new HeaderList();
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if(jsonObject1.get("parent_id").equals(0))
            {
                headerList.setName(jsonObject1.getString("name"));
                headerLists.add(headerList);

            }
            else
            {
              */
/*      ChildList childList = new ChildList();
                    childList.setId(jsonObject1.getInt("parent_id"));
                    childLists.add(childList);
*//*



            }

        }




    }
*/

