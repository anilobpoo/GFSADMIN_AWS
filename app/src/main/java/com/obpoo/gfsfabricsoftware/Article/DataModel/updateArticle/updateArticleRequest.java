package com.obpoo.gfsfabricsoftware.Article.DataModel.updateArticle;

/**
 * Created by obpoo on 11/16/2018.
 */

public class updateArticleRequest {
    String method,id,articleno,note,fabrictype,pricefullroll,price1to9,price10plus,pricefullrollmtrs,price1to9mtrs,price10plusmtrs,
            composition,occassion;

    public updateArticleRequest(String method, String id, String articleno, String note, String fabrictype,
                                String pricefullroll, String price1to9, String price10plus, String pricefullrollmtrs,
                                String price1to9mtrs, String price10plusmtrs, String composition, String occassion) {
        this.method = method;
        this.id = id;
        this.articleno = articleno;
        this.note = note;
        this.fabrictype = fabrictype;
        this.pricefullroll = pricefullroll;
        this.price1to9 = price1to9;
        this.price10plus = price10plus;
        this.pricefullrollmtrs = pricefullrollmtrs;
        this.price1to9mtrs = price1to9mtrs;
        this.price10plusmtrs = price10plusmtrs;
        this.composition = composition;
        this.occassion = occassion;
    }
}
