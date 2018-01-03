package com.amdocs.classloader;
public  class DetectClass extends ClassLoader {
	public DetectClass(ClassLoader parent) {
		super(parent);
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		return super.findClass(name);
	}
}