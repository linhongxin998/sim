package test;

import org.junit.Test;

import com.gyq.sim.entity.common.BaseUser;

public class simTest {

	@Test
	public void UUidTest(){
		BaseUser user = new BaseUser();
		System.out.println("the uuid of user is----"+user.getUUid());
	}

}
