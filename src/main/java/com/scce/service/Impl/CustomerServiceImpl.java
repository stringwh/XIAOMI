package com.scce.service.Impl;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.Customer;

import com.scce.pojo.Goods;
import com.scce.service.CustomerService;
import com.scce.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    //查询所有员工并分页
    @Override
    public PageInfo<Customer> selectAllCustomer(int pageNum, int pageSize) throws Exception {
        System.out.println("12313213123123123213213");
        List<Customer> list= customerMapper.selectCustomer();
        System.out.println(list.size());
        PageInfo< Customer > pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer customerId) {
        customerMapper.deleteByPrimaryKey(customerId);
        return 1;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public List<Customer> selectCustomer() {
        List<Customer> list=customerMapper.selectCustomer();
        return list;
    }

    @Override
    public PageInfo<Customer> selectname(String customerName,int pageNum, int pageSize) {
        List<Customer> list=customerMapper.selectname(customerName);
        PageInfo< Customer > pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Customer selectCustomerLogin(String customerName, String customerPWD) {
        System.out.println(customerName+"++++"+customerPWD);
        return customerMapper.login(customerName,customerPWD);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    @Override
    public Customer selectOne(String customerName) {
        return customerMapper.selectOneByname(customerName);
    }

    @Override
    public Customer selectById(Integer customerId) {
        return customerMapper.selectById(customerId);
    }
    @Override
    public Customer selCustomer(int customerId) {
        return customerMapper.selCustomer(customerId);
    }


}
