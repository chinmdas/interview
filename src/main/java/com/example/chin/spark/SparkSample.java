package com.practice.chin.spark;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import com.google.common.collect.Maps;

public class SparkSample {

	public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("sample").setMaster("spark://9.30.213.164:7077")
        		.set("spark.executor.memory","1g")
//        		.set("spark.driver.memory", "1g")
//        		.set("spark.cores.max", "3") 
       		.set("spark.driver.port", "4040")
        		.set("spark.driver.host", "9.30.213.164")
//        		.set("spark.driver.bindAddress", "10122")
        //.set("spark.cores.max", "12") 
        		.set("spark.shuffle.service.enabled", "true")
        		.set("spark.dynamicAllocation.enabled", "true");
        
        SparkSession sparkSession = SparkSession.builder().config(sparkConf).getOrCreate();

        // start a spark context
        JavaSparkContext sc = JavaSparkContext.fromSparkContext(sparkSession.sparkContext());
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        JavaRDD<Integer> rdd = sc.parallelize(list);
        
        //rdd.collect();
        System.out.println(rdd.collect());
    }

}
