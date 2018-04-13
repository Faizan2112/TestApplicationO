package com.example.root.testapplicationo.custom_text_field;

/**
 * Created by root on 2/19/18.
 */
/*
* hi

Login service

Url:http://webworldindia.com/freshup_oms/api/login

Post Parameters:
mobileNo:9599734462
pin:123

Otp Send Service

Url: http://webworldindia.com/freshup_oms/api/sendOtpInMobile

Post Parameter:
mobileNo:9599734462
* */

public class UrlConstants {
    // recognize api call id
    public static final int TYPE_OFF_REQUEST_LOGIN = 1;


    //App url
    public static final String FRESH_UP_LOGIN_URL = "http://webworldindia.com/freshup_oms/api/login";
    public static final String FRESH_UP_LOGIN_URL_OTP = "http://webworldindia.com/freshup_oms/api/sendOtpInMobile";
    public static final String FRESH_UP_UPDATE_PROFILE = "http://webworldindia.com/freshup_oms/api/updateUserDetails";
    public static final String FRESH_UP_GET_USER_DETAILS = "http://webworldindia.com/freshup_oms/api/getUserDetails";
    public static final String FRESH_UP_SPINNER_CATEGORY = "http://webworldindia.com/freshup_oms/api/getAllCategory";
    public static final String FRESH_UP_SPINNER_SUB_CATEGORY = "http://webworldindia.com/freshup_oms/api/getAllSubCategory";
    public static final String FRESH_UP_SPINNER_PRODUCT = "http://webworldindia.com/freshup_oms/api/getAllProductByCategory";
    public static final String FRESH_UP_SPINNER_LXWXH = "http://webworldindia.com/freshup_oms/api/get_catalogue_for_order_product_api";
    public static final String FRESH_UP_FETCH_COLOR_AND_PRICE = "http://webworldindia.com/freshup_oms/api/fetch_price_by_dimemsion_api";
    public static final String FRESH_UP_SAVE_ORDER = "http://webworldindia.com/freshup_oms/api/save_order_record_api";
    // Parameter :Userid : set to 11 proid length width height quantity


    public static final String FRESH_UP_ALL_ORDER = "http://webworldindia.com/freshup_oms/api/order_list_api";
    public static final String FRESH_UP_ORDER_DETAILS = "http://webworldindia.com/freshup_oms/api/show_order_details_api";
    //Parameter :orderNo
    public static final String FRESH_UP_ORDER_STATUS = "http://webworldindia.com/freshup_oms/api/change_order_status_api";
    public static final String FRESH_UP_FETCH_ALL_PRODUCT_DETAILS = "http://webworldindia.com/freshup_oms/api/fetch_catalogue_by_proid_api";
    public static final String FRESH_UP_FETCH_ALL_STOCK_DETAILS = "http://webworldindia.com/freshup_oms/api/check_stock_by_user_pro";

    public static final String FRESH_UP_FETCH_SHOW_USER_STOCK_DETAILS = "http://webworldindia.com/freshup_oms/api/show_stock_api";
    public static final String FRESH_UP_ALL_SCHEMES = "http://webworldindia.com/freshup_oms/api/show_scheme_target_api";
    public static final String FRESH_UP_FETCH_ALL_ORDER = "http://webworldindia.com/freshup_oms/api/order_list_api";

    public static final String FRESH_UP_ACCEPT_DATA = "http://webworldindia.com/freshup_oms/api/stock_check";

    public static final String FRESH_UP_SEND_TOKEN_DATA = "http://webworldindia.com/freshup_oms/api/registerDevice";

    //Barcode scanner
    public  static final String URL_SEND_ALL_BARCODE = "http://webworldindia.com/freshup_oms/api/get_product_by_barcode";
    public  static final String URL_SEND_SINGLE_BARCODE = "http://webworldindia.com/freshup_oms/api/get_product_by_barcode_single";


    /*  *//*ORDER STATUS :

<option value="">Select Order Status</option>

<option value="0">pending</option>

<option value="1">partial completed</option>

<option value="2">completed</option>
*//*


    Url:

    http://webworldindia.com/freshup_oms/api/change_order_status_api





    Parameter :

    statusid orderNo
    //url connection time*/
    public static final int TIME_OUT_CONNECTION = 60000;


}
