package com.xiaogch.maven.common.db.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.common.db.BaseService;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao<T> getBaseDao() {
        return baseDao;
    }

    @Override
    public T selectById(Object parameter) {
        return baseDao.selectById(parameter);
    }

    @Override
    public <T1> T1 selectOne() {
        return baseDao.selectOne("selectOne");
    }

    @Override
    public <T1> T1 selectOne(Object parameter) {
        return baseDao.selectOne("selectOne" , parameter);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String mapKey) {
        return baseDao.selectMap("selectMap" , mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(Object parameter, String mapKey) {
        return baseDao.selectMap("selectMap" , parameter , mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(Object parameter, String mapKey, RowBounds rowBounds) {
        return baseDao.selectMap("selectMap" , parameter , mapKey);
    }

    @Override
    public <T1> Cursor<T1> selectCursor() {
        return baseDao.selectCursor("selectCursor");
    }

    @Override
    public <T1> Cursor<T1> selectCursor(Object parameter) {
        return baseDao.selectCursor("selectCursor" , parameter);
    }

    @Override
    public <T1> Cursor<T1> selectCursor(Object parameter, RowBounds rowBounds) {
        return baseDao.selectCursor("selectCursor" , parameter , rowBounds);
    }

    @Override
    public <E> List<E> selectList() {
        return baseDao.selectList("selectList");
    }

    @Override
    public <E> List<E> selectList(Object parameter) {
        return baseDao.selectList("selectList" , parameter);
    }

    @Override
    public <E> List<E> selectList(Object parameter, RowBounds rowBounds) {
        return baseDao.selectList("selectList" , parameter , rowBounds);
    }

    @Override
    public <E> PagedList<E> selectList(Object parameter, int pageNo, int size) {
        return baseDao.selectList("selectList" , parameter , pageNo , size);
    }

    @Override
    public int insert(Object parameter) {
        return baseDao.insert("insert" , parameter);
    }

    @Override
    public int update(Object parameter) {
        return baseDao.update("update" , parameter);
    }

    @Override
    public int delete(Object parameter) {
        return baseDao.delete("delete" , parameter);
    }
}
