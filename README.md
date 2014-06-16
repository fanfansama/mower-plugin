mower-plugin
============

Bienvenue sur le mower-plugin !

## Pré-Requis

- JDK 8
- Maven 3+ 


## Utilisation

```java
$ mvn clean install
```

## Notes

- Ajouter ***un ou plusieurs fichiers*** (***.txt***) dans le répertoire ***src/it/resources***,

## Restrictions

- ***Les espaces et les sauts de lignes superflux ne sont pas tolérés***,
- ***Le codage de fichier  UTF-8 « standard » sans BOM est apprécié***

## Exemple de fichier

```
5 5
1 1 N
AAAA
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```

## Sortie

```
/Library/Java/JavaVirtualMachines/jdk1.8.0_05.jdk/Contents/Home/bin/java -Dmaven.home=/Users/fanfan/Applis/java/apache-maven-3.0.4 -Dclassworlds.conf=/Users/fanfan/Applis/java/apache-maven-3.0.4/bin/m2.conf -Didea.launcher.port=7540 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA 12.app/bin" -Dfile.encoding=UTF-8 -classpath "/Users/fanfan/Applis/java/apache-maven-3.0.4/boot/plexus-classworlds-2.4.jar:/Applications/IntelliJ IDEA 12.app/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.classworlds.Launcher --fail-fast --strict-checksums install
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building mower-plugin 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ mower-plugin ---
[debug] execute contextualize
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/fanfan/Applis/java/working_dir/mower-plugin/src/main/resources
[INFO]
[INFO] --- build-helper-maven-plugin:1.9:add-test-source (add-test-source) @ mower-plugin ---
[INFO] Test Source directory: /Users/fanfan/Applis/java/working_dir/mower-plugin/src/it/java added.
[INFO]
[INFO] --- build-helper-maven-plugin:1.9:add-test-resource (add-test-resource) @ mower-plugin ---
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mower-plugin ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 18 source files to /Users/fanfan/Applis/java/working_dir/mower-plugin/target/classes
[WARNING] /Users/fanfan/Applis/java/working_dir/mower-plugin/src/main/java/com/mower/reader/core/validator/ActionLineValidator.java: /Users/fanfan/Applis/java/working_dir/mower-plugin/src/main/java/com/mower/reader/core/validator/ActionLineValidator.java uses unchecked or unsafe operations.
[WARNING] /Users/fanfan/Applis/java/working_dir/mower-plugin/src/main/java/com/mower/reader/core/validator/ActionLineValidator.java: Recompile with -Xlint:unchecked for details.
[INFO]
[INFO] --- maven-resources-plugin:2.5:testResources (default-testResources) @ mower-plugin ---
[debug] execute contextualize
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/fanfan/Applis/java/working_dir/mower-plugin/src/test/resources
[INFO] Copying 5 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ mower-plugin ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 11 source files to /Users/fanfan/Applis/java/working_dir/mower-plugin/target/test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.11:test (default-test) @ mower-plugin ---
[INFO] Surefire report directory: /Users/fanfan/Applis/java/working_dir/mower-plugin/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.mower.engine.BasicTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.092 sec
Running com.mower.engine.MowerControllerTest
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.259 sec
Running com.mower.geo.DoubleListeChaineeTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 sec
Running com.mower.geo.OrientationServiceTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.mower.reader.core.validator.ActionLineValidatorTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.mower.reader.core.validator.ActionValidatorTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.mower.reader.core.validator.DimensionTerrainValidatorTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 sec
Running com.mower.reader.core.validator.PositionValidatorTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec
Running com.mower.reader.impl.ParserImplTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.764 sec

Results :

Tests run: 40, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.3.2:jar (default-jar) @ mower-plugin ---
[INFO] Building jar: /Users/fanfan/Applis/java/working_dir/mower-plugin/target/mower-plugin-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-failsafe-plugin:2.17:integration-test (default) @ mower-plugin ---
[INFO] Failsafe report directory: /Users/fanfan/Applis/java/working_dir/mower-plugin/target/failsafe-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.mower.engine.ProcesserFichiersIT
********** ba sic.txt **********
1 5 N
1 3 N
5 1 E
********** basic.txt **********
1 5 N
1 3 N
5 1 E
********** basic2.txt **********
0 0 N
0 0 N
********** basic3.txt **********
++++[basic3.txt] ERREUR DETECTEE (IllegalArgumentException:Action Code unknown)++++
********** basic4.txt **********
++++[basic4.txt] ERREUR DETECTEE (IllegalArgumentException:Position Missing)++++
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.226 sec - in com.mower.engine.ProcesserFichiersIT

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO]
[INFO] --- maven-failsafe-plugin:2.17:verify (default) @ mower-plugin ---
[INFO] Failsafe report directory: /Users/fanfan/Applis/java/working_dir/mower-plugin/target/failsafe-reports
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO]
[INFO] --- maven-install-plugin:2.3.1:install (default-install) @ mower-plugin ---
[INFO] Installing /Users/fanfan/Applis/java/working_dir/mower-plugin/target/mower-plugin-1.0-SNAPSHOT.jar to /Users/fanfan/.m2/repository/fr/fbe/mower/mower-plugin/1.0-SNAPSHOT/mower-plugin-1.0-SNAPSHOT.jar
[INFO] Installing /Users/fanfan/Applis/java/working_dir/mower-plugin/pom.xml to /Users/fanfan/.m2/repository/fr/fbe/mower/mower-plugin/1.0-SNAPSHOT/mower-plugin-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.432s
[INFO] Finished at: Mon Jun 16 23:23:13 CEST 2014
[INFO] Final Memory: 17M/104M
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0

```

