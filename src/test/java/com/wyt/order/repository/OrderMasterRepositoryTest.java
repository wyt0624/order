package com.wyt.order.repository;

import com.wyt.order.OrderApplication;
import com.wyt.order.dataobject.OrderMaster;
import com.wyt.order.enums.OrderStatusEnum;
import com.wyt.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest{

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void saveOrderMaster(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123");
        orderMaster.setBuyerName("wuyutong");
        orderMaster.setBuyerAddress("北京市海淀区");
        orderMaster.setBuyerOpenid("123111111");
        orderMaster.setBuyerPhone("15545527776");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(new BigDecimal(3.1));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}