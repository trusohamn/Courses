package alabrudzinska.utp.assignment9;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class PolishPESELTest {

	@Test
	public void testValildation() {
		String pesel = "44051401359";
		try {
			Constructor<?> constructor = PolishPESEL.class.getConstructor(String.class);
			PolishPESEL instance = (PolishPESEL)constructor.newInstance(pesel);
			Method m = PolishPESEL.class.getDeclaredMethod("validation");
			m.getName();
			m.setAccessible(true); 
			boolean test = (boolean) m.invoke(instance);
			Assert.assertTrue(test);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public void testValildation2() {
		String pesel = "44051401357";
		try {
			Constructor<?> constructor = PolishPESEL.class.getConstructor(String.class);
			PolishPESEL instance = (PolishPESEL)constructor.newInstance(pesel);
			Method m = PolishPESEL.class.getDeclaredMethod("validation");
			m.getName();
			m.setAccessible(true); 
			boolean test = (boolean) m.invoke(instance);
			Assert.assertFalse(test);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testExtractDate() {
		String pesel = "44051401359";
		try {
			Constructor<?> constructor = PolishPESEL.class.getConstructor(String.class);
			PolishPESEL instance = (PolishPESEL)constructor.newInstance(pesel);
			Method m = PolishPESEL.class.getDeclaredMethod("extractDate");
			m.getName();
			m.setAccessible(true); 
			Date d = (Date) m.invoke(instance);
			System.out.println(d);	
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testExtractSex() {
		String pesel = "44051401359";
		try {
			Constructor<?> constructor = PolishPESEL.class.getConstructor(String.class);
			PolishPESEL instance = (PolishPESEL)constructor.newInstance(pesel);
			Method m = PolishPESEL.class.getDeclaredMethod("extractSex");
			m.getName();
			m.setAccessible(true); 
			Sex s =  (Sex) m.invoke(instance);
			System.out.println(s);	
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
