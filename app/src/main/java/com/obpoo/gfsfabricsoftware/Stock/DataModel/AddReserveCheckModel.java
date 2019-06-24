package com.obpoo.gfsfabricsoftware.Stock.DataModel;

/**
 * Created by PHD on 2/13/2019.
 */

public class AddReserveCheckModel {
    String uniqueCode,remain;

    public AddReserveCheckModel(String uniqueCode, String remain) {
        this.uniqueCode = uniqueCode;
        this.remain = remain;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getRemain() {
        return remain;
    }
}
