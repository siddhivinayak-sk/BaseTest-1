/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.filehandling;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 *
 * @author sandeep.kumar
 */
public class FileVisitorTest {
    public static void main(String...args) throws Exception {
        StringBuilder sb = new StringBuilder();
        SimpleFileVisitor<Path> sfv = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(sb.length() == 0) {
                    sb.append(file.toAbsolutePath().toString());
                }
                else {
                    sb.append("\n" + file.toAbsolutePath().toString());
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Path path = Paths.get("D:\\sandeep\\sandbox\\NetBeansProjects\\WebAppNB07\\target\\WebAppNB07-1.0-SNAPSHOT\\WEB-INF\\lib");
        Files.walkFileTree(path, sfv);
        System.err.println(sb);
    }
}
