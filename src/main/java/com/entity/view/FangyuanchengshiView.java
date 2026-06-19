package com.entity.view;

import com.entity.FangyuanchengshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 房源城市
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
@TableName("fangyuanchengshi")
public class FangyuanchengshiView  extends FangyuanchengshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FangyuanchengshiView(){
	}
 
 	public FangyuanchengshiView(FangyuanchengshiEntity fangyuanchengshiEntity){
 	try {
			BeanUtils.copyProperties(this, fangyuanchengshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
