package com.entity.vo;

import com.entity.ZulinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 租赁信息
 * @author 
 * @email 
 * @date 2024-03-19 21:56:26
 */
public class ZulinxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 地址
	 */
	
	private String dizhi;
		
	/**
	 * 房源类型
	 */
	
	private String fangyuanleixing;
		
	/**
	 * 房源城市
	 */
	
	private String fangyuanchengshi;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 面积/㎡
	 */
	
	private String mianji;
		
	/**
	 * 月租/元
	 */
	
	private Double yuezu;
		
	/**
	 * 押金/元
	 */
	
	private Double yajin;
		
	/**
	 * 定金/元
	 */
	
	private Double dingjin;
		
	/**
	 * 总金额/元
	 */
	
	private Double zongjine;
		
	/**
	 * 租户账号
	 */
	
	private String zuhuzhanghao;
		
	/**
	 * 租户姓名
	 */
	
	private String zuhuxingming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 签订时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date qiandingshijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：房源类型
	 */
	 
	public void setFangyuanleixing(String fangyuanleixing) {
		this.fangyuanleixing = fangyuanleixing;
	}
	
	/**
	 * 获取：房源类型
	 */
	public String getFangyuanleixing() {
		return fangyuanleixing;
	}
				
	
	/**
	 * 设置：房源城市
	 */
	 
	public void setFangyuanchengshi(String fangyuanchengshi) {
		this.fangyuanchengshi = fangyuanchengshi;
	}
	
	/**
	 * 获取：房源城市
	 */
	public String getFangyuanchengshi() {
		return fangyuanchengshi;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：面积/㎡
	 */
	 
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	
	/**
	 * 获取：面积/㎡
	 */
	public String getMianji() {
		return mianji;
	}
				
	
	/**
	 * 设置：月租/元
	 */
	 
	public void setYuezu(Double yuezu) {
		this.yuezu = yuezu;
	}
	
	/**
	 * 获取：月租/元
	 */
	public Double getYuezu() {
		return yuezu;
	}
				
	
	/**
	 * 设置：押金/元
	 */
	 
	public void setYajin(Double yajin) {
		this.yajin = yajin;
	}
	
	/**
	 * 获取：押金/元
	 */
	public Double getYajin() {
		return yajin;
	}
				
	
	/**
	 * 设置：定金/元
	 */
	 
	public void setDingjin(Double dingjin) {
		this.dingjin = dingjin;
	}
	
	/**
	 * 获取：定金/元
	 */
	public Double getDingjin() {
		return dingjin;
	}
				
	
	/**
	 * 设置：总金额/元
	 */
	 
	public void setZongjine(Double zongjine) {
		this.zongjine = zongjine;
	}
	
	/**
	 * 获取：总金额/元
	 */
	public Double getZongjine() {
		return zongjine;
	}
				
	
	/**
	 * 设置：租户账号
	 */
	 
	public void setZuhuzhanghao(String zuhuzhanghao) {
		this.zuhuzhanghao = zuhuzhanghao;
	}
	
	/**
	 * 获取：租户账号
	 */
	public String getZuhuzhanghao() {
		return zuhuzhanghao;
	}
				
	
	/**
	 * 设置：租户姓名
	 */
	 
	public void setZuhuxingming(String zuhuxingming) {
		this.zuhuxingming = zuhuxingming;
	}
	
	/**
	 * 获取：租户姓名
	 */
	public String getZuhuxingming() {
		return zuhuxingming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：签订时间
	 */
	 
	public void setQiandingshijian(Date qiandingshijian) {
		this.qiandingshijian = qiandingshijian;
	}
	
	/**
	 * 获取：签订时间
	 */
	public Date getQiandingshijian() {
		return qiandingshijian;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
