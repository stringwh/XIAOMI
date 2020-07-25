package com.scce.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Customer {
    private Integer customerId;

    private String customerName;

    private String customerPWD;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date customerBirthday;

    private String customerPhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date customerRegDate;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerPWD() {
        return customerPWD;
    }

    public void setCustomerPWD(String customerPWD) {
        this.customerPWD = customerPWD == null ? null : customerPWD.trim();
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public Date getCustomerRegDate() {
        return customerRegDate;
    }

    public void setCustomerRegDate(Date customerRegDate) {
        this.customerRegDate = customerRegDate;
    }

    public Customer(Integer customerId, String customerName, String customerPWD, Date customerBirthday, String customerPhone, Date customerRegDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPWD = customerPWD;
        this.customerBirthday = customerBirthday;
        this.customerPhone = customerPhone;
        this.customerRegDate = customerRegDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPWD='" + customerPWD + '\'' +
                ", customerBirthday=" + customerBirthday +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerRegDate=" + customerRegDate +
                '}';
    }
}