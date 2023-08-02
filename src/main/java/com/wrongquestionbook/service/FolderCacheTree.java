package com.wrongquestionbook.service;

import com.wrongquestionbook.domain.Folder;
import com.wrongquestionbook.domain.User;
import com.wrongquestionbook.mapper.FolderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 缓存只做根节点和回收站的缓存
 */
@Service
public class FolderCacheTree {

    @Resource
    public FolderMapper foldermapper;

    @Resource
    public NotesService notesService;

    /**
     * 刷新个人组织树，需要添加Redis缓存
     * @param account 当前登录用户账号
     * @return 返回当前用户的组织树根目录
     */
    public Folder getMyRoot(String account) {
        // TODO implement here
        return null;
    }

    /**
     * 需要添加Redis缓存
     * @param account 当前登录用户账号
     * @return 回收站根目录
     */
    public Folder getRecycleBin(String account) {
        // TODO implement here
        return null;
    }

    /**
     * 删除根目录缓存，每次更新根目录的时候就需要删除缓存，等下次重新获取数据时自动刷新缓存
     * @param account 当前登录用户
     * @return
     */
    public boolean deleteRootCache(String account) {
        // TODO implement here
        return false;
    }

    /**
     * 删除回收站缓存，每次更新根目录的时候就需要删除缓存，等下次重新获取数据时自动刷新缓存
     * @param account 当前登录用户
     * @return
     */
    public boolean deleteRecycleBinCache(String account) {
        // TODO implement here
        return false;
    }

    /**
     * @param folder
     * @return
     */
    public Folder updateMyRoot(String account,Folder folder) {
        // TODO implement here
        return null;
    }

    /**
     * @param folder
     * @return
     */
    public Folder updateRecycleBin(String account,Folder folder) {
        // TODO implement here
        return null;
    }

}