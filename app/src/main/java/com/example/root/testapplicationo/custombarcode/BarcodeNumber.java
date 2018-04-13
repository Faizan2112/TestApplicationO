package com.example.root.testapplicationo.custombarcode;

/**
 * Created by root on 3/22/18.
 */

class BarcodeNumber {
    public BarcodeNumber(String barCodeNumber) {
        BarCodeNumber = barCodeNumber;
    }

    public BarcodeNumber() {
    }

    public String getBarCodeNumber() {
        return BarCodeNumber;
    }

    public void setBarCodeNumber(String barCodeNumber) {
        BarCodeNumber = barCodeNumber;
    }

    private String BarCodeNumber ;

}
