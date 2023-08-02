package com.wrongquestionbook.util;

import com.wrongquestionbook.domain.Folder;
import com.wrongquestionbook.domain.Item;
import com.wrongquestionbook.domain.Notes;
import com.wrongquestionbook.service.FolderCacheTree;
import com.wrongquestionbook.service.FolderService;
import com.wrongquestionbook.service.NotesService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 负责处理树形算法,用@Autowired装配使用
 */
@Component
public class TreeUtil {

    /**
     * 
     */
    @Resource
    public FolderCacheTree cacheTree;

    /**
     * 
     */
    @Resource
    public FolderService folderService;

    @Resource
    public NotesService notesService;

    /**
     * 按目录和题目名称进行搜索
     * @param root 标题（错题标题或练习标题）
     * @param content 
     * @return 将所有搜索结果储存到一个Folder里作为返回结果
     */
    public Folder search(Folder root, String content) {
        // TODO implement here
        return null;
    }

    /**
     * 迭代生成文件树进行返回(用于缓存的调用）
     * @param root 根节点
     * @return 是否创建成功
     */
    public Folder createTree(Folder root) {
        Queue<Folder> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){ //广搜算法
            Folder temp = queue.peek();
            queue.poll();
            long[] subFolderId = split(temp.subFolderId);
            long[] subNotesId = split(temp.subNotesId);
            root.subFolder = new Folder[subFolderId.length];
            root.subNotes = new Notes[subNotesId.length];
            for (int i = 0; i < subFolderId.length; i++) {
                root.subFolder[i] = folderService.getFolder(subFolderId[i]);
                queue.add(root.subFolder[i]);
            }
            for (int i = 0; i < subNotesId.length; i++) {
                root.subNotes[i] = notesService.getNotes(subNotesId[i]);
            }
        }
        return root;
    }

    /**
     * 添加节点
     * @param notes 要添加的节点（错题）
     * @param parent 当前目录（要添加的节点的父节点）
     * @return 是否添加成功
     */
    public boolean addNotes(Notes notes, Folder parent) {
//        Folder[] folders = new Folder[parent.subFolder.length+1];
//        for (int i = 0; i < ; i++) {
//
//        }
        return false;
    }

    /**
     * 删除题目/错题
     * @param root
     * @param notes 要删除的节点
     * @param parent 要删除的节点的父节点
     * @param recycleBin 删除后将题目/错题放入对应的回收站
     * @return 是否删除成功
     */
    public boolean deleteItem(Folder root,  Notes notes, Folder parent, Folder recycleBin) {
        // TODO implement here
        return false;
    }

    /**
     * 添加目录
     * @param root
     * @param folder 要创建的目录
     * @param parent 父节点
     * @return 是否创建成功
     */
    public boolean addFolder(Folder root, Folder folder, Folder parent) {
        // TODO implement here
        return false;
    }

    /**
     * 删除目录
     * @param root
     * @param folder 要删除的目录
     * @param parent 父节点
     * @param recycleBin 删除后将目录放入对应的回收站
     * @return 是否删除成功
     */
    public boolean deleteFolder(Folder root, Folder folder, Folder parent, Folder recycleBin) {
        // TODO implement here
        return false;
    }

    /**
     * 根据路径创建题，用于删除文件的恢复
     * @param notes 错题
     * @return 是否成功
     */
    public boolean recoverNotes(Notes notes) {
        // TODO implement here
        return false;
    }

    /**
     * 根据路径创建题，用于删除题的恢复
     * @param folder
     * @return
     */
    public boolean recoverFolder(Folder folder) {
        // TODO implement here
        return false;
    }

    public long[] split(String sub){
        String[] r = sub.split(" ");
        long[] ret = new long[r.length];
        for (int i = 0; i < r.length ; i++) {
            ret[i] = Long.parseLong(r[i]);
        }
        return ret;
    }

}