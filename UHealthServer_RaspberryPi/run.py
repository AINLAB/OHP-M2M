import os
import sys

if __name__ == "__main__":
	ProjectJar = "Test.jar"
	classpath = "libs/californium-core-1.0.0-SNAPSHOT.jar:libs/element-connector-1.0.0-SNAPSHOT.jar:libs/jdom-2.0.5.jar"

	if sys.argv[1] == "c":
		print("Compile program")

		src = "src/com/ain/coapserver/coapresources/*.java src/com/ain/coapserver/*.java src/com/ain/coapserver/elements/*.java"
		os.system("javac -classpath " + classpath +" -d bin " +src)
		os.system("jar -cvf " + ProjectJar +" -C bin/ .")

	if sys.argv[1] == "r":
		print("Run program")
		os.system("java -cp " + classpath + ":" + ProjectJar + " com.ain.coapserver.Main")

	print "over"

