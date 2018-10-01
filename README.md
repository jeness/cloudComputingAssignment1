# cloudComputingAssignment1
## Task1
### 1.	Single word count
First, load bible data from google cloud storage bucket to RDD, split words with spaces, and then use filter to get non-space elements. Second, map elements to key-value pair like, <word, 1>. Third, reduce pair by the same key and get the result of counting words in descending order.

### 2.	Result
Screenshots shows the result file of single word count which is download from google cloud storage.<br>
+ File link: https://storage.googleapis.com/ufcloudcomputing/wordcountOneOutput_OneFlie/part-00000
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/1.png)

### 3.	Output console screenshot<br>
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/2.png)

## Task 2
### 1.	Double word count<br>
First, load bible data from google cloud storage bucket to RDD, split words with spaces, then use function to get current word and the word after current word, and store every new double words combination to a new list. Second, map elements to key-value pair like, <<word 1, word 2>, 1>. Third, reduce pair by the same key and get the result of counting words with descending order.
### 2.	Result<br>
Screenshots shows the result file of double word count which is download from google cloud storage.
+ File Link:
https://storage.googleapis.com/ufcloudcomputing/wordcountTwoOutputFolder/part-00000
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/3.png)
### 3.  Output console screenshot<br>
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/4.png)
## Task 3
### 1.	Word count with distributed cache
First, load bible data and small list data from google cloud storage bucket to 2 different RDD, split words with spaces, and then use filter to get non-space elements. Second, map bible data to key-value pair like, <word, 1> and reduce pair by the same key and get the result of counting words in bible. Third, map small list data to key-value pair like, <word, 0> and join two RDD and get the result of common words and the respect value from bible RDD with descending order.

### 2.	Result
Screenshots shows the result file of distributed cache word count which is download from google cloud storage.
+ Link file:
https://storage.googleapis.com/ufcloudcomputing/wordcountThreeOutputFolder/part-00000
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/5.png)
### 3.	Console output screenshot
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/7.png)

## Configurations
### 1.	VM instances
Three VM instances in total. One master node, and two worker nodes.
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/8.png)

### 2.	Submit jobs to run
#### Task 1
Use web UI, see screenshot for configuration<br>
![](https://github.com/jeness/cloudComputingAssignment1/raw/master/images/9.png)
#### Task 2
Use command line tool to submit
```
gcloud dataproc jobs submit pyspark \
    --cluster cluster-assign1 --region global \
    gs://ufcloudcomputing/wordCountTwo.py
```
#### Task 3
Use command line tool to submit
```
gcloud dataproc jobs submit pyspark \
    --cluster cluster-assign1 --region global \
    gs://ufcloudcomputing/wordCountThree.py
```





