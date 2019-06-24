package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;

/**
 * Created by PHD on 11/19/2018.
 */

public interface cmnArtInteractor {
    interface cmnArtGroupResponse{
        void onGetcmnArtGroupResponse(cmnArticlePOJO response);
        void onGetcmnArtGroupError(String message);
    }
    void CallcmnArtGroupResponse(String method, cmnArtGroupResponse response);
    interface deleteCmnArtGroupResponse{
        void onGetdeleteCmnArtGroupResponse(cmnArtdeletePOJO response);
        void onGetdeleteCmnArtGroupError(String message);
    }
    void calldeleteCmnArtGroupResponse(String method, String id, deleteCmnArtGroupResponse response);

}
