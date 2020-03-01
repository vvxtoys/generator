package com.lenovo.thinkiot.mybatis.mapper;

import com.lenovo.thinkiot.mybatis.po.LaoActivity;
import com.lenovo.thinkiot.mybatis.po.LaoActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

public interface LaoActivityMapper {
    long countByExample(LaoActivityExample example);

    int deleteByExample(LaoActivityExample example);

    int deleteByPrimaryKey(Long activityId);

    int insert(LaoActivity record);

    int insertSelective(LaoActivity record);

    List<LaoActivity> selectByExample(LaoActivityExample example);

    LaoActivity selectByPrimaryKey(Long activityId);

    int updateByExampleSelective(@Param("record") LaoActivity record, @Param("example") LaoActivityExample example);

    int updateByExample(@Param("record") LaoActivity record, @Param("example") LaoActivityExample example);

    int updateByPrimaryKeySelective(LaoActivity record);

    int updateByPrimaryKey(LaoActivity record);

    Cursor<LaoActivity> selectCursorByExample(LaoActivityExample example);
}