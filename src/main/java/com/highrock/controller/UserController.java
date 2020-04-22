package com.highrock.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.highrock.dto.UserDTO;
import com.highrock.model.User;
import com.highrock.util.BaseJsonRst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author 张进文
 * @ClassName UserController
 * @Description TODO
 * @Date 2018/11/28 10:40
 * @Version 1.0
 */
@RestController
@Api(value="UserController用户相关的API")
@Slf4j
@CrossOrigin
public class UserController {



    /**
     * @description: 根据id查询用户
     * @author: 张进文
     * @param: [id]
     * @return: com.highrock.util.BaseJsonRst
     * @date: 2018/11/28 11:18
     * @version: 1.0
     */
    @ApiOperation(value ="获取用户详细信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/user/{id}")
    public BaseJsonRst getUserById(@PathVariable Integer id){
        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(true);
        ret.setMessage("succffess");
        User user=new User(id,"zjw",444,"132456",new Date());
        ret.setResult(user);
        return ret;
    }

    /** *
     * @description: 保存用户
     * @author: 张进文
     * @param: []
     * @return: com.highrock.util.BaseJsonRst
     * @date: 2018/11/28 14:08
     * @version: 1.0
     */
    @ApiOperation(value = "保存用户信息")
    @PostMapping("/user")
    public BaseJsonRst saveUser(@RequestBody UserDTO userDTO){
        System.out.println(JSON.toJSON(userDTO));

        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(true);
        ret.setMessage("success");

        return ret;
    }


    @ApiOperation(value = "通过id删除用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/user/{id}")
    public BaseJsonRst deleteUserById(@PathVariable Integer id){

        return null;
    }

    /** *
     * @description: TODO
     * @author: 张进文
     * @param: []
     * @return: com.highrock.util.BaseJsonRst
     * @date: 2018/11/29 14:41
     * @version: 1.0
     */
    @ApiOperation(value = "通过id更新用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer",paramType = "path")
    @PutMapping("/user/{id}")
    public BaseJsonRst updateUserById(@PathVariable Integer id){

        log.info("==========="+id);
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("aaaaaaaaaaaaa");

            }
        }).start();

        ThreadFactory namedThreadFactory=new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool=new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(1024),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        singleThreadPool.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        singleThreadPool.shutdown();
        System.out.println("5555");
//        new ThreadplPoolExe


        return null;

    }








}
