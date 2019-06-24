package com.obpoo.gfsfabricsoftware.CommonArticleGroup.MVP.AddCmnArtGroup;

import java.util.List;

/**
 * Created by PHD on 11/20/2018.
 */

public interface AddCmgPresenter {
    void showColorsForCMNArtGroup(String method);
    void addCmnAddArticleGroup(String method, String groupname, List<String> ArticlegrpList, String QDesc, String QName);
    void updateCmdArticleGroup(String method, String id, String groupname, List<String> ArticlegrpList, String QDesc, String QName);

}
