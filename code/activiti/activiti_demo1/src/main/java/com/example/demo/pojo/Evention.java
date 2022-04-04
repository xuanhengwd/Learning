package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 出差申请中的流程变量对象
 */
public class Evention implements Serializable {

    private Long id;

    private String eventionName;
    /**
     * 出差天数
     */
    private Double num;

    private Date beginDate;
    private Date endDate;
    private String destination;

    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventionName() {
        return eventionName;
    }

    public void setEventionName(String eventionName) {
        this.eventionName = eventionName;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
