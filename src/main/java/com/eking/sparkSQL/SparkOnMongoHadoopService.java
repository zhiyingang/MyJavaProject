package com.eking.sparkSQL;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataTypes;

import com.google.common.hash.Hashing;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;

/**
 * 执行owlMapping脚本
 * 
 * @author 鲍立飞
 *
 */
public class SparkOnMongoHadoopService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkSession spark = SparkSession.builder().master("local")
				.config("spark.sql.warehouse.dir", "/home/spark-warehouse")
				.appName("MongoSparkConnectorIntro")
				.config("spark.mongodb.input.uri", "mongodb://10.123.32.60/venture_buffer.Person")
				.config("spark.mongodb.output.uri", "mongodb://10.123.32.60/venture_graph.relation_P2P").getOrCreate();

		try {
			// Create a JavaSparkContext using the SparkSession's SparkContext
			// object
			JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

			// Load data and infer schema, disregard toDF() name as it returns
			// Dataset

			// baikePerson
			// Create a custom ReadConfig
			Map<String, String> readOverrides = new HashMap<String, String>();
			readOverrides.put("collection", "Person");
			ReadConfig readConfig = ReadConfig.create(jsc).withOptions(readOverrides);
			Dataset<Row> Person = MongoSpark.load(jsc, readConfig).toDF();
			Person.createOrReplaceTempView("Person");

			// node_person_map1
			System.out.println("=================================relation_P2P======================================");
			Dataset<Row> relation_P2P = spark.sql(
					"select PersonID, coWork.PersonID as PersonID2, coWork.PersonName as PersonName from Person  LATERAL VIEW explode(CurrentCoWork) adTable AS coWork where PersonID = 'http://www.itjuzi.com/person/31'");
			relation_P2P.createOrReplaceTempView("relation_P2P");
			relation_P2P.show();

			jsc.close();

			System.out.println("-------------------------> RDD : yes");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("-------------------------> RDD : no");

		}
	}

}
