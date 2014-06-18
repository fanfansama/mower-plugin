mower-plugin
============

Bienvenue sur le mower-plugin !

## Pré-Requis

- JDK 8
- Maven 3+ ou Gradle 1.12 (utilisation en mode découverte...) 


## Utilisation

```java
$ mvn clean install
```

```java
$ gradle clean check
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

***Maven***
```
$> mvn clean install
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
Running com.mower.geo.LinkListTest
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
Running com.mower.engine.AllFilesIT
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
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.226 sec - in com.mower.engine.AllFilesIT

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
***Gradle***



```
$> gradle clean check
The Test.testReportDir property has been deprecated and is scheduled to be removed in Gradle 2.0. Please use the Test.getReports().getHtml().getDestination() property instead.
:clean
:compileJava
Note: /home/francois/IdeaProjects/mower/src/main/java/com/mower/reader/core/validator/ActionLineValidator.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
:processResources UP-TO-DATE
:classes
:jar
:assemble
:compileIntegTestJava
:processIntegTestResources
:integTestClasses
:integTest
Running TI : test mowItNowTestCase(com.mower.engine.IntegrationFileIT)
Running TI : test readAllFiles(com.mower.engine.AllFilesIT)

com.mower.engine.AllFilesIT > readAllFiles STANDARD_OUT
    ********** basic2.txt **********
    0 0 N
    0 0 N
    ********** basic3.txt **********
    ++++[basic3.txt] ERREUR DETECTEE (IllegalArgumentException:Action Code Unknown)++++
    ********** ba sic.txt **********
    1 5 N
    1 3 N
    5 1 E
    ********** basic.txt **********
    1 5 N
    1 3 N
    5 1 E
    ********** basic4.txt **********
    ++++[basic4.txt] ERREUR DETECTEE (IllegalArgumentException:Position Missing)++++
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test
Running TU : test avancerAlEst(com.mower.engine.MowerControllerTest)
Running TU : test avancerAuSud(com.mower.engine.MowerControllerTest)
Running TU : test avancerAuNord(com.mower.engine.MowerControllerTest)
Running TU : test sortir_ouest(com.mower.engine.MowerControllerTest)
Running TU : test avancerAlOuest(com.mower.engine.MowerControllerTest)
Running TU : test turnRight(com.mower.engine.MowerControllerTest)
Running TU : test sortir_est(com.mower.engine.MowerControllerTest)
Running TU : test sortir_sud(com.mower.engine.MowerControllerTest)
Running TU : test turnLeft(com.mower.engine.MowerControllerTest)
Running TU : test sortir_nord(com.mower.engine.MowerControllerTest)
Running TU : test cas1(com.mower.engine.BasicTest)
Running TU : test cas2(com.mower.engine.BasicTest)
Running TU : test tournerADroiteEtAGauche(com.mower.geo.OrientationServiceTest)
Running TU : test tournerADroite(com.mower.geo.OrientationServiceTest)
Running TU : test tournerAGauche(com.mower.geo.OrientationServiceTest)
Running TU : test initialisation(com.mower.geo.OrientationServiceTest)
Running TU : test treeElements(com.mower.geo.LinkListTest)
Running TU : test oneElementGettersNotNull(com.mower.geo.LinkListTest)
Running TU : test twoElements(com.mower.geo.LinkListTest)
Running TU : test valide(com.mower.reader.core.validator.ActionValidatorTest)
Running TU : test valide(com.mower.reader.core.validator.PositionValidatorTest)
Running TU : test actionNonValide_null(com.mower.reader.core.validator.ActionLineValidatorTest)
Running TU : test actionNonValide_vide(com.mower.reader.core.validator.ActionLineValidatorTest)
Running TU : test valide(com.mower.reader.core.validator.ActionLineValidatorTest)
Running TU : test actionNonValide_caractereNonValide(com.mower.reader.core.validator.ActionLineValidatorTest)
Running TU : test actionNonValide_caracteresNonValide(com.mower.reader.core.validator.ActionLineValidatorTest)
Running TU : test estValide(com.mower.reader.core.validator.DimensionTerrainValidatorTest)
Running TU : test estValide_alphanumerique(com.mower.reader.core.validator.DimensionTerrainValidatorTest)
Running TU : test estValide_presenceEspaceSupplumentaire(com.mower.reader.core.validator.DimensionTerrainValidatorTest)
Running TU : test estValide_valeurTropGrande_X(com.mower.reader.core.validator.DimensionTerrainValidatorTest)
Running TU : test estValide_valeurTropGrande_Y(com.mower.reader.core.validator.DimensionTerrainValidatorTest)
Running TU : test badformat(com.mower.reader.core.validator.DimensionTerrainValidatorTest)
Running TU : test casA(com.mower.reader.impl.ParserImplTest)
Running TU : test casB(com.mower.reader.impl.ParserImplTest)
Running TU : test casC(com.mower.reader.impl.ParserImplTest)
Running TU : test casD(com.mower.reader.impl.ParserImplTest)
Running TU : test casE(com.mower.reader.impl.ParserImplTest)
Running TU : test casF(com.mower.reader.impl.ParserImplTest)
Running TU : test casG(com.mower.reader.impl.ParserImplTest)
Running TU : test casH(com.mower.reader.impl.ParserImplTest)
:check

BUILD SUCCESSFUL

Total time: 13.259 secs

```


