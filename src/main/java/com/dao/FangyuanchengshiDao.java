package com.dao;

import com.entity.FangyuanchengshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuanchengshiVO;
import com.entity.view.FangyuanchengshiView;


/**
 * 房源城市
 * 
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
public interface FangyuanchengshiDao extends BaseMapper<FangyuanchengshiEntity> {
	
	List<FangyuanchengshiVO> selectListVO(@Param("ew") Wrapper<FangyuanchengshiEntity> wrapper);
	
	FangyuanchengshiVO selectVO(@Param("ew") Wrapper<FangyuanchengshiEntity> wrapper);
	
	List<FangyuanchengshiView> selectListView(@Param("ew") Wrapper<FangyuanchengshiEntity> wrapper);

	List<FangyuanchengshiView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanchengshiEntity> wrapper);

	
	FangyuanchengshiView selectView(@Param("ew") Wrapper<FangyuanchengshiEntity> wrapper);
	

}
