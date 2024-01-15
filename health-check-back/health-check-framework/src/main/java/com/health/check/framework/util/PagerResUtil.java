package com.health.check.framework.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.db.sql.Direction;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.health.check.framework.base.Order;
import com.health.check.framework.base.PagerReq;
import com.health.check.framework.base.PagerRes;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hoda 2022/5/15 1:04 下午
 * @title: PagerResUtil
 * @description:
 */
public class PagerResUtil {


    /**
     * 分页结果对象转换
     *
     * @author xiao.xl 2022/3/9 23:22
     */
    public static <T> Page<T> pagerRes2Page(PagerReq<T> pagerReq) {
        Page<T> page = new Page<>();
        page.setCurrent(pagerReq.getPageNo() != null ? pagerReq.getPageNo() : 1);
        page.setSize(pagerReq.getLimit() > 0 ? pagerReq.getLimit() : 10);
        addSortInfo(page, pagerReq.getOrders());
        return page;
    }

    /**
     * 分页结果对象转换
     *
     * @author xiao.xl 2022/3/9 23:14
     */
    public static <T> PagerRes<T> page2PagerRes(IPage<T> page) {
        PagerRes<T> pagerRes = new PagerRes<>();
        pagerRes.setPageNo((int) page.getCurrent());
        pagerRes.setLimit((int) page.getSize());
        pagerRes.setTotal(page.getTotal());
        pagerRes.setRecords(page.getRecords());
        pagerRes.setTotalPage((int) page.getPages());
        return pagerRes;
    }


    /**
     * 排序处理
     *
     * @author xiao.xl 2022/3/9 22:56
     */
    public static <T> void addSortInfo(Page<T> page, List<Order> orderList) {
        if (CollectionUtil.isNotEmpty(orderList)) {
            List<OrderItem> orderItemList = orderList.stream().distinct().map(item ->
                    new OrderItem(item.getProperty(), Direction.ASC.equals(item.getDirection()))
            ).collect(Collectors.toList());
            page.addOrder(orderItemList);
        }
    }


}
