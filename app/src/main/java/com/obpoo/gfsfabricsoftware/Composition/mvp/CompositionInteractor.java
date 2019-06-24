package com.obpoo.gfsfabricsoftware.Composition.mvp;


import com.obpoo.gfsfabricsoftware.Composition.datamodels.CompositionResponse;
import com.obpoo.gfsfabricsoftware.Composition.datamodels.ViewCompositionRequest;

public interface CompositionInteractor {

    interface  CompositionListener{
        void onSuccess(CompositionResponse response);

        void onError(String message);
    }

    void addcomposition(String name, String description, CompositionListener listener);

    void  viewCompositionList(ViewCompositionRequest request, CompositionListener listener);
}
