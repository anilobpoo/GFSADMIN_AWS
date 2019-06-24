package com.obpoo.gfsfabricsoftware.Article.MVP.UpdateArticle;

import com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle.updateArticleResponse;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

/**
 * Created by PHD on 11/16/2018.
 */

public interface updateArticleView extends BaseView {
    void onUpdateArticle(updateArticleResponse response);
    void onValidate(int type);
}
