package com.wrongquestionbook.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分组
 */
@Data
@TableName("t_folder")
@AllArgsConstructor
@NoArgsConstructor
public class Folder {

    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
    public Long folderId;

    /**
     * 
     */
    public Long parentFolder;

    /**
     * 
     */
    public String folderName;

    /**
     * 
     */
    public String folderPath;

    /**
     * 
     */
    public int subNumber;

    /**
     * 
     */
    public String subNotesId;

    /**
     * 
     */
    public String subFolderId;

    /**
     * 用于分组树
     */
    @TableField(exist = false)
    public Notes[] subNotes;

    /**
     * 用于分组树
     */
    @TableField(exist = false)
    public Folder[] subFolder;

}