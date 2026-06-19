package com.entity.view;

import com.entity.TuizuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 退租信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 21:56:26
 */
@TableName("tuizuxinxi")
public class TuizuxinxiView  extends TuizuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TuizuxinxiView(){
	}
 
 	public TuizuxinxiView(TuizuxinxiEntity tuizuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tuizuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
