package com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/3/2019.
 */

public class DeliveryResponse {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("order_qr")
    @Expose
    private String orderQr;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("leftover")
    @Expose
    private String leftover;
    @SerializedName("order_total")
    @Expose
    private String orderTotal;
    @SerializedName("orderdate")
    @Expose
    private String orderdate;
    @SerializedName("complete_status")
    @Expose
    private String completeStatus;
    @SerializedName("pg_assign_time")
    @Expose
    private String pgAssignTime;
    @SerializedName("pg_delivery_time")
    @Expose
    private String pgDeliveryTime;
    @SerializedName("delivery_by")
    @Expose
    private String deliveryBy;
    @SerializedName("feedback")
    @Expose
    private String feedback;
    @SerializedName("Dellivery_address")
    @Expose
    private String delliveryAddress;
    @SerializedName("payble_amount")
    @Expose
    private String paybleAmount;
    @SerializedName("pay_mode")
    @Expose
    private String payMode;
    @SerializedName("credit_time")
    @Expose
    private String creditTime;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;
    @SerializedName("lattitude")
    @Expose
    private String lattitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("pg_confirm")
    @Expose
    private String pgConfirm;
    @SerializedName("customer_details")
    @Expose
    private CustomerDetails customerDetails;
    @SerializedName("packet_details")
    @Expose
    private PacketDetails packetDetails;

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

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(String completeStatus) {
        this.completeStatus = completeStatus;
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

    public String getDeliveryBy() {
        return deliveryBy;
    }

    public void setDeliveryBy(String deliveryBy) {
        this.deliveryBy = deliveryBy;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDelliveryAddress() {
        return delliveryAddress;
    }

    public void setDelliveryAddress(String delliveryAddress) {
        this.delliveryAddress = delliveryAddress;
    }

    public String getPaybleAmount() {
        return paybleAmount;
    }

    public void setPaybleAmount(String paybleAmount) {
        this.paybleAmount = paybleAmount;
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

    public String getPgConfirm() {
        return pgConfirm;
    }

    public void setPgConfirm(String pgConfirm) {
        this.pgConfirm = pgConfirm;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public PacketDetails getPacketDetails() {
        return packetDetails;
    }

    public void setPacketDetails(PacketDetails packetDetails) {
        this.packetDetails = packetDetails;
    }

}
