//Created by MyEclipse Struts
//XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.nit.vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/** 
* MyEclipse Struts
* Creation date: 01-17-2007
* 
* XDoclet definition:
* @struts:action path="/delete" name="StudentDetailsForm" scope="request" validate="true"
* @struts:action-forward name="success" path="/DeleteRecord.jsp"
* @struts:action-forward name="fail" path="/TryAgain.jsp"
*/
public class DeleteBranchAction extends Action {

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
		HttpServletResponse response)throws Exception {
		
		BranchBeanForm fb =(BranchBeanForm)form;
		Connection con=null;
		PreparedStatement ps=null;
		Statement st=null;
		ResultSet rs=null;
		int i=0;
		int j=0;
					try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@server:1521:server","scott","tiger");
				System.out.println("........connection established.......");
				j=fb.getBid();
				System.out.println("entered branch id="+j);
					st=con.createStatement();
					i=st.executeUpdate("delete from btable where bid="+j);
					System.out.println("no.of records deleted:"+i);
					if(i!=0)
					{
						return mapping.findForward("success");}
					else
					{
						return mapping.findForward("fail");}
				}
					finally{
				try{
					st.close();
					con.close();
					}catch(Exception e){}
				}
	}
}

