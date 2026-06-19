package com.dao;

import com.entity.ErjiguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErjiguanliyuanVO;
import com.entity.view.ErjiguanliyuanView;


/**
 * 二级管理员
 * 
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
public interface ErjiguanliyuanDao extends BaseMapper<ErjiguanliyuanEntity> {
	
	List<ErjiguanliyuanVO> selectListVO(@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);
	
	ErjiguanliyuanVO selectVO(@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);
	
	List<ErjiguanliyuanView> selectListView(@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);

	List<ErjiguanliyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);

	
	ErjiguanliyuanView selectView(@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);
	

}
