package com.xiaogch.maven.common.db.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.common.db.BaseService;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> getBaseDao();

    @Override
    public T selectById(Object parameter) {
        return getBaseDao().selectOne("selectById" , parameter);
    }

    @Override
    public <T1> T1 selectOne() {
        return getBaseDao().selectOne("selectOne");
    }

    @Override
    public <T1> T1 selectOne(Object parameter) {
        return getBaseDao().selectOne("selectOne" , parameter);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String mapKey) {
        return getBaseDao().selectMap("selectMap" , mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(Object parameter, String mapKey) {
        return getBaseDao().selectMap("selectMap" , parameter , mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(Object parameter, String mapKey, RowBounds rowBounds) {
        return getBaseDao().selectMap("selectMap" , parameter , mapKey);
    }

    @Override
    public <T1> Cursor<T1> selectCursor() {
        return getBaseDao().selectCursor("selectCursor");
    }

    @Override
    public <T1> Cursor<T1> selectCursor(Object parameter) {
        return getBaseDao().selectCursor("selectCursor" , parameter);
    }

    @Override
    public <T1> Cursor<T1> selectCursor(Object parameter, RowBounds rowBounds) {
        return getBaseDao().selectCursor("selectCursor" , parameter , rowBounds);
    }

    @Override
    public <E> List<E> selectList() {
        return getBaseDao().selectList("selectList");
    }

    @Override
    public <E> List<E> selectList(Object parameter) {
        return getBaseDao().selectList("selectList" , parameter);
    }

    @Override
    public <E> List<E> selectList(Object parameter, RowBounds rowBounds) {
        return getBaseDao().selectList("selectList" , parameter , rowBounds);
    }

    @Override
    public <E> PagedList<E> selectList(Object parameter, int pageNo, int size) {
        return getBaseDao().selectList("selectList" , parameter , pageNo , size);
    }

    @Override
    public int insert(Object parameter) {
        return getBaseDao().insert("insert" , parameter);
    }

    @Override
    public int update(Object parameter) {
        return getBaseDao().update("update" , parameter);
    }

    @Override
    public int delete(Object parameter) {
        return getBaseDao().delete("delete" , parameter);
    }
}
