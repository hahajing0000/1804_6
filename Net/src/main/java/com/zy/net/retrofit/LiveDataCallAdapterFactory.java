package com.zy.net.retrofit;

import com.zy.net.protocol.resp.BaseRespEntity;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import androidx.lifecycle.LiveData;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {

    public static LiveDataCallAdapterFactory create(){
        return new LiveDataCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType = getRawType(returnType);
        if (rawType != LiveData.class){
            return null;
        }
        Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class<?> rawObservableType = getRawType(observableType);
        if (rawObservableType!= BaseRespEntity.class){
            throw new IllegalArgumentException("args type is wrong...");
        }
        return new LiveDataCallAdapter<>(observableType);
    }
}
