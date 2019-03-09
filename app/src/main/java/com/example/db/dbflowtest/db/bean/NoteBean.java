package com.example.db.dbflowtest.db.bean;

import com.example.db.dbflowtest.db.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @author lijian
 * @des 创建表
 * @date 2019/3/9 11:8
 **/
@Table(database = MyDatabase.class)
public class NoteBean extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    private int id;
    @Column
    private String title;
    @Column
    private String date;
    @Column
    private String content;

    public NoteBean() {
    }

    public NoteBean(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
