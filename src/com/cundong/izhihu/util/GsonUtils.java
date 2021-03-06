package com.cundong.izhihu.util;

import java.util.ArrayList;

import android.text.TextUtils;

import com.cundong.izhihu.entity.BaseEntity;
import com.cundong.izhihu.entity.NewsListEntity;
import com.cundong.izhihu.entity.NewsListEntity.NewsEntity;
import com.google.gson.Gson;

public class GsonUtils {

	public static ArrayList<NewsEntity> getNewsList(String content) {

		if (TextUtils.isEmpty(content))
			return null;

		Gson gson = new Gson();

		try {
			NewsListEntity newsListEntity = gson.fromJson(content,
					NewsListEntity.class);
			return newsListEntity != null ? newsListEntity.stories : null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 解析一个字符串，得到BaseEntity对象
	 * 
	 * @param content
	 * @param clazz
	 * @return
	 */
	public static BaseEntity getEntity(String content, Class<?> clazz) {

		if (TextUtils.isEmpty(content))
			return null;

		Gson gson = new Gson();
		
		try {
			BaseEntity baseEntity = (BaseEntity) gson.fromJson(content, clazz);
			return baseEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}