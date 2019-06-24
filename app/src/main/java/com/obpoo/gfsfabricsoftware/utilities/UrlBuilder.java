package com.obpoo.gfsfabricsoftware.utilities;

import java.util.Map;


public class UrlBuilder {

    public static String formatRequestURLByRequestType(int requestType, Map<String, String> mapOfRequestParams) {
        String requestURL = AppConstants.BASEURL_new;

        switch (requestType) {
            case Constants.SERVICE_LOGIN:
                requestURL = String.format(requestURL+"login.php");
                break;
            case Constants.ADD_SHOP:
                requestURL = String.format(requestURL+"shop.php");
                break;
            case Constants.ADD_DEPARTMENT:
                requestURL = String.format(requestURL+"dept.php");
                break;
            case Constants.ADD_CUSTOMER_TYPE:
                requestURL = String.format(requestURL+"customer_type.php");
                break;
            case Constants.VENDOR_TYPE:
                requestURL = String.format(requestURL+"vendor_type.php");
                break;
            case Constants.CUSTOMER:
                requestURL = String.format(requestURL+"customer.php");
                break;

            case Constants.EDIT_SHOP:
                requestURL = String.format(requestURL+"shop.php");
                break;
            case Constants.GET_SHOP:
                requestURL = String.format(requestURL+"shop.php");
                break;
            case Constants.GET_SHOP_ID:
                requestURL = String.format(requestURL+"shop.php");
                break;
            case Constants.DELETE_SHOP:
                requestURL = String.format(requestURL+"shop.php");
                break;
            case Constants.GET_DEPARTMENT:
                requestURL = String.format(requestURL+"dept.php");
                break;
            case Constants.DELETE_DEPARTMENT:
                requestURL = String.format(requestURL+"dept.php");
                break;

            case Constants.EDIT_DEPARTMENT:
                requestURL = String.format(requestURL+"dept.php");
                break;

            case Constants.GET_CUSTOMER_TYPE:
                requestURL = String.format(requestURL+"customer_type.php");
                break;

            case Constants.EDIT_CUSTOMER_TYPE:
                requestURL = String.format(requestURL+"customer_type.php");
                break;
            case Constants.DELETE_CUSTOMER_TYPE:
                requestURL = String.format(requestURL+"customer_type.php");
                break;
            case Constants.DELETE_VENDOR_TYPE:
                requestURL = String.format(requestURL+"vendor_type.php");
                break;

            case Constants.GET_VENDOR_TYPE:
                requestURL = String.format(requestURL+"vendor_type.php");
                break;

            case Constants.EDIT_VENDOR_TYPE:
                requestURL = String.format(requestURL+"vendor_type.php");
                break;

            case Constants.GET_CUSTOMER:
                requestURL = String.format(requestURL+"customer.php");
                break;
            case Constants.DELETE_CUSTOMER:
                requestURL = String.format(requestURL+"customer.php");
                break;
            case Constants.UPDATE_CUSTOMER:
                requestURL = String.format(requestURL+"customer.php");
                break;
            case Constants.GET_ID_CUSTOMER:
                requestURL = String.format(requestURL+"customer.php");
                break;

            case Constants.GET_VENDORS:
                requestURL = String.format(requestURL+"vendor.php");
                break;
            case Constants.ADD_VENDORS:
                requestURL = String.format(requestURL+"vendor.php");
                break;
            case Constants.UPDATE_VENDORS:
                requestURL = String.format(requestURL+"vendor.php");
                break;
            case Constants.DELETE_VENDORS:
                requestURL = String.format(requestURL+"vendor.php");
                break;
            case Constants.GET_ID_VENDORS:
                requestURL = String.format(requestURL+"vendor.php");
                break;

            case Constants.GET_WAREHOUSE:
                requestURL = String.format(requestURL+"warehouse.php");
                break;
            case Constants.GET_WAREHOUSE_ID:
                requestURL = String.format(requestURL+"warehouse.php");
                break;
            case Constants.ADD_WAREHOUSE:
                requestURL = String.format(requestURL+"warehouse.php");
                break;
            case Constants.DELETE_WAREHOUSE:
                requestURL = String.format(requestURL+"warehouse.php");
                break;
            case Constants.EDIT_WAREHOUSE:
                requestURL = String.format(requestURL+"warehouse.php");
                break;

            case Constants.GET_BANK:
                requestURL = String.format(requestURL+"bank_crud.php");
                break;
            case Constants.ADD_BANK:
                requestURL = String.format(requestURL+"bank_crud.php");
                break;
            case Constants.DELETE_BANK:
                requestURL = String.format(requestURL+"bank_crud.php");
                break;
            case Constants.EDIT_BANK:
                requestURL = String.format(requestURL+"bank_crud.php");
                break;

            case Constants.ADD_FABRIC_TYPE:
                requestURL = String.format(requestURL+"fabric_type.php");
                break;
            case Constants.EDIT_FABRIC_TYPE:
                requestURL = String.format(requestURL+"fabric_type.php");
                break;

            case Constants.GET_FABRIC_TYPE:
                requestURL = String.format(requestURL+"fabric_type.php");
                break;

            case Constants.DELETE_FABRIC_TYPE:
                requestURL = String.format(requestURL+"fabric_type.php");
                break;

            case Constants.ADD_MINMAX:
                requestURL = String.format(requestURL+"minmax.php");
                break;
            case Constants.GET_MINMAX:
                requestURL = String.format(requestURL+"minmax.php");
                break;
            case Constants.DELETE_MINMAX:
                requestURL = String.format(requestURL+"minmax.php");
                break;
             case Constants.EDIT_MINMAX:
                requestURL = String.format(requestURL+"minmax.php");
                break;

            case Constants.ADD_COMP:
                requestURL = String.format(requestURL+"composition.php");
                break;
            case Constants.GET_COMP:
                requestURL = String.format(requestURL+"composition.php");
                break;
            case Constants.DELETE_COMP:
                requestURL = String.format(requestURL+"composition.php");
                break;
            case Constants.EDIT_COMP:
                requestURL = String.format(requestURL+"composition.php");
                break;

            case Constants.ADD_COLOR:
                requestURL = String.format(requestURL+"colors.php");
                break;
            case Constants.GET_COLOR:
                requestURL = String.format(requestURL+"colors.php");
                break;
            case Constants.DELETE_COLOR:
                requestURL = String.format(requestURL+"colors.php");
                break;
            case Constants.EDIT_COLOR:
                requestURL = String.format(requestURL+"colors.php");
                break;


            case Constants.ADD_ARTICLE:
                requestURL = String.format(requestURL+"article_no.php");
                break;
            case Constants.GET_ARTICLE:
                requestURL = String.format(requestURL+"article_no.php");
                break;
            case Constants.DELETE_ARTICLE:
                requestURL = String.format(requestURL+"article_no.php");
                break;
            case Constants.EDIT_ARTICLE:
                requestURL = String.format(requestURL+"article_no.php");
                break;
            case Constants.GET_ARTICLE_ID:
                requestURL = String.format(requestURL+"article_no.php");
                break;


            case Constants.ADD_GROUP:
                requestURL = String.format(requestURL+"customer_group.php");
                break;
            case Constants.GET_GROUP:
                requestURL = String.format(requestURL+"customer_group.php");
                break;
            case Constants.DELETE_GROUP:
                requestURL = String.format(requestURL+"customer_group.php");
                break;
            case Constants.EDIT_GROUP:
                requestURL = String.format(requestURL+"customer_group.php");
                break;


            default:
                break;
        }
        return requestURL;
    }

}
