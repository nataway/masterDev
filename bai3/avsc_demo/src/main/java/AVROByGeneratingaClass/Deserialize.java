package AVROByGeneratingaClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import with_code_gen.UserInfo;

public class Deserialize {
    public static void main(String args[]) throws IOException {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String PATH = s+"/src/main/java/FileSave/emp.avro";

        //DeSerializing the objects
        DatumReader<UserInfo> empDatumReader = new SpecificDatumReader<>(UserInfo.class);

        //Instantiating DataFileReader
        DataFileReader<UserInfo> dataFileReader = new DataFileReader<>(new
                File(PATH), empDatumReader);
        UserInfo em = null;

        while(dataFileReader.hasNext()){
            em=dataFileReader.next(em);
//            ObjectMapper mapper = new ObjectMapper();
//
//
//            String json = mapper.writeValueAsString(em);
//
//            System.out.println(json);

            System.out.println(em);
        }
    }
}
