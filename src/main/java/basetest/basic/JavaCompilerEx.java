/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 *
 * @author sandeep.kumar
 */
public class JavaCompilerEx {
   public static void main(String...args) throws IOException {
       JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
       
       
       for(SourceVersion sv:jc.getSourceVersions()) {
           System.out.println(sv);
       }
       
       class CountClassMethodFieldScanner extends ElementScanner8 {
           private int variableCount;
           private int typeParameterCount;
           private int executableCount;
           private int typeCount;
           private int packageCount;
           private int unknownCount;
           
           @Override
           public Object visitVariable(VariableElement e, Object p) {
               ++variableCount;
               return super.visitVariable(e, p);
           }

           @Override
           public Object visitTypeParameter(TypeParameterElement e, Object p) {
               ++typeParameterCount;
               return super.visitTypeParameter(e, p);
           }

           @Override
           public Object visitExecutable(ExecutableElement e, Object p) {
               ++executableCount;
               return super.visitExecutable(e, p);
           }

           @Override
           public Object visitType(TypeElement e, Object p) {
               ++typeCount;
               return super.visitType(e, p);
           }

           @Override
           public Object visitPackage(PackageElement e, Object p) {
               ++packageCount;
               return super.visitPackage(e, p);
           }

           @Override
           public Object scan(Element e, Object p) {
               return super.scan(e, p);
           }

           @Override
           public Object visitUnknown(Element e, Object p) {
               ++unknownCount;
               return super.visitUnknown(e, p); //To change body of generated methods, choose Tools | Templates.
           }

           public int getVariableCount() {
               return variableCount;
           }

           public int getTypeParameterCount() {
               return typeParameterCount;
           }

           public int getExecutableCount() {
               return executableCount;
           }

           public int getTypeCount() {
               return typeCount;
           }

           public int getPackageCount() {
               return packageCount;
           }

           public int getUnknownCount() {
               return unknownCount;
           }
       }
       class CountElementProcessor extends AbstractProcessor {
           private CountClassMethodFieldScanner scanner;

           public CountElementProcessor(CountClassMethodFieldScanner scanner) {
               this.scanner = scanner;
           }

           @Override
           public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
               if(!roundEnv.processingOver()) {
                   for(Element e:roundEnv.getRootElements()) {
                       scanner.scan(e);
                   }
               }
               return true;
           }
           
       }


       CountClassMethodFieldScanner scanner = new CountClassMethodFieldScanner();
       CountElementProcessor processor = new CountElementProcessor(scanner);
       
       File[] files = {new File("D:\\test\\9\\AbstractionTest.java")};
       DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
       StandardJavaFileManager manager = jc.getStandardFileManager(diagnostics, Locale.UK, null);
       Iterable<? extends JavaFileObject> sources = manager.getJavaFileObjects(files);
       CompilationTask task = jc.getTask(null, manager, diagnostics, null, null, sources);
       task.setProcessors(Arrays.asList(processor));
       task.call();
       
        for(Diagnostic<? extends JavaFileObject> d:diagnostics.getDiagnostics()) {
            if(null != d) {
                System.out.format("%s, line %d in %s", d.getMessage(null), d.getLineNumber(), ((null != d.getSource())?d.getSource().getName():""));            
            }
        }
       manager.close();
       
       
       System.out.println("ExecutableCount: " + scanner.getExecutableCount());
       System.out.println("PackageCount: " + scanner.getPackageCount());
       System.out.println("TypeCount: " + scanner.getTypeCount());
       System.out.println("TypeParameterCount: " + scanner.getTypeParameterCount());
       System.out.println("UnknownCount: " + scanner.getUnknownCount());
       System.out.println("VariableCount: " + scanner.getVariableCount());
   }
}

       class CountClassMethodFieldScanner extends ElementScanner8 {
           private int variableCount;
           private int typeParameterCount;
           private int executableCount;
           private int typeCount;
           private int packageCount;
           private int unknownCount;
           
           @Override
           public Object visitVariable(VariableElement e, Object p) {
               ++variableCount;
               return super.visitVariable(e, p);
           }

           @Override
           public Object visitTypeParameter(TypeParameterElement e, Object p) {
               ++typeParameterCount;
               return super.visitTypeParameter(e, p);
           }

           @Override
           public Object visitExecutable(ExecutableElement e, Object p) {
               ++executableCount;
               return super.visitExecutable(e, p);
           }

           @Override
           public Object visitType(TypeElement e, Object p) {
               ++typeCount;
               return super.visitType(e, p);
           }

           @Override
           public Object visitPackage(PackageElement e, Object p) {
               ++packageCount;
               return super.visitPackage(e, p);
           }

           @Override
           public Object scan(Element e, Object p) {
               return super.scan(e, p);
           }

           @Override
           public Object visitUnknown(Element e, Object p) {
               ++unknownCount;
               return super.visitUnknown(e, p); //To change body of generated methods, choose Tools | Templates.
           }

           public int getVariableCount() {
               return variableCount;
           }

           public int getTypeParameterCount() {
               return typeParameterCount;
           }

           public int getExecutableCount() {
               return executableCount;
           }

           public int getTypeCount() {
               return typeCount;
           }

           public int getPackageCount() {
               return packageCount;
           }

           public int getUnknownCount() {
               return unknownCount;
           }
       }
       class CountElementProcessor extends AbstractProcessor {
           private CountClassMethodFieldScanner scanner;

           public CountElementProcessor(CountClassMethodFieldScanner scanner) {
               this.scanner = scanner;
           }

           @Override
           public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
               if(!roundEnv.processingOver()) {
                   for(Element e:roundEnv.getRootElements()) {
                       scanner.scan(e);
                   }
               }
               return true;
           }
           
       }


