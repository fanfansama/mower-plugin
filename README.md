mower-plugin
============

Bienvenue sur le mower-plugin !

## Pré-Requis

- JDK 7
- Maven 3+ 


## Utilisation

```java
$ mvn clean install
```

## Notes

- Ajouter ***un ou plusieurs fichiers*** (***.txt***) dans le répertoire ***src/test/resources***,

## Restrictions

- ***Les espaces et les sauts de lignes superflux ne sont pas tolérés***,
- ***Les noms de fichiers avec espaces ne sont pas prise en compte***,

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
/Library/Java/JavaVirtualMachines/1.7.0.jdk/Contents/Home/bin/java -Dmaven.home=/Users/fanfan/Applis/java/apache-maven-3.0.4 -Dclassworlds.conf=/Users/fanfan/Applis/java/apache-maven-3.0.4/bin/m2.conf -Didea.launcher.port=7534 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA 12.app/bin" -Dfile.encoding=UTF-8 -classpath "/Users/fanfan/Applis/java/apache-maven-3.0.4/boot/plexus-classworlds-2.4.jar:/Applications/IntelliJ IDEA 12.app/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.classworlds.Launcher --fail-fast --strict-checksums install
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
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mower-plugin ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.5:testResources (default-testResources) @ mower-plugin ---
[debug] execute contextualize
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO]
[INFO] --- build-helper-maven-plugin:1.9:add-test-resource (add-test-resource) @ mower-plugin ---
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ mower-plugin ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.11:test (default-test) @ mower-plugin ---
[INFO] Surefire report directory: /Users/fanfan/Applis/java/working_dir/mower-plugin/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running fr.fbe.tondeuse.geo.DoubleListeChaineeTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.067 sec
Running fr.fbe.tondeuse.geo.RoseDesVentsTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running fr.fbe.tondeuse.moteur.BasicTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running fr.fbe.tondeuse.moteur.TondeuseTest
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.256 sec
Running fr.fbe.tondeuse.programme.ParseurTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.771 sec
Running fr.fbe.tondeuse.programme.validateur.ActionValidateurTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running fr.fbe.tondeuse.programme.validateur.DimensionTerrainValidateurTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running fr.fbe.tondeuse.programme.validateur.LigneActionValidateurTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running fr.fbe.tondeuse.programme.validateur.PositionValidateurTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec

Results :

Tests run: 38, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.3.2:jar (default-jar) @ mower-plugin ---
[INFO]
[INFO] --- maven-failsafe-plugin:2.17:integration-test (default) @ mower-plugin ---
[INFO] Failsafe report directory: /Users/fanfan/Applis/java/working_dir/mower-plugin/target/failsafe-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running fr.fbe.tondeuse.moteur.ProcesserFichiersIT
************basic.txt*********************
1 5 N
1 3 N
5 1 E
************basic3.txt*********************
1 5 N
1 3 N
5 1 E
************basic4.txt*********************
1 5 N
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.084 sec - in fr.fbe.tondeuse.moteur.ProcesserFichiersIT

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

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
[INFO] Total time: 3.700s
[INFO] Finished at: Sun Jun 15 21:50:41 CEST 2014
[INFO] Final Memory: 13M/197M
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
```

