package com.obpoo.gfsfabricsoftware.Article.MVP.AddArticle_stock;

/**
 * Created by obpoo on 11/16/2018.
 */

public interface addArticle_stockPresenter {
    void sendrequest(String method, String aNo, String note, String FT, String occasion, String compassion, String fullYards, String _9yards,
                     String _10Yards, String fullMtrs, String _9Mtrs, String _10Mtrs);
}
