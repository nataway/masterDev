import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;

public class SalaryRecord implements Writable {
//    public Text job = new Text();
    public Text salary = new Text();


    public SalaryRecord(){}
    public SalaryRecord( String salary){

        this.salary.set(salary);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        this.salary.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.salary.readFields(dataInput);
    }
}
