package com.munchkin.product.dto;

import java.util.Date;

public class BrandDto {

    private int brandSeq;
    private String name;
    private String appLogo;
    private String webLogo;
    private Date createTime;
    private Date modifyTime;

    public int getBrandSeq() {
        return brandSeq;
    }

    public void setBrandSeq(int brandSeq) {
        this.brandSeq = brandSeq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getWebLogo() {
        return webLogo;
    }

    public void setWebLogo(String webLogo) {
        this.webLogo = webLogo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
