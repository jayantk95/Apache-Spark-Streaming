# Apache-Spark-Streaming
This project streams the files added in the Dataset folder and analyzes them using sparkSQL.

  To run this project using sbt:
    1. Change directory to Streaming
    2. run sbt
    3. compile
    4. run
   
  To run using spark-submit:
    1.Change directory to SimpleProject 
    2.run->  YOUR SPARKPATH/bin/spark-submit
      \ --class "SimpleProject"
      \ --master local[*]
      \ target/simpleproject_2.12-0.1.0-SNAPSHOT.jar
