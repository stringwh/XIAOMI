package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.Manager;

/**
 * @auther JHY
 * @data 2019/7/5 9:56
 **/
public interface ManagerService {
    //登录
    public Manager getManagerByLogin(String account, String password);
    //查询所有员工信息
    public PageInfo<Manager> selectAllManager(int pageNum, int pageSize)throws Exception;


    //根据ID查询员工信息
    public  Manager selectManagerById(int managerId);

    //添加员工方法
    public  void addManager(Manager manager);

    //删除员工方法
    public  void  delManager(int managerId);

    //修改员工方法
    public  void updateManager(Manager manager);

}
