package com.xiaogch.maven.springmvc.dao.impl;

import com.xiaogch.maven.springmvc.dao.BaseDao;
import com.xiaogch.maven.springmvc.entity.PagedInfo;
import com.xiaogch.maven.springmvc.entity.PagedList;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private SqlSessionTemplate sqlSessionTemplate;
    private String namespace;

    public BaseDaoImpl(){

    }

    public BaseDaoImpl(String namespace , SqlSessionTemplate sqlSessionTemplate) {
        Assert.notNull(namespace , "namespace cont be null");
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public T selectById(Object parameter) {
        return sqlSessionTemplate.selectOne(namespace + ".selectById" , parameter);
    }

    @Override
    public <T1> T1 selectOne(String statement) {
        return sqlSessionTemplate.selectOne(namespace + "." + statement);
    }

    @Override
    public <T1> T1 selectOne(String statement, Object parameter) {
        return sqlSessionTemplate.selectOne(namespace + "." + statement , parameter);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return sqlSessionTemplate.selectMap(namespace + "." + statement , mapKey);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
        return sqlSessionTemplate.selectMap(namespace + "." + statement , parameter, mapKey );
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
        return sqlSessionTemplate.selectMap(namespace + "." + statement , parameter, mapKey , rowBounds);
    }

    @Override
    public <T1> Cursor<T1> selectCursor(String statement) {
        return sqlSessionTemplate.selectCursor(namespace + "." + statement);
    }

    @Override
    public <T1> Cursor<T1> selectCursor(String statement, Object parameter) {
        return sqlSessionTemplate.selectCursor(namespace + "." + statement , parameter);
    }

    @Override
    public <T1> Cursor<T1> selectCursor(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSessionTemplate.selectCursor(namespace + "." + statement , parameter , rowBounds);
    }

    @Override
    public <E> List<E> selectList(String statement) {
        return sqlSessionTemplate.selectList(namespace + "." + statement);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return sqlSessionTemplate.selectList(namespace + "." + statement , parameter);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return sqlSessionTemplate.selectList(namespace + "." + statement , parameter , rowBounds);
    }

    @Override
    public int count(String statement) {
        return (int) sqlSessionTemplate.selectOne(namespace + "." + statement);
    }

    @Override
    public int count(String statement, Object parameter) {
        return (int) sqlSessionTemplate.selectOne(namespace + "." + statement , parameter);
    }

    @Override
    public PagedList<T> selectList(String statement, Object parameter, int pageId, int size) {
        Assert.isTrue(pageId >=0 , "pageId must greater than or equal zore");
        Assert.isTrue(size > 0 , "size must greater than zore");
        int totalRecordSize = count(statement + "_count" , parameter);
        int totalPageSize = totalRecordSize > size ? (totalRecordSize/size) + 1 : 0;
        int currentPageNo = totalPageSize >= pageId ? pageId : totalPageSize;
        int offset = pageId > 0 ? (pageId - 1) * size : 0;
        List<T> data = selectList(statement , parameter , new RowBounds(offset , size));
        if (data == null) {
            data = Collections.emptyList();
        }
        PagedInfo pagedInfo = new PagedInfo(totalRecordSize , data.size() , currentPageNo , totalPageSize , size);
        return new PagedList<>(pagedInfo , data);
    }

    @Override
    public void select(String statement, ResultHandler handler) {
        sqlSessionTemplate.select(namespace + "." + statement , handler);
    }

    @Override
    public void select(String statement, Object parameter, ResultHandler handler) {
        sqlSessionTemplate.select(namespace + "." + statement , parameter , handler);
    }

    @Override
    public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        sqlSessionTemplate.select(namespace + "." + statement , parameter , rowBounds , handler);
    }

    @Override
    public int insert(String statement) {
        return sqlSessionTemplate.insert(namespace + "." + statement);
    }

    @Override
    public int insert(T t) {
        return sqlSessionTemplate.insert(namespace + ".insert" , t);
    }

    @Override
    public int insert(String statement, Object parameter) {
        return sqlSessionTemplate.insert(namespace + "." + statement , parameter);
    }

    @Override
    public int update(T t) {
        return sqlSessionTemplate.update(namespace + ".update" , t);
    }

    @Override
    public int update(String statement) {
        return sqlSessionTemplate.insert(namespace + "." + statement);
    }

    @Override
    public int update(String statement, Object parameter) {
        return sqlSessionTemplate.update(namespace + "." + statement , parameter);
    }

    @Override
    public int delete(String statement) {
        return sqlSessionTemplate.delete(namespace + "." + statement);
    }

    @Override
    public int delete(String statement, Object parameter) {
        return sqlSessionTemplate.delete(namespace + "." + parameter , parameter);
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
