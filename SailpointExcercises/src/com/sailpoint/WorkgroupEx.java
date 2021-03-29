package com.sailpoint;



import java.util.ArrayList;
import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.object.*;
import sailpoint.tools.GeneralException;

public class WorkgroupEx {

	public static void main(String[] args) throws GeneralException {
		// TODO Auto-generated method stub
		//GroupFactory gf = new GroupFactory();
		SailPointContext context = null;
		Identity i = new Identity();
		i.setName("rama");
		i.setWorkgroup(true);
		context.saveObject(i);
		context.commitTransaction();
		 
		List i1 = context.getObjects(Identity.class);
		for(Identity id : i1) {
			id.add(context.getObject(Identity.class, "rama"));
			context.saveObject(id);
			context.commitTransaction();
		}
		GroupFactory f = context.getObject(null, null)
		GroupDefinition gd = new GroupDefinition();
		gd.setName("second population");
		gd.setFactory(f);
		context.saveObject(gd);
		context.commitTransaction();
		
		Identity obj = new Identity();
		List list = new ArrayList();
		list.add("maruthi");
		list.add("rajesh");
		list.add("stephen");
		list.add("ram");
		
	}
	
}
