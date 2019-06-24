package com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/18/2019.
 */

public class Bill_Invoice_Response {
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
    @SerializedName("vat_enabled")
    @Expose
    private String vatEnabled;
    @SerializedName("vat_slip")
    @Expose
    private String vatSlip;
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
    @SerializedName("return_accepted_by")
    @Expose
    private String returnAcceptedBy;
    @SerializedName("return_description")
    @Expose
    private String returnDescription;
    @SerializedName("return_other")
    @Expose
    private String returnOther;
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
    @SerializedName("vat_amount")
    @Expose
    private String vatAmount;
    @SerializedName("deliver_charges")
    @Expose
    private String deliverCharges;
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
    @SerializedName("duedate")
    @Expose
    private String duedate;
    @SerializedName("partial_return")
    @Expose
    private String partialReturn;
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
    private CustomerDetails customerDetails;
    @SerializedName("item_details")
    @Expose
    private ArrayList<ItemDetail> itemDetails = null;

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

    public String getVatEnabled() {
        return vatEnabled;
    }

    public void setVatEnabled(String vatEnabled) {
        this.vatEnabled = vatEnabled;
    }

    public String getVatSlip() {
        return vatSlip;
    }

    public void setVatSlip(String vatSlip) {
        this.vatSlip = vatSlip;
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

    public String getReturnAcceptedBy() {
        return returnAcceptedBy;
    }

    public void setReturnAcceptedBy(String returnAcceptedBy) {
        this.returnAcceptedBy = returnAcceptedBy;
    }

    public String getReturnDescription() {
        return returnDescription;
    }

    public void setReturnDescription(String returnDescription) {
        this.returnDescription = returnDescription;
    }

    public String getReturnOther() {
        return returnOther;
    }

    public void setReturnOther(String returnOther) {
        this.returnOther = returnOther;
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

    public String getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(String vatAmount) {
        this.vatAmount = vatAmount;
    }

    public String getDeliverCharges() {
        return deliverCharges;
    }

    public void setDeliverCharges(String deliverCharges) {
        this.deliverCharges = deliverCharges;
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

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getPartialReturn() {
        return partialReturn;
    }

    public void setPartialReturn(String partialReturn) {
        this.partialReturn = partialReturn;
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

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public ArrayList<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ArrayList<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }

}
