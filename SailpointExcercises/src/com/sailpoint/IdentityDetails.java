package com.sailpoint;
import sailpoint.object.Application;


import sailpoint.object.Bundle;
import sailpoint.object.Capability;
import sailpoint.object.Filter;
import sailpoint.object.GroupDefinition;
import sailpoint.object.Identity;
import sailpoint.object.Link;
import sailpoint.object.ProvisioningPlan;
import sailpoint.object.QueryOptions;
import sailpoint.tools.GeneralException;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sailpoint.api.*;

public class IdentityDetails {

	public static void main(String[] args) throws GeneralException {
		// TODO Auto-generated method stub
		Identity i = new Identity();
//		System.out.println(Filter.eq("Last Name","Jones"));
//		Filter f = Filter.or(Filter.ne("Last Name","Jones"),
//							Filter.eq("Location", "San Jose"),
//							Filter.like("Manager", "Smith"));
//		System.out.println(f);
//		System.out.println(f);
//		Filter f1 = Filter.eq("First Name","Peter");
//		Filter f2 = Filter.eq("Last Name","Jones");
//		Filter res = Filter.ignoreCase(Filter.and(f1,f2));
		SailPointContext context = null;
		Application appName = context.getObjectByName(Application.class,"AuthEmployees App");
		
		
		//Identity i = new Identity();
		Bundle b1 = context.getObjectByName(Bundle.class, "Bussiness role");
		Bundle b2 = context.getObjectByName(Bundle.class, "Xyz business role");
		List<Bundle> l = new ArrayList<Bundle>();
		l.add(b1);
		l.add(b2);
		Identity name = context.getObjectByName(Identity.class,"Rowdy");
		name.setBundles(l);
		
		String identityName ="Uttej";

		ProvisioningPlan plan = new ProvisioningPlan();

		plan.setIdentity(context.getObject(Identity.class, identityName));

		plan.add("IIQ", identityName, "assignedRoles", ProvisioningPlan.Operation.Add, "Bussiness role");

		Provisioner p = new Provisioner(context);

		// if you want to remove the assignment without de-provisioning the entitlements set this

		p.setNoRoleExpansion(true);

		p.execute(plan);
		

		List<Capability> cp = name.getCapabilities();
	Bundle b1 = name.getDetectedRoleByName("Xyz business role");
		name.setAttribute("capabilities",cp);
	name.getBundles()
		//name.add(b);
	String roles = name.getBundles(name);
	Capability cap = context.get
		
		//name.add
		//Map<String,Object> map = name.getExtendedAttributes();
		//return map;
		name.setDisabled(true);
		Provisioner p  = new Provisioner(context);
		p.
		//name.getManager();
		i.setName("Am"+appName.getName());
		i.setDescription("this group is based on authemp"+appName.getName());
		appName.setExtended2(i.getName());
		i.setWorkgroup(true);
		context.saveObject(appName);
		context.commitTransaction();
					System.out.println("group is created succesfully");				
		i.setName("WorkgroupThroughRule");
		i.setWorkgroup(true);
		context.saveObject(i);
		context.commitTransaction();
		
		List<Identity> list = new ArrayList<Identity>();
		Link l = new Link();
		Application link  = l.getApplication();
		String app = l.getApplicationName();
		if(app.equalsIgnoreCase("Actors Application")) {
			Identity id = l.getIdentity();
			list.add(id);
		}
		System.out.println(list);
		
		
		
		QueryOptions qo=new QueryOptions();
        qo.addFilter(Filter.subquery("location",GroupDefinition.class,"name",Filter.ignoreCase(Filter.eq("name","Tokyo"))));
        List<Identity> list1=context.getObjects(Identity.class,qo);
  
  for(Identity id : list1) {
  //String id1 = id.toString();

		ProvisioningPlan plan1 = new ProvisioningPlan();

		plan1.setIdentity(context.getObject(Identity.class, id.getName()));

		plan1.add("IIQ", id.getName(), "assignedRoles", ProvisioningPlan.Operation.Add, "Bussiness role");

		Provisioner p1 = new Provisioner(context);

		// if you want to remove the assignment without de-provisioning the entitlements set this

		p1.setNoRoleExpansion(true);

		p1.execute(plan);
  }
		
		SailPointContext context1 =null;
		String id = context1.getUserName();;
		
		if(id != null) {
			
		}
 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
