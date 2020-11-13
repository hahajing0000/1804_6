package com.zy.mvvm.model.api;

import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.net.protocol.resp.BaseRespEntity;

import androidx.lifecycle.LiveData;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public interface UserCenterApi {
    @POST("api/User/register")
    LiveData<BaseRespEntity<UserEntity>> register(@Body UserEntity userEntity);
}
