import serial
import time

se = serial.Serial("/dev/ttyUSB0",57600)

print se.portstr

while True:
	print "-----------------------------"
	str = se.readline()
	print str
	f = open("assets/measurment.txt",'w')
	f.write(str)
	f.close()
	time.sleep(1.5)


