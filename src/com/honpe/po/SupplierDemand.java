package com.honpe.po;

import java.io.Serializable;

public class SupplierDemand implements Serializable{
    private String did;

    private String sid;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }
}