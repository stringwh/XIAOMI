package com.scce.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.pojo.Customer;
import com.scce.service.CustomerService;
import com.scce.utils.ExcelUtil;
import com.scce.utils.JsonResult;
import com.scce.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Api(tags = "customerManage")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //查询所有商品信息并分页
    @ApiOperation("查询客户")
    @RequestMapping("/getAllCustomer")
    public JsonResult getAllCustomer(int pageNum, int pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("执行查询所有客户信息的方法");
        PageInfo<Customer> pageInfo=customerService.selectAllCustomer(pageNum,pageSize);
        pageInfo.getList();
        System.out.println(pageInfo.getList());
        return new JsonResult(0,pageInfo.getList());
    }
    @ApiOperation("查询用户个人信息")
    @RequestMapping("/getCustomer")
    public JsonResult getCustomer(int customerId){
        Customer customer=customerService.selCustomer(customerId);

        return new JsonResult(0,customer);
    }

    //根据id删除客户
    @ApiOperation("删除客户")
    @RequestMapping("/deleteByPrimaryKey")
    public JsonResult deleteByPrimaryKey(Integer customerId) throws Exception{
        customerService.deleteByPrimaryKey(customerId);
        System.out.println("删除客户的方法");
        System.out.println(customerId);
        return new JsonResult(0,"删除成功");
    }
    //根据id删除客户
    @ApiOperation("修改客户")
    @RequestMapping("/updateCustomer")
    public JsonResult updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return new JsonResult(0,"修改成功");
    }
    //导出表格
    @ApiOperation("导出表格")
    @RequestMapping("/Excel")
    public String Excel(HttpServletResponse response){
        System.out.println("进入Excel");
       try {
            Workbook wb = new HSSFWorkbook();  //创建工作簿
            String headers[] = {"姓名", "密码", "出生日期", "联系方式", "注册时间"};
            List<Customer> list = customerService.selectCustomer();
            System.out.println(list);
            ExcelUtil.fillExcelData(list, wb, headers);
            ResponseUtil.export(response, wb, "导出excel.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //根据用户名字查找
    @ApiOperation("查找客户")
    @RequestMapping("/selectname")
    public JsonResult selectname(@RequestParam(value = "customerName",required = false) String customerName,
                                 int pageNum, int pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("进入查找客户");
        PageInfo<Customer> pageInfo=customerService.selectname(customerName,pageNum,pageSize);
        System.out.println(pageInfo.getList()+"========"+customerName);
        System.out.println(pageInfo);
        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }
    @ApiOperation(value = "客户登录")
    @RequestMapping("/CustomerLogin")
    @ResponseBody
    public JsonResult CustomerLogin(String customerName,String customerPWD) throws Exception{
        Customer customer = customerService.selectCustomerLogin(customerName,customerPWD);
        System.out.println(customer);
        if (customer!=null){
            return new JsonResult(0,customer);
        }else {
            return new JsonResult(1,customer);
        }
    }
    @ApiOperation(value = "客户注册")
    @RequestMapping("/insertCustomer")
    public  JsonResult insertCustomer(Customer customer){
        System.out.println(customer);
        customerService.insertCustomer(customer);
        return new JsonResult(0,"注册成功");
    }

    @ApiOperation("查找单个用户信息")
    @RequestMapping(value = "/getCustomerByName",method = RequestMethod.GET)
    public JsonResult findOne(String customerName){
        return new JsonResult(customerService.selectOne(customerName));
    }
}
