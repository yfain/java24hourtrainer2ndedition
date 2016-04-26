package json; /**
 * Created by yfain11 on 4/12/14.
 */

import javax.json.JsonObject;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonObjectBuilder;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class JavaToJSONObject {

        public static void main(String[] args) {

            Product prd1 = new Product(777, "Chanel Handbag", 1000.00);

            try (OutputStream fos = new FileOutputStream("product_from_object.json");
                 JsonWriter jsonWriter = Json.createWriter(fos);) {

                JsonObjectBuilder prdBuilder = Json.createObjectBuilder();

                prdBuilder.add("id", prd1.id)
                          .add("description", prd1.description)
                          .add("price", prd1.price);

                JsonObject prdJsonObject = prdBuilder.build();

                System.out.println("prdJsonObject: " + prdJsonObject);


                jsonWriter.writeObject(prdJsonObject);
                
                // Read and parse the newly created file back
                JsonReader jsonReader = 
                		Json.createReader(new FileReader("product_from_object.json"));
                JsonObject jsonObject = jsonReader.readObject();
                System.out.println(jsonObject);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
