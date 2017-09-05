package com.xiaogch.maven.springmvc.dao;

import com.xiaogch.maven.springmvc.entity.PagedList;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.springmvc.dao <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/5 15:25 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public interface BaseDao<T> {

    T selectById(Object parameter);

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <K, V> Map<K, V> selectMap(String statement, String mapKey);

    <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey);

    <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds);

    <T> Cursor<T> selectCursor(String statement);

    <T> Cursor<T> selectCursor(String statement, Object parameter);

    <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds);

    <E> List<E> selectList(String statement);

    <E> List<E> selectList(String statement, Object parameter);

    <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds);

    PagedList<T> selectList(String statement , Object parameter , int pageId , int size);

    void select(String statement, ResultHandler handler);

    void select(String statement, Object parameter, ResultHandler handler);

    void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler);

    int count(String statement);

    int count(String statement, Object parameter);

    int insert(T t);

    int insert(String statement);

    int insert(String statement, Object parameter);

    int update(T t);

    int update(String statement);

    int update(String statement, Object parameter);

    int delete(String statement);

    int delete(String statement, Object parameter);

}
