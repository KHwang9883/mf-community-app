package com.kidozh.discuzhub.DataFactory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.kidozh.discuzhub.DataSource.FavoriteThreadDataSource;
import com.kidozh.discuzhub.entities.Discuz;
import com.kidozh.discuzhub.entities.User;
import com.kidozh.discuzhub.utilities.ConstUtils;

public class FavoriteThreadDataFactory extends DataSource.Factory {

    Context context;
    Discuz bbsInfo;
    User userBriefInfo;
    private MutableLiveData<FavoriteThreadDataSource> favoriteThreadDataSourceMutableLiveData;
    public FavoriteThreadDataSource favoriteThreadDataSource;
    public MutableLiveData<Integer> networkStateLiveData = new MutableLiveData<>(ConstUtils.NETWORK_STATUS_SUCCESSFULLY);

    public FavoriteThreadDataFactory(@NonNull Context context, @NonNull Discuz bbsInfo, User userBriefInfo) {
        this.context = context;
        this.bbsInfo = bbsInfo;
        this.userBriefInfo = userBriefInfo;
    }

    @NonNull
    @Override
    public DataSource create() {
        favoriteThreadDataSource = new FavoriteThreadDataSource(context,bbsInfo,userBriefInfo);
        favoriteThreadDataSourceMutableLiveData.postValue(favoriteThreadDataSource);
        return favoriteThreadDataSource;
    }

    public MutableLiveData<FavoriteThreadDataSource> getFavoriteThreadDataSourceMutableLiveData() {
        return favoriteThreadDataSourceMutableLiveData;
    }

    public void invalidate(){
        if(favoriteThreadDataSource !=null){
            favoriteThreadDataSource.invalidate();
        }
    }
}
