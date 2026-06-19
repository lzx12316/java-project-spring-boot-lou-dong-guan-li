package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuizuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuizuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuizuxinxiView;


/**
 * 退租信息
 *
 * @author 
 * @email 
 * @date 2024-03-19 21:56:26
 */
public interface TuizuxinxiService extends IService<TuizuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuizuxinxiVO> selectListVO(Wrapper<TuizuxinxiEntity> wrapper);
   	
   	TuizuxinxiVO selectVO(@Param("ew") Wrapper<TuizuxinxiEntity> wrapper);
   	
   	List<TuizuxinxiView> selectListView(Wrapper<TuizuxinxiEntity> wrapper);
   	
   	TuizuxinxiView selectView(@Param("ew") Wrapper<TuizuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuizuxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<TuizuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<TuizuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<TuizuxinxiEntity> wrapper);



}

