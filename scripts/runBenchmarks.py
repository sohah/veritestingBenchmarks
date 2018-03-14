#! /usr/bin/python3

import subprocess
import os
import datetime
from array import *

benchmarkJPF=["tcas"]
location = '/home/soha/git/veritesting/benchmarks/'
timeNow = datetime.datetime.now()
outputDirectory = location+'output'+timeNow.strftime("%m-%d-%H-%M")
#os.system('rm -r '+outputDirectory)
#os.system('mkdir '+outputDirectory)
original_umask = os.umask(0)
if not os.path.exists(outputDirectory):
    os.makedirs(outputDirectory,0o777)
for x in benchmarkJPF:
	os.system('java  -cp . -Djava.library.path="/home/soha/git/veritesting/jpf-symbc-veritesting/lib" -Xmx1024m -ea -jar /home/soha/git/veritesting/jpf-core-veritesting/build/RunJPF.jar /home/soha/git/veritesting/jpf-symbc-veritesting/src/examples/'+x+'.jpf >'+outputDirectory+'/'+x+'.txt')
	print(outputDirectory+'/'+x+'.txt')
exit()
