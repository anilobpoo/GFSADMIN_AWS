package com.obpoo.gfsfabricsoftware.Article.DataModel.AddArticle;

/**
 * Created by PHD on 11/16/2018.
 */

public class AddArticleRequest {
    String method, articleno,note, fabrictype, occassion, composition, pricefullroll, price1to9, price10plus, pricefullrollmtrs, price1to9mtrs, price10plusmtrs;
    public AddArticleRequest(String method, String articleno, String note,String fabrictype, String occassion, String composition, String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs, String price1to9mtrs, String price10plusmtrs) {
        this.method = method;
        this.articleno = articleno;
        this.fabrictype = fabrictype;
        this.occassion = occassion;
        this.composition = composition;
        this.pricefullroll = pricefullroll;
        this.price1to9 = price1to9;
        this.price10plus = price10plus;
        this.pricefullrollmtrs = pricefullrollmtrs;
        this.price1to9mtrs = price1to9mtrs;
        this.price10plusmtrs = price10plusmtrs;
        this.note=note;
    }




}
