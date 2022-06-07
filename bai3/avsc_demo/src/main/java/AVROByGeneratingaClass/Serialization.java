package AVROByGeneratingaClass;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import with_code_gen.Address;
import with_code_gen.Gender;
import with_code_gen.UserInfo;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    public static void main(String args[]) throws IOException {

        UserInfo userinfo = new UserInfo();
        Address address = new Address();
        List<Address> listAddress = new ArrayList<>();

        address.setCity("ND");
        address.setCountry("VN");
        address.setStreet("12");
        listAddress.add(address);

        Address address2 = new Address();
        address2.setCity("HN");
        address2.setCountry("VN");
        address2.setStreet("Lang");
        listAddress.add(address2);

        userinfo.setFistName("Bui");
        userinfo.setLastName("Chi");
        userinfo.setAge(23);
        userinfo.setPhone("123456789");
        userinfo.setGenger(Gender.female);
        userinfo.setListAddress(listAddress);

        //Instantiate DatumWriter class
        DatumWriter<UserInfo> empDatumWriter = new SpecificDatumWriter<UserInfo>(UserInfo.class);
        DataFileWriter<UserInfo> empFileWriter = new DataFileWriter<UserInfo>(empDatumWriter);

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        empFileWriter.create(userinfo.getSchema(), new File(s+"/src/main/java/with_code_gen/emp.avro"));
        empFileWriter.append(userinfo);

        empFileWriter.close();

        System.out.println("data successfully serialized");
    }
}
