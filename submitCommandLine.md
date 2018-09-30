1. show content
gsutil cat gs://ufcloudcomputing/wordCountTwo.py
2. submit to run
gcloud dataproc jobs submit pyspark \
    --cluster cluster-assign1 --region global \
    gs://ufcloudcomputing/wordCountTwo.py