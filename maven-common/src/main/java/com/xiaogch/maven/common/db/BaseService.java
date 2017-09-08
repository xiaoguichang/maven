package com.xiaogch.maven.common.db;

import com.xiaogch.maven.common.db.bean.PagedList;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.springmvc.service <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 15:11 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public interface BaseService<T> {

    T selectById(Object parameter);

    <T> T selectOne();

    <T> T selectOne(Object parameter);

    <K, V> Map<K, V> selectMap(String mapKey);

    <K, V> Map<K, V> selectMap(Object parameter, String mapKey);

    <K, V> Map<K, V> selectMap(Object parameter, String mapKey, RowBounds rowBounds);

    <T> Cursor<T> selectCursor();

    <T> Cursor<T> selectCursor(Object parameter);

    <T> Cursor<T> selectCursor(Object parameter, RowBounds rowBounds);

    <E> List<E> selectList();

    <E> List<E> selectList(Object parameter);

    <E> List<E> selectList(Object parameter, RowBounds rowBounds);

    <E> PagedList<E> selectList(Object parameter , int pageId , int size);

    int insert(Object parameter);

    int update(Object parameter);

    int delete(Object parameter);
}
