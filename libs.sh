mvn -U clean

mvn install:install-file \
  -Dfile="lib/db4o-7.4.106.13438-java5.jar" \
  -DgroupId="db4o" \
  -DartifactId="db4o" \
  -Dversion="7.4.106.13438-java5" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/forms.jar" \
  -DgroupId="forms" \
  -DartifactId="forms" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/jcalendar-1.3.3.jar" \
  -DgroupId="jcalendar" \
  -DartifactId="jcalendar" \
  -Dversion="1.3.3" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/PgsLookAndFeel.jar" \
  -DgroupId="PgsLookAndFeel" \
  -DartifactId="PgsLookAndFeel" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/TableLayout-javadoc.jar" \
  -DgroupId="TableLayout-javadoc" \
  -DartifactId="TableLayout-javadoc" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/TableLayout-src.jar" \
  -DgroupId="TableLayout-src" \
  -DartifactId="TableLayout-src" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/TableLayout.jar" \
  -DgroupId="TableLayout" \
  -DartifactId="TableLayout" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/backport175/backport175-1.1.RC1-snapshot.jar" \
  -DgroupId="genesis.backport175" \
  -DartifactId="backport" \
  -Dversion="175-1.1.RC1-snapshot" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/commons/commons-beanutils-1.7.jar" \
  -DgroupId="genesis.commons" \
  -DartifactId="commons-beanutils" \
  -Dversion="1.7" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/commons/commons-digester-1.8.jar" \
  -DgroupId="genesis.commons" \
  -DartifactId="commons-digester" \
  -Dversion="1.8" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/commons/commons-logging-1.1.jar" \
  -DgroupId="genesis.commons" \
  -DartifactId="commons-logging" \
  -Dversion="1.1" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/commons/commons-validator-1.3.1.jar" \
  -DgroupId="genesis.commons" \
  -DartifactId="commons-validator" \
  -Dversion="1.3.1" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/commons/jakarta-oro-2.0.8.jar" \
  -DgroupId="genesis.commons" \
  -DartifactId="jakarta-oro" \
  -Dversion="2.0.8" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/commons/reusable-components-20060810.jar" \
  -DgroupId="genesis.commons" \
  -DartifactId="reusable-components" \
  -Dversion="1.3.1" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/script/bsf-2.4.0.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="bsf" \
  -Dversion="2.4.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/script/bsh-2.0b4.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="bsh" \
  -Dversion="2.0b4" \
  -Dpackaging=jar
  
mvn install:install-file \
  -Dfile="lib/genesis/lib/script/commons-el-1.0.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="commons-el" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/script/commons-jxpath-1.2.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="commons-jxpath" \
  -Dversion="1.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/script/jakarta-taglibs-standard-1.1.2.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="jakarta-taglibs-standard" \
  -Dversion="1.1.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/script/js-1.6R5.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="js" \
  -Dversion="1.6R5" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/lib/script/jsp-api.jar" \
  -DgroupId="genesis.script" \
  -DartifactId="jsp-api" \
  -Dversion="1.0" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-annotation-jdk5-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-annotation" \
  -Dversion="3.2" \
  -Dpackaging=jar
  
mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-aspect-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-aspect" \
  -Dversion="3.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-aspect-annotated-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-aspect-annotated" \
  -Dversion="3.2" \
  -Dpackaging=jar
  
mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-client-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-client" \
  -Dversion="3.2" \
  -Dpackaging=jar
  
mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-client-swing-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-client-swing" \
  -Dversion="3.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-client-swt-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-client-swt" \
  -Dversion="3.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-client-thinlet-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-client-thinlet" \
  -Dversion="3.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-container-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-container" \
  -Dversion="3.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-server-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-server" \
  -Dversion="3.2" \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-shared-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-shared" \
  -Dversion="3.2" \
  -Dpackaging=jar
  
mvn install:install-file \
  -Dfile="lib/genesis/dist/genesis-shared-annotated-3.2.jar" \
  -DgroupId="genesis" \
  -DartifactId="genesis-shared-annotated" \
  -Dversion="3.2" \
  -Dpackaging=jar