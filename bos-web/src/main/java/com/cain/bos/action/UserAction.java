package com.cain.bos.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cain.bos.action.base.BaseAction;
import com.cain.bos.domain.User;
import com.cain.bos.service.IUserService;
import com.cain.bos.service.impl.UserService;
import com.cain.bos.utils.BOSUtils;


@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{

	
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService iUserService;
	
	public String login(){
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNotBlank(validatecode) && validatecode.equals(checkcode)){
			User user = iUserService.login(model);
			if(user != null){
				ServletActionContext.getRequest().getSession().setAttribute("loginuser", user);
				return HOME;
			}else{
				this.addActionError("用户名或密码错误");
				return LOGIN;
			}
		}else{
			this.addActionError("验证码错误");
			return LOGIN;
		}
	
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	public String editPassword() throws IOException{
		User loginUser = BOSUtils.getLoginUser();
		String f ="1";
		try{
			iUserService.editPassword(loginUser.getId(),model.getPassword());
		}catch(Exception e){
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
}
