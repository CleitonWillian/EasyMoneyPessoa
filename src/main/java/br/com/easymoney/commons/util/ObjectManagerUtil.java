package br.com.easymoney.commons.util;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectManagerUtil {

	private ObjectManagerUtil() throws IllegalAccessException {
		throw new IllegalAccessException("Classe utilitario");
	}
	
	
	public static void copy(Object source, Object target) {
		
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}
	
	
	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper wrapper = new BeanWrapperImpl(source);
		return Stream.of(wrapper.getPropertyDescriptors())
				.filter(propertie -> wrapper.getPropertyValue(propertie.getName()) == null  )
				.map(FeatureDescriptor::getName)
				.toArray(String[]::new);
		
	}
	
	
}
