package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.updateSimilarArticleGroup;

import java.util.List;

/**
 * Created by PHD on 11/21/2018.
 */

public class updateSMGRequest {
    String method,id,grp_name,Quality_description,Quality_name;
    List<String> updt_article;

    public updateSMGRequest(String method, String id,String grp_name, List<String> updt_article, String quality_description, String quality_name) {
        this.grp_name = grp_name;
        this.updt_article = updt_article;
        Quality_description = quality_description;
        Quality_name = quality_name;
        this.method = method;
        this.id=id;
    }
}
