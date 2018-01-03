package com.amdocs.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomURLClassLoader extends URLClassLoader {
	private DetectClass realParent;

	public CustomURLClassLoader(URL[] urls, DetectClass realParent) {
		super(urls, null);
		this.realParent = realParent;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			Class<?> loaded = super.findLoadedClass(name);
			if (loaded != null)
				return loaded;
			return super.findClass(name);
		} catch (Throwable e) {
			return realParent.loadClass(name);
		}
		
	}



}
