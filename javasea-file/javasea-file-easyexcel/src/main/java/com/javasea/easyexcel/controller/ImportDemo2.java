package com.javasea.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.javasea.easyexcel.entity.Teacher;
import com.javasea.easyexcel.relase.executor.HandeExecutor;
import com.javasea.easyexcel.relase.listener.ExcelImportDataListener;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName ImportDemo
 * @Description 关于EasyExcel的数据读取会稍微麻烦一点，直接通过工具类读取到的数据不能直接处理，需要借助一个中间的类 监听器 类
 * @Author longxiaonan@163.com
 * @Date 2020/3/23 0023 17:44
 */
public class ImportDemo2 {

    @Test
    public void importTest() {

        String fileName =  "d:/wms/aaaa-无title.xls";

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        /**
         * 参数1 要读取的文件
         * 参数2 要读取的数据对应的实体类类对象
         * 参数3 监听器对象 可以在创建的时候把dao当做参数传进去
         */
        ExcelImportDataListener<Teacher> teacherExcelImportDataListener = new ExcelImportDataListener<>();

        HandeExecutor<Teacher> executor = (list) -> {
            aa(list);
        };
        teacherExcelImportDataListener.setHandeExecutor(executor);

        EasyExcel.read(fileName, Teacher.class, teacherExcelImportDataListener).sheet().doRead();
    }

    private void aa(List<Teacher> list) {
        System.out.println(list);
    }
}
