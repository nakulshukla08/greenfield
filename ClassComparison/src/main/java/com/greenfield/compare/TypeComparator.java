package com.amdocs.compare;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.amdocs.classloader.CustomLoader;

public class TypeComparator {

	private static CustomClassType convertClass(Class<?> clz) {
		CustomClassType loadedClz = new CustomClassType();
		loadedClz.setType(clz.getCanonicalName());

		Field[] fields = clz.getDeclaredFields();

		Map<String, CustomField> fieldMap = new HashMap<>();

		for (Field fld : fields) {
			CustomField custField = new CustomField();
			custField.setName(fld.getName());
			custField.setType(fld.getType().getCanonicalName());
			fieldMap.put(fld.getName(), custField);
		}
		
		Method[] methods = clz.getDeclaredMethods();
		
		Map<String, CustomMethod> methodMap = new HashMap<>();
		
		for(Method method : methods)
		{
			CustomMethod methodCust = new CustomMethod();
			methodCust.setName(method.getName());
			methodMap.put(method.getName(), methodCust);
		}
	
		loadedClz.setMethodMap(methodMap);
		loadedClz.setFieldMap(fieldMap);
		return loadedClz;
	}

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			List<String> backendJarPath = new ArrayList<String>();

			backendJarPath.add("C:/AWSI_WSF/jars");

			CustomLoader loadGeneratedClasses = loadGeneratedClassesOrig();

			String[] extensions = new String[1];
			extensions[0] = "class";

			File directory = new File("C:/wsdl-2-java/target/classes");
			Collection<File> files = FileUtils.listFiles(directory, extensions, true);

			Set<String> classSet = new HashSet<String>();
			Map<String, CustomClassType> generatedClassMap = new HashMap<String, CustomClassType>();

			Map<String, CustomClassType> backendClassMap = new HashMap<String, CustomClassType>();

			for (File file : files) {

				if (file != null) {
					String canonicalPath = file.getCanonicalPath();
					System.out.println(canonicalPath);

					// canonicalPath =
					// canonicalPath.substring(canonicalPath.indexOf("classes"));

					// System.out.println("trimmed : " + canonicalPath);

					String className = processClassFileName(canonicalPath);

				//	System.out.println("Class name :" + className);

					Class<?> loadClass = loadGeneratedClasses.loadClass(className);

					if (loadClass != null) {
				//		System.out.println("Class is loaded, populating map for : " + loadClass);
						CustomClassType convertClass = convertClass(loadClass);
						classSet.add(className);
						generatedClassMap.put(className, convertClass);
					}
				}

			}

			CustomLoader loadedBackendClasses = loadBackendJars(backendJarPath);

			for (String className : classSet) {
				//System.out.println("Trying to load : " + className);
				Class<?> loadClass = null;
				try {
					loadClass = loadedBackendClasses.loadClass(className.trim());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if (loadClass != null) {
				//	System.out.println("found class : " + className);
					CustomClassType convertClass = convertClass(loadClass);

					backendClassMap.put(className, convertClass);
					CustomClassType genClz = generatedClassMap.get(className);

					compareClasses(genClz, convertClass);
				}
			}

			System.out.println("generatedClassMap size : " + generatedClassMap.size());
			System.out.println("backendClassMap size : " + backendClassMap.size());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void compareClasses(CustomClassType genCustClz, CustomClassType backendCustClz) {
		String genClz = genCustClz.getType();
		String backendClz = backendCustClz.getType();
	//	System.out.println("Compare classes : " + genClz + " and : " + backendClz);
		Map<String, CustomField> genDeclaredFields = genCustClz.getFieldMap();

		for (Map.Entry<String, CustomField> fld : genDeclaredFields.entrySet()) {

			String genFieldName = fld.getKey();
			CustomField genFieldValue = fld.getValue();
			String genFieldType = genFieldValue.getType();

			CustomField backendField = backendCustClz.getFieldMap().get(genFieldName);
			String backendFieldType = backendField.getType();

			if (genFieldType.equals(backendFieldType)) {
				// System.out.println("fields equal : " + fld.getName());

			} else {
				System.out.println("Class : "+genCustClz.getType()+" field of different types "+genFieldType+" || "+backendFieldType);
			}

		}
		
		Map<String, CustomMethod> methodMap = backendCustClz.getMethodMap();
		
		for (Map.Entry<String, CustomMethod> method : methodMap.entrySet()) {
			
			String genMethodName = method.getKey();
			
			CustomMethod customMethod = genCustClz.getMethodMap().get(genMethodName);
			String name = null;
			if(customMethod!=null){
			 name = customMethod.getName();
		//	System.out.println("Class : "+genCustClz.getType()+" method matched : "+name);
			}else
			{
				System.out.println("Class : "+genCustClz.getType()+" method not matched : "+genMethodName);
			}
		}
	}

	private static String processClassFileName(String canonicalPath) {
		String substringAfter = StringUtils.substringAfter(canonicalPath, "classes\\");

		String removedExtn = StringUtils.remove(substringAfter, ".class");

		String replace = StringUtils.replace(removedExtn, "\\", ".");

		return replace;
	}

	private static CustomLoader loadBackendJars(List<String> backendJarPath) throws MalformedURLException {

		List<URL> urlList = new ArrayList<URL>();

		if (backendJarPath != null) {
			for (String element : backendJarPath) {
				File[] listClassPathFiles = new File(element).listFiles();
				for (File file : listClassPathFiles) {
					urlList.add(file.toURI().toURL());

					System.out.println("Backend jars : " + file.getAbsolutePath());
				}
			}
		}

		URL[] urlArray = urlList.toArray(new URL[urlList.size()]);
		// URLClassLoader backendJarLoader = new URLClassLoader(urlArray);

		CustomLoader backendJarLoader = new CustomLoader(urlList);

		return backendJarLoader;
	}
	
	private static URLClassLoader loadBackendJarsOrig(List<String> backendJarPath) throws MalformedURLException {

		List<URL> urlList = new ArrayList<URL>();

		if (backendJarPath != null) {
			for (String element : backendJarPath) {
				File[] listClassPathFiles = new File(element).listFiles();
				for (File file : listClassPathFiles) {
					urlList.add(file.toURI().toURL());

					System.out.println("Backend jars : " + file.getAbsolutePath());
				}
			}
		}

		URL[] urlArray = urlList.toArray(new URL[urlList.size()]);
		 URLClassLoader backendJarLoader = new URLClassLoader(urlArray, null);

	//	CustomLoader backendJarLoader = new CustomLoader(urlList);

		return backendJarLoader;
	}

	private static URLClassLoader loadGeneratedClasses() throws MalformedURLException {
		String generatedSourcePath = "C:/AifWorkspc/wsdl-2-java/target/classes";
		List<URL> urlList = new ArrayList<URL>();

		String[] extensions = new String[1];
		extensions[0] = "class";

		if (generatedSourcePath != null) {

			File directory = new File(generatedSourcePath);

			Collection<File> files = FileUtils.listFiles(directory, extensions, true);
			// File[] listClassPathFiles = new
			// File(generatedSourcePath).listFiles();
			for (File file : files) {
				System.out.println("loading : " + file.getAbsolutePath());
				urlList.add(file.toURI().toURL());
			}

		}

		URL[] urlArray = urlList.toArray(new URL[urlList.size()]);
		URLClassLoader generatedClassLoader = new URLClassLoader(urlArray);// URLClassLoader.newInstance(urlArray);

		return generatedClassLoader;

	}
	
	private static CustomLoader loadGeneratedClassesOrig() throws MalformedURLException {
		String generatedSourcePath = "C:/wsdl-2-java/target/classes";
		List<URL> urlList = new ArrayList<URL>();

		String[] extensions = new String[1];
		extensions[0] = "class";

		if (generatedSourcePath != null) {

			File directory = new File(generatedSourcePath);

			Collection<File> files = FileUtils.listFiles(directory, extensions, true);
			// File[] listClassPathFiles = new
			// File(generatedSourcePath).listFiles();
			for (File file : files) {
				System.out.println("loading : " + file.getAbsolutePath());
				urlList.add(file.toURI().toURL());
			}

		}

		URL[] urlArray = urlList.toArray(new URL[urlList.size()]);
		CustomLoader generatedClassLoader = new CustomLoader(urlList);// URLClassLoader.newInstance(urlArray);

		return generatedClassLoader;

	}

}

class CustomClassType {
	Map<String, CustomField> fieldMap;
	
	Map <String, CustomMethod> methodMap;

	public Map<String, CustomField> getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Map<String, CustomField> fieldMap) {
		this.fieldMap = fieldMap;
	}

	String type;

	public Map<String, CustomMethod> getMethodMap() {
		return methodMap;
	}

	public void setMethodMap(Map<String, CustomMethod> methodMap) {
		this.methodMap = methodMap;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

class CustomField {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

class CustomMethod
{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}