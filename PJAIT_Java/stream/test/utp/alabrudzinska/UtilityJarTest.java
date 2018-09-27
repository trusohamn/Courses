package utp.alabrudzinska;

import java.io.IOException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.Before;
import org.junit.Test;

public class UtilityJarTest {
	final String dir = "data43.jar";
	JarFile jarFile;
	@Before
	public void before() {
		try {
			jarFile = new JarFile(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFind() {
		List<JarEntry> files = UtilityJar.find(jarFile, "a");
		files.forEach(System.out::println);
	}

	@Test
	public void testFindParallel() {
		System.out.println("---->filename in parallel");
		List<JarEntry> files = UtilityJar.findParallel(jarFile, "a");
		files.forEach(System.out::println);
	}

	@Test
	public void testFindInContent() {
		System.out.println("---->In content");
		List<JarEntry> files = UtilityJar.findInContent(jarFile, "kiwi");
		files.forEach(System.out::println);
	}

	@Test
	public void testFindInContentParallel() {
		System.out.println("---->In content parallel");
		List<JarEntry> files = UtilityJar.findInContent(jarFile, "kiwi");
		files.forEach(System.out::println);
	}

}
