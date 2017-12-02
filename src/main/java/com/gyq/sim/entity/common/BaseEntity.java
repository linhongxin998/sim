package com.gyq.sim.entity.common;

import java.util.UUID;

public class BaseEntity {
	public String getUUid(){
		String tempUUid = UUID.randomUUID().toString();
		return tempUUid.replaceAll("-", "");
	}
}
