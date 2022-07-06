import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PeopleRecord implements Writable {

    public IntWritable id = new IntWritable();
    public Text first_name = new Text();
    public Text last_name = new Text();
    public IntWritable age = new IntWritable();
    public Text street = new Text();
    public Text city = new Text();
    public Text state = new Text();
    public IntWritable zip = new IntWritable();

    public PeopleRecord(){}

    public PeopleRecord(int id,String first_name, String last_name, int age, String street, String city, String state
                        , int zip){
        this.id.set(id);
        this.first_name.set(first_name);
        this.last_name.set(last_name);
        this.age.set(age);
        this.street.set(street);
        this.city.set(city);
        this.state.set(state);
        this.zip.set(zip);

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.id.write(dataOutput);
        this.first_name.write(dataOutput);
        this.last_name.write(dataOutput);
        this.age.write(dataOutput);
        this.street.write(dataOutput);
        this.city.write(dataOutput);
        this.state.write(dataOutput);
        this.zip.write(dataOutput);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id.readFields(dataInput);
        this.first_name.readFields(dataInput);
        this.last_name.readFields(dataInput);
        this.age.readFields(dataInput);
        this.street.readFields(dataInput);
        this.city.readFields(dataInput);
        this.state.readFields(dataInput);
        this.zip.readFields(dataInput);

    }

}
