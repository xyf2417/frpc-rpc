package xyf.frpc.rpc.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;




import xyf.frpc.rpc.StubInvoker;

public class StubProxyFactoryWrapper implements ProxyFactory {
	
	private ProxyFactory proxyFactory;
	
	public StubProxyFactoryWrapper(ProxyFactory proxyFactory) {
		this.proxyFactory = proxyFactory;
	}

	
	public Object getProxy(Class interfaceClass, Object target,
			boolean isProvider) {
		if(isProvider) {
			throw new IllegalStateException("Service can't use stub");
		}
		StubInvoker stubInvoker = (StubInvoker)target;
		
		Class stubClass = stubInvoker.getStubClass();
		
		Object proxied = proxyFactory.getProxy(interfaceClass, stubInvoker.getInvoker(), isProvider);
		
		Constructor<?> constructor;
		Object proxy = null;
		try {
			constructor = findConstructor(stubClass, interfaceClass);
			proxy = constructor.newInstance(new Object[]{proxied});
		} catch (NoSuchMethodException e) {
			throw new IllegalStateException("Service can't use stub");
		} catch (InstantiationException e) {
			throw new IllegalStateException("Instantiation stub exception");
		} catch (IllegalAccessException e) {
			throw new IllegalStateException("IllegalAccess stub exception");
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException("IllegalArgument stub exception");
		} catch (InvocationTargetException e) {
			throw new IllegalStateException("InvocationTarget stub exception");
		}

		return proxy;
	}
	
	 private static Constructor<?> findConstructor(Class<?> clazz, Class<?> paramType) throws NoSuchMethodException {
	        Constructor<?> targetConstructor;
	        try {
	            targetConstructor = clazz.getConstructor(new Class<?>[]{paramType});
	        } catch (NoSuchMethodException e) {
	            targetConstructor = null;
	            Constructor<?>[] constructors = clazz.getConstructors();
	            for (Constructor<?> constructor : constructors) {
	                if (Modifier.isPublic(constructor.getModifiers())
	                        && constructor.getParameterTypes().length == 1
	                        && constructor.getParameterTypes()[0].isAssignableFrom(paramType)) {
	                    targetConstructor = constructor;
	                    break;
	                }
	            }
	            if (targetConstructor == null) {
	                throw e;
	            }
	        }
	        return targetConstructor;
	    }

}
