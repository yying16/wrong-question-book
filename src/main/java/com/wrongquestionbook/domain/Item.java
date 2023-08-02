package com.wrongquestionbook.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 题目
 */
@Data
@TableName("t_item")
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
    public Long itemId;

    /**
     * 
     */
    public String itemName;

    /**
     * 
     */
    public String classify;

    /**
     * 
     */
    public String itemTime;

    /**
     * 
     */
    public boolean deleted;

    /**
     * 
     */
    public int favorites;

    /**
     * 
     */
    public String itemContent;

    /**
     * 
     */
    public byte[] contentPhoto;

    /**
     * 
     */
    public String answer;

    /**
     * 
     */
    public byte[] answerPhoto;

    /**
     * 
     */
    public String promulgatorAccount;

    /**
     * 
     */
    @TableField(exist = false)
    public String promulgatorName;

}