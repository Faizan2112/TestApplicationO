package com.example.root.testapplicationo.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.root.testapplicationo.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RXExampleActivity extends AppCompatActivity {
    private static final String TAG = RXExampleActivity.class.getSimpleName();
    Observable<String> animalObserable ;
    Observer<String> animalObserver ;
    /**
     * Basic Observable, Observer, Subscriber example
     * Observable emits list of animal names
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxexample);


        // obserable
        differentObserable();


        //observer
        differentObserver();







        // observer subscribing to observable

        animalObserable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(animalObserver);


    }

    private void differentObserver() {
        animalObserver = getAnimalsObserver();

    }

    private void differentObserable() {
        // obseravble
        // different ways to create obserables
        // types of obserable depends on emmisons
        // single , may be , completed , obserable
       animalObserable = getAnimalObserables();


    }

    private Observer<String> getAnimalsObserver() {

    return  new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.d(TAG, "onSubscribe");

        }

        @Override
        public void onNext(String s) {
            Log.d(TAG, "Name: " + s);

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: " + e.getMessage());

        }

        @Override
        public void onComplete() {
            Log.d(TAG, "All items are emitted!");

        }
    };
    }

    private Observable<String> getAnimalObserables() {
        //just , create , range
        //The operators like create, just, fromArray, range creates an Observable.
        //operators such as debounce, filter, skip, last are used to filter the data emitted
        /*RxJava Operators allows you manipulate the data emitted by Observables.
        Basically, operators tells Observable, how to modify the data and when to emit the data.
         Using the operators you can modify, merge, filter or group the data streams.*/
        return Observable.just("dfh", "sdfsd", "sdfsdf");
    }
/*
* Disposable: Disposable is used to dispose the subscription when an Observer no longer wants to listen to Observable.
 * In android disposable are very useful in avoiding memory leaks.
* */
    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
