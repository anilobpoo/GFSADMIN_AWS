package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.commonArticleGroup;

import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel.cmnArticlePOJO;
import com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.deleteCmnArt.cmnArtdeletePOJO;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 11/19/2018.
 */

public interface cmnArtView extends BaseView {
    void onShowCmnArtGroup(cmnArticlePOJO response);
    void ondeleteCmnArtGroup(cmnArtdeletePOJO response);
}
