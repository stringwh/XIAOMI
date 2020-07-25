package com.scce.service;

import java.util.List;
import com.scce.pojo.Customer;
import com.github.pagehelper.PageInfo;

public interface CustomerService {

    //查询所有客户信息
    public PageInfo<Customer> selectAllCustomer(int pageNum, int pageSize)throws Exception;
    //删除客户
    int deleteByPrimaryKey(Integer customerId);
    //修改客户
    void updateCustomer(Customer customer);
    //导出表格
    List<Customer> selectCustomer();
    //根据客户姓名查找
    PageInfo<Customer> selectname(String customerName,int pageNum, int pageSize)throws Exception;
    //登录
    public Customer selectCustomerLogin(String customerName, String customerPWD);
    //注册
    public void insertCustomer(Customer customer);
    //根据客户姓名查找单个客户
    public Customer selectOne(String customerName);

    public Customer selectById(Integer customerId);
    public Customer selCustomer(int customerId);

}
