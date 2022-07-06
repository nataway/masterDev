package main.java;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class CountDistinctNumber {
    public static class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable>{
        private final static IntWritable one = new IntWritable(1);
        private final Text number = new Text();

        @Override
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            String line = value.toString().trim();
            if (!Objects.equals(line, "")){
                number.set(line);
                context.write(number, one);
            }

        }
    }

    public static class shuffle
            extends Mapper<Object, Text, Text, IntWritable>{
        private final static IntWritable one = new IntWritable(1);
        private final Text number = new Text();

        @Override
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            number.set("0");
            context.write(number, one);
        }
    }

    public static class IntSumReducer
            extends Reducer<Text,IntWritable,Text, NullWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context
        ) throws IOException, InterruptedException {
            context.write(key, NullWritable.get());
        }
    }

    public static class IntSumReducer2
            extends Reducer<Text,IntWritable,Text,IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context
        ) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        GenericOptionsParser optionParser = new GenericOptionsParser(conf, args);
        String[] remainingArgs = optionParser.getRemainingArgs();
        if ((remainingArgs.length != 3)) {
            System.err.println("Usage: <in> <out> <out2>");
            System.exit(2);
        }
        List<String> otherArgs = new ArrayList<String>();
        Collections.addAll(otherArgs, remainingArgs);
        Job job = Job.getInstance(conf, "CountDistinctNumber");
        job.setJarByClass(CountDistinctNumber.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        FileInputFormat.addInputPath(job, new Path(otherArgs.get(0)));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs.get(1)));
//        System.exit(job.waitForCompletion(true) ? 0 : 1);



        Job job2 = Job.getInstance(conf, "CountDistinctNumber2");
        job2.setJarByClass(CountDistinctNumber.class);
        job2.setMapperClass(shuffle.class);
        job2.setReducerClass(IntSumReducer2.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(IntWritable.class);
        job2.setInputFormatClass(TextInputFormat.class);
        job2.getConfiguration().set("mapreduce.output.textoutputformat.separator",",");


        FileInputFormat.addInputPath(job2, new Path(otherArgs.get(1)));
        FileOutputFormat.setOutputPath(job2, new Path(otherArgs.get(2)));
        if(job.waitForCompletion(true)){
            System.exit(job2.waitForCompletion(true) ? 0 : 1);
        }

    }
}

