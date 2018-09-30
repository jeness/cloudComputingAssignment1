from __future__ import print_function

from operator import add
import sys
from pyspark import SparkContext


if __name__ == "__main__":
    sc = SparkContext(appName="PythonWordCountTwo")
    lines = sc.textFile("gs://ufcloudcomputing/bible", 1)
  
    def pairs(param):
        tempList = param.split(" ")
        index = 0 
        start = 0
        dup = []
        for word in tempList:
            if(start == 0):
                start = 1
                index+=1
            else:
                dup.append((str(tempList[index-1]),str(word)))
                index+=1
        return dup
 
    counts = lines.flatMap(pairs).map(lambda x: (str(x),1)).reduceByKey(add)
    counts.saveAsTextFile("gs://ufcloudcomputing/wordcountTwoOutputFolder/")

    sc.stop()