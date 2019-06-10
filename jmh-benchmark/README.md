#Simple benchmark project using JMH

This project is created only for a purpose of demonstration. It has simple to understand code with 4 benchmark
methods, which generate the throughput report of sequential and parallel sorting.

#How to use

	- Clone this project
	- Run command `mvn clean install` on root directory
	- Run command `java -jar target\benchmark.jar`

---
**Result


 Run complete. Total time: 00:02:08

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                Mode  Cnt         Score   Error  Units
MyBenchmark.testParallelArraySort_10    thrpt    2  20434749.323          ops/s
MyBenchmark.testParallelArraySort_20    thrpt    2  20253940.112          ops/s
MyBenchmark.testSequentialArraySort_10  thrpt    2  20451793.295          ops/s
MyBenchmark.testSequentialArraySort_20  thrpt    2  20253031.258          ops/s

---
