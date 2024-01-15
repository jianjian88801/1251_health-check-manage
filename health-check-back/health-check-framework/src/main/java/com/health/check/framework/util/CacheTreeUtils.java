package com.health.check.framework.util;

import com.google.common.collect.Sets;
import com.health.check.framework.base.CacheTreeNode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 缓存树形工具类
 *
 * @author xiao.xl 2021/10/19 14:25
 */
@Component
public class CacheTreeUtils {

    /**
     * 缓存键树构造方法
     *
     * @param cacheTreeNodes 缓存键树型结构参数
     * @return 缓存键树型结构Set
     * @author xiao.xl 2021/10/19 14:25
     */
    public Set<CacheTreeNode> buildTree(List<CacheTreeNode> cacheTreeNodes) {
        Set<CacheTreeNode> treeNodes = Sets.newHashSet();
        for (CacheTreeNode node : cacheTreeNodes) {
            if (node.getParentKey() == null) {
                treeNodes.add(recursionNode(node, cacheTreeNodes));
            }
        }
        return treeNodes;
    }

    private CacheTreeNode recursionNode(CacheTreeNode node, List<CacheTreeNode> treeNodes) {
        for (CacheTreeNode cacheTreeNode : treeNodes) {
            if (StringUtils.equals(cacheTreeNode.getParentKey(), node.getKey())) {
                if (!cacheTreeNode.getLeaf()) {
                    node.addChild(recursionNode(cacheTreeNode, treeNodes));
                } else {
                    node.addChild(cacheTreeNode);
                }
            }
        }
        return node;
    }

}
