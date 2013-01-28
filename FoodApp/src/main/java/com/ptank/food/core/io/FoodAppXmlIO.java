package com.ptank.food.core.io;

import java.io.Reader;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ptank.food.core.FoodApp;

public class FoodAppXmlIO {

	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public FoodAppXmlIO() {
		try {
			JAXBContext context = JAXBContext.newInstance(FoodApp.class);
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public FoodApp loadFoodApp(Reader reader) {
		try {
			return (FoodApp) unmarshaller.unmarshal(reader);
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}
		
	public void save(Object foodObject, Writer writer) {
		try {
			marshaller.marshal(foodObject, writer);
		} catch (JAXBException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
