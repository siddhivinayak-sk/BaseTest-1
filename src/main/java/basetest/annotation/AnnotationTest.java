package basetest.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.ElementType.MODULE;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


/**
 * If annotation has not property used to mark only, called marker annotation.
 * If no property then brackets () are optional as time of using annotation.
 * The method defined for primitives, annotation, class and arrays of any legal types.
 * If method names is 'value' then values can be set directly without having name like: @MyAnnotation("Abc") 
 * Predefined Annotations:
 * - @Retention
 * - @Documented
 * - @Target
 * - @Inherited
 * - @Override
 * - @Depricated
 * - @FunctionalInterface
 * - @SafeVarargs
 * - @SupperssWarnings
 * 
 * Normally, annotations can be applied (as defined in annotation definition @Target) on:
 * Class (Class, Interface, Enumeration), Method, Constructor and Field, Local variable, Module, Package,
 * Parameter, Type of Parameter, Type uses 
 * 
 * Providing default value, makes annotation property optional, the default keyword is used and it must same time value (as per return type)
 * 
 *  Type Annotations introduced in J1.8 to provide additional validation/strictness which can be applied on types e.g.
 *  - return type
 *  - exception throws in method declaration
 *  
 *  Repeating Annotation are created with containers annotation, mark annotation with @Repeatable(<Container Annotation>)
 *  And repeated annotations value can be obtained.
 *
 */
@Documented
@Retention(RUNTIME)
@Inherited
@Repeatable(MyAnnotationContainerForRepetableAnnotation.class)
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE })
@interface MyAnnotation {

	String value();
	boolean booleans() default false;
	byte bytes() default 0;
	short shorts() default 0;
	char chars() default 0;
	int ints() default 0;
	long longs() default 0;
	float floats() default 0.0f;
	double doubles() default 0.0;
	String[] names() default {"A", "B"};
	Class classes() default Integer.class;
	SubAnnotation subAnnotation() default @SubAnnotation();
}

@interface SubAnnotation {
	String value() default "";
}

@Documented
@Retention(RUNTIME)
@Inherited
@Target({ TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE })
@interface MyAnnotationContainerForRepetableAnnotation {
	MyAnnotation[] value();
}

public class AnnotationTest {
	
	@MyAnnotation("A")
	@MyAnnotation("B")
	public static void main(String...args) throws NoSuchMethodException, SecurityException {
		Class clazz = AnnotationTest.class;
		Method mainMethod = clazz.getMethod("main", new String[] {}.getClass());
		MyAnnotationContainerForRepetableAnnotation annotation = mainMethod.getAnnotation(MyAnnotationContainerForRepetableAnnotation.class);
		System.out.println(annotation);
		
	}
}