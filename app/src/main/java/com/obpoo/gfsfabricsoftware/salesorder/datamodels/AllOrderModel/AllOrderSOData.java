package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllOrderSOData implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("order_qr")
    @Expose
    private String orderQr;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("tailor_id")
    @Expose
    private String tailorId;
    @SerializedName("from_ts")
    @Expose
    private String fromTs;
    @SerializedName("salesno")
    @Expose
    private String salesno;
    @SerializedName("note")
    @Expose
    private String note;
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
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("currency")
    @Expose
    private String currency;
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
    @SerializedName("reason")
    @Expose
    private String reason;
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
    @SerializedName("receipt_no")
    @Expose
    private String receiptNo;
    @SerializedName("courier_img")
    @Expose
    private String courierImg;
    @SerializedName("invoice")
    @Expose
    private String invoice;
    @SerializedName("runno")
    @Expose
    private String runno;
    @SerializedName("typepo")
    @Expose
    private String typepo;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("customer_details")
    @Expose
    private AllOrderSoCus customerDetails;
    @SerializedName("item_details")
    @Expose
    private ArrayList<AllOrderItemDet>  itemDetails = null;

    protected AllOrderSOData(Parcel in) {
        id = in.readString();
        orderQr = in.readString();
        customerId = in.readString();
        tailorId = in.readString();
        fromTs = in.readString();
        salesno = in.readString();
        note = in.readString();
        orderBy = in.readString();
        orderType = in.readString();
        vatEnabled = in.readString();
        vatSlip = in.readString();
        orderNo = in.readString();
        advance = in.readString();
        leftover = in.readString();
        balance = in.readString();
        currency = in.readString();
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
        returnAcceptedBy = in.readString();
        returnDescription = in.readString();
        returnOther = in.readString();
        pickupTime = in.readString();
        delliveryAddress = in.readString();
        discount = in.readString();
        paybleAmount = in.readString();
        vatAmount = in.readString();
        deliverCharges = in.readString();
        signature = in.readString();
        reason = in.readString();
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
        duedate = in.readString();
        partialReturn = in.readString();
        receiptNo = in.readString();
        courierImg = in.readString();
        invoice = in.readString();
        runno = in.readString();
        typepo = in.readString();
        statusText = in.readString();
        customerDetails = in.readParcelable(AllOrderSoCus.class.getClassLoader());
        itemDetails = in.createTypedArrayList(AllOrderItemDet.CREATOR);
    }

    public static final Creator<AllOrderSOData> CREATOR = new Creator<AllOrderSOData>() {
        @Override
        public AllOrderSOData createFromParcel(Parcel in) {
            return new AllOrderSOData(in);
        }

        @Override
        public AllOrderSOData[] newArray(int size) {
            return new AllOrderSOData[size];
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

    public String getTailorId() {
        return tailorId;
    }

    public void setTailorId(String tailorId) {
        this.tailorId = tailorId;
    }

    public String getFromTs() {
        return fromTs;
    }

    public void setFromTs(String fromTs) {
        this.fromTs = fromTs;
    }

    public String getSalesno() {
        return salesno;
    }

    public void setSalesno(String salesno) {
        this.salesno = salesno;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getCourierImg() {
        return courierImg;
    }

    public void setCourierImg(String courierImg) {
        this.courierImg = courierImg;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getRunno() {
        return runno;
    }

    public void setRunno(String runno) {
        this.runno = runno;
    }

    public String getTypepo() {
        return typepo;
    }

    public void setTypepo(String typepo) {
        this.typepo = typepo;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public AllOrderSoCus getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(AllOrderSoCus customerDetails) {
        this.customerDetails = customerDetails;
    }

    public ArrayList<AllOrderItemDet> getItemDetails() {
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
        dest.writeString(tailorId);
        dest.writeString(fromTs);
        dest.writeString(salesno);
        dest.writeString(note);
        dest.writeString(orderBy);
        dest.writeString(orderType);
        dest.writeString(vatEnabled);
        dest.writeString(vatSlip);
        dest.writeString(orderNo);
        dest.writeString(advance);
        dest.writeString(leftover);
        dest.writeString(balance);
        dest.writeString(currency);
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
        dest.writeString(returnAcceptedBy);
        dest.writeString(returnDescription);
        dest.writeString(returnOther);
        dest.writeString(pickupTime);
        dest.writeString(delliveryAddress);
        dest.writeString(discount);
        dest.writeString(paybleAmount);
        dest.writeString(vatAmount);
        dest.writeString(deliverCharges);
        dest.writeString(signature);
        dest.writeString(reason);
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
        dest.writeString(duedate);
        dest.writeString(partialReturn);
        dest.writeString(receiptNo);
        dest.writeString(courierImg);
        dest.writeString(invoice);
        dest.writeString(runno);
        dest.writeString(typepo);
        dest.writeString(statusText);
        dest.writeParcelable(customerDetails, flags);
        dest.writeTypedList(itemDetails);
    }
}
