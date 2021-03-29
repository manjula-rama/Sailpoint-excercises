package com.sailpoint;

import java.util.List;

import sailpoint.api.Provisioner;
import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.object.Link;
import sailpoint.object.ProvisioningPlan;
import sailpoint.spring.SpringStarter;
import sailpoint.tools.GeneralException;

public class DisableIdentity {

	public static void main(String[] args) throws GeneralException {
		// TODO Auto-generated method stub
		SpringStarter starter = new SpringStarter("iiqBeans");//
        starter.start();
        SailPointContext context = SailPointFactory.createContext();

 

        Identity identity = context.getObjectByName(Identity.class, "jason.roy");
        ProvisioningPlan plan = new ProvisioningPlan();
        System.out.println("Identity Name: " + identity.getName());
        if (identity != null) {
            List<Link> links = identity.getLinks();
            
            for (Link link : links) {
                ProvisioningPlan.AccountRequest accountRequest = new sailpoint.object.ProvisioningPlan.AccountRequest();
                plan.setIdentity(identity);
                accountRequest.setApplication(link.getApplicationName());
                accountRequest.setInstance(link.getInstance());                
                accountRequest.setNativeIdentity(link.getNativeIdentity());
                accountRequest.setOperation(sailpoint.object.ProvisioningPlan.AccountRequest.Operation.Enable);
                //accountRequest.setApplication(link.getApplicationName());
                //accountRequest.setTargetIntegration(link.getApplicationName());
                
                System.out.println("In ProvPlan: " + accountRequest.getApplicationName());
                plan.add(accountRequest);
            }

 

            Provisioner prov = new Provisioner(context);
            prov.execute(plan);
            context.saveObject(identity);
            context.commitTransaction();
        }
        

	}

}
