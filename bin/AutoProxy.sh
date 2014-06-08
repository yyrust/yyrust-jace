export SCRIPT_PATH="$(readlink -f $(dirname "$0"))"
export JACE_HOME=$SCRIPT_PATH/..
export CLASSPATH="$JACE_HOME/core/java/target/*":"$JACE_HOME/core/java/target/dependency/*":.
echo $CLASSPATH
java -classpath $CLASSPATH org.jace.proxy.AutoProxy $*
