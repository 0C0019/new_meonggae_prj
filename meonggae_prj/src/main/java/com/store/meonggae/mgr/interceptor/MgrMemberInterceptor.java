package com.store.meonggae.mgr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.store.meonggae.mgr.login.domain.MgrDomain;

public class MgrMemberInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object mgrObj = WebUtils.getSessionAttribute(request, "mgr");
		MgrDomain mgrDomain = null;
		boolean flag = false;
		
		if(mgrObj != null) {
			mgrDomain = (MgrDomain)mgrObj;
			flag = mgrDomain.getPermission().equals("10") || mgrDomain.getPermission().equals("11");
		} // end if
		
		if(!flag) {	 // 관리자 권한이 충분하지 않으면 대시보드로 이동
			response.sendRedirect("http://localhost/meonggae_prj/mgr/dashboard/mgr_dashboard_frm.do");
		} // end if
		
		return flag;
	} // preHandle
} // class