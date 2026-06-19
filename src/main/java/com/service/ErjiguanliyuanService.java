package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ErjiguanliyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ErjiguanliyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ErjiguanliyuanView;


/**
 * 二级管理员
 *
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
public interface ErjiguanliyuanService extends IService<ErjiguanliyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ErjiguanliyuanVO> selectListVO(Wrapper<ErjiguanliyuanEntity> wrapper);
   	
   	ErjiguanliyuanVO selectVO(@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);
   	
   	List<ErjiguanliyuanView> selectListView(Wrapper<ErjiguanliyuanEntity> wrapper);
   	
   	ErjiguanliyuanView selectView(@Param("ew") Wrapper<ErjiguanliyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ErjiguanliyuanEntity> wrapper);

   	

}

