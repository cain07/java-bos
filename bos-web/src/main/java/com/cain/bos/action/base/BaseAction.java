package com.cain.bos.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	public static final String HOME = "home";
	public static final String LIST = "list";
	
	protected T model;
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public BaseAction() {
		// TODO Auto-generated constructor stub
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		Class<T> entyClass = (Class<T>) actualTypeArguments[0];
		
		try {
			model = entyClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
