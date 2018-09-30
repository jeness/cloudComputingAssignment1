1. show content
gsutil cat gs://ufcloudcomputing/wordCountTwo.py
2. submit to run
+ task1
use web ui to submit
+ task2
```
gcloud dataproc jobs submit pyspark \
    --cluster cluster-assign1 --region global \
    gs://ufcloudcomputing/wordCountTwo.py
```
+ task3
```
gcloud dataproc jobs submit pyspark \
    --cluster cluster-assign1 --region global \
    gs://ufcloudcomputing/wordCountThree.py
```