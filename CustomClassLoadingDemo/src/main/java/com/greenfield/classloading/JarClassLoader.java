package com.greenfield.classloading;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarClassLoader extends ClassLoader {
	private String jarFile = "jar/test.jar"; // Path to the jar file
	private Hashtable classes = new Hashtable(); // used to cache already
													// defined classes

	public JarClassLoader() {
		super(JarClassLoader.class.getClassLoader()); // calls the parent class
														// loader's constructor
	}

	public Class loadClass(String className) throws ClassNotFoundException {
		return findClass(className);
	}

	public Class findClass(String className) {
		byte classByte[];
		Class result = null;

		result = (Class) classes.get(className); // checks in cached classes
		if (result != null) {
			return result;
		}

		try {
			return findSystemClass(className);
		} catch (Exception e) {
		}

		try {
			

			
			JarFile jar = new JarFile(jarFile);
			JarEntry entry = jar.getJarEntry(className + ".class");
			InputStream is = jar.getInputStream(entry);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			int nextValue = is.read();
			while (-1 != nextValue) {
				byteStream.write(nextValue);
				nextValue = is.read();
			}

			classByte = byteStream.toByteArray();
			result = defineClass(className, classByte, 0, classByte.length, null);
			classes.put(className, result);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

}