/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import javax.tools.ToolProvider;

/**
 *
 * @author sandeep.kumar
 */
public class AnnotationEx {
    public static void main(String...args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class atest = ToolProvider.getSystemToolClassLoader().loadClass("basetest.ATest");
        Annotation[] alist = atest.getAnnotations();
        AType at = (AType)atest.getAnnotation(AType.class);
        System.out.println(at.id());
        System.out.println(at.name());
        System.out.println(at.ob());
        System.out.println(at.type().getCanonicalName());
        System.out.println(at.boxen());
        AAnnotationType aat = at.atype();
        System.out.println(aat);
        System.out.println(at.abcClass());
    }
}

@AType(
        id = 1,
        name = "IDT1",
        ob = {"X", "Y", "Z"},
        type = File.class,
        boxen = {String.class, StringBuilder.class, StringBuffer.class},
        atype = @AAnnotationType(
                ob = {}
            ),
        abcClass = ArrayList.class
)
class ATest {}

/**
 * Annotation: Annotations are the way in Java to provide meta data for any data
 * element in Java. It has retention policy which defines till when the meta
 * data will be available like, source, class and runtime. Another attribute is
 * target which define with which type of element the defined annotation could 
 * be used for class, method, parameters etc.
 * - Only primitives, String, Enum, Annotation, Class and it's single dimension
 * arrays are allowed in annotation creation
 * - If default value is not assign, that annotation property will be mandatory
 */

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@interface AType {
    int id() default 0;
    String name() default "";
    String[] ob();
    Class type() default Object.class;
    Class[] boxen() default {};
    AAnnotationType atype();
    Class<? extends List> abcClass() default List.class;
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE_PARAMETER)
@interface ATypeParameter {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE_USE)
@interface ATypeUse {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.PARAMETER)
@interface AParameter {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.PACKAGE)
@interface APackage {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@interface AMethod {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.LOCAL_VARIABLE)
@interface ALocalVariable {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@interface AField {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.CONSTRUCTOR)
@interface AConstructor {
    int id() default 0;
    String name() default "";
    String[] ob();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
@interface AAnnotationType {
    int id() default 0;
    String name() default "";
    String[] ob();
}

