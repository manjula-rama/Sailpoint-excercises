package com.sailpoint;

import java.util.List;

import sailpoint.api.SailPointContext;
import sailpoint.connector.ConnectorException;
import sailpoint.object.Identity;

public class EntitlementsEx {

	public static void main(String[] args) throws ConnectorException {
		/*
		 * // TODO Auto-generated method stub Result result = new Result(); Schema
		 * schema = new Schema(); Map map =
		 * JDBCConnector.buildMapFromResultSet((ResultSet) result); if
		 * (schema.getObjectType().compareTo(Connector.TYPE_ACCOUNT) == 0) { String
		 * lname = (String) map.get("LNAME"); String loc = (String) map.get("LOCATION");
		 * String str = lname + loc; map.put("LNAME", str);
		 * 
		 * } Identity i = new Identity
		 */

		SailPointContext context = null;

		List i1 = context.getObjects(Identity.class);
		Identity i = new Identity();
		i.setName("OjasWorkgroupdemo");
		i.setWorkgroup(true);
		context.saveObject(i);
		context.commitTransaction();

		for (Identity id : i1) {
			if (id.equals(context.getObject(Identity.class, "Peter.Powell"))
					|| id.equals(context.getObject(Identity.class, "Richard.Jackson"))
					|| id.equals(context.getObject(Identity.class, "Bruce.Henry"))) {
				id.add(context.getObject(Identity.class, "OjasWorkgroupdemo"));
				context.saveObject(id);
				context.commitTransaction();
			}

		}

	}
}
