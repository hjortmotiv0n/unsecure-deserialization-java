package com.mycompany.app;

import java.io.*;
public class SerializationExample {
    private byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream stream = new ObjectOutputStream(buffer)) {
            stream.writeObject(object);
        }
        return buffer.toByteArray();
    }
    private Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream buffer = new ByteArrayInputStream(bytes);
        try (ObjectInputStream stream = new ObjectInputStream(buffer)) {
            return stream.readObject();
        }
    }
    public static void main(String[] args) {
        SerializationExample example = new SerializationExample();
        Person person = new Person("Bob", 31);
        try {
            // Serialize the person object to a byte array
            byte[] serializedData = example.serialize(person);
            System.out.println("Serialized data: " + new String(serializedData));
            // Deserialize the byte array back to a person object
            Person deserializedPerson = (Person) example.deserialize(serializedData);
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}