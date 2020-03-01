package com.lenovo.thinkiot.mybatis.po;

import java.io.Serializable;
import java.util.Date;

public class LaoActivity implements Serializable {
    private Long activityId;

    private String activityName;

    private String activityType;

    private String subType;

    private String suitObj;

    private Long tagId1;

    private String modelId;

    private Date startDate;

    private Date endDate;

    private String activityStatus;

    private String descr;

    private String hasGroup;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    public String getSuitObj() {
        return suitObj;
    }

    public void setSuitObj(String suitObj) {
        this.suitObj = suitObj == null ? null : suitObj.trim();
    }

    public Long getTagId1() {
        return tagId1;
    }

    public void setTagId1(Long tagId1) {
        this.tagId1 = tagId1;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus == null ? null : activityStatus.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getHasGroup() {
        return hasGroup;
    }

    public void setHasGroup(String hasGroup) {
        this.hasGroup = hasGroup == null ? null : hasGroup.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}