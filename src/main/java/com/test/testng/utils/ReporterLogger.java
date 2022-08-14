package com.test.testng.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.Reporter;

public class ReporterLogger {
    //使用org.apache.log4j.Logger 而不是org.slf4j.Logger;
    private Logger LOGGER;

    // log4j把传递进来的callerFQCN在堆栈中一一比较，相等后，再往上一层即认为是用户的调用类
    static final String FQCN = ReporterLogger.class.getName();

    public ReporterLogger(Class<?> clazz){
        LOGGER= Logger.getLogger(clazz); // 这里也要改
    }

    public void  info(String message){
        //使用slf4j打印到控制台或者文件
        LOGGER.log(FQCN, Level.INFO,message,null);
        //记录到Reporter
        Reporter.log(message);
    }


}
