package hu.unideb.inf;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class JsonWriter {
    public static void fillJson(){
        try {
            List<Product> products = Arrays.asList(
                    new Product(100,"motor1","Szepaghdfghlma","img/img1.jpg",1),
                    new Product(101,"motor2","Szepdghdalma","img/motor2.jpg",2),
                    new Product(120,"motor3","Szepdfghhdgfflma","img/motor.png",3),
                    new Product(150,"motor4","Szepaldfgdgma","img/motor2.jpg",4),
                    new Product(180,"motor5","Szephdfghdgfdalma","img/motor.png",5),
                    new Product(10,"motor6","Szepgdalma","img/motor3.jpg",6),
                    new Product(1470,"alma","Szepgdaljhghjkma","img/motor2.jpg",7),
                    new Product(12054,"alma","Szepdfghhdgfflma","img/motor2.jpg",8),
                    new Product(14750,"alma","Szepaldfgdgma","img/motor2.jpg",9),
                    new Product(1215,"alma","Szephdfghdgfdalma","img/motor2.jpg",10),
                    new Product(184,"alma","Szepgdalma","img/motor3.jpg",11),
                    new Product(101324,"alma","Szepdghdalma","img/motor2.jpg",12),
                    new Product(125620,"alma","Szepdfghhdgfflma","img/motor3.jpg",13),
                    new Product(1574230,"alma","Szepaldfgdgma","img/motor.png",14),
                    new Product(185420,"alma","Szephdfghdgfdalma","img/motor2.jpg",15),
                    new Product(178950,"alma","Szepgdalma","img/motor2.jpg",16),
                    new Product(146570,"alma","Szepgdaljhghjkma","img/motor3.jpg",17),
                    new Product(120654,"alma","Szepdfghhdgfflma","img/motor.png",18),
                    new Product(1475430,"alma","Szepaldfgdgma","img/motor2.jpg",19),
                    new Product(123215,"alma","Szephdfghdgfdalma","img/motor.png",20),
                    new Product(1824564,"alma","Szepgdalma","img/motor2.jpg",21)
            );
            Writer writer = new FileWriter(new File("src/main/resources/hu/unideb/inf/Jsons/Products.json"));
            new Gson().toJson(products, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }

