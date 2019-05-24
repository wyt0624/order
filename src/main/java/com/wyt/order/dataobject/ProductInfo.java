package com.wyt.order.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class ProductInfo {
    //商品ID
    @Id
    private String productId;

    //商品名称
    private String productName;

    //商品价格
    private BigDecimal productPrice;

    //商品库存
    private String productStock;

    //商品描述
    private String productDescription;

    //商品图片
    private String productIcon;

    //商品状态 0：正常 1：下架
    private Integer productStatus;

    //商品类目
    private Integer categoryType;

    //商品创建时间
    private Date createTime;

    //商品更新时间
    private Date updateTime;

}
