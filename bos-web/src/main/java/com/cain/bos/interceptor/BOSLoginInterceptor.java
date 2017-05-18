package com.cain.bos.interceptor;

import com.cain.bos.domain.User;
import com.cain.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BOSLoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		ActionProxy proxy = invocation.getProxy();
		String namespace = proxy.getNamespace();
		String actionName = proxy.getActionName();
		
		System.out.println(namespace+actionName);
		
		User loginUser = BOSUtils.getLoginUser();
		if(loginUser  == null){
			return "login";
		}
		return invocation.invoke();
	}

}
