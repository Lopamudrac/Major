# Steps to run Sbc
1. First browse and select the dataset file to create clusters. The contents of a file are read
using FileReader and buffered in a buffer and then stored in a string variable. Further the
contents are stored in an array list to create the probability matrix.
2. The categorical data used for clustering is printed after reading it in from file.
3. For creating clusters using SBC algorithm, firstly the categorical data is converted into its
equivalent space structure matrix which is calculated using the similarity between different pairs
of objects for each of the given features.
4. Once the space structure matrix is created, clusters are made by the taking the number of clusters
as input from user. All the value of one cluster are then displayed.
5. The accuracy of SBC algorithm is calculated for evaluating the performance of the algorithm for
the given data set. The main idea to find accuracy is to measure the shared set cardinality
between two clustering results on a given data set.

# To test working of kmeans
1. Enter data for running k-means algorithm.
2. Taking input from user about the number of clusters and creating the clusters using k-means
algorithm.
