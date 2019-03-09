package com.example.db.dbflowtest;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * @author lijian
 * @des
 * @date 2019/3/9 11:32
 **/
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化DBFLOW
        FlowManager.init(new FlowConfig.Builder(this).build());
        //设置日志显示
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
    }

}
