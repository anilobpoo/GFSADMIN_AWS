package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.similarArticleGrpAdd;

import java.util.List;

/**
 * Created by PHD on 11/20/2018.
 */

public class similarArticlerequest {
    String method,grp_name,Quality_description,Quality_name;
    List<String> article;

    public similarArticlerequest(String method, String grp_name, List<String> article, String quality_description, String quality_name) {
        this.grp_name = grp_name;
        this.article = article;
        Quality_description = quality_description;
        Quality_name = quality_name;
        this.method = method;
    }
}
