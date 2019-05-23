package com.wyt.order.service.impl;

import com.wyt.order.dataobject.OrderMaster;
import com.wyt.order.dto.OrderDTO;
import com.wyt.order.enums.OrderStatusEnum;
import com.wyt.order.enums.PayStatusEnum;
import com.wyt.order.repository.OrderDetailRepository;
import com.wyt.order.repository.OrderMasterRepository;
import com.wyt.order.service.OrderService;
import com.wyt.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO 查询商品信息（调用商品服务）
        //TODO 计算总价
        //TODO 减库存（调用商品服务）

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(20));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderId(KeyUtil.genUniqueKey());
        orderMasterRepository.save(orderMaster);
        return null;
    }
}
