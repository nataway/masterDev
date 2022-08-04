package Spark.ReadFile;


import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.apache.spark.util.LongAccumulator;

import java.util.HashMap;

public class ReadFilePar {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("Read_Parquet_File").master("local").getOrCreate();
        Dataset<Row> parquetFileDF = spark.read().parquet("chibm/data_tracking");
        parquetFileDF.show();
//        parquetFileDF.printSchema();

        LongAccumulator accum = spark.sparkContext().longAccumulator("accum");
        HashMap<String, LongAccumulator> accumulatorHashMap = new HashMap<>();
        parquetFileDF.map((MapFunction<Row, Row>) row -> {
                    accum.add(1);
                    return  row;
                }, RowEncoder.apply(parquetFileDF.schema()))
                .count();
        System.out.printf(String.valueOf(accum.value()));

    }
}
