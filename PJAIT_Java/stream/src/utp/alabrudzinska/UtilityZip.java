package utp.alabrudzinska;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UtilityZip {
	static List<ZipEntry> find(ZipFile zip, String name) {
		/*Finds files in given zip which name contains the string name
		Sequential*/
		if(zip!=null) {
			return zip.stream().
					filter(e -> e.getName().toString().contains(name)).
					collect(toList());
		}
		else return new ArrayList<>();
	}

	static List<ZipEntry> findParallel(ZipFile zip, String name) {
		/*Finds files in given zip which name contains the string name
		Parallel*/
		if(zip!=null) {
			return zip.stream().parallel().
					filter(e -> e.getName().toString().contains(name)).
					collect(toList());
		}
		else {
			return new ArrayList<>();
		}
	}

	static List<ZipEntry> findInContent(ZipFile zip,  String phrase) {
		if(zip!=null) {
			return zip.stream().
					filter(e -> !e.isDirectory()).
					filter(e ->{
						try {
							InputStream is = zip.getInputStream(e);
							BufferedReader br = new BufferedReader(new InputStreamReader(is));
							return br.lines().
									filter(l -> l.contains(phrase)).
									findFirst().isPresent();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						return false;

					}).
					collect(toList());
		}
		else return new ArrayList<>();
	}

	static List<ZipEntry> findInContentParallel(ZipFile zip,  String phrase) {
		if(zip!=null) {
			return zip.stream().parallel().
					filter(e -> !e.isDirectory()).
					filter(e ->{
						try {
							InputStream is = zip.getInputStream(e);
							BufferedReader br = new BufferedReader(new InputStreamReader(is));
							return br.lines().
									filter(l -> l.contains(phrase)).
									findFirst().isPresent();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						return false;

					}).
					collect(toList());
		}
		else return new ArrayList<>();
	}




}
