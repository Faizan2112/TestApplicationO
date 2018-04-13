package com.example.root.testapplicationo.autodropdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.root.testapplicationo.R;
import com.example.root.testapplicationo.newautodropdown.CustomAutoCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SimpleAutoCompleteTextView extends AppCompatActivity implements View.OnTouchListener, AdapterView.OnItemSelectedListener {

  //  private AutoCompleteTextView autocompleteView;
    private CustomAutoCompleteTextView autocompleteView ;
    private ArrayList<Dog> dogs;
    private ArrayList<HashMap<String ,String>> storeData =new ArrayList<HashMap<String ,String>>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_auto_complete_text_view);
        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        String[] dogsArr = getResources().getStringArray(R.array.dogs_list);
        //
        //       List<String> dogList = Arrays.asList(dogsArr);
        dogs = new ArrayList<>();
        dogs.add(new Dog("abc"));
        dogs.add(new Dog("asdbc"));
        dogs.add(new Dog("asddbc"));
        HashMap<String,String> ss = new HashMap<String,String>();
        ss.put("name" ,"abc" );
        ss.put("name","abcr");
        ss.put("name","dsdabcr");
        ss.put("name","abcrdfd");
        storeData.add(ss);

        // storeData.add(new HashMap<String, String>());

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutItemId, dogList);
        autocompleteView = findViewById(R.id.autocompleteView);

       // AutoCompleteDogsAdapter autoCompleteDogsAdapter = new AutoCompleteDogsAdapter(this, dogs);
        SupplierSuggestionAdapter supplierSuggestionAdapter = new SupplierSuggestionAdapter(SimpleAutoCompleteTextView.this, R.layout.row_dog, storeData);
        autocompleteView.setAdapter(supplierSuggestionAdapter);
        autocompleteView.setOnTouchListener(this);
        autocompleteView.setOnItemSelectedListener(this);
        autocompleteView.setValidator(new Validater());
        autocompleteView.setThreshold(-1);
        autocompleteView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               try{
                int val = Integer.parseInt(String.valueOf(charSequence));

                if(charSequence.length() > 1  && charSequence.length() <= 2  ) {
                    if (val <= 73 || val >= 90) {
                        Toast.makeText(getApplicationContext(), "Size must be between 73 to 90", Toast.LENGTH_LONG).show();


                    }
                }

            }catch (Exception e){Toast.makeText(getApplicationContext(),"Enter number",Toast.LENGTH_SHORT).show();};

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //autocompleteView.showDropDown();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        autocompleteView.showDropDown();

        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       // String d = dogs.get(i).getBreed().toString();
        Dog d = dogs.get(i);
        String ds = d.getBreed().toString();
        autocompleteView.setText(ds);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class Validater implements AutoCompleteTextView.Validator {
        @Override
        public boolean isValid(CharSequence charSequence) {
            int val = Integer.parseInt(String.valueOf(charSequence));

           // boolean less = val < "70" ;
           if(val <=73 && val >= 90 )
           {
               Toast.makeText(getApplicationContext(),"Size must be between &3 to 90",Toast.LENGTH_LONG).show();

               return true ;
           }


            return false;
        }

        @Override
        public CharSequence fixText(CharSequence charSequence) {
            return null;
        }
    }
}
