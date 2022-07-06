import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


import java.io.IOException;
import java.util.Objects;

public class Run {

    public static class JoinGroupingComparator extends WritableComparator{
        public JoinGroupingComparator() {
            super (JobKey.class, true);
        }

        @Override
        public int compare (WritableComparable a, WritableComparable b){
            JobKey first = (JobKey) a;
            JobKey second = (JobKey) b;

            return first.jobKey.compareTo(second.jobKey);
        }
    }

    public static class JoinSortingComparator extends WritableComparator{
        public JoinSortingComparator() {
            super (JobKey.class, true);
        }

        @Override
        public int compare (WritableComparable a, WritableComparable b){
            JobKey first = (JobKey) a;
            JobKey second = (JobKey) b;

            return first.compareTo(second);
        }
    }

    public static class salaryMapper extends Mapper<LongWritable,
            Text, JobKey, JoinGenericWritable>{
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] recordFields = value.toString().split(",");
            if (!Objects.equals(recordFields[0], "job")){

                String job = recordFields[0];
                String salary = recordFields[1];

                JobKey recordKey = new JobKey(job, JobKey.SALARY_RECORD);
                SalaryRecord record = new SalaryRecord(salary);

                JoinGenericWritable genericRecord = new JoinGenericWritable(record);
                context.write(recordKey, genericRecord);
            }

        }
    }

    public static class peopleMapper extends Mapper<LongWritable,
            Text, JobKey, JoinGenericWritable>{
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] recordFields = value.toString().split(",");
            if (!Objects.equals(recordFields[0], "id")){
                int id = Integer.parseInt(recordFields[0]);
                String first_name = recordFields[1];
                String last_name = recordFields[2];
                int  age = Integer.parseInt(recordFields[3]);
                String state = recordFields[4];
                String city = recordFields[5];
                String street = recordFields[6];
                int  zip = Integer.parseInt(recordFields[7]);
                String job = recordFields[8];

                JobKey recordKey = new JobKey(job, JobKey.PEOPLE_RECORD);
                PeopleRecord record = new PeopleRecord(id,first_name,last_name,age,street,city,state,zip);

                JoinGenericWritable genericRecord = new JoinGenericWritable(record);
                context.write(recordKey, genericRecord);
            }
        }
    }

    public static class JoinReducer extends Reducer<JobKey,
            JoinGenericWritable, NullWritable, Text> {
        StringBuilder output = new StringBuilder();


        @Override
        protected void setup(Reducer<JobKey, JoinGenericWritable, NullWritable, Text>.Context context) throws IOException, InterruptedException {
            output.append("id,first_name,last_name,age,street,city,state,zip,job,salary \n");
        }

        public void reduce(JobKey key, Iterable<JoinGenericWritable> values,
                           Context context) throws IOException, InterruptedException{
            String salary = null;
            for (JoinGenericWritable v : values) {
                Writable record = v.get();
                if (key.nameTable.equals(JobKey.SALARY_RECORD)){
                    SalaryRecord record2 = (SalaryRecord) record;
                    salary = record2.salary.toString();
                } else {
                    PeopleRecord pRecord = (PeopleRecord) record;
                    output.append(pRecord.id.toString()).append(", ");
                    output.append(pRecord.first_name.toString()).append(", ");
                    output.append(pRecord.last_name.toString()).append(", ");
                    output.append(pRecord.age.toString()).append(", ");
                    output.append(pRecord.state.toString()).append(", ");
                    output.append(pRecord.city.toString()).append(", ");
                    output.append(pRecord.street.toString()).append(", ");
                    output.append(pRecord.zip.toString()).append(", ");
                    output.append(key.jobKey.toString()).append(", ");
                    output.append(salary).append("\n");
                }
            }

        }

        @Override
        protected void cleanup(Reducer<JobKey, JoinGenericWritable, NullWritable, Text>.Context context) throws IOException, InterruptedException {
            context.write(NullWritable.get(), new Text(output.toString()));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        String[] allArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if ((allArgs.length != 3)) {
            System.err.println("Usage: </chibm/bai3/input/salary.csv> </chibm/bai3/input/salary.csv> <output>");
            System.exit(2);
        }


        Job job = Job.getInstance(conf);
        job.setJarByClass(Run.class);


        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setMapOutputKeyClass(JobKey.class);
        job.setMapOutputValueClass(JoinGenericWritable.class);

        MultipleInputs.addInputPath(job, new Path(allArgs[0]), TextInputFormat.class, salaryMapper.class);
        MultipleInputs.addInputPath(job, new Path(allArgs[1]), TextInputFormat.class, peopleMapper.class);

        job.setSortComparatorClass(JoinSortingComparator.class);
        job.setGroupingComparatorClass(JoinGroupingComparator.class);


        job.setReducerClass(JoinReducer.class);
        job.setNumReduceTasks(2);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        FileOutputFormat.setOutputPath(job, new Path(allArgs[2]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
//id,first_name,last_name,age,street,city,state,zip,job
//job,salary