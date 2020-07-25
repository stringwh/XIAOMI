package com.scce.pojo;

public class Manager {
    private Integer managerId;

    private String managerNum;

    private String managerName;

    private String managerPWD;

    private Integer managerStatus;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerNum() {
        return managerNum;
    }

    public void setManagerNum(String managerNum) {
        this.managerNum = managerNum == null ? null : managerNum.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPWD() {
        return managerPWD;
    }

    public void setManagerPWD(String managerPWD) {
        this.managerPWD = managerPWD == null ? null : managerPWD.trim();
    }

    public Integer getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(Integer managerStatus) {
        this.managerStatus = managerStatus;
    }
}