package com.jingyunbank.demo.springboot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(Application.class, args);
    	deletefiles();
    }

	public static void deletefiles() throws IOException {
		Path p = Paths.get("D:/Projects/jingyun-shop/ui/jingyunetrade-new");
    	Stack<File> stack = new Stack<File>();
    	File f = p.toFile();
    	addtostack(f, stack);
    	delete(stack);
	}

	private static void delete(Stack<File> stack) throws IOException {
		for (int i = 0; i < stack.size(); i++) {
			File file = stack.pop();
    		System.out.println(file.toString());
			Files.delete(file.toPath());
			System.out.println(file.exists());
		}
	}
    
    private static void addtostack (File f, Stack<File> stack){
    	stack.push(f);
    	File[] cfs = f.listFiles();
    	if(cfs == null) return;
    	for (int i = 0; i < cfs.length; i++) {
    		addtostack(cfs[i], stack);
		}
    }
}
