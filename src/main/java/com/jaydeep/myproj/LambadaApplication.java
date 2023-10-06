package com.jaydeep.myproj;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootConfiguration
public class LambadaApplication implements ApplicationContextInitializer<GenericApplicationContext>{
	public static void main(String[] args) {
		FunctionalSpringApplication.run(LambadaApplication.class, args);
	}

	public Function<String,String> test1(){
		return (input) -> "Hello "+input;
	}
	
	
	public Consumer<String> test2(){
		return (input) -> System.out.println(input);
	}

	
	public Supplier<String> test3(){
		return () -> "Hello Jaydeep";
	}

	@Override
	public void initialize(GenericApplicationContext context) {
		
		context.registerBean("test1", FunctionRegistration.class,
				()-> new FunctionRegistration<Function<String,String>>(test1())
				.type(FunctionType.from(String.class).to(String.class).getType()));
		
		context.registerBean("test2", FunctionRegistration.class,
				()-> new FunctionRegistration<Consumer<String>>(test2())
				.type(FunctionType.consumer(String.class).getType()));
		
		context.registerBean("test3", FunctionRegistration.class,
				()-> new FunctionRegistration<Supplier<String>>(test3())
				.type(FunctionType.supplier(String.class).getType()));
	}
	
	
	
}
