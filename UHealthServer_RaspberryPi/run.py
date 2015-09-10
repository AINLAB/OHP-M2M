import os
import sys

if __name__ == "__main__":
	ProjectJar = "Test.jar"
	classpath = "libs/californium-core-1.0.0-SNAPSHOT.jar:libs/element-connector-1.0.0-SNAPSHOT.jar:libs/jdom-2.0.5.jar:libs/hapi-hl7overhttp-2.2.jar:libs/hapi-structures-v26-2.2.jar:libs/hapi-base-2.2.jar:libs/log4j-1.2.17.jar:libs/slf4j-log4j12-1.6.6.jar:libs/slf4j-api-1.6.6.jar"

	if sys.argv[1] == "c":
		print("Compile program")

		src = "src/com/ain/coapserver/coapresources/*.java src/com/ain/coapserver/*.java src/com/ain/ieee11073/*.java src/com/ain/ieee11073/devices/*.java src/com/ain/ihepcd/transaction/*.java"
		os.system("javac -encoding UTF8 -classpath " + classpath +" -d bin " +src)
		os.system("jar -cvf " + ProjectJar +" -C bin/ .")

	if sys.argv[1] == "r":
		print("Run program")
		os.system("java -cp " + classpath + ":" + ProjectJar + " com.ain.coapserver.Main")

	print "over"

