//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.nit.vehicle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 02-21-2007
 * 
 * XDoclet definition:
 * @struts:action path="/gotonewadmin" name="gotonewadminForm" input="/NewAdmin.jsp" scope="request" validate="true"
 * @struts:action-forward name="success" path="/NewAdminsuccess.jsp"
 */
public class NewAdminAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)  throws Exception 
		{
		NewAdminForm nf = (NewAdminForm) form;
		NewAdminDAO ndao=new NewAdminDAO(getDataSource(request));
		String   result=ndao.newadmincreation(nf );
		if(result=="true")
			return mapping.findForward("success");
		return mapping.findForward("fail");
		}
}
