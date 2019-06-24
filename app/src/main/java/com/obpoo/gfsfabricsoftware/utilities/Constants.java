package com.obpoo.gfsfabricsoftware.utilities;

public class Constants {

    public static final int SERVICE_LOGIN = 1;

    public static final int ADD_SHOP = 2;
    public static final int GET_SHOP = 7;
    public static final int DELETE_SHOP = 8;



    public static final int ADD_DEPARTMENT = 3;
    public static final int GET_DEPARTMENT = 9;
    public static final int DELETE_DEPARTMENT = 10;

    public static final int ADD_CUSTOMER_TYPE = 4;
    public static final int GET_CUSTOMER_TYPE = 11;
    public static final int DELETE_CUSTOMER_TYPE = 12;


    public static final int VENDOR_TYPE = 5;
    public static final int GET_VENDOR_TYPE = 13;
    public static final int DELETE_VENDOR_TYPE = 14;

    public static final int CUSTOMER= 6;
    public static final int GET_CUSTOMER= 15;
    public static final int DELETE_CUSTOMER= 20;
    public static final int UPDATE_CUSTOMER= 21;
    public static final int GET_ID_CUSTOMER= 22;

    public static final int GET_VENDORS= 16;
    public static final int ADD_VENDORS= 17;
    public static final int UPDATE_VENDORS= 18;
    public static final int DELETE_VENDORS= 19;
    public static final int GET_ID_VENDORS= 23;


    public static final int GET_WAREHOUSE= 24;
    public static final int DELETE_WAREHOUSE= 25;
    public static final int EDIT_WAREHOUSE= 26;
    public static final int ADD_WAREHOUSE= 27;


    public static final int GET_BANK= 28;
    public static final int DELETE_BANK= 29;
    public static final int EDIT_BANK= 30;
    public static final int ADD_BANK= 31;

    public static final int GET_FABRIC_TYPE= 32;
    public static final int DELETE_FABRIC_TYPE= 33;
    public static final int EDIT_FABRIC_TYPE =34;
    public static final int ADD_FABRIC_TYPE= 35;


    public static final int GET_MINMAX= 36;
    public static final int DELETE_MINMAX= 37;
    public static final int EDIT_MINMAX= 38;
    public static final int ADD_MINMAX= 39;

    public static final int GET_COMP= 40;
    public static final int DELETE_COMP= 41;
    public static final int EDIT_COMP= 42;
    public static final int ADD_COMP= 43;

    public static final int EDIT_SHOP = 44;
    public static final int EDIT_DEPARTMENT = 45;
    public static final int EDIT_CUSTOMER_TYPE = 46;
    public static final int EDIT_VENDOR_TYPE = 47;
    public static final int GET_SHOP_ID = 48;
    public static final int GET_VENDOR_ID = 49;
    public static final int GET_WAREHOUSE_ID = 50;

    public static final int GET_COLOR= 51;
    public static final int DELETE_COLOR= 52;
    public static final int EDIT_COLOR= 53;
    public static final int ADD_COLOR= 54;

    public static final int GET_ARTICLE= 55;
    public static final int GET_ARTICLE_ID= 57;
    public static final int DELETE_ARTICLE= 56;
    public static final int EDIT_ARTICLE= 58;
    public static final int ADD_ARTICLE= 59;

    public static final int GET_GROUP= 60;
    public static final int ADD_GROUP= 61;
    public static final int DELETE_GROUP= 62;
    public static final int EDIT_GROUP= 63;



    public static final String BASEURL = "http://furnirworld.com/giovanifs/api/";
    public static final String FSPIC="https://www.obpoomail.com/app/photos/";
    public static final String NO_PIC = "https://rafver.is/wp-content/uploads/2016/05/no-image.jpg";
    public static final String CONTENT_TYPE_JSON = "application/json";
    //status error
    public static final int STATUS_CODE_SUCCESS = 200;
    public static final int STATUS_CODE_ERROR = 500;
    public static final String CONTENT_TYPE_EMPTY_STRING = "";


    //permissions
    public static final int REQUEST_CODE_FOR_EXTERNAL_STORAGE_PERMISSION = 0;
    public static final int REQUEST_CODE_FOR_READ_CONTACTS_PERMISSION = 1;

    public static final String username = "username";
    public static final String password = "password";
    public static final String token = "token";
    public static final String type = "type";
    public static final String device_id = "device_id";
    public static final String method = "method";
    public static final String min_max_type = "min_max_type";
    public static final String location = "location";
    public static final String color_code = "color_code";
    public static final String articleno = "articleno";
    public static final String note = "note";
    public static final String fabrictype = "fabrictype";
    //Master
    public static final String name = "name";
    public static final String customer_type = "customer_type";
    public static final String id = "id";
    public static final String user_id = "user_id";

    //vendor
    public static final String vendorno = "vendorno";
    public static final String vendortype = "vendortype";
    public static final String vendor = "vendor";
    public static final String address = "address";
    public static final String country = "country";
    public static final String telephone = "telephone";
    public static final String fax = "fax";
    public static final String email = "email";
    public static final String zipcode = "zipcode";
    public static final String bankname = "bankname";
    public static final String fabric_type = "fabric_type";
    public static final String title = "title";
    public static final String composition = "composition";

    //customer
    public static final String customer_name = "customer_name";
    public static final String phone = "phone";
    public static final String customer_type_id = "customer_type_id";
    public static final String customer_group = "customer_group";
    public static final String user_name = "user_name";
    public static final String shop_id = "shop_id";
    public static final String vat_name = "vat_name";

    //Warehouse
    public static final String warehouse_name = "warehouse_name";
    public static final String warehouse_no = "warehouse_no";
    public static final String shopNo = "shopNo";
    public static final String locality = "locality";
    public static final String can_sell_part = "can_sell_part";
    public static final String Available_status = "Available_status";
}
