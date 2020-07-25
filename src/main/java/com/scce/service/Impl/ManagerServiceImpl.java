package com.scce.service.Impl;

import com.github.pagehelper.PageInfo;
import com.scce.dao.ManagerMapper;
import com.scce.pojo.Manager;
import com.scce.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther JHY
 * @data 2019/7/5 9:56
 **/
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager getManagerByLogin(String account, String password) {
        System.out.println(account+password);
        return managerMapper.login(account,password);
    }
    //查询所有员工并分页
    @Override
    public PageInfo<Manager> selectAllManager(int pageNum, int pageSize) throws Exception {
        System.out.println("查询所有员工方法");
        List<Manager> list= managerMapper.selectManager();
        System.out.println(list.size());
        PageInfo< Manager > pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Manager selectManagerById(int managerId) {

        return  managerMapper.selectManagerById(managerId);
    }

    //增加员工
    @Override
    public void addManager(Manager manager) {
        managerMapper.addManager(manager);
    }

    @Override
    public void delManager(int managerId) {
        managerMapper.delManager(managerId);
    }

    @Override
    public void updateManager(Manager manager) {
        managerMapper.updateManager(manager);
    }
}
