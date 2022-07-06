import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class JobKey implements WritableComparable<JobKey> {
    public Text jobKey = new Text();
    public IntWritable nameTable = new IntWritable();

    public JobKey(){}

    public JobKey(String jobKey, IntWritable nameTable){
        this.jobKey.set(jobKey);
        this.nameTable = nameTable;
    }

    @Override
    public int compareTo(JobKey o) {
        if (this.jobKey.equals(o.jobKey)){
            return this.nameTable.compareTo(o.nameTable);
        }
        else {
            return this.jobKey.compareTo(o.jobKey);
        }
    }

    public boolean equals( JobKey o){
        return this.jobKey.equals(o.jobKey) &&
                this.nameTable.equals(o.nameTable);
    }
    public int hashCode(){
        return this.jobKey.hashCode();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.jobKey.write(dataOutput);
        this.nameTable.write(dataOutput);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.jobKey.readFields(dataInput);
        this.nameTable.readFields(dataInput);
    }

    public static final IntWritable PEOPLE_RECORD = new IntWritable(1);
    public static final IntWritable SALARY_RECORD = new IntWritable(0);

}
