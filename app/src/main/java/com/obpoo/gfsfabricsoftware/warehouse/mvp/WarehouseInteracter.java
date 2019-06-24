package com.obpoo.gfsfabricsoftware.warehouse.mvp;


import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseRequest;
import com.obpoo.gfsfabricsoftware.warehouse.datamodels.WarehouseResponse;

public interface WarehouseInteracter {
    interface WarehouseListerner {
        void onSuccess(WarehouseResponse response);

        void onError(String message);
    }

    void  viewList(WarehouseRequest request, WarehouseInteracter.WarehouseListerner listener);




}
