package com.obpoo.gfsfabricsoftware.Dashboard.MVP;

import java.util.ArrayList;

/**
 * Created by PHD on 1/15/2019.
 */

public interface ReportPresenter {
    void onViewReport(String method);
    void onViewRates(String base);
    void onViewStockAlert(String method, String page_no);
    void onViewCurve(String method,String fab_id,String year);
    void onViewStockSearch(String method,String fab_name);
    void onPreviledgesSearch(String method, ArrayList<String> previleges);

}
