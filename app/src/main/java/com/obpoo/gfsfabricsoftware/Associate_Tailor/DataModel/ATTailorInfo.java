package com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ATTailorInfo implements Serializable {

    @SerializedName("admin_id")
    @Expose
    private Integer adminId;
    @SerializedName("admin_password")
    @Expose
    private String adminPassword;
    @SerializedName("admin_email")
    @Expose
    private String adminEmail;
    @SerializedName("admin_name")
    @Expose
    private String adminName;
    @SerializedName("admin_pic")
    @Expose
    private String adminPic;
    @SerializedName("store_name")
    @Expose
    private String storeName;
    @SerializedName("store_email")
    @Expose
    private String storeEmail;
    @SerializedName("store_number")
    @Expose
    private String storeNumber;
    @SerializedName("store_pic")
    @Expose
    private String storePic;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("fatoryemail")
    @Expose
    private String fatoryemail;
    @SerializedName("trip")
    @Expose
    private String trip;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("deactivate")
    @Expose
    private String deactivate;
    @SerializedName("ordercount")
    @Expose
    private String ordercount;
    @SerializedName("fabriccount")
    @Expose
    private String fabriccount;
    @SerializedName("salescount")
    @Expose
    private String salescount;
    @SerializedName("QR")
    @Expose
    private String qR;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("verified")
    @Expose
    private String verified;
    @SerializedName("obpoo")
    @Expose
    private Integer obpoo;
    @SerializedName("website")
    @Expose
    private Integer website;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("sublocality")
    @Expose
    private String sublocality;
    @SerializedName("3D")
    @Expose
    private Integer _3D;
    @SerializedName("loc_switch")
    @Expose
    private Integer locSwitch;
    @SerializedName("gtype")
    @Expose
    private Integer gtype;
    @SerializedName("stx")
    @Expose
    private Integer stx;
    @SerializedName("terms")
    @Expose
    private Object terms;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("other")
    @Expose
    private Object other;
    @SerializedName("account_type")
    @Expose
    private Object accountType;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPic() {
        return adminPic;
    }

    public void setAdminPic(String adminPic) {
        this.adminPic = adminPic;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStorePic() {
        return storePic;
    }

    public void setStorePic(String storePic) {
        this.storePic = storePic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFatoryemail() {
        return fatoryemail;
    }

    public void setFatoryemail(String fatoryemail) {
        this.fatoryemail = fatoryemail;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDeactivate() {
        return deactivate;
    }

    public void setDeactivate(String deactivate) {
        this.deactivate = deactivate;
    }

    public String getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(String ordercount) {
        this.ordercount = ordercount;
    }

    public String getFabriccount() {
        return fabriccount;
    }

    public void setFabriccount(String fabriccount) {
        this.fabriccount = fabriccount;
    }

    public String getSalescount() {
        return salescount;
    }

    public void setSalescount(String salescount) {
        this.salescount = salescount;
    }

    public String getQR() {
        return qR;
    }

    public void setQR(String qR) {
        this.qR = qR;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public Integer getObpoo() {
        return obpoo;
    }

    public void setObpoo(Integer obpoo) {
        this.obpoo = obpoo;
    }

    public Integer getWebsite() {
        return website;
    }

    public void setWebsite(Integer website) {
        this.website = website;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSublocality() {
        return sublocality;
    }

    public void setSublocality(String sublocality) {
        this.sublocality = sublocality;
    }

    public Integer get3D() {
        return _3D;
    }

    public void set3D(Integer _3D) {
        this._3D = _3D;
    }

    public Integer getLocSwitch() {
        return locSwitch;
    }

    public void setLocSwitch(Integer locSwitch) {
        this.locSwitch = locSwitch;
    }

    public Integer getGtype() {
        return gtype;
    }

    public void setGtype(Integer gtype) {
        this.gtype = gtype;
    }

    public Integer getStx() {
        return stx;
    }

    public void setStx(Integer stx) {
        this.stx = stx;
    }

    public Object getTerms() {
        return terms;
    }

    public void setTerms(Object terms) {
        this.terms = terms;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public Object getAccountType() {
        return accountType;
    }

    public void setAccountType(Object accountType) {
        this.accountType = accountType;
    }
}
