package com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock;

import com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle.AddArticleResponse;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by obpoo on 11/16/2018.
 */

public interface AddArticleView extends BaseView {
    void onGetAddArticleInsertMsg(AddArticleResponse response);
    void onValidationFail(int type);
}
