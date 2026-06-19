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

import com.entity.ErjiguanliyuanEntity;
import com.entity.view.ErjiguanliyuanView;

import com.service.ErjiguanliyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 二级管理员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 21:56:25
 */
@RestController
@RequestMapping("/erjiguanliyuan")
public class ErjiguanliyuanController {
    @Autowired
    private ErjiguanliyuanService erjiguanliyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ErjiguanliyuanEntity u = erjiguanliyuanService.selectOne(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"erjiguanliyuan",  "二级管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ErjiguanliyuanEntity erjiguanliyuan){
    	//ValidatorUtils.validateEntity(erjiguanliyuan);
    	ErjiguanliyuanEntity u = erjiguanliyuanService.selectOne(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", erjiguanliyuan.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		erjiguanliyuan.setId(uId);
        erjiguanliyuanService.insert(erjiguanliyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ErjiguanliyuanEntity u = erjiguanliyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ErjiguanliyuanEntity u = erjiguanliyuanService.selectOne(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        erjiguanliyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ErjiguanliyuanEntity erjiguanliyuan,
		HttpServletRequest request){
        EntityWrapper<ErjiguanliyuanEntity> ew = new EntityWrapper<ErjiguanliyuanEntity>();

		PageUtils page = erjiguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, erjiguanliyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ErjiguanliyuanEntity erjiguanliyuan, 
		HttpServletRequest request){
        EntityWrapper<ErjiguanliyuanEntity> ew = new EntityWrapper<ErjiguanliyuanEntity>();

		PageUtils page = erjiguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, erjiguanliyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ErjiguanliyuanEntity erjiguanliyuan){
       	EntityWrapper<ErjiguanliyuanEntity> ew = new EntityWrapper<ErjiguanliyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( erjiguanliyuan, "erjiguanliyuan")); 
        return R.ok().put("data", erjiguanliyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ErjiguanliyuanEntity erjiguanliyuan){
        EntityWrapper< ErjiguanliyuanEntity> ew = new EntityWrapper< ErjiguanliyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( erjiguanliyuan, "erjiguanliyuan")); 
		ErjiguanliyuanView erjiguanliyuanView =  erjiguanliyuanService.selectView(ew);
		return R.ok("查询二级管理员成功").put("data", erjiguanliyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ErjiguanliyuanEntity erjiguanliyuan = erjiguanliyuanService.selectById(id);
        return R.ok().put("data", erjiguanliyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ErjiguanliyuanEntity erjiguanliyuan = erjiguanliyuanService.selectById(id);
        return R.ok().put("data", erjiguanliyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ErjiguanliyuanEntity erjiguanliyuan, HttpServletRequest request){
        if(erjiguanliyuanService.selectCount(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", erjiguanliyuan.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
    	erjiguanliyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(erjiguanliyuan);
    	ErjiguanliyuanEntity u = erjiguanliyuanService.selectOne(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", erjiguanliyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		erjiguanliyuan.setId(new Date().getTime());
        erjiguanliyuanService.insert(erjiguanliyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ErjiguanliyuanEntity erjiguanliyuan, HttpServletRequest request){
        if(erjiguanliyuanService.selectCount(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", erjiguanliyuan.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
    	erjiguanliyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(erjiguanliyuan);
    	ErjiguanliyuanEntity u = erjiguanliyuanService.selectOne(new EntityWrapper<ErjiguanliyuanEntity>().eq("zhanghao", erjiguanliyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		erjiguanliyuan.setId(new Date().getTime());
        erjiguanliyuanService.insert(erjiguanliyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ErjiguanliyuanEntity erjiguanliyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(erjiguanliyuan);
        if(erjiguanliyuanService.selectCount(new EntityWrapper<ErjiguanliyuanEntity>().ne("id", erjiguanliyuan.getId()).eq("zhanghao", erjiguanliyuan.getZhanghao()))>0) {
            return R.error("账号已存在");
        }
        erjiguanliyuanService.updateById(erjiguanliyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        erjiguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
