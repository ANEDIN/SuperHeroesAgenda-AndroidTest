package com.example.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.example.informacion.Login;
import com.example.informacion.Usuario;

public class LoginTest extends ActivityInstrumentationTestCase2<Login> {

	/*
	 * 
	 * Este clase de test se usa para realizar tests en la actividad Login
	 * 
	 * Tests de la función validar validarUsuario
	 * 		inicio --> 1 path
	 * 		existen 3 if's (+ 1 else) --> + 3 paths 
	 * 		
	 * 		cada if continene un and --> + 3 paths
	 * 		total paths ==> 7 
	 * 
	 * 		Paths:
	 * 			(1) Test Login (linea 72) retorna true
	 *			(2) Test Login (linea 72) retorna false
	 * 			(3) Test Login (linea 76) retorna true
	 * 			(4) Test Login (linea 76) retorna false
	 * 			(5) Test Login (linea 80) retorna true
	 * 			(6) Test Login (linea 80) retorna false
	 * 			(7) Test Login (linea 84) retorna true
	 * 
	 * 
	 * 
	 * A su vez también se estan realizando tests 
	 * a las funciones getter/setter de la clase Usuario
	 */
	
	private Login login;
	private Usuario usuario;

	public LoginTest() {
		super(Login.class);
		
	}
	
	public LoginTest(Class<Login> activityClass) {
		super(activityClass);
		
	}
	
	 @Override
	 protected void setUp() throws Exception {
		 super.setUp();
		 login = getActivity();
	 }
	
	public void tearDown() throws Exception
	{
		super.tearDown();
		login = null;
	}
	
	public void testUsuarioRellenado() throws Exception
	{
		/*
		 *
		 *  (1) Test Login (linea 72) retorna true
		 * 
		 */
		
		boolean result;

		usuario.setNombre("admin");
		usuario.setContrasenya("12345");
		
		result = login.validarUsuario(usuario);
		
		assertEquals(usuario.getNombre(), "admin");
		assertEquals(usuario.getContrasenya(), "12345");
		assertEquals(result, true);
	}
	
	
	
	public void testNombreUsuarioVacio() throws Exception
	{
		/*
		 *
		 * 	(2) Test Login (linea 72) retorna false
		 * 	(3) Test Login (linea 76) retorna true
		 * 
		 */
		
		boolean result;

		usuario.setNombre("");
		usuario.setContrasenya("1234");
		result = login.validarUsuario(usuario);
		assertEquals(usuario.getNombre(), "");
		assertEquals(usuario.getContrasenya(), "1234");
		assertEquals(result, false);
	}
	
	public void testContrasenyaUsuarioVacia() throws Exception
	{
		/*
		 *
		 *	(2) Test Login (linea 72) retorna false
		 *	(4) Test Login (linea 76) retorna false
		 *	(5) Test Login (linea 80) retorna true
		 * 
		 */
		
		boolean result;
		
		usuario.setNombre("admin");
		usuario.setContrasenya("");
		result = login.validarUsuario(usuario);
		assertEquals(usuario.getNombre(), "admin");
		assertEquals(usuario.getContrasenya(), "");
		assertEquals(result, false);
	}
	
	public void testUsuarioVacio() throws Exception
	{
		/*
		 *
		 * 	(2) Test Login (linea 72) retorna false
		 * 	(4) Test Login (linea 76) retorna false
		 * 	(6) Test Login (linea 80) retorna false
		 * 	(7) Test Login (linea 84) retorna true
		 * 
		 */
		
		boolean result;

		usuario.setNombre("");
		usuario.setContrasenya("");
		result = login.validarUsuario(usuario);
		
		assertEquals(usuario.getNombre(), "");
		assertEquals(usuario.getContrasenya(), "");
		assertEquals(result, false);
	}
}
