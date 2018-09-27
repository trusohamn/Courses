package utp.alabrudzinska;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class UtilityJar { 

	static List<JarEntry> find(JarFile directory, String name) {
		/*Finds files in given directory which name contains the string name
		Sequential*/
		if(directory!=null) {
			return directory.
					stream().
					filter(e -> e.getName().toString().contains(name)).
					collect(toList());	
		}
		else return new ArrayList<>();
	}

	static List<JarEntry> findParallel(JarFile directory, String name) {
		/*Finds files in given directory which name contains the string name
		Parallel*/
		if(directory!=null) {
			return directory.
					stream().parallel().
					filter(e -> e.getName().toString().contains(name)).
					collect(toList());
		}
		else return new ArrayList<>();
	}

	static List<JarEntry> findInContent(JarFile directory, String phrase) {
		if(directory!=null) {return directory.stream().
				filter(e -> !e.isDirectory()).
				filter(e -> {
					try {		
						InputStream is = directory.getInputStream(e);
						BufferedReader br = new BufferedReader(new InputStreamReader(is));
						return br.lines().
								filter(l -> l.contains(phrase)).
								findFirst().
								isPresent();					
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					return false;		        
				}).collect(toList());
		}
		else return new ArrayList<>();
	}

	static List<JarEntry> findInContentParallel(JarFile directory, String phrase) {
		if(directory!=null) {
			return directory.stream().parallel().
					filter(e -> !e.isDirectory()).
					filter(e -> {
						try {		
							InputStream is = directory.getInputStream(e);
							BufferedReader br = new BufferedReader(new InputStreamReader(is));
							return br.lines().
									filter(l -> l.contains(phrase)).
									findFirst().
									isPresent();					
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						return false;		        
					}).collect(toList());
		}
		else return new ArrayList<>();
	}


}
