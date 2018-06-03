package com.shop.domain.product;

import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 部门
* @gitHub:https://github.com/lzdn
*/
public class Product extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Product(){
	
	}
	/**
    *注释：
    */
	private Integer productId;
	/**
    *注释：
    */
	private byte[] content;
	/**
    *注释：
    */
	private byte[] description;

    public Integer getProductId() {
        return this.productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
	public byte[] getContent() {
        return this.content;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }
	public byte[] getDescription() {
        return this.description;
    }
    public void setDescription(byte[] description) {
        this.description = description;
    }
}