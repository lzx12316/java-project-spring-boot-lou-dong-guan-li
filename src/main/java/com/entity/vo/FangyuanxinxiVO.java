package com.entity.vo;

import com.entity.FangyuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房源信息
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
public class FangyuanxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 地址
	 */
	
	private String dizhi;
		
	/**
	 * 房源城市
	 */
	
	private String fangyuanchengshi;
		
	/**
	 * 状态
	 */
	
	private String zhuangtai;
		
	/**
	 * 面积/㎡
	 */
	
	private String mianji;
		
	/**
	 * 月租/元
	 */
	
	private Double yuezu;
		
	/**
	 * 定金/元
	 */
	
	private Double dingjin;
		
	/**
	 * 押金/元
	 */
	
	private Double yajin;
		
	/**
	 * 朝向
	 */
	
	private String chaoxiang;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 房源类型
	 */
	
	private String fangyuanleixing;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 配套详情
	 */
	
	private String peitaoxiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：状态
	 */
	 
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
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
	 * 设置：朝向
	 */
	 
	public void setChaoxiang(String chaoxiang) {
		this.chaoxiang = chaoxiang;
	}
	
	/**
	 * 获取：朝向
	 */
	public String getChaoxiang() {
		return chaoxiang;
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
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：配套详情
	 */
	 
	public void setPeitaoxiangqing(String peitaoxiangqing) {
		this.peitaoxiangqing = peitaoxiangqing;
	}
	
	/**
	 * 获取：配套详情
	 */
	public String getPeitaoxiangqing() {
		return peitaoxiangqing;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
