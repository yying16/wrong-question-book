package com.wrongquestionbook.service;

import com.alibaba.fastjson.JSONObject;
import com.wrongquestionbook.domain.Notes;
import com.wrongquestionbook.mapper.NotesMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
/**
 * 只负责错题的存储
 *
 * */
@Service
public class NotesService {
    @Mapper
    NotesMapper notesMapper;

    /**
     * 更新错题
     * */
    public boolean updateNotes(Notes notes){
        // TODO implement here
        return false;
    }

    /**
     * 获取错题详情,需要重新写mapper查询视图,返回json对象
     * */
    public JSONObject getNotesDetail(Notes notes){
        // TODO implement here
        return null;
    }


    /**
     * 添加错题
     * */
    public boolean addNotes(Notes notes){
        // TODO implement here
        return false;
    }


    /**
     * 删除错题
     * */
    public boolean deleteNotes(Notes notes){
        // TODO implement here
        return false;
    }

    /**
     * 根据id获取错题
     * @param notesId 错题id;
     * @return 返回对应的错题;
     *
     * */
    public Notes getNotes(long notesId){
        return null;
    }






}
