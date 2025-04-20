# Summary

This lab provides clear evidence of successful MapReduce job execution across various stages of text processing and analysis. Each part of the lab reflects the cumulative effect of preprocessing, data aggregation, and result visualization applied to literary corpora.

---

## Part 01: Word Count (Shakespeare)

The output confirms that all words were successfully **lowercased** and **stripped of punctuation** before counting. This ensured accurate word frequency statistics without duplication due to case differences or punctuation noise.

---

## Part 02: Cleaned Word Count (Top Words)

The results highlight the **top 15 most frequently used words** in Shakespeare’s works, following normalization. This offers insight into common language usage patterns and demonstrates effective text standardization.

---

## Part 03: Vocabulary Richness Comparison

The richness measure (unique words divided by total words) reveals that:

- **Shakespeare:** 11.5%
- **Jane Austen:** 3.81%
- **King James Bible:** 2.00%

This illustrates lexical variation and authorial style differences, with Shakespeare showing significantly more vocabulary diversity.

---

## Part 04: Longest Words in the Corpus

The extracted longest words include **hyphenated and compound words**, showcasing Shakespeare’s creative and stylistic linguistic structures. A notable trend is that **longer words occur less frequently**, which is typical in natural language where shorter words dominate.

---

Together, these outputs underscore the power of distributed text processing and provide compelling literary insights through big data techniques.

---

# Copying Files from Local to HDFS

To begin the lab, you must copy files from your local environment to your EC2 instance. You’ll be working with the `textcorpora` folder.

---

# Shell Commands to Start the Lab

```bash
# Connect to your EC2 instance
ssh -i keys/<your-key>.pem ubuntu@<public-IP>

# Copy textcorpora folder from Windows to EC2
scp -i keys/bda_demo.pem /mnt/c/Users/dell/Downloads/textcorpora/ ubuntu@<public-IP>:/home/ubuntu/

# Format HDFS and start NameNode/DataNodes
/usr/local/hadoop/bin/hdfs namenode -format
/usr/local/hadoop/sbin/start-dfs.sh
```

Make sure the path to your textcorpora folder is correct. The path may differ on your system.
To check the folder's path, use:

```bash
sudo find / -name textcorpora
pwd
```

sudo find / -name textcorpora: Searches your system for the folder.

pwd: Displays your current working directory.

Once you are done with the labs make sure you stop the hdfs 

```bash
/usr/local/hadoop/sbin/stop-dfs.sh
```