package com.obpoo.gfsfabricsoftware.user.mvp;

public interface UserPresenter {
    void validate(String name, String description);
    void viewAll(String methodname);
}
