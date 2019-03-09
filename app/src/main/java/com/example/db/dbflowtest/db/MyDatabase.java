package com.example.db.dbflowtest.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @author lijian
 * @des dbflow使用
 * @date 2019/3/9 11:8
 **/
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    //数据库名称
    public static final String NAME = "MyDatabase";
    //数据库版本号
    public static final int VERSION = 1;
}
