package com.greenfield.classloading;

import java.net.URL;
import java.util.List;



public class CustomLoader extends ClassLoader{

    private CustomURLClassLoader childClassLoader;
    public CustomLoader(List<URL> classpath)
    {
        super(Thread.currentThread().getContextClassLoader());
        URL[] urls = classpath.toArray(new URL[classpath.size()]);
        childClassLoader = new CustomURLClassLoader( urls, new DetectClass(this.getParent()) );
    }
    @Override
    public synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException
    {
        try
        {
            return childClassLoader.findClass(name);
        }
        catch( ClassNotFoundException e )
        {
            return super.loadClass(name, resolve);
        }
    }

    
}
