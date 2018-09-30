package com.haoran.wordCount

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object wordCountOne {
   def main(args: Array[String]) {
 /**
        * step1: create spark configuration info
        */
//      val conf = new SparkConf().setAppName("WordCount").setMaster("local") //running locally
//       val conf = new SparkConf().setAppName("WordCount").setMaster("spark://cluster-assign1-m:8032")  // running in cluster
       val conf = new SparkConf() // running in cluster

      /**
        * step2：create specific info for spark, initialize core functional components: DAGScheduler、TaskScheduler、SchedulerBackend, initialize master
        */
      val sc = new SparkContext(conf)
 
      /**
        * step3: set input data source (including HDFS, HBase, Local FS, DB, S3) to create RDD
        */
      val lines = sc.textFile("gs://ufcloudcomputing/bible")   // read from gs cloud
//      val lines = sc.textFile("bible")   // read from local file
      //  val lines = sc.textFile("/library/wordcount/input")   // read from hdfs
      //  val lines = sc.textFile("hdfs://master:9000/libarary/wordcount/input")  // read from hdfs
 
      /**
       * step4: transformation for RDD, such as map, filter
        */
      val words = lines.flatMap(_.split(" ")).filter(word => word != " ")  // split words, filter with space
 
      val pairs = words.map(word => (word, 1))  // count 1 for word in words
 
      val wordscount = pairs.reduceByKey(_ + _)  // add up all <key,value> pair with the same key
      //  val wordscount = pairs.reduceByKey((v1, v2) => v1 + v2)  // same result
 
      wordscount.collect.foreach(println)  // printout result in console, collect will make result be collected to the master
//      wordscount.saveAsTextFile("gs://ufcloudcomputing/wordcountOneOutputFolder/") //save result as two workers result and wrap up in a folder
      wordscount.coalesce(1).saveAsTextFile("gs://ufcloudcomputing/wordcountOneOutput.txt") //save and merge result as one file
      sc.stop()   // release resource
 
   }

}