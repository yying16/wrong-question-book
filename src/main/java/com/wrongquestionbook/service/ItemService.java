package com.wrongquestionbook.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wrongquestionbook.domain.Item;
import com.wrongquestionbook.domain.User;
import com.wrongquestionbook.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 */
@Service
public class ItemService {
    /**
     * 
     */
    @Resource
    public ItemMapper itemMapper;

    /**
     * 获取所有！未删除！的练习
     * @return
     */
    public IPage<Item> getAllItem() {
        // TODO implement here
        return null;
    }

    /**
     * 条件查找练习，分类内容为空则不进行分类筛选
     * @param category 
     * @param promulgator 
     * @param content 
     * @return
     */
    public IPage<Item> searchItem(String category, String promulgator, String content) {
        // TODO implement here
        return null;
    }

    /**
     * 获取练习详情
     * @param itemId 
     * @return
     */
    public Item getItem(Long itemId) {
        // TODO implement here
        return null;
    }

    /**
     * @param item 
     * @param user 
     * @return
     */
    public boolean addItem(Item item, User user) {
        // TODO implement here
        return false;
    }

    /**
     * 生成item的路劲
     * @param item 
     * @return
     */
    public String generatePath(Item item) {
        // TODO implement here
        return "";
    }

}