package org.pangolin.eeip.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.pangolin.util.UUIDHexGenerator;

public class ServiceTicket implements Serializable {
	
	private static final long serialVersionUID = -878777617828361807L;
	
	private static Map<String, String> stMap = new HashMap<String, String>();
	
	public static boolean containsTicket(String key) {
		return stMap.containsKey(key);
	}
	
	public static String get(String key) {
		if ( stMap.containsKey(key) ) {
			return stMap.get(key);
		}
		return "";
	}
	
	public static boolean push(String key, String value) {
		if ( key != null && value != null 
				&& !key.trim().equals("") && !value.trim().equals("") ) {
			if ( !stMap.containsKey(key) ) {
				stMap.put(key, value);
				return stMap.containsKey(key);
			}
		}
		return false;
	}
	
	public static List<String> getTickets() {
		List<String> keys = new ArrayList<String>();
		Set<String> keySet = stMap.keySet();
		for ( String key : keySet ) keys.add(key);
		return keys;
	}
	
	public static boolean remove(String key) {
		stMap.remove(key);
		if ( !stMap.containsKey(key) ) return true;
		return false;
	}
	
	public static String generateTicket() {
		return UUIDHexGenerator.getInstance().generate();
	}
}