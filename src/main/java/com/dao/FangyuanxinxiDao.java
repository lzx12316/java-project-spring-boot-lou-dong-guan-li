package com.dao;

import com.entity.FangyuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuanxinxiVO;
import com.entity.view.FangyuanxinxiView;


/**
 * 房源信息
 * 
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
public interface FangyuanxinxiDao extends BaseMapper<FangyuanxinxiEntity> {
	
	List<FangyuanxinxiVO> selectListVO(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);
	
	FangyuanxinxiVO selectVO(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);
	
	List<FangyuanxinxiView> selectListView(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);

	List<FangyuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);

	
	FangyuanxinxiView selectView(@Param("ew") Wrapper<FangyuanxinxiEntity> wrapper);
	

}
