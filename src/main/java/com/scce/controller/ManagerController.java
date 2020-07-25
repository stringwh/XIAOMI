package com.scce.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.scce.pojo.Manager;

import com.scce.service.ManagerService;
import com.scce.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "员工管理")
@RestController
public class ManagerController {

    @Autowired
   private ManagerService managerService;

    @ApiOperation(value = "管理员登录")
    @RequestMapping(value = "/managerlogin",method = RequestMethod.POST)
    public JsonResult managerLogin(String managerNum, String managerPWD) throws Exception{
        Manager manager = managerService.getManagerByLogin(managerNum,managerPWD);
        if (manager!=null){
            return new JsonResult(0,"登录成功");
        }else {
            return new JsonResult(1,"账号或密码有误");
        }
    }


    //查询所有员工管理员并分页
    @ApiOperation("查询员工")
    @RequestMapping("/getAllManager")
    public JsonResult getAllManager(int pageNum, int pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("执行查询所有员工信息的方法");
        PageInfo<Manager> pageInfo=managerService.selectAllManager(pageNum,pageSize);
        pageInfo.getList();
        System.out.println(pageInfo.getList());
        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }

    @ApiOperation("根据ID查询员工")
    @RequestMapping("/getManager")
    public JsonResult getManager(int managerId) throws Exception{

        System.out.println("准备执行根据ID查询员工信息的方法");
        Manager manager=managerService.selectManagerById(managerId);
        System.out.println("成功执行根据ID查询员工信息的方法");

        return new JsonResult(0,manager);
    }



    @ApiOperation("添加员工")
    @RequestMapping(value = "addManager")
    public JsonResult addManager(Manager manager){
//        Manager manager = new Manager();
//        //新建员工并赋值
//        manager.setManagerNum(managerNum);
//        manager.setManagerName(managerName);
//        manager.setManagerPWD(managerPWD);
//        manager.setManagerStatus(managerStatus);
        managerService.addManager(manager);
        return new JsonResult(0,"添加员工成功");
    }

    //删除员工方法

    @ApiOperation("删除员工")
    @RequestMapping("/delManager")
    public void delManager(int managerId){
        System.out.println("开始执行删除员工方法");
        managerService.delManager(managerId);
        System.out.println("删除员工方法执行完毕");
    }

    @ApiOperation("修改员工")
    @RequestMapping("/updateManager")
    public JsonResult updateManager(Manager manager){
        managerService.updateManager(manager);
        return new JsonResult(0,"修改成功");
    }
}
