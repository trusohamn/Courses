package utp.alabrudzinska;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class UtilityFileDir {

	static List<File> find(File directory, String name) {
		/*Finds files in given directory which name contains the string name
		Sequential*/
		if(directory!=null) {
			try {
				return Files. 
						walk(directory.toPath()).
						filter(e -> e.getFileName().toString().contains(name)).
						map(e -> e.toFile()).
						collect(toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ArrayList<>();}
		else return new ArrayList<>();

	}


	static List<File> findParallel(File directory, String name) {
		/*Finds files in given directory which name contains the string name
		Parallel*/
		if(directory!=null) {
			try {
				return Files.
						walk(directory.toPath()).
						parallel().
						filter(e -> e.getFileName().toString().contains(name)).
						map(e -> e.toFile()).
						collect(toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ArrayList<>();}
		else return new ArrayList<>();

	}

	static List<File> findInContent(File directory, String phrase) {
		if(directory!=null) {

			try {
				return Files.
						walk(directory.toPath()).
						filter(Files::isRegularFile).
						filter(e ->{
							try {
								return Files.lines(e).
										filter(l -> l.contains(phrase)).
										findFirst().isPresent();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							return false;
						}
								).
						map(e -> e.toFile()).
						collect(toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ArrayList<>();}
		else return new ArrayList<>();
	}

	static List<File> findInContentParallel(File directory, String phrase) {
		if(directory!=null) {

			try {
				return Files.
						walk(directory.toPath()).
						parallel().
						filter(Files::isRegularFile).
						filter(e ->{
							try {
								return Files.lines(e).
										filter(l -> l.contains(phrase)).
										findFirst().isPresent();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							return false;
						}
								).
						map(e -> e.toFile()).
						collect(toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ArrayList<>();}
		else return new ArrayList<>();
	}


}
