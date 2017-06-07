package com.cain.bos.action;


import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.cain.bos.action.base.BaseAction;
import com.cain.bos.domain.User;
import com.cain.bos.utils.ResultUtils;

public class TestAction  extends BaseAction<User>{

	
	public String  test1(){
		String str = "[{\"name\":\"aaa\",\"type\":\"5\"},{\"name\":\"bbbb\",\"type\":\"6\"},{\"name\":\"cccc\",\"type\":\"7\"}]";
		 try {
			ResultUtils.toJson(ServletActionContext.getResponse(), str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
}
