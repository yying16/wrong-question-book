package com.wrongquestionbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrongquestionbook.domain.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
}
