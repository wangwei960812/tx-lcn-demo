package com.springcloud.db.txmanager.entities;

import java.util.Date;

public class TDemo {
    private Long id;

    private String kid;

    private String demoField;

    private String groupId;

    private String unitId;

    private String appName;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid == null ? null : kid.trim();
    }

    public String getDemoField() {
        return demoField;
    }

    public void setDemoField(String demoField) {
        this.demoField = demoField == null ? null : demoField.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}