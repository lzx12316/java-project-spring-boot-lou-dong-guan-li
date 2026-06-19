package com.dao;

import com.entity.ZuhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuhuVO;
import com.entity.view.ZuhuView;


/**
 * 租户
 * 
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
public interface ZuhuDao extends BaseMapper<ZuhuEntity> {
	
	List<ZuhuVO> selectListVO(@Param("ew") Wrapper<ZuhuEntity> wrapper);
	
	ZuhuVO selectVO(@Param("ew") Wrapper<ZuhuEntity> wrapper);
	
	List<ZuhuView> selectListView(@Param("ew") Wrapper<ZuhuEntity> wrapper);

	List<ZuhuView> selectListView(Pagination page,@Param("ew") Wrapper<ZuhuEntity> wrapper);

	
	ZuhuView selectView(@Param("ew") Wrapper<ZuhuEntity> wrapper);
	

}
