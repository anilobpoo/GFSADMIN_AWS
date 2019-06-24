package com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP;

import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;
import com.obpoo.gfsfabricsoftware.mvp.BaseView;

public interface ATview extends BaseView {
    void ATretriveData(ATresponse response);
    void associateActicity(AssociateActivity response);
    void assoFabrics(AssoFabricResponse response);
    void changeFabURL(AssociateFabricChangeURL response);
    void changeFabricStatus(AssociateFabircChangeRes response);
    void changeTailorRequest(AssociateActivity response);


}
