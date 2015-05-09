package com.example.tests;

import com.example.informacion.BaseDatosGlobal;

import junit.framework.TestCase;

public class BaseDatosGlobalTest extends TestCase {

	private BaseDatosGlobal bdGlobal;
	
	public void setUp() throws Exception
	{
		super.setUp();
		bdGlobal = BaseDatosGlobal.getInstance();
	}
	
	public void tearDown() throws Exception
	{
		super.tearDown();
		bdGlobal = null;
	}
	
	public void testInstancia() throws Exception
	{
		assertNotSame(bdGlobal, null);	
	}
}
