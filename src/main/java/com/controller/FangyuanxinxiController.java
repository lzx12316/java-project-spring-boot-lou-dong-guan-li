package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FangyuanxinxiEntity;
import com.entity.view.FangyuanxinxiView;

import com.service.FangyuanxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 房源信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
@RestController
@RequestMapping("/fangyuanxinxi")
public class FangyuanxinxiController {
    @Autowired
    private FangyuanxinxiService fangyuanxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyuanxinxiEntity fangyuanxinxi,
                @RequestParam(required = false) Double yuezustart,
                @RequestParam(required = false) Double yuezuend,
		HttpServletRequest request){
        EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();
                if(yuezustart!=null) ew.ge("yuezu", yuezustart);
                if(yuezuend!=null) ew.le("yuezu", yuezuend);

		PageUtils page = fangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyuanxinxiEntity fangyuanxinxi, 
                @RequestParam(required = false) Double yuezustart,
                @RequestParam(required = false) Double yuezuend,
		HttpServletRequest request){
        EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();
                if(yuezustart!=null) ew.ge("yuezu", yuezustart);
                if(yuezuend!=null) ew.le("yuezu", yuezuend);

		PageUtils page = fangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyuanxinxiEntity fangyuanxinxi){
       	EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyuanxinxi, "fangyuanxinxi")); 
        return R.ok().put("data", fangyuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyuanxinxiEntity fangyuanxinxi){
        EntityWrapper< FangyuanxinxiEntity> ew = new EntityWrapper< FangyuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyuanxinxi, "fangyuanxinxi")); 
		FangyuanxinxiView fangyuanxinxiView =  fangyuanxinxiService.selectView(ew);
		return R.ok("查询房源信息成功").put("data", fangyuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyuanxinxiEntity fangyuanxinxi = fangyuanxinxiService.selectById(id);
		fangyuanxinxi.setClicknum(fangyuanxinxi.getClicknum()+1);
		fangyuanxinxi.setClicktime(new Date());
		fangyuanxinxiService.updateById(fangyuanxinxi);
        fangyuanxinxi = fangyuanxinxiService.selectView(new EntityWrapper<FangyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangyuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyuanxinxiEntity fangyuanxinxi = fangyuanxinxiService.selectById(id);
		fangyuanxinxi.setClicknum(fangyuanxinxi.getClicknum()+1);
		fangyuanxinxi.setClicktime(new Date());
		fangyuanxinxiService.updateById(fangyuanxinxi);
        fangyuanxinxi = fangyuanxinxiService.selectView(new EntityWrapper<FangyuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangyuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangyuanxinxi);
        fangyuanxinxiService.insert(fangyuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangyuanxinxi);
        fangyuanxinxiService.insert(fangyuanxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyuanxinxi);
        fangyuanxinxiService.updateById(fangyuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FangyuanxinxiEntity fangyuanxinxi, HttpServletRequest request,String pre){
        EntityWrapper<FangyuanxinxiEntity> ew = new EntityWrapper<FangyuanxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = fangyuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanxinxi), params), params));
        return R.ok().put("data", page);
    }










}
