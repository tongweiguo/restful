package com.twg.restful.jetty;

import junit.framework.TestCase;

public class DemoServerTest extends TestCase {

	
	public void testStaticPush() throws Exception {
		DemoServer s = new DemoServer();
		
		s.pushStatic();
	}
	
}
