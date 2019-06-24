package com.obpoo.gfsfabricsoftware.salesorder.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel.AllOrderItemDet;

import java.util.ArrayList;

public class MyOrdersDetail implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("order_qr")
    @Expose
    private String orderQr;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("order_by")
    @Expose
    private String orderBy;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("order_no")
    @Expose
    private String orderNo;
    @SerializedName("advance")
    @Expose
    private String advance;
    @SerializedName("leftover")
    @Expose
    private String leftover;
    @SerializedName("order_total")
    @Expose
    private String orderTotal;
    @SerializedName("coupon_id")
    @Expose
    private String couponId;
    @SerializedName("coupon_per")
    @Expose
    private String couponPer;
    @SerializedName("coupon_discount_price")
    @Expose
    private String couponDiscountPrice;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("orderdate")
    @Expose
    private String orderdate;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("complete_status")
    @Expose
    private String completeStatus;
    @SerializedName("activity")
    @Expose
    private String activity;
    @SerializedName("pg_assign_time")
    @Expose
    private String pgAssignTime;
    @SerializedName("pg_delivery_time")
    @Expose
    private String pgDeliveryTime;
    @SerializedName("pg_confirm")
    @Expose
    private String pgConfirm;
    @SerializedName("security_check")
    @Expose
    private String securityCheck;
    @SerializedName("delivery_by")
    @Expose
    private String deliveryBy;
    @SerializedName("cutting_by")
    @Expose
    private String cuttingBy;
    @SerializedName("cutter_accepted")
    @Expose
    private String cutterAccepted;
    @SerializedName("feedback")
    @Expose
    private String feedback;
    @SerializedName("pickup_time")
    @Expose
    private String pickupTime;
    @SerializedName("Dellivery_address")
    @Expose
    private String delliveryAddress;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("payble_amount")
    @Expose
    private String paybleAmount;
    @SerializedName("signature")
    @Expose
    private String signature;
    @SerializedName("qc_by")
    @Expose
    private String qcBy;
    @SerializedName("canceled_by")
    @Expose
    private String canceledBy;
    @SerializedName("discount_type")
    @Expose
    private String discountType;
    @SerializedName("delete_status")
    @Expose
    private String deleteStatus;
    @SerializedName("updated_by")
    @Expose
    private String updatedBy;
    @SerializedName("pay_mode")
    @Expose
    private String payMode;
    @SerializedName("credit_time")
    @Expose
    private String creditTime;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;
    @SerializedName("otp")
    @Expose
    private String otp;
    @SerializedName("lattitude")
    @Expose
    private String lattitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("group_name")
    @Expose
    private String groupName;
    @SerializedName("discount_per")
    @Expose
    private String discountPer;
    @SerializedName("status_text")
    @Expose
    private String statusText;


    @SerializedName("customer_details")
    @Expose
    private CustomerDetailOrder  customerDetails;



    @SerializedName("item_details")
    @Expose
    public ArrayList<AllOrderItemDet> itemDetails = null;


    protected MyOrdersDetail(Parcel in) {
        id = in.readString();
        orderQr = in.readString();
        customerId = in.readString();
        orderBy = in.readString();
        orderType = in.readString();
        orderNo = in.readString();
        advance = in.readString();
        leftover = in.readString();
        orderTotal = in.readString();
        couponId = in.readString();
        couponPer = in.readString();
        couponDiscountPrice = in.readString();
        groupId = in.readString();
        orderdate = in.readString();
        updatedOn = in.readString();
        completeStatus = in.readString();
        activity = in.readString();
        pgAssignTime = in.readString();
        pgDeliveryTime = in.readString();
        pgConfirm = in.readString();
        securityCheck = in.readString();
        deliveryBy = in.readString();
        cuttingBy = in.readString();
        cutterAccepted = in.readString();
        feedback = in.readString();
        pickupTime = in.readString();
        delliveryAddress = in.readString();
        discount = in.readString();
        paybleAmount = in.readString();
        signature = in.readString();
        qcBy = in.readString();
        canceledBy = in.readString();
        discountType = in.readString();
        deleteStatus = in.readString();
        updatedBy = in.readString();
        payMode = in.readString();
        creditTime = in.readString();
        deliveryType = in.readString();
        otp = in.readString();
        lattitude = in.readString();
        longitude = in.readString();
        groupName = in.readString();
        discountPer = in.readString();
        statusText = in.readString();
        itemDetails = in.createTypedArrayList(AllOrderItemDet.CREATOR);
    }

    public static final Creator<MyOrdersDetail> CREATOR = new Creator<MyOrdersDetail>() {
        @Override
        public MyOrdersDetail createFromParcel(Parcel in) {
            return new MyOrdersDetail(in);
        }

        @Override
        public MyOrdersDetail[] newArray(int size) {
            return new MyOrdersDetail[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderQr() {
        return orderQr;
    }

    public void setOrderQr(String orderQr) {
        this.orderQr = orderQr;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getLeftover() {
        return leftover;
    }

    public void setLeftover(String leftover) {
        this.leftover = leftover;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponPer() {
        return couponPer;
    }

    public void setCouponPer(String couponPer) {
        this.couponPer = couponPer;
    }

    public String getCouponDiscountPrice() {
        return couponDiscountPrice;
    }

    public void setCouponDiscountPrice(String couponDiscountPrice) {
        this.couponDiscountPrice = couponDiscountPrice;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(String completeStatus) {
        this.completeStatus = completeStatus;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPgAssignTime() {
        return pgAssignTime;
    }

    public void setPgAssignTime(String pgAssignTime) {
        this.pgAssignTime = pgAssignTime;
    }

    public String getPgDeliveryTime() {
        return pgDeliveryTime;
    }

    public void setPgDeliveryTime(String pgDeliveryTime) {
        this.pgDeliveryTime = pgDeliveryTime;
    }

    public String getPgConfirm() {
        return pgConfirm;
    }

    public void setPgConfirm(String pgConfirm) {
        this.pgConfirm = pgConfirm;
    }

    public String getSecurityCheck() {
        return securityCheck;
    }

    public void setSecurityCheck(String securityCheck) {
        this.securityCheck = securityCheck;
    }

    public String getDeliveryBy() {
        return deliveryBy;
    }

    public void setDeliveryBy(String deliveryBy) {
        this.deliveryBy = deliveryBy;
    }

    public String getCuttingBy() {
        return cuttingBy;
    }

    public void setCuttingBy(String cuttingBy) {
        this.cuttingBy = cuttingBy;
    }

    public String getCutterAccepted() {
        return cutterAccepted;
    }

    public void setCutterAccepted(String cutterAccepted) {
        this.cutterAccepted = cutterAccepted;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getDelliveryAddress() {
        return delliveryAddress;
    }

    public void setDelliveryAddress(String delliveryAddress) {
        this.delliveryAddress = delliveryAddress;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPaybleAmount() {
        return paybleAmount;
    }

    public void setPaybleAmount(String paybleAmount) {
        this.paybleAmount = paybleAmount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getQcBy() {
        return qcBy;
    }

    public void setQcBy(String qcBy) {
        this.qcBy = qcBy;
    }

    public String getCanceledBy() {
        return canceledBy;
    }

    public void setCanceledBy(String canceledBy) {
        this.canceledBy = canceledBy;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(String creditTime) {
        this.creditTime = creditTime;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(String discountPer) {
        this.discountPer = discountPer;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public CustomerDetailOrder getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetailOrder customerDetails) {
        this.customerDetails = customerDetails;
    }

    public ArrayList<AllOrderItemDet>  getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ArrayList<AllOrderItemDet>  itemDetails) {
        this.itemDetails = itemDetails;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(orderQr);
        dest.writeString(customerId);
        dest.writeString(orderBy);
        dest.writeString(orderType);
        dest.writeString(orderNo);
        dest.writeString(advance);
        dest.writeString(leftover);
        dest.writeString(orderTotal);
        dest.writeString(couponId);
        dest.writeString(couponPer);
        dest.writeString(couponDiscountPrice);
        dest.writeString(groupId);
        dest.writeString(orderdate);
        dest.writeString(updatedOn);
        dest.writeString(completeStatus);
        dest.writeString(activity);
        dest.writeString(pgAssignTime);
        dest.writeString(pgDeliveryTime);
        dest.writeString(pgConfirm);
        dest.writeString(securityCheck);
        dest.writeString(deliveryBy);
        dest.writeString(cuttingBy);
        dest.writeString(cutterAccepted);
        dest.writeString(feedback);
        dest.writeString(pickupTime);
        dest.writeString(delliveryAddress);
        dest.writeString(discount);
        dest.writeString(paybleAmount);
        dest.writeString(signature);
        dest.writeString(qcBy);
        dest.writeString(canceledBy);
        dest.writeString(discountType);
        dest.writeString(deleteStatus);
        dest.writeString(updatedBy);
        dest.writeString(payMode);
        dest.writeString(creditTime);
        dest.writeString(deliveryType);
        dest.writeString(otp);
        dest.writeString(lattitude);
        dest.writeString(longitude);
        dest.writeString(groupName);
        dest.writeString(discountPer);
        dest.writeString(statusText);
        dest.writeTypedList(itemDetails);
    }
}









