package tomek.java.itjp.concurrent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

public class SetExample {

	static class MySet {

		//private final static Set<SetElement> set = Collections.synchronizedSet(new HashSet<SetElement>());
		private final static Set<SetElement> set = new HashSet<SetElement>();

		public void add(SetElement setElement) {
			log.trace(setElement + " " + set.add(setElement));
		}

		public String toString() {
			return set.toString();
		}
		
	}

	static class SetElement {

		String string;

		public SetElement(String s) {
			this.string = s;
		}

		public String toString() {
			return string;
		}

		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (!(obj instanceof SetElement)) return false;
			return this.string.equals(((SetElement) obj).string);
		}

		public int hashCode() {
			return Objects.hash(this.string);
		}
		
	}

	private final static String file = "names.properties";
	private final static Logger log = LogManager.getLogger(SetExample.class);

	private static String names[];

	private static String[] getNames() {
		String names[] = null;

		Properties properties = new Properties();

		try (InputStream inputStream = new FileInputStream(file)) {

			properties.load(inputStream);
			int elements = Integer.parseInt(properties.getProperty("names"));
			log.trace("Found " + elements + " name(s)");

			names = new String[elements];

			for (int i = 0; i < elements; i++) {
				names[i] = properties.getProperty("name." + (i + 1));
			}

			if (log.getLevel() == Level.TRACE)
				for (String s : names)
					System.out.println(s);

		} catch (FileNotFoundException e) {
			log.error("File not found: " + file);
		} catch (IOException e) {
			log.error("Problems " + e.getLocalizedMessage(), e);
		}

		return names;
	}

	public static void main(String[] args) {

		Configurator.initialize(new DefaultConfiguration());
		Configurator.setRootLevel(Level.TRACE);

		names = getNames();
		if (names == null) {
			log.fatal("No names - exiting");
			return;
		}

		MySet mySet = new MySet();
		for (String s : names) {
			mySet.add(new SetElement(s));
		}
		for (String s : names) {
			mySet.add(new SetElement(s));
		}
		System.out.println(mySet);

	}

}
