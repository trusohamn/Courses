package utp.alabrudzinska;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.junit.Before;
import org.junit.Test;

public class UtilityZipTest {
	String zipDir = "data2.zip";
	ZipFile f = null;
	
	@Before
	public void before() {
		try {
			f = new ZipFile(zipDir);
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	@Test
	public void testFind() {

		System.out.println("---->filename sequential");
		List<ZipEntry> files = UtilityZip.find(f, "a");
		files.forEach(System.out::println);

	}

	@Test
	public void testFindParallel() {
		System.out.println("---->filename in parallel");
		List<ZipEntry> files = UtilityZip.findParallel(f, "a");
		files.forEach(System.out::println);

	}

	@Test
	public void testFindInContent() {
		System.out.println("---->In content");
		List<ZipEntry> files = UtilityZip.findInContent(f, "kiwi");
		files.forEach(System.out::println);
	}

	@Test
	public void testFindInContentParallel() {
		System.out.println("---->In content parallel");
		List<ZipEntry> files = UtilityZip.findInContentParallel(f, "kiwi");
		files.forEach(System.out::println);
	}

}
