package utp.alabrudzinska;

import java.io.File;
import java.util.List;

import org.junit.Before;
//import org.junit.Assert;
import org.junit.Test;

public class UtilityFileDirTest {
	final String dir = "data";
	File f;
	@Before
	public void before() {
		f = new File(dir);
	}
	
	@Test
	public void testFind() {
		System.out.println("---->filename sequential");		
		List<File> files = UtilityFileDir.find(f, "a");
		files.forEach(System.out::println);
	}
	
	@Test
	public void testFindParallel() {
		System.out.println("---->filename in parallel");
		List<File> files = UtilityFileDir.findParallel(f, "a");
		files.forEach(System.out::println);
	}

	@Test
	public void testFindInContent() {
		System.out.println("---->In content");
		List<File> files = UtilityFileDir.findInContent(f, "kiwi");
		files.forEach(System.out::println);

	}
	
	@Test
	public void testFindInContentParallel() {
		System.out.println("---->In content parallel");
		List<File> files = UtilityFileDir.findInContentParallel(f, "kiwi");
		files.forEach(System.out::println);

	}

}
