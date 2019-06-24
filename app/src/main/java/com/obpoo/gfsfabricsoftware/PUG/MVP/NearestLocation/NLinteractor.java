package com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation;

import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;

/**
 * Created by PHD on 12/7/2018.
 */

public interface NLinteractor {
    interface GetNLResponse{
        void onGetNLSuccess(NLData response);
        void onGetNLerror(String message);
    }
    void callRetroNL(String method, GetNLResponse response);


}
