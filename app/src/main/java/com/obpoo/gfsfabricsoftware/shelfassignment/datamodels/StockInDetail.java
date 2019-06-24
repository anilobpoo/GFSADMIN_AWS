package com.obpoo.gfsfabricsoftware.shelfassignment.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StockInDetail {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("packet_id")
    @Expose
    private String packet_id;
    @SerializedName("unique_code")
    @Expose
    private String unique_code;
    @SerializedName("shelf_id")
    @Expose
    private String shelf_id;
    @SerializedName("fab_id")
    @Expose
    private String fab_id;
    @SerializedName("total")
    @Expose
    private String total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacket_id() {
        return packet_id;
    }

    public void setPacket_id(String packet_id) {
        this.packet_id = packet_id;
    }

    public String getUnique_code() {
        return unique_code;
    }

    public void setUnique_code(String unique_code) {
        this.unique_code = unique_code;
    }

    public String getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getFab_id() {
        return fab_id;
    }

    public void setFab_id(String fab_id) {
        this.fab_id = fab_id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public ArrayList<PacketDetails> getPacket_details() {
        return Packet_details;
    }

    public void setPacket_details(ArrayList<PacketDetails> packet_details) {
        Packet_details = packet_details;
    }

    @SerializedName("remain")
    @Expose

    private String remain;
    @SerializedName("reserve")
    @Expose
    private String reserve;
    @SerializedName("Packet_details")
    @Expose
    private ArrayList<PacketDetails> Packet_details;




}
