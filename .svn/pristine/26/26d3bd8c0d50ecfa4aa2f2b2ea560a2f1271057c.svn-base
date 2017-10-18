package org.pangolin.eeip.dto;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

@SuppressWarnings("all")
public class BaseDto {

	public String outputObjPropertyString(Object obj) {
		StringBuffer sb = new StringBuffer();
		if (null != obj) {
			try {
				this.getPropertyString(obj, sb);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}

	public String getPropertyString(Object entityName, StringBuffer sb) {
		try {
			Class clazz = entityName.getClass();
			Field field[] = clazz.getDeclaredFields();
			Object obj = null;
			Object tempObj = null;
			sb.append("------ " + " begin ------\n");
			for (Field f : field) {
				if ( !f.getName().trim().equals("serialVersionUID") ) {
					sb.append(f.getName());
					sb.append(" : ");
					obj = invokeMethod(entityName, f.getName(), f.getType(), null);
					if (null != obj) {
						if (obj.getClass().isArray()) {
							for (int i = 0; i < Array.getLength(obj); i++) {
								tempObj = Array.get(obj, i);
								if (tempObj.getClass().isPrimitive()) {
									sb.append(tempObj.toString());
								} else if (tempObj instanceof String) {
									sb.append(tempObj.toString());
								} else if (tempObj instanceof Date) {
									sb.append(tempObj.toString());
								} else if (tempObj instanceof Number) {
									sb.append(tempObj.toString());
								} else {
									this.getPropertyString(tempObj, sb);
								}
							}
						}
					}
					sb.append(obj);
					sb.append("\n");
				}
			}
			sb.append("------ " + " end ------\n");
		} catch(Exception ex) { ex.printStackTrace(); }
		return sb.toString();
	}

	public Object invokeMethod(Object owner, String methodName, Class fieldType, Object[] args) {
		try {
			Method method = null;
			Class ownerClass = owner.getClass();
			methodName = methodName.substring(0, 1).toUpperCase() 
					+ methodName.substring(1);
			try {
				if (fieldType == boolean.class) {
					method = ownerClass.getMethod("is" + methodName);
				} else {
					method = ownerClass.getMethod("get" + methodName);
				}
			} catch (SecurityException ex) {
				ex.printStackTrace();
			} catch (NoSuchMethodException ex) {
				ex.printStackTrace();
				return " can't find method '" + methodName + "'";
			}
			return method.invoke(owner);
		} catch(Exception ex) { ex.printStackTrace(); }
		return null;
	}
}