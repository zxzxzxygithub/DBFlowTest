package com.example.db.dbflowtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.db.dbflowtest.Model.NoteModel;
import com.example.db.dbflowtest.Utils.DateUtil;
import com.example.db.dbflowtest.db.bean.NoteBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lijian
 * @des dbflow使用
 * @date 2019/3/9 11:28
 **/
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private NoteModel mNoteModel;
    //    private NotePresenter presenter;
    private List<NoteBean> arrayList;
    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        //初始化RecyclerView
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        mNoteAdapter = new NoteAdapter(R.layout.item_note_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setAdapter(mNoteAdapter);
    }

    private void initData() {
        mNoteModel = new NoteModel();
        mNoteModel.deleteAll();
        for (int i = 0; i < 10; i++) {
            mNoteModel.addData(i);
        }
    }

    @OnClick({R.id.btnAdd, R.id.btnDelete, R.id.btnUpdate, R.id.btnQuery})
    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                //添加
                mNoteModel.addData(new NoteBean("title", DateUtil.getDate(new Date(), DateUtil.DATE_FORMAT_DEFAULT), "content"));
                queryData();
                break;
            case R.id.btnDelete:
                //删除title包含titlede的数据
                mNoteModel.deleteDataOfTitle("title");
                queryData();
                break;
            case R.id.btnUpdate:
                //修改title为title的内容
                mNoteModel.updateData();
                queryData();
                break;
            case R.id.btnQuery:
                //查询
                queryData();
                break;
        }
    }

    private void queryData() {
        mNoteAdapter.setNewData(mNoteModel.queryData());
        mRecyclerView.scrollToPosition(mNoteAdapter.getData().size() - 1);
    }

    public class NoteAdapter extends BaseQuickAdapter<NoteBean, BaseViewHolder> {

        public NoteAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, NoteBean item) {
            helper.setText(R.id.tvTitle, item.getTitle())
                    .setText(R.id.tvDate, item.getDate())
                    .setText(R.id.tvContent, item.getContent())
            ;

        }
    }

}
