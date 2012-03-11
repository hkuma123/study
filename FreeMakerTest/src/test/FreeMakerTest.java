/*
 * PJ-CODE-NAME: PJ-SYSTEM-NAME
 * Copyright(C) 2011 
 */
package test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMakerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try { 
            test01();
            test02();
        } catch (Exception ex ){
            
            ex.printStackTrace();
        }
   
        
        
    }

    public static void test01() throws Exception {
        
        Configuration cfg = new Configuration();
        
        cfg.setDirectoryForTemplateLoading(new File("./templates"));
        
        Template temp = cfg.getTemplate("test.ftl");
        
        Map <Object,Object>root = new HashMap<Object,Object>();
        
        root.put("string", "string");
        root.put("int", new Integer(1000));
        
        Writer out = new OutputStreamWriter(System.out);
        
        temp.process(root, out);
        
        out.flush();        
        
    }
    
    public static void test02() throws Exception {
        
        Configuration cfg = new Configuration();
        
        cfg.setDirectoryForTemplateLoading(new File("./templates"));
        
        Template temp = cfg.getTemplate("object.ftl");
        
        
        // Data Model
        Map<Object,Object> root = new HashMap<Object,Object>();
        root.put("kittens", Arrays.asList(  new Kitten[]{
            new Kitten( "mii  ", 2 ),
            new Kitten( "kuro ", 1 ),
            new Kitten( "shiro", 1 ),
            new Kitten( "tora ", 0 )
        } ));

        

        
        Writer out = new OutputStreamWriter(System.out);
        
        temp.process(root, out);
        
        out.flush();        
        
    }    

    
}
