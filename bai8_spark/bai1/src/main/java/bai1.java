import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class bai1 {

    public static void RUN(SparkSession spark, String SQL, String TYPEOUT, String OUTPUT){
        Dataset<Row> ds = spark.sql(SQL);
        ds.repartition(1)
                .write()
                .mode("overwrite")
                .format(TYPEOUT)
                .save(OUTPUT);
    }


    public static void main(String[] args) throws AnalysisException {
        SparkSession spark = SparkSession.builder().appName("Read_Parquet_File").getOrCreate();
        Dataset<Row> rawDf = spark.read().parquet("/user/chibm/input/part2.snappy.parquet"); //file Name
        Dataset<Row> clearDf = rawDf.filter(rawDf.col("device_model").isNotNull())
                .filter(rawDf.col("user_id").isNotNull())
                .filter(rawDf.col("user_id").notEqual(""))
                .filter(rawDf.col("button_id").isNotNull());

//        clearDf.printSchema();

//        dataset.show();
        clearDf.createGlobalTempView("data");

        String SQL = null;
        String TYPEOUT = null;
        String OUTPUT = null;

        SQL = "SELECT device_model, count(DISTINCT(user_id)) as count " +
                "FROM global_temp.data " +
                "GROUP BY device_model";
        TYPEOUT = "parquet";
        OUTPUT = "/user/chibm/device_model_num_user/small";
        RUN(spark, SQL, TYPEOUT, OUTPUT);


        SQL = "SELECT device_model, collect_set(user_id) " +
                "FROM global_temp.data " +
                "GROUP BY device_model";
        TYPEOUT = "orc";
        OUTPUT = "/user/chibm/device_model_list_user/small";
        RUN(spark, SQL, TYPEOUT, OUTPUT);


        SQL = "SELECT CONCAT(user_id,'_',device_model) as user_id_device_model," +
                " button_id, count(*) as count " +
                "FROM global_temp.data " +
                "GROUP BY user_id_device_model, button_id ";
        TYPEOUT = "parquet";
        OUTPUT = "/user/chibm/button_count_by_user_id_device_model/small";
        RUN(spark, SQL, TYPEOUT, OUTPUT);



    }
}
