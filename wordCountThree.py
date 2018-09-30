from __future__ import print_function

import sys
from operator import add

from pyspark import SparkContext


if __name__ == "__main__":
    sc = SparkContext(appName="PythonWordCount3")
# read from bible
    lines = sc.textFile("gs://ufcloudcomputing/bible", 1)

# function to get words from sc
    def findword(param):
        templist = param.split(" ")
        return templist

    dummy = sc.textFile("gs://ufcloudcomputing/word-patterns.txt").flatMap(findword)
# word count in bible
    counts = lines.flatMap(findword).map(lambda x: (str(x),1)).reduceByKey(add)
# get list of words in word-patterns.txt
    counts2 = dummy.map(lambda x: (str(x),0)).reduceByKey(add)
# join both and get the count
    temp = counts.join(counts2).map(lambda x:(x[0],x[1][0]))
    temp.saveAsTextFile("gs://ufcloudcomputing/wordcountThreeOutputFolder/")


    sc.stop()