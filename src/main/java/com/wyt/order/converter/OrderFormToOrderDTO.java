package com.wyt.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wyt.order.dataobject.OrderDetail;
import com.wyt.order.dto.OrderDTO;
import com.wyt.order.enums.ResultEnum;
import com.wyt.order.exception.OrderException;
import com.wyt.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFormToOrderDTO {

    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems()
                    ,new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e){
            e.printStackTrace();
            log.error("Json转换出错", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
