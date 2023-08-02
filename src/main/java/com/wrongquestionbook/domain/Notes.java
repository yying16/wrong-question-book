package com.wrongquestionbook.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错题
 */
@Data
@TableName("t_notes")
@AllArgsConstructor
@NoArgsConstructor
public class Notes {
    @TableId(type = IdType.ASSIGN_ID)
    public Long notesId;
    /**
     *
     */
    public String notesName;
    /**
     *
     */
    public String notesPath;
    /**
     *
     */
    public String notesContent;
    /**
     *
     */
    public Byte[] notesPhoto;
    /**
     *
     */
    public String notesTime;
    /**
     *
     */
    public Long exercise;
    /**
     *
     */
    public boolean deleted;


}
