package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges;

import java.util.ArrayList;

public class PreviledgesRequest {
    String method;
    ArrayList<String> previleges;
    public PreviledgesRequest(String method, ArrayList<String> previleges){
        this.method = method;
        this.previleges = previleges;
    }
}
