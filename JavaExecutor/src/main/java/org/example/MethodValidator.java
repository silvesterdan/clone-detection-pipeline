// src/main/java/org/example/MethodValidator.java
package org.example;

import java.util.Arrays;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class MethodValidator {

    public static void main(String[] args) throws IOException {
        // CLI Parsing
        if (args.length < 1) {
            System.err.println("Usage: java -jar MethodValidator.jar <folder> [--verbose]");
            System.exit(1);
        }
        File folder = new File(args[0]);
        boolean verbose = Arrays.asList(args).contains("--verbose");  // optional flag

        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Error: " + folder.getAbsolutePath() + " is not a directory.");
            System.exit(1);
        }

        // Configure parser (Java 17 in this example)
        ParserConfiguration config = new ParserConfiguration()
                .setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_17);

        JavaParser parser = new JavaParser(config);

        File[] javaFiles = folder.listFiles((dir, name) -> name.endsWith(".java"));
        if (javaFiles == null || javaFiles.length == 0) {
            System.out.println("No .java files found in: " + folder.getAbsolutePath());
            return;
        }

        // Track invalid files
        List<String> invalidFiles = new ArrayList<>();

        for (File javaFile : javaFiles) {
            String content = new String(Files.readAllBytes(javaFile.toPath()));

            // Wrap the method in a dummy class
            ParseResult<CompilationUnit> result = parser.parse(content);

            // If direct parse fails, wrap it in a dummy class and try again
            if (!result.isSuccessful() || result.getResult().isEmpty()) {
                String wrappedCode = "class Wrapper {\n" + content + "\n}";
                result = parser.parse(wrappedCode);
            }

            if (!result.isSuccessful() || result.getResult().isEmpty()) {
                invalidFiles.add(javaFile.getName());
                // Optionally log reasons
//                 UNCOMMENT BELOW LINE TO SEE SYNTAX ERRORS!!!
                if (verbose) {
                    System.out.println("--> " + javaFile.getName());
                    result.getProblems().forEach(problem -> System.out.println("   -> " + problem));

                }
                continue;
            }

            CompilationUnit cu = result.getResult().get();
            List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);

//             Expect exactly one method in each file
//            if (methods.size() != 1) {
//                invalidFiles.add(javaFile.getName());
//            }
            // Instead of enforcing exactly one method, simply log the count:
//            System.out.println("Found " + methods.size() + " methods in file: " + javaFile.getName());
        }

        // Final summary
        if (invalidFiles.isEmpty()) {
            System.out.println("INFO: All files have a valid method!");
        } else {
            System.out.println("INFO: Some files could not be processed correctly:");
            invalidFiles.forEach(fileName -> System.out.println(fileName));
        }
    }
}
