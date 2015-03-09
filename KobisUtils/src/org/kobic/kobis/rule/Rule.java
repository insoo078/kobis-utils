package org.kobic.kobis.rule;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.kobic.kobis.file.excel.obj.XCommonSheetObj;
import org.kobic.kobis.mybatis.dao.RuleDAO;
import org.kobic.kobis.mybatis.db.vo.RuleQueryVO;
import org.kobic.kobis.mybatis.factory.MyBatisConnectionFactory;
import org.kobic.kobis.rule.interpreter.LexicalInterpreter;
import org.kobic.kobis.rule.obj.RuleParamObj;

public class Rule {
	private String insCd;
	private RuleDAO dao;

	public Rule( String insCd ) {
		this.insCd = insCd;

		this.dao = new RuleDAO( MyBatisConnectionFactory.getSqlSessionFactory() );
	}

	public RuleDAO getDAO() {
		return this.dao;
	}

	private RuleParamObj makeParams( XCommonSheetObj obj ) {
		RuleParamObj params = null;

		BeanInfo info;
		try {
			params = new RuleParamObj();
			info = Introspector.getBeanInfo(obj.getClass(), Object.class);
		    PropertyDescriptor[] props = info.getPropertyDescriptors();
		    for (PropertyDescriptor pd : props) {
		        String name = pd.getName();
		        Method getter = pd.getReadMethod();
		        Object value = getter.invoke( obj);
		        params.addParam( name, value );
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			params = null;
		}

		return params;
	}

	public boolean rule( XCommonSheetObj obj ) throws NoSuchMethodException, SecurityException, Exception {
		RuleParamObj ruleObj = this.makeParams( obj );
		List<RuleQueryVO> ruleList = this.dao.getRulesByInsId( this.insCd );
		
		for(Iterator<RuleQueryVO> iter = ruleList.iterator(); iter.hasNext();) {
			LexicalInterpreter.getInstance().interpret( iter.next(), ruleObj );
		}

		System.out.println( ruleObj.getParam("species") );
		return true;
	}
	
	public boolean validate(String statement) {
		return true;
	}
}