package com.obpoo.gfsfabricsoftware.bank.mvp;

public interface BankPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void add(String methodname,String bankname,String add,String adds);
   void update(String methodname,String bankname,String id);
   void delete(String methodname,String id);
}
