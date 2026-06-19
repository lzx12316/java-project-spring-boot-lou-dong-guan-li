package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ErjiguanliyuanDao;
import com.entity.ErjiguanliyuanEntity;
import com.service.ErjiguanliyuanService;
import com.entity.vo.ErjiguanliyuanVO;
import com.entity.view.ErjiguanliyuanView;

@Service("erjiguanliyuanService")
public class ErjiguanliyuanServiceImpl extends ServiceImpl<ErjiguanliyuanDao, ErjiguanliyuanEntity> implements ErjiguanliyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErjiguanliyuanEntity> page = this.selectPage(
                new Query<ErjiguanliyuanEntity>(params).getPage(),
                new EntityWrapper<ErjiguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ErjiguanliyuanEntity> wrapper) {
		  Page<ErjiguanliyuanView> page =new Query<ErjiguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ErjiguanliyuanVO> selectListVO(Wrapper<ErjiguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ErjiguanliyuanVO selectVO(Wrapper<ErjiguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ErjiguanliyuanView> selectListView(Wrapper<ErjiguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ErjiguanliyuanView selectView(Wrapper<ErjiguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
