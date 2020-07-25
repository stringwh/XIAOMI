package com.scce.dao;

import com.scce.pojo.Manager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {

    @Select(value = "select * from manager where managerNum = #{managerNum} and managerPWD = #{managerPWD}")
    Manager login(@Param("managerNum")String managerNum,@Param("managerPWD")String managerPWD);

    @Select("select * from manager")
    List<Manager> selectManager();

    @Select("select * from manager where managerId=#{managerId}")
    Manager selectManagerById( int managerId);

    @Insert("insert into manager (managerNum,managerName, managerPWD,managerStatus) values (#{managerNum},#{managerName},#{managerPWD},#{managerStatus})")
    void addManager(Manager manager);

    @Delete("delete from manager where managerId=#{managerId}")
    void delManager(int managerId);

    @Update("update manager set managerNum=#{managerNum},managerName=#{managerName}, managerPWD=#{managerPWD},managerStatus=#{managerStatus}  where managerId=#{managerId}")
    void updateManager(Manager manager);


}