package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.addCagPOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticleDATA;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.UpdateSMGmodel;

import java.util.List;

/**
 * Created by PHD on 11/20/2018.
 */

public interface AddCmgInteractor {
    interface AddCmgResponse{
        void onGetAddCmgResponse(addCagPOJO response);
        void onGetAddCmgError(String message);
    }
    void callAddCmg(String method, AddCmgResponse response);

    interface AddSimilarGroup{
        void onGetAddSimilarGroupResponse(similarArticleDATA response);
        void onGetAddSimilarGroupError(String message);
    }
    void CallAddSimilarGroup(String method, String groupname, List<String> ArticlegrpList, String QDesc, String QName, AddSimilarGroup response);

    interface UpdateSimilarGroup{
        void onGetUpdateSimilarGroupResponse(UpdateSMGmodel response);
        void onGetUpdateSimilarGroupError(String message);
    }
    void CallUpdateSimilarGroup(String method, String id, String groupname, List<String> ArticlegrpList, String QDesc, String QName, UpdateSimilarGroup response);

}
