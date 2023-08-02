package com.wrongquestionbook.service;

import com.wrongquestionbook.domain.Folder;
import com.wrongquestionbook.mapper.FolderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 
 */
@Service
public class FolderService {

    /**
     * 文件mapper映射
     */
    @Resource
    public FolderMapper folderMapper;

    /**
     * 我的组织树,学生端为错题树
     */
    public Folder myRoot;

    /**
     * 回收站
     */
    public Folder myRecycleBin;

    /**
     * @param folder
     * @return
     */
    public boolean modifyFolder(Folder folder) {
        // TODO implement here
        return false;
    }

    /**
     * @param folder
     * @return
     */
    public boolean deleteFolder(Folder folder) {
        // TODO implement here
        return false;
    }

    /**
     * @param folder
     * @param parent 
     * @return
     */
    public boolean addFolder(Folder folder, Folder parent) {
        // TODO implement here
        return false;
    }

    /**
     * @param folderId
     * @return
     */
    public Folder getFolder(Long folderId) {
        // TODO implement here
        return null;
    }

    /**
     * 获得所有子节点（包括错题和分组)
     * */
    public Folder getSub(Long folderId){
        return null;
    }

}