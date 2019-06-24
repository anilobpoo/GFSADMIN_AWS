package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG.addCagPOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd.similarArticleDATA;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup.UpdateSMGmodel;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 11/20/2018.
 */

public interface AddCmgView extends BaseView {
    void onShowADDCMGVIEW(addCagPOJO response);
    void onShowSimilarArticleAdded(similarArticleDATA response);
    void onShowSimilarArticleupdate(UpdateSMGmodel response);
    void onValidationFail(int type);

}
