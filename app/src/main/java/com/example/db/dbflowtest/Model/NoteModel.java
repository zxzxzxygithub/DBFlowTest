package com.example.db.dbflowtest.Model;

import com.example.db.dbflowtest.Utils.DateUtil;
import com.example.db.dbflowtest.db.bean.NoteBean;
import com.example.db.dbflowtest.db.bean.NoteBean_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;
import java.util.List;

/**
 * @author lijian
 * @des
 * @date 2019/3/9 14:16
 **/
public class NoteModel {
    /**
     * 添加数据
     */
    public void addData(int id) {
        NoteBean noteBean = new NoteBean();
        noteBean.setDate(DateUtil.getDate(new Date(), DateUtil.DATE_FORMAT_DEFAULT));
//        noteBean.setId(id);//主键自增
        noteBean.setTitle("第" + id + "条数据");
        noteBean.setContent("这是内容....");
        noteBean.insert();
    }

    /**
     * 添加数据
     *
     * @param noteBean
     */
    public void addData(NoteBean noteBean) {
        noteBean.insert();
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public void deleteData(int id) {
        SQLite.delete()
                .from(NoteBean.class)
                .where(NoteBean_Table.id.is(id))
                .execute();
    }

    /**
     * 按照title删除数据
     *
     * @param str
     */
    public void deleteDataOfTitle(String str) {
        SQLite.delete()
                .from(NoteBean.class)
                .where(NoteBean_Table.title.eq(str))
                .execute();
    }

    /**
     * 删除所有数据
     */
    public void deleteAll() {
        SQLite.delete().from(NoteBean.class).async().execute();
    }


    /**
     * 查询全部数据
     */
    public List<NoteBean> queryData() {
        return SQLite.select().from(NoteBean.class).queryList();
    }

    /**
     * 更新数据
     */
    public void updateData() {
        SQLite.update(NoteBean.class)
                .set(NoteBean_Table.title.is("这是修改的标题1243"))
                .where(NoteBean_Table.title.is("title"))
                .execute();
    }
}
