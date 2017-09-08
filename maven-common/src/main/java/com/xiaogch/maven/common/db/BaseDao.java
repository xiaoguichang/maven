package com.xiaogch.maven.common.db;

import com.xiaogch.maven.common.db.bean.PagedList;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

    <T> T selectOne(String statementId);

    <T> T selectOne(String statementId, Object parameter);

    <K, V> Map<K, V> selectMap(String statementId, String mapKey);

    <K, V> Map<K, V> selectMap(String statementId, Object parameter, String mapKey);

    <K, V> Map<K, V> selectMap(String statementId, Object parameter, String mapKey, RowBounds rowBounds);

    <T> Cursor<T> selectCursor(String statementId);

    <T> Cursor<T> selectCursor(String statementId, Object parameter);

    <T> Cursor<T> selectCursor(String statementId, Object parameter, RowBounds rowBounds);

    <E> List<E> selectList(String statementId);

    <E> List<E> selectList(String statementId, Object parameter);

    <E> List<E> selectList(String statementId, Object parameter, RowBounds rowBounds);

    <E> PagedList<E> selectList(String statementId , Object parameter , int pageId , int size);

    void select(String statementId, ResultHandler handler);

    void select(String statementId, Object parameter, ResultHandler handler);

    void select(String statementId, Object parameter, RowBounds rowBounds, ResultHandler handler);

    int count(String statementId);

    int count(String statementId, Object parameter);

    int insert(T t);

    int insert(String statementId);

    int insert(String statementId, Object parameter);

    int update(T t);

    int update(String statementId);

    int update(String statementId, Object parameter);

    int delete(String statementId);

    int delete(String statementId, Object parameter);

}
