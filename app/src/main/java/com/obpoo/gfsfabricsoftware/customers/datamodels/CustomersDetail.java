package com.obpoo.gfsfabricsoftware.customers.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomersDetail implements Parcelable {


    @SerializedName("discount_per")
    @Expose
    private String discountPer;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("profile_pic")
    @Expose
    private String profilePic;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("customer_group")
    @Expose
    private String customerGroup;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("shop_id")
    @Expose
    private String shopId;
    @SerializedName("added_date")
    @Expose
    private String addedDate;
    @SerializedName("last_edited")
    @Expose
    private String lastEdited;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("vat_name")
    @Expose
    private String vatName;
    @SerializedName("customer_type_id")
    @Expose
    private String customerTypeId;
    @SerializedName("customer_type_name")
    @Expose
    private String customerTypeName;
    @SerializedName("customer_group_name")
    @Expose
    private String customerGroupName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("verified")
    @Expose
    private String verified;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("vat")
    @Expose
    private String vat;
    @SerializedName("credit_limit")
    @Expose
    private String creditLimit;
    @SerializedName("credit_time")
    @Expose
    private String creditTime;
    @SerializedName("email_code")
    @Expose
    private String emailCode;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("api")
    @Expose
    private String api;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("otp")
    @Expose
    private String otp;

    protected CustomersDetail(Parcel in) {
        discountPer = in.readString();
        shopName = in.readString();
        id = in.readString();
        customerName = in.readString();
        address = in.readString();
        country = in.readString();
        phone = in.readString();
        email = in.readString();
        profilePic = in.readString();
        password = in.readString();
        zipcode = in.readString();
        customerGroup = in.readString();
        userId = in.readString();
        userName = in.readString();
        shopId = in.readString();
        addedDate = in.readString();
        lastEdited = in.readString();
        fax = in.readString();
        vatName = in.readString();
        customerTypeId = in.readString();
        customerTypeName = in.readString();
        customerGroupName = in.readString();
        status = in.readString();
        verified = in.readString();
        cod = in.readString();
        vat = in.readString();
        creditLimit = in.readString();
        creditTime = in.readString();
        emailCode = in.readString();
        lastLogin = in.readString();
        updatedDate = in.readString();
        api = in.readString();
        apiToken = in.readString();
        otp = in.readString();
    }

    public static final Creator<CustomersDetail> CREATOR = new Creator<CustomersDetail>() {
        @Override
        public CustomersDetail createFromParcel(Parcel in) {
            return new CustomersDetail(in);
        }

        @Override
        public CustomersDetail[] newArray(int size) {
            return new CustomersDetail[size];
        }
    };

    public String getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(String discountPer) {
        this.discountPer = discountPer;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getVatName() {
        return vatName;
    }

    public void setVatName(String vatName) {
        this.vatName = vatName;
    }

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public void setCustomerGroupName(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(String creditTime) {
        this.creditTime = creditTime;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString(){
        return customerName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(discountPer);
        dest.writeString(shopName);
        dest.writeString(id);
        dest.writeString(customerName);
        dest.writeString(address);
        dest.writeString(country);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(profilePic);
        dest.writeString(password);
        dest.writeString(zipcode);
        dest.writeString(customerGroup);
        dest.writeString(userId);
        dest.writeString(userName);
        dest.writeString(shopId);
        dest.writeString(addedDate);
        dest.writeString(lastEdited);
        dest.writeString(fax);
        dest.writeString(vatName);
        dest.writeString(customerTypeId);
        dest.writeString(customerTypeName);
        dest.writeString(customerGroupName);
        dest.writeString(status);
        dest.writeString(verified);
        dest.writeString(cod);
        dest.writeString(vat);
        dest.writeString(creditLimit);
        dest.writeString(creditTime);
        dest.writeString(emailCode);
        dest.writeString(lastLogin);
        dest.writeString(updatedDate);
        dest.writeString(api);
        dest.writeString(apiToken);
        dest.writeString(otp);
    }
}
