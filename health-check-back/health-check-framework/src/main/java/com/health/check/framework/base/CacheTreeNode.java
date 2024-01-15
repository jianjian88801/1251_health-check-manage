package com.health.check.framework.base;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Set;

/**
 * 缓存键树型结构
 *
 * @author xiao.xl 2022/4/26 22:05
 */
@Data
public class CacheTreeNode {
    
    private String key;
    
    private String value;
    
    private Boolean leaf;
    
    private String parentKey;
    
    private Set<CacheTreeNode> children;

    public CacheTreeNode(String key) {
        this.key = key;
    }
    
    public void addChild(CacheTreeNode node){
        if(getChildren() == null){
            setChildren(Sets.newHashSet());
        }
        getChildren().add(node);
    }
    
}